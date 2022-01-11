package com.xiaorui.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密
 */
public class MD5Utils {
    
    /**
     * MD5字符串，全大写
     *
     * @param str
     * @return
     */
    public static String digestUpper(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return digest(str).toUpperCase();
    }
    
    /**
     * MD5字符串，默认全小写
     *
     * @param str
     * @return
     */
    public static String digest(String str) {
        if (StringUtils.isEmpty(str)) {
            return null;
        }
        return digest(str.getBytes());
    }
    
    /*
     * MD5字符串
     */
    public static String digest(byte[] data) {
        MessageDigest messageDigest = null;
        
        try {
            messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(data);
        } catch (NoSuchAlgorithmException e) {
        }
        byte[] byteArray = messageDigest.digest();
        StringBuffer md5StrBuff = new StringBuffer();
        for (int i = 0; i < byteArray.length; i++) {
            if (Integer.toHexString(0xFF & byteArray[i]).length() == 1) {
                md5StrBuff.append("0").append(Integer.toHexString(0xFF & byteArray[i]));
            } else {
                md5StrBuff.append(Integer.toHexString(0xFF & byteArray[i]));
            }
        }
        return md5StrBuff.toString();
    }
    
}
