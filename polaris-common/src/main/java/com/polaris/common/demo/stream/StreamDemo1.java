package com.polaris.common.demo.stream;

import lombok.Data;

/**
 * Stream的操作符大体上分为两种：中间操作符和终止操作符
 * <p>
 * 中间操作符:对于数据流来说，中间操作符在执行制定处理程序后，数据流依然可以传递给下一级的操作符。
 * map(mapToInt,mapToLong,mapToDouble),flatmap(flatmapToInt,flatmapToLong,flatmapToDouble),limit,distint,filter,peek,skip,sorted(unordered)
 * <p>
 * 终止操作符:数据经过中间加工操作，就轮到终止操作符上场了；
 * 终止操作符就是用来对数据进行收集或者消费的，数据到了终止操作这里就不会向下流动了，终止操作符只能使用一次。
 * <p>
 * collect,count,findFirst、findAny,noneMatch、allMatch、anyMatch,min、max,reduce,forEach、forEachOrdered,toArray
 * <p>
 * !!!!Stream 的一系列操作必须要使用终止操作，否则整个数据流是不会流动起来的，即处理操作不会执行。
 * <p>
 * foreach 属于集合的语法糖
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        //Stream.of("xiaoming", "wangwu", "zhangsan", "lisi").map(e -> e.length()).forEach(e -> System.out.println(e));
        //Stream.of("a-b-c", "d-e-f", "g-h-i").flatMap(e -> Stream.of(e.split("-"))).forEach(e -> System.out.println(e));
        //Stream.of(1, 2, 3, 4, 5, 6).limit(3).forEach(e -> System.out.println(e));
        //Stream.of(1, 2, 1, 2, 3, 4, 5, 6, 7, 7, 7, 8).distinct().forEach(e -> System.out.print(e));
        //Stream.of(1,2,3,4,5,6,7,8,9,2,3,2,2,2,2).filter(e->e==2).forEach(e->System.out.print(e));
/*        User user1 = new User("zs", 10);
        User user2 = new User("ls", 11);
        User user3 = new User("ww", 12);
        Stream.of(user1, user2, user3).peek(e -> {
            e.setName(e.getName() + e.getAge());
        }).forEach(e -> System.out.print(e));*/
        //Stream.of(1, 2, 3, 4).skip(2).forEach(e -> System.out.print(e));
        //Stream.of(1, 3, 2, 6, 5, 4).sorted().forEach(e -> System.out.print(e));
        //Stream.of("张三", "王五", "小金", "小绿").collect(Collectors.toSet()).forEach(e -> System.out.print(e));
        //System.out.println(Stream.of(1, 2, 3, 4, 5, 6).count());
/*        Optional<String> value = Stream.of("a", "b", "v", "d", "h", "p").findFirst();
        System.out.print(value.get());*/
/*        Optional<String> value = Stream.of("b", "a", "v", "d", "h", "p").parallel().findAny();
        System.out.print(value.get());*/
        //boolean result=Stream.of("b", "a", "v", "d", "h", "p").noneMatch(e->"o".equalsIgnoreCase(e));
        //boolean result=Stream.of("b", "a", "v", "d", "h", "p").anyMatch(e->"a".equalsIgnoreCase(e));
        //int value=Stream.of(0,2,3,8,9,5,6,4).max((e1,e2)->e1.compareTo(e2)).get();
        //int value = Stream.of(0, 2, 3, 8, 9, 5, 6, 4).reduce(0, (e1, e2) -> e1 + e2);
        //Stream.of(0, 2, 3, 8, 9, 5, 6, 4).parallel().forEachOrdered(e -> System.out.println(Thread.currentThread().getName() + e));
        //Object[] objects = Stream.of(0, 2, 3, 8, 9, 5, 6, 4).toArray();
    }

    @Data
    private static class User {
        private String name;
        private int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
