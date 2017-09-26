package cn.com.zuoqiang.test;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //初始化集合
        //jdk
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("jdk is" + list);
        //guava
        List<String> ls = Lists.newArrayList("a", "b", "c");
        System.out.println("guava is " + ls);

        //读取文件内容
        //jdk省略
        //guava
        //List<String> linelist = Files.readLines(new File(""), Charsets.UTF_8);

        //集合新类型
        //Guava针对开发中的常见场景，提供了一些新的集合类型简化代码。

        //类型1Multiset
        //类型2MultiMap

        //集合工具类

        //Sets
        //Primitives
        //hashing

    }

}
