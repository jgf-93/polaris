package com.polaris.common.demo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * java8stream 支持函数式编程
 * 什么是函数式接口？简单来说就是只有一个抽象函数的接口。为了使得函数式接口的定义更加规范，
 * java8 提供了@FunctionalInterface 注解告诉编译器在编译器去检查函数式接口的合法性，
 * 以便在编译器在编译出错时给出提示。为了更加规范定义函数接口，给出如下函数式接口定义规则：
 * <p>
 * 1:有且仅有一个抽象函数
 * 2:必须要有@FunctionalInterface 注解
 * 3:可以有默认方法
 * <p>
 * 函数式api
 * Consumer:消费者接口，就是用来消费数据的。
 * Function:提供一种转换功能。
 * Operator:可以简单理解成算术中的各种运算操作
 * Predicate:断言、判断，对输入的数据根据某种标准进行评判，最终返回boolean值
 * Supplier:生产、提供数据
 */

public class StreamDemo2 {
    public static void main(String[] args) {
        Function<Integer, Integer> square = integer -> integer * integer;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        //四次方处理
        //list.stream().map(square.andThen(square).andThen(square)).forEach(e -> System.out.println(e));
        //减一再平方
        list.stream().map(square.andThen(e -> e - 1)).forEach(e -> System.out.println(e));
        //Stream.of(2, 4, 5, 6, 7, 1).reduce(BinaryOperator.maxBy(Comparator.comparing(Integer::intValue))).ifPresent(System.out::println);
        //IntBinaryOperator intBinaryOperator = (e1, e2) -> (e1 + e2);
        //IntStream.of(2, 4, 5, 6, 7, 1).reduce(intBinaryOperator).ifPresent(System.out::println);

        //选出大于0的2个数
        //IntStream.of(200,177,2,-22,-31,-33).filter(e->e>0).limit(2).forEach(e->System.out.println(e));

        //一直产生2
        //Stream.generate(() -> 2).limit(10).forEach(e -> System.out.println(e));
    }

}
