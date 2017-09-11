package com.moven.common.utils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * 设置密钥的MD5加密
 */
public class MD5Util {
    private final static String[] hexDigits = {
            "0", "1", "2", "3", "4", "5", "6", "7", 
            "8", "9", "A", "B", "C", "D", "E", "F" };
    
    private static MessageDigest md5Digest = null;
    
    static {
    	try {
    		md5Digest = MessageDigest.getInstance("MD5");
    	} catch(NoSuchAlgorithmException e) {
    		e.printStackTrace();
    	}
    }
    
    public static MessageDigest newDigest() {
    	MessageDigest md = null;
    	try {
    		md = (MessageDigest) md5Digest.clone();
    	} catch(CloneNotSupportedException ignore) {
    		ignore.printStackTrace();
    	}
    	return md;
    }

    public static String byteArrayToHexString(byte in[]) {
        if (in == null || in.length <= 0) {
            return null;
        }

        byte ch = 0x00;
        int i = 0; 

        StringBuffer out = new StringBuffer(in.length * 2);
        while (i < in.length) {
            ch = (byte) (in[i] & 0xF0); // Strip off high nibble
            ch = (byte) (ch >>> 4);
            // shift the bits down
            ch = (byte) (ch & 0x0F);
            // must do this is high order bit is on!
            out.append(hexDigits[ (int) ch]); // convert the nibble to a String Character
            ch = (byte) (in[i] & 0x0F); // Strip off low nibble 
            out.append(hexDigits[ (int) ch]); // convert the nibble to a String Character
            i++;
        }
        return out.toString();
    }

    public static String encode(String origin) {
        return encode(origin, null);
    }
    
    public static String encode(String origin, String salt) {
        byte[] b1 = null;
        byte[] b2 = null;
        try {
        	b1 = origin.getBytes("UTF-8");
        	b2 = salt == null ? null : salt.getBytes("UTF-8");
        } catch(UnsupportedEncodingException e) {
        	e.printStackTrace();
        	
    		b1 = origin.getBytes();
        	b2 = salt == null ? null : salt.getBytes();
        }

        return encode(b1, b2);
    }

    public static String encode(byte[] origin) {
        return encode(origin, null);
    }

    public static String encode(byte[] origin, byte[] salt) {
    	MessageDigest md = newDigest();
    	md.reset();
    	if (salt != null) {
    		md.update(salt);
    	}
    	md.update(origin);
    	return byteArrayToHexString(md.digest());
    }

    public static byte[] encodeBytes(byte[] origin) {
        return encodeBytes(origin, null);
    }

    public static byte[] encodeBytes(byte[] origin, byte[] salt) {
    	MessageDigest md = newDigest();
    	md.reset();
    	if (salt != null) {
    		md.update(salt);
    	}
    	md.update(origin);
    	return md.digest();
    }
}