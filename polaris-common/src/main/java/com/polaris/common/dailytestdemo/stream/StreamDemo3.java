package com.polaris.common.dailytestdemo.stream;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamAPI的  Collectors收集器 提供了很多的api
 * 1:数据收集：set、map、list
 * 2:聚合归约：统计、求和、最值、平均、字符串拼接、规约
 * 3:前后处理：分区、分组、自定义操作
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        //Stream.of(1, 2, 3, 6, 7, 5, 4, 8, 8).collect(Collectors.toCollection(HashSet::new)).forEach(e -> System.out.println(e));
        //串行转换
/*        Stream.of(new User("ww", 1), new User("qq", 3), new User("tt", 6))
                .collect(Collectors.toMap(User::getName, Function.identity()));*/
        //并行转换
/*        Stream.of(new User("ww", 1), new User("qq", 3), new User("tt", 6))
                .parallel().collect(Collectors.toConcurrentMap(User::getName, Function.identity()));*/
        //转map
/*        Stream.of(new User("ww", 1), new User("qq", 3), new User("tt", 6))
                .collect(Collectors.toMap(User::getName, Function.identity(), BinaryOperator.maxBy(Comparator.comparing(User::getAge))));*/
        User user1 = new User("ww", 1);
        User user2 = new User("qq", 3);
        User user3 = new User("tt", 6);
        //聚合规约 list转字符串拼接
        //System.out.println(Stream.of(user1, user2, user3).map(User::getName).collect(Collectors.joining("^--^", "[", "]")));
        //取最大
        //Stream.of(1, 22, 12, 222, 33, 76, 2).collect(Collectors.maxBy(Integer::compareTo)).ifPresent(System.out::println);
        //summing---包含了数量统计count、求和sum、最小值min、平均值average、最大值max
        //System.out.println(Stream.of(1, 22, 12, 222, 33, 76, 2).collect(Collectors.summarizingInt(Integer::intValue)));
        //求平均值
        //System.out.println(Stream.of(1, 22, 12, 222, 33, 76, 2).collect(Collectors.averagingInt(Integer::intValue)));
        //规约处理
        //System.out.println(Stream.of(user1, user2, user3).map(User::getAge).collect(Collectors.reducing(0, (i1, i2) -> i1 + i2)));

        //前后处理---groupBy(groupingBy 是在数据收集前分组的，再将分好组的数据传递给下游的收集器。
        // 前后处理可以自定义容器map和自定义下游收集器,参数支持
/*        System.out.println(Stream.of(2, 44, 3, 7, 123, -1, -33, -44, 100, 99).collect(Collectors.groupingBy(i -> {
            if (i > 0) {
                return "正数";
            } else if (i < 0) {
                return "负数";
            } else {
                return 0;
            }
        })));*/
        //尚未发现返回值是啥
/*        Object object = Stream.of(2, 44, 3, 7, 123,123, -1, -33, -44, 100, 99).collect(Collectors.groupingBy(integer -> {
            if (integer > 0) {
                return "正数";
            } else if (integer < 0) {
                return "负数";
            } else {
                return 0;
            }
        }, LinkedHashMap::new, Collectors.toSet()));
        System.out.println(object);*/


        //Collectors.partitioningBy() 字面意思话就叫分区好了  --根据断言的处理,只有true false
        //System.out.println(Stream.of(1, 2, 2, 1, 1, 1).collect(Collectors.partitioningBy(i -> i == 1)));
        //System.out.println(Stream.of(1, 2, 2, 1, 1, 1).collect(Collectors.partitioningBy(i -> i == 1, Collectors.toSet())));

        //Collectors.mapping() 可以自定义要收集的字段。
        //System.out.println(Stream.of(user1, user2, user3).collect(Collectors.mapping(User::getName, Collectors.toSet())));

        //Collectors.collectingAndThen()收集后操作，如果你要在收集数据后再做一些操作，那么这个就非常有用了。
        Object ob = Stream.of(user1, user2, user3).collect(Collectors.collectingAndThen(Collectors.toList(), List::listIterator));
        System.out.println(JSON.toJSONString(ob));
    }

    @Data
    static class User {
        private String name;
        private int age;

        User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
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
