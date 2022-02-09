package com.polaris.common.demo.stream;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo4 {
    public static void main(String[] args) {
        List<String> test = new ArrayList<>();
        test.add("测试");
        test.add("学习");
        System.out.println(test.stream().collect(Collectors.joining(",")));
        groupData();
    }

    /**
     * lambda排序
     */
    private static void sort() {
        List<Test> testList = new ArrayList<>();
        Test test1 = new Test();
        test1.setAge(1);
        test1.setCredId(111);
        testList.add(test1);
        Test test2 = new Test();
        test2.setAge(3);
        test2.setCredId(12);
        testList.add(test2);
        Test test3 = new Test();
        test3.setAge(2);
        test3.setCredId(11);
        testList.add(test3);
        Test test4 = new Test();
        test4.setAge(2);
        test4.setCredId(2);
        testList.add(test4);
        List<Test> newList = testList.stream().sorted(Comparator.comparing(Test::getAge).thenComparing(Test::getCredId)).collect(Collectors.toList());
        System.out.println(JSON.toJSONString(newList));
    }

    /**
     * lambda分组
     */
    private static void groupData() {
        List<Test> testList = new ArrayList<>();
        Test test1 = new Test();
        test1.setAge(1);
        test1.setCredId(111);
        testList.add(test1);
        Test test2 = new Test();
        test2.setAge(3);
        test2.setCredId(12);
        testList.add(test2);
        Test test3 = new Test();
        test3.setAge(2);
        test3.setCredId(11);
        testList.add(test3);
        Test test4 = new Test();
        test4.setAge(2);
        test4.setCredId(2);
        testList.add(test4);
        Map<Integer, Set<Integer>> map = testList.stream().collect(Collectors.groupingBy(Test::getAge, Collectors.mapping(Test::getCredId, Collectors.toSet())));
        System.out.println(map);
    }

    @Data
    static class Test {
        private int age;
        private int credId;
    }
}
