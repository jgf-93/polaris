package com.polaris.common.demo.test;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.stream.Collectors;

public class LocalTest {
    @stu
    private static final String constantA="constant-A";

    public static String study(String userId){
        System.out.println("study");
        return "study";
    }
    public int toBig(long value){
        return (int)value;
    }
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
    public @interface stu{
        String tag() default "-1";
    }
    public static void main(String[] args) {
        Class<LocalTest> localTestClass=LocalTest.class;
        Field[] fields=localTestClass.getDeclaredFields();
        for(Field field:fields){
            System.out.println("字段名:"+field.getName());
            Annotation[] annotations=field.getDeclaredAnnotations();
            for(Annotation annotation:annotations){
                Method[] methods=annotation.annotationType().getDeclaredMethods();
                System.out.println("注解上的方法："+ Arrays.stream(methods).map(Method::getName).collect(Collectors.toList()));
            }
        }
        Method[] methods=localTestClass.getDeclaredMethods();
        for(Method m:methods){
            Type[] pTypes=m.getGenericParameterTypes();
            for(Type t:pTypes){
                System.out.println("方法名："+m.getName()+"参数值类型名："+t.getTypeName());
                System.out.println("方法名："+m.getName()+"参数类类型："+t.getClass().getTypeName());
            }
            Type rType=m.getGenericReturnType();
            System.out.println("方法名："+m.getName()+"返回值类型："+rType.getTypeName());
        }
    }
}
