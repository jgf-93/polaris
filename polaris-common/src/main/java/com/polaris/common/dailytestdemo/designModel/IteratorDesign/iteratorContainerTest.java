package com.polaris.common.dailytestdemo.designModel.IteratorDesign;

/**
 * 迭代器设计模式
 * 意图：提供一种方法顺序访问一个聚合对象中各个元素, 而又无须暴露该对象的内部表示。
 * <p>
 * 主要解决：不同的方式来遍历整个整合对象。
 * <p>
 * 何时使用：遍历一个聚合对象。
 * <p>
 * 如何解决：把在元素之间游走的责任交给迭代器，而不是聚合对象。
 * <p>
 * 关键代码：定义接口：hasNext, next。
 * <p>
 * 应用实例：JAVA 中的 iterator。
 * <p>
 * 优点：
 * 1、它支持以不同的方式遍历一个聚合对象。
 * 2、迭代器简化了聚合类。
 * 3、在同一个聚合上可以有多个遍历。
 * 4、在迭代器模式中，增加新的聚合类和迭代器类都很方便，无须修改原有代码。
 * <p>
 * 缺点：
 * 由于迭代器模式将存储数据和遍历数据的职责分离，
 * 增加新的聚合类需要对应增加新的迭代器类，
 * 类的个数成对增加，这在一定程度上增加了系统的复杂性。
 * <p>
 * 使用场景：
 * 1、访问一个聚合对象的内容而无须暴露它的内部表示。
 * 2、需要为聚合对象提供多种遍历方式。
 * 3、为遍历不同的聚合结构提供一个统一的接口。
 */

import java.util.*;
import java.util.Iterator;

public class iteratorContainerTest {
    public static void main(String[] args) {
        List<String> nameList = new ArrayList();
        nameList.add("张三");
        nameList.add("李四");
        nameList.add("王五");
        CollectionIteratorContainer ci = new CollectionIteratorContainer();
        for (Iterator it = (Iterator) ci.getIterator(nameList); it.hasNext(); ) {
            System.out.println((String) it.next());
        }
        Set<String> nameSet = new HashSet<>();
        nameSet.add("张三");
        nameSet.add("李四");
        nameSet.add("王五");
        for (Iterator it = (Iterator) ci.getIterator(nameSet); it.hasNext(); ) {
            System.out.println((String) it.next());
        }
    }
}
