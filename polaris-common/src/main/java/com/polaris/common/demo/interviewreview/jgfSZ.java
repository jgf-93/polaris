package com.polaris.common.demo.interviewreview;

import java.util.HashMap;
import java.util.Map;

public class jgfSZ {

    public static void main(String[] args) {
            System.out.println("33".hashCode());
    }

    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        String s = s2 + s2;
        return s.contains(s1);
    }
}
