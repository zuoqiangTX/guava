package cn.com.zuoqiang.test;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSortedSet;
import pojo.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableTest {
    public static void main(String[] args) {
        //不可变集合，顾名思义就是说集合是不可被修改的。集合的数据项是在创建的时候提供，并且在整个生命周期中都不可改变。
        //url:http://www.cnblogs.com/peida/p/Guava_ImmutableCollections.html
       /* 为什么要用immutable对象？immutable对象有以下的优点：
        1.对不可靠的客户代码库来说，它使用安全，可以在未受信任的类库中安全的使用这些对象
        2.线程安全的：immutable对象在多线程下安全，没有竞态条件
        3.不需要支持可变性, 可以尽量节省空间和时间的开销. 所有的不可变集合实现都比可变集合更加有效的利用内存 (analysis)
        4.可以被使用为一个常量，并且期望在未来也是保持不变的
        immutable对象可以很自然地用作常量，因为它们天生就是不可变的对于immutable对象的运用来说，它是一个很好的防御编程（defensive programming）的技术实践。
        */
        //1)正常jdk的list
        System.out.println("-----------------------jdk---------------------------------------");
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println("jdk自带的List为" + list);

        List<String> unmodifyList = Collections.unmodifiableList(list);
        System.out.println("jdk实现的不可变集合（会有一定的问题）" + unmodifyList);
        String temp = unmodifyList.get(1);
        System.out.println("unmodifiableList [0]：" + temp);
        list.add("baby");   //当不可变集合的原始集合改变以后，jdk自带的也会改变
        System.out.println("改变后的list为" + list);
        System.out.println("改变后的UnmodifableList为" + unmodifyList);   //居然tm的改变了！！！！
       /* unmodifyList.add("cc");
        System.out.println("unmodifiableList add a item after list:"+unmodifyList);   //但是直接修改不可变集合确实会报错*/
        //总结
        /*说明：Collections.unmodifiableList实现的不是真正的不可变集合，当原始集合修改后，不可变集合也发生变化。不可变集合不可以修改集合数据，当强制修改时会报错，实例中的最后两个add会直接抛出不可修改的错误。
　　  总结一下JDK的Collections.unmodifiableXXX方法实现不可变集合的一些问题：
　　  1.它用起来笨拙繁琐你不得不在每个防御性编程拷贝的地方用这个方法
　　  2.它不安全：如果有对象reference原始的被封装的集合类，这些方法返回的集合也就不是正真的不可改变。
　　  3.效率低：因为它返回的数据结构本质仍旧是原来的集合类，所以它的操作开销，包括并发下修改检查，hash table里的额外数据空间都和原来的集合是一样的。
        * */


        //2)用google的guava生成的不可变集合
        //Guava的immutable集合
        //Guava提供了对JDK里标准集合类里的immutable版本的简单方便的实现，以及Guava自己的一些专门集合类的immutable实现。当你不希望修改一个集合类，或者想做一个常量集合类的时候，使用immutable集合类就是一个最佳的编程实践。
     /*   注意：每个Guava immutable集合类的实现都拒绝null值。我们做过对Google内部代码的全面的调查，
         并且发现只有5%的情况下集合类允许null值，而95%的情况下都拒绝null值。
        /万一你真的需要能接受null值的集合类，你可以考虑用Collections.unmodifiableXXX。*/
     /*　Immutable集合使用方法：
　　一个immutable集合可以有以下几种方式来创建：
　　1.用copyOf方法, 譬如, ImmutableSet.copyOf(set)
　　2.使用of方法，譬如，ImmutableSet.of("a", "b", "c")或者ImmutableMap.of("a", 1, "b", 2)
　　3.使用Builder类
     * */
        System.out.println("-----------------------guava---------------------------------------");
        List<String> googleList = new ArrayList<String>();
        googleList.add("a");
        googleList.add("b");
        googleList.add("c");
        System.out.println("googleList：" + googleList);
        ImmutableList<String> immutableList = ImmutableList.copyOf(googleList);
        System.out.println("immutableList" + immutableList);
        ImmutableList<String> immutableList1 = ImmutableList.of("a", "b", "c", "d", "e");
        System.out.println("immutableList1" + immutableList1);

        ImmutableSet<String> immutableSortedSet = ImmutableSortedSet.of("a", "b", "c", "d","b");
        //对于排序的集合来说有例外，因为元素的顺序在构建集合的时候就被固定下来了。譬如，ImmutableSet.of("a", "b", "c", "a", "d", "b")，对于这个集合的遍历顺序来说就是"a", "b", "c", "d"。
        System.out.println("immutableSortedSet" + immutableSortedSet);

        googleList.add("d"); //原始集合修改，查看不可变类是否改变
        System.out.println("修改以后的原始类" + googleList);

        System.out.println("修改以后的不可变类" + immutableList);
        ImmutableSet<Person> personImmutableSet = ImmutableSet.<Person>builder().add(new Person("001", "zuoqiang")).build();
        System.out.println("personImmutableSet" + personImmutableSet);

        //取得第几个元素的值
        ImmutableList<String> imList=ImmutableList.of("peida","jerry","harry","lisa","jerry");
        System.out.println("imList："+imList);
        ImmutableSortedSet<String> imSortList=ImmutableSortedSet.copyOf(imList);
        System.out.println("imSortList："+imSortList);
        System.out.println("imSortList as list："+imSortList.asList().get(0));

        ImmutableList<String> imTestList=ImmutableList.of("peida","jerry","harry","lisa","jerry",null); //使用空指针会报错
    }
}
