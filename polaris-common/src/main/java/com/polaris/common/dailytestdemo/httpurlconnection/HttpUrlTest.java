package com.polaris.common.dailytestdemo.httpurlconnection;

import java.io.*;

public class HttpUrlTest {

    public static void main(String[] args) {

    }

    public void testFlie() {
        StringBuffer buffer = new StringBuffer();
        try (FileInputStream fileInputStream = new FileInputStream("/Users/jiangguanfeng/Desktop/未命名.txt");
             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             FileOutputStream fileOutputStream = new FileOutputStream("/Users/jiangguanfeng/Desktop/未命名1.txt");
             BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);) {
            byte[] buf = new byte[1024];
            int len = 0;
            while (bufferedInputStream.read(buf) != -1) {
                bufferedOutputStream.write(buf);
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        try (FileReader fileReader = new FileReader("/Users/jiangguanfeng/Desktop/未命名.txt");
             FileWriter fileWriter = new FileWriter("/Users/jiangguanfeng/Desktop/未命名1.txt")) {
            char[] buf = new char[1024];
            int len = 0;
            while ((len = fileReader.read(buf)) != -1) {
                fileWriter.write(new String(buf, 0, len));
                fileWriter.flush();
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
