package com.tw.utils;

import java.io.UnsupportedEncodingException;
import java.util.Base64;


public class Base64Utils {


    public static String encode(String text) {
        String encodedString = null;
        Base64.Encoder encoder = Base64.getEncoder();
        try {
            byte[] textByte = text.getBytes("UTF-8");
            encodedString = encoder.encodeToString(textByte);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedString;
    }

    public static String decode(String text) {
        Base64.Decoder decoder = Base64.getDecoder();
        String decodeString = null;

        try {
            decodeString = new String(decoder.decode(text), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decodeString;

    }

    public static boolean checkBase64(String str) {
        String destr = Base64Utils.decode(str);
        String newEnstr = Base64Utils.encode(destr);
        if (str.equals(newEnstr)) {
            return true;
        }
        return false;
    }


}
