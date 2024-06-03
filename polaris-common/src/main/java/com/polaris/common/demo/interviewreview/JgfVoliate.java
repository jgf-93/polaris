package com.polaris.common.demo.interviewreview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class JgfVoliate {
    static class Counter {
        //加了voliate就可以实现共享变量的可见性
        public int flag = 0;
    }

    public static void main(String[] args) {
//        Counter counter = new Counter();
//        Thread t1 = new Thread(() -> {
//            while (counter.flag == 0) {
//                // do nothing
//            }
//            System.out.println("循环结束!");
//        });
//        Thread t2 = new Thread(() -> {
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("输入一个整数:");
//            counter.flag = scanner.nextInt();
//        });
//        t1.start();
//        t2.start();
//        System.out.println(leetcodeTest("abc", ));
        int[] maopaoInt = maopao();
        int[] charu = charru();
        System.out.println("ceshi");
        System.out.println(canPermutePalindrome("code"));
        String result = compressString("aabcccccaa");
        System.out.println(result);

    }

    public static String leetcodeTest(String s1, int length) {
        return s1.substring(0, length).replace(" ", "%20");
    }

    public static int[] maopao() {
        int[] mp = {1, 5, 2, 4, 3};
        int n = mp.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (mp[j] > mp[j + 1]) {
                    int temp = mp[j];
                    mp[j] = mp[j + 1];
                    mp[j + 1] = temp;
                }
            }
        }
        return mp;
    }

    public static int[] charru() {
        int[] charu = {6, 4, 2, 5, 3, 1};
        for (int i = 1; i < charu.length; i++) {
            int value = charu[i];
            int j = i - 1;
            while (j >= 0 && charu[j] > value) {
                charu[j + 1] = charu[j];
                j--;
            }
            charu[j + 1] = value;
        }
        return charu;
    }

    public static boolean canPermutePalindrome(String s) {
        char[] xs = s.toCharArray();
        Map<Character, Integer> dicMap = new HashMap<>();
        for (int i = 0; i < xs.length; i++) {
            dicMap.put(xs[i], dicMap.getOrDefault(xs[i], 0) + 1);
        }

        AtomicBoolean flag = new AtomicBoolean(true);
        AtomicInteger count = new AtomicInteger();
        dicMap.forEach((x, y) -> {
            if (y % 2 == 1 && count.incrementAndGet() > 1) {
                flag.set(false);
            }
        });
        if (flag.get()) {
            return true;
        }
        return false;
    }

    public static String compressString(String S) {
        int length = S.length();
        char[] charArray = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArray.length; i++) {
            char first = charArray[i];
            int count = 1;
            for (int j = i+1; j < charArray.length; j++) {
                if (first == charArray[j]) {
                    i++;
                    count++;
                } else {
                    break;
                }
            }
            sb.append(first).append(count);
        }
        String newStr = sb.toString();
        if (newStr.length() >= length) {
            return S;
        }
        return newStr;

    }
}