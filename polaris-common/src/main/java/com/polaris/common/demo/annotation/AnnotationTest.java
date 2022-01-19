package com.polaris.common.demo.annotation;

import java.util.Date;
import java.util.stream.Stream;

public class AnnotationTest {
    @Test(name = "ceshi annotation is success")
    public void printAnnotation(String name) {
        Stream.of(name.split(" ")).forEach(n -> System.out.println(n));
        @SuppressWarnings("use but no recommed")
        Date date = new Date(12, 8, 12);
        System.out.println(date);
    }

    public static void main(String[] args) {
        AnnotationTest at=new AnnotationTest();
        at.printAnnotation("ceshi a");
    }
}
