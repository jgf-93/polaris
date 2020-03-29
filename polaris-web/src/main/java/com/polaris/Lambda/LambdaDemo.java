package com.polaris.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntBinaryOperator;

/**
 * 函数式编程：它将电脑运算视为数学上的函数计算，并且避免使用程序状态以及易变对象
 * 函数式编程更加强调程序执行的结果而非过程
 * <p>
 * 函数式编程的特性：
 * 1：(函数是"第一等公民")：函数不仅拥有一切其他函数的使用方式，可以赋值给其他变量。也可以作为参数，传入另一个函数。还可以作为别的函数的返回值
 * 函数可以当作参数传入，吧"行为"参数化，意味着我们可以把逻辑从外部传入，程序就可以设计的更灵活
 * 2：(没有"副作用")：函数内部与外部互动(最典型的情况是修改全局变量的值)，产生运算以外的其他结果。函数式编程强调没有"副作用"，
 * 函数保持独立，所有功能就是返回一个新值，没有其他行为，不能修改外部的变量
 * 3：(引用透明)：函数的运行不依赖于外部的变量或"状态"，只依赖于输入参数，只要输入参数相同，函数的返回值总是一样
 * <p>
 * 优点->函数式编程:
 * 1:函数式编程大量使用函数，减少了代码的重复，因此程序比较短，(开发速度较快)。
 * 2:函数式编程的自由度很高，很接近自然语言,(易于理解)
 * 3:函数式编程不依赖也不会改变外界的状态，只要给定参数相同，返回值必定相同。每一个函数可以被看作独立单元(代码方便管理)
 * 4:函数式编程不会发生死锁，因为它不修改变量，不存在‘锁’线程的问题（易于并发编程）
 * 5:函数式编程支持热升级，接口不变的情况下，内部实现是与外部无关的(热升级)
 * 缺点:
 * 函数式编程严重耗费cpu和存储器资源
 * (1)早期的函数式编程并未考虑到性能问题
 * (2)有些非函数式编程语言为求提升速度，不提供自动边界检查或者垃圾回收等功能
 * (3)语言学习难度高
 * <p>
 * <p>
 * java 8 Lambda 表达式的实现方式在本质是以匿名内部类的形式的实现的！！！！！！！！！！！！！！！
 * 对于函数式接口来说@FunctionalInterface并不是必须的,
 * 只要接口中只定义了唯一的抽象方法的接口那它就是一个实质上的函数式接口,就可以用来实现Lambda表达式。
 */
public class LambdaDemo {
    /**
     * lambda表达式
     * 语法：
     * 第一部分:一个括号内用逗号分隔的形式参数(int a)
     * 第二部分：一个箭头符号->
     * 第三部分：方法体(可以是表达式或者代码块)
     * <p>
     * 1、方法体为表达式，该表达式的值作为返回值返回。
     * 例:(int a,int b) -> return a + b; //求和
     * 2、方法体为代码块，必须用 {} 来包裹起来，且需要一个 return 返回值，但若函数式接口里面方法返回值是 void，则无需返回值。
     * 例:
     * (int a) -> {System.out.println("a = " + a);} //打印，无返回值
     * (int a) -> {return a * a;} //求平方
     * <p>
     * Lambda表达式的应用场景!!!!!!!!!!!!!!!!!!
     * 1、使用() -> {} 替代匿名类
     * 2、以流水线的方式处理数据
     * 3、更简单的数据并行处理
     * 4、用内部迭代取代外部迭代
     * 5、重构现有臃肿代码，更高的开发效率
     * <p>
     * Lambda表达式中的Stream
     * Stream 就如同一个迭代器（Iterator），单向，不可往复，数据只能遍历一次，遍历过一次后即用尽了，
     * 就好比流水从面前流过，一去不复返。而和迭代器又不同的是，Stream 可以并行化操作，迭代器只能命令式地、串行化操作。
     * stream流的创建方式:
     * 由值创建流：Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
     * 由数组创建流：int[] numbers = {2, 3, 5, 7, 11, 13}; int sum = Arrays.stream(numbers).sum();
     * 由文件创建流: Stream<String> lines =Files.lines(Paths.get("data.txt"), Charset.defaultCharset())
     * 用函数来创建一个无限Stream:Stream.iterate(0, n -> n + 2).forEach(System.out::println);
     * <p>
     * JDK8中有双冒号的用法，就是把方法当做参数传到stream内部，使stream的每个元素都传入到该方法里面执行一下。!!!!
     * 这个双冒号的是吧方法当作参数传入了！！！！！！  函数式编程的特点
     *
     * @param args
     */
    private String testValue = "wo zai ce shi";

    public static void main(String[] args) {
        //LambdaDemo lb = new LambdaDemo();
        //lb.test();
        List<String> valueList = Arrays.asList("张三", "李四", "王五", "地藏");
        valueList.forEach(LambdaDemo::pp);
        Consumer<String> consumer = LambdaDemo::pp;
        valueList.forEach(x -> consumer.accept(x));
    }

    public static void pp(String a) {
        System.out.println(a);
    }

    public void test() {
/*        IntBinaryOperator intBinaryOperator = (int a, int b) -> {
            return a + b;
        };
        System.out.println(intBinaryOperator.applyAsInt(1, 2));*/

        Foo foo1 = new Foo() {
            String testValue = "test1";

            public String p() {
                return this.testValue;
            }
        };
        Foo foo2 = () -> {
            String testVlaue = "test2";
            return this.testValue;
        };
        System.out.println("匿名内部类输出:" + foo1.p() + "-lambda表达式输出:" + foo2.p());
    }
}

interface Foo {
    String p();
}
