package com.bbs.util;

import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.commons.lang.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 加密、解密
 * 
 * @author jie.xu 2014年11月19日 上午9:36:07
 */
@SuppressWarnings("restriction")
public class EncryptUtils {

    private static final String DEFAULT_KEY = "20141122$#@!jie";

    /**
     * 加密
     */
    public static String encrypt(String source) {
        if (StringUtils.isEmpty(source)) {
            return null;
        }

        try {
            byte[] decryptData = source.getBytes();
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            SecureRandom sr = new SecureRandom();
            DESKeySpec dks = new DESKeySpec(Md5Util.toMd5(DEFAULT_KEY).getBytes());

            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            byte[] encryptData = cipher.doFinal(decryptData);
            String ret = new BASE64Encoder().encode(encryptData);
            return EncodeUtils.encode(ret);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 解密
     */
    public static String decrypt(String secretString) {
        if (StringUtils.isEmpty(secretString)) {
            return null;
        }

        try {
            secretString = EncodeUtils.decode(secretString);
            byte[] encryptedData = new BASE64Decoder().decodeBuffer(secretString);
            Security.addProvider(new com.sun.crypto.provider.SunJCE());
            SecureRandom sr = new SecureRandom();

            DESKeySpec dks = new DESKeySpec(Md5Util.toMd5(DEFAULT_KEY).getBytes());
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);

            byte[] decryptedData = cipher.doFinal(encryptedData);

            return new String(decryptedData);

        } catch (Exception e) {
            // TODO: handle exception
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(decrypt("FvmREDzRg5g%3D"));
    }
}
