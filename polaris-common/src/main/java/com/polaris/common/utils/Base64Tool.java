package com.polaris.common.utils;

import java.util.Base64;

/**
 */
public class Base64Tool {

    public static String encrypt(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        return Base64.getEncoder().encodeToString(s.getBytes());
    }

    public static String decrypt(String s) {
        if (null == s || "".equals(s)) {
            return "";
        }
        return new String(Base64.getDecoder().decode(s));
    }
}
