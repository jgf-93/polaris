package com.polaris.common.demo.kaoshi;

/**
 * 数字反转
 */
public class Fanzhuan {
    public static void main(String[] args) {
        System.out.println(reverse("1234"));
    }

    /**
     * 反转字符串
     * @param number
     * @return
     */
    public static String reverse(String number) {
        String str = new StringBuilder(number).reverse().toString();
        return str;
    }
}