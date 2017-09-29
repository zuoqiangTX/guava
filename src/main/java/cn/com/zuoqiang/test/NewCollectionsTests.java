package cn.com.zuoqiang.test;

import com.google.common.collect.*;
import pojo.Person;

import java.util.Map;

public class NewCollectionsTests {
    public static void main(String[] args) {
        //MultiSet的统计功能
        //就是一般的set，但是加入了重复的值会被统计进去
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("c");
        multiset.add("c");
        multiset.add(null);
        System.out.println("multiset的统计功能"+multiset.count("a"));
        System.out.println(multiset);
        //MultiMap  仅仅只是个接口
        Multimap<String, String> multimap = HashMultimap.create();  //这个会对值去重，相当于Map<key, Set<E>>
        multimap.put("a", "a");
        multimap.put("a", "b");
        multimap.put("a", "a");
        System.out.println("去重的multimap"+multimap.get("a"));

        multimap = ArrayListMultimap.create();      //这个不会对值去重，允许重复的元素存在，相当于Map<key, List<E>>
        multimap.put("a", "a");
        multimap.put("a", "b");
        multimap.put("a", "a");
        System.out.println("允许重复的multiMap"+multimap.get("a"));

        //双向Map，可以反转  BiMap是它的接口
        Map<String, Integer> nameToId = Maps.newHashMap();
        nameToId.put("zuoqiang",2);
        BiMap<String,Integer> biMap = HashBiMap.create(nameToId);
        System.out.println(biMap.get("zuoqiang"));
        System.out.println(biMap.inverse().get(2));

        //Table接口，类似于 Map<K1, Map<K2, V>>
        Table<Integer, Integer, Person> table = HashBasedTable.create();
        table.put(1, 1, new Person("20", "a"));
        table.put(1, 2, new Person("20", "b"));
        table.put(2, 1, new Person("20", "c"));
        table.put(2, 2, new Person("20", "d"));
        System.out.println(table);
        System.out.println(table.row(1));
        System.out.println(table.column(2));


    }
}
