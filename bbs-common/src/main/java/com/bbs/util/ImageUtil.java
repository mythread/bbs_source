package com.bbs.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.google.common.base.Strings;

import net.coobird.thumbnailator.Thumbnails;

/**
 * @author Johnny
 * 
 */
public class ImageUtil {

    private ImageUtil() {
    }

    /**
     * 
     * @param srcBytes
     *            读入内存的图片
     * @param width
     *            目标要resize到的宽度
     * @param height
     *            图片要resize到的高度
     * @return 在内存中转为的新图片
     */
    public static byte[] resize(byte[] srcBytes, int width,
            int height) {

        Strings.isNullOrEmpty("");
        
        if ( (srcBytes == null) || (srcBytes.length <= 0) || (width <= 0)
                || (height <= 0))
            return null;

        ByteArrayOutputStream bos = null;
        try {
            bos = new ByteArrayOutputStream(srcBytes.length);
            Thumbnails.of(new ByteArrayInputStream(srcBytes)).size(width, height).toOutputStream(bos);
            byte[] resizedBytes = bos.toByteArray();
            bos.flush();
            return resizedBytes;

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                bos.close();
            } catch (IOException ex) {
                return null;
            }
        }
    }

}
