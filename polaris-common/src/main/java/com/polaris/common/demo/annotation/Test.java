package com.polaris.common.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Java 注解（Annotation）又称 Java 标注，是 JDK5.0 引入的一种注释机制。
 * Java 语言中的类、方法、变量、参数和包等都可以被标注。
 * 和 Javadoc 不同，Java 标注可以通过反射获取标注内容。
 * 在编译器生成类文件时，标注可以被嵌入到字节码中。
 * Java 虚拟机可以保留标注内容，在运行时可以获取到标注内容 。
 * 当然它也支持自定义 Java 标注。
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Test {
    String name() default "";
}
