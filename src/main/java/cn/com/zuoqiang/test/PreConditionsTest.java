package cn.com.zuoqiang.test;

import com.google.common.base.Preconditions;
import pojo.Person;

public class PreConditionsTest {
    public static void main(String[] args) {
        //检查方法的参数，可以立即抛出异常错误，也可以定制错误信息
        int i = 1;
        int j = 2;
      //  Preconditions.checkArgument(i <= 0);  //当不符合条件的时候就会报出异常IllegalArgumentException
       // Preconditions.checkArgument(i > j ,"i期望大于j，结果不是这样子");
       // Preconditions.checkArgument(i > j ,"i期望大于j，结果%s小于%s",i,j);

        //检查是否为null的
        Object o = new Object();
        Person person = null;
        Preconditions.checkNotNull(o);  //如果为null 就会报出空指针错误
        //Preconditions.checkNotNull(person);

    }
}
