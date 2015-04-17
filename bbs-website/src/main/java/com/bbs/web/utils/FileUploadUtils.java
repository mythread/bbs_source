package com.bbs.web.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.bbs.core.DefaultResult;
import com.bbs.core.IResult;
import com.bbs.enums.PicsInfoEnum;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**
 * 
 * @author jie.xu 2014年12月8日 下午4:03:49
 */
public class FileUploadUtils {

    public static final String IMG_ROOT_PATH = "/usr/static/images";
    public static final String UPLOAD_STR = "/upload";

    /**
     * 
     * @param in
     * @param type
     *            上传类型
     * @param fileName
     *            文件名
     * @param size
     *            文件大小
     * @return
     */
    public static IResult<String> upload(InputStream in, String type, String fileName, long size) {
        try {
            type = StringUtils.trimToEmpty(type);
            PicsInfoEnum picEnum = PicsInfoEnum.getEnum(type);
            if (picEnum == null) {
                return DefaultResult.failResult("出错了", null);
            }
            String suffix = getSuffix(fileName);
            // 判断后缀名合法性
            boolean isLegal = checkSuffixLegal(picEnum.getSuffixs(), suffix);
            if (!isLegal) {
                return DefaultResult.failResult("上传图片后缀不合法", null);
            }
            return uploadPic(picEnum, in, fileName, size);
        } catch (Exception e) {
            return DefaultResult.failResult("图片上传出错", null);
        }
    }

    /**
     * <pre>
     * 上传图片
     * 1、图片大小 
     * 2、存放目录
     * 3、图片缩放
     * </pre>
     * 
     * @return
     */
    public static IResult<String> upload(File file, String type, int size) {

        try {
            return upload(new FileInputStream(file), type, file.getName(), size);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return DefaultResult.failResult("图片上传出错", null);
        }
    }

    /**
     * 上传图片
     * 
     * @throws IOException
     */
    private static IResult<String> uploadPic(PicsInfoEnum picEnum, InputStream inputStream, String picName, long size)
            throws IOException {
        int tarWidth = picEnum.getWidth();
        int tarHeight = picEnum.getHeight();
        if (size > picEnum.getMaxSize()) {
            return DefaultResult.failResult("上传图片大小不能超过：" + picEnum.getMaxSize() / 1024 + " KB", null);
        }
        String relativePath = getFileRelativePath(picEnum, picName);
        File tarFile = new File(IMG_ROOT_PATH + relativePath);
        if (!tarFile.getParentFile().exists()) {
            tarFile.getParentFile().mkdirs();
        }
        if (tarWidth > 0 && tarHeight > 0) {
            // 图片缩放
            resize(inputStream, picName, tarFile, tarWidth);
        } else {
            byte[] input = null;
            input = new byte[inputStream.available()];
            inputStream.read(input);

            FileUtils.writeByteArrayToFile(tarFile, input);
        }
        IOUtils.closeQuietly(inputStream);
        return DefaultResult.successResult("上传成功", UPLOAD_STR + relativePath);

    }

    /**
     * 等比缩放
     * 
     * @param inputStream
     * @param picName
     * @param tarFile
     * @throws IOException
     */
    private static void zoomPic(InputStream inputStream, String picName, File tarFile, int destWidth, int destHeight)
            throws IOException {
        BufferedImage buffImage = ImageIO.read(inputStream);
        int srcWidth = buffImage.getWidth();
        int srcHeight = buffImage.getHeight();
        int imgWidth = destWidth;
        int imgHeight = destHeight;
        double scaleW = destWidth * 1.0 / srcWidth;
        double scaleH = destHeight * 1.0 / srcHeight;
        if (scaleW >= scaleH) {
            double imgWidth1 = scaleH * srcWidth;
            double imgHeight1 = scaleH * srcHeight;
            imgWidth = (int) imgWidth1;
            imgHeight = (int) imgHeight1;
        } else {
            double imgWidth1 = scaleW * srcWidth;
            double imgHeight1 = scaleW * srcHeight;
            imgWidth = (int) imgWidth1;
            imgHeight = (int) imgHeight1;
        }

        BufferedImage image = new BufferedImage(destWidth, destHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setBackground(Color.WHITE);
        g.clearRect(0, 0, destWidth, destHeight);
        g.drawImage(buffImage.getScaledInstance(imgWidth, imgHeight, Image.SCALE_SMOOTH), (destWidth / 2)
                - (imgWidth / 2), (destHeight / 2) - (imgHeight / 2), null);
        g.dispose();
        ImageIO.write(image, getSuffix(picName), tarFile);
    }

    /**
     * 根据宽进行缩放
     */
    @SuppressWarnings("restriction")
    private static void resize(InputStream inputStream, String picName, File tarFile, int destWidth) throws IOException {
        BufferedImage srcBuffImage = ImageIO.read(inputStream);
        int srcWidth = srcBuffImage.getWidth();
        int srcHeight = srcBuffImage.getHeight();
        Image resizedImage = null;
        if (srcWidth > srcHeight) {
            resizedImage = srcBuffImage.getScaledInstance(destWidth, (destWidth * srcHeight) / srcWidth,
                    Image.SCALE_SMOOTH);
        } else {
            resizedImage = srcBuffImage.getScaledInstance((destWidth * srcWidth) / srcHeight, destWidth,
                    Image.SCALE_SMOOTH);
        }
        Image temp = new ImageIcon(resizedImage).getImage();
        BufferedImage bufferedImage = new BufferedImage(temp.getWidth(null), temp.getHeight(null),
                BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.createGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, temp.getWidth(null), temp.getHeight(null));
        g.drawImage(temp, 0, 0, null);
        g.dispose();
        // ImageIO.write(bufferedImage, getSuffix(picName), tarFile);

        float softenFactor = 0.05f;
        float[] softenArray = {0, softenFactor, 0, softenFactor, 1 - (softenFactor * 4), softenFactor, 0, softenFactor,
                0};
        Kernel kernel = new Kernel(3, 3, softenArray);
        ConvolveOp cOp = new ConvolveOp(kernel, ConvolveOp.EDGE_NO_OP, null);
        bufferedImage = cOp.filter(bufferedImage, null);
        // Write the jpeg to a file.
        FileOutputStream out = new FileOutputStream(tarFile);
        // Encodes image as a JPEG data stream
        JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
        JPEGEncodeParam param = encoder.getDefaultJPEGEncodeParam(bufferedImage);
        param.setQuality(1, true);
        encoder.setJPEGEncodeParam(param);
        encoder.encode(bufferedImage);

    }

    /**
     * 获得图片的相对路径
     * 
     * @param userId
     * @param picEnum
     * @return
     */
    private static String getFileRelativePath(PicsInfoEnum picEnum, String picName) {
        Calendar cal = Calendar.getInstance();
        String fileName = null;
        fileName = randomChars() + System.currentTimeMillis() + "." + getSuffix(picName);
        StringBuilder sb = new StringBuilder(200);
        sb.append(picEnum.getDirPrefix()).append("/");
        sb.append(cal.get(Calendar.YEAR)).append(cal.get(Calendar.MONTH) + 1);
        sb.append("/").append(cal.get(Calendar.DATE)).append("/");
        sb.append(fileName);
        return sb.toString();
    }

    /**
     * 获得图片的后缀
     */
    private static String getSuffix(String picName) {
        if (StringUtils.isEmpty(picName)) {
            return "";
        }
        int index = picName.lastIndexOf(".");
        if (index == -1) {
            return "";
        }
        return picName.substring(index + 1, picName.length());
    }

    /**
     * 随机获取4位字母(ascii:97 ~ 122,65 ~ 90)
     */
    private static String randomChars() {
        StringBuilder sb = new StringBuilder(4);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 4; i++) {
            int r = random.nextInt(52);
            char c = 'a';
            if (r < 26) {
                // 大写字母
                c = (char) (r + 65);
            } else {
                // 小写字母
                c = (char) (r + 71);
            }
            sb.append(Character.toString(c));
        }
        return sb.toString();
    }

    /**
     * 检查后缀合法性
     */
    private static boolean checkSuffixLegal(String[] srcSuffixs, String tarSuffix) {
        if (StringUtils.isEmpty(tarSuffix)) {
            return true;
        }
        for (String str : srcSuffixs) {
            if (tarSuffix.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {
        resize(new FileInputStream(new File("/Users/jiejie/Downloads/39931_180.jpg")), "39931_180.jpg", new File(
                "/Users/jiejie/Downloads/39931_182.jpg"), 50);
    }
}
