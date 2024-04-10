package com.polaris.common.demo.interviewreview;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 类加载机制验证
 */
public class JgfClassLoader extends ClassLoader{
    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        // 首先尝试使用父类加载器加载类
        try {
            return super.loadClass(name);
        } catch (ClassNotFoundException e) {
            // 如果父类加载器无法加载类，则自己加载类
            return findClass(name);
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 在这里实现自己的类加载逻辑，例如从特定位置加载类文件
        // 这里只是一个示例，实际实现需要根据具体需求进行处理
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] loadClassData(String name) {
        // 在这里实现加载类文件的逻辑，返回类文件的字节数组
        // 这里只是一个示例，实际实现需要根据具体需求进行处理
        try {
            FileInputStream fis = new FileInputStream(name + ".class");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
            fis.close();
            bos.close();
            return bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        // 创建自定义类加载器
        JgfClassLoader classLoader = new JgfClassLoader();
        System.out.println(classLoader.getClass().getName());
        System.out.println(classLoader.getParent().getClass().getName());
        System.out.println(classLoader.getParent().getParent().getClass().getName());
        try {
            // 使用自定义类加载器
            Class<?> clazz = classLoader.loadClass("com.polaris.common.demo.interviewreview.JgfClassLoader");
            System.out.println("Class loaded: " + clazz.getClassLoader().getClass().getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
}
