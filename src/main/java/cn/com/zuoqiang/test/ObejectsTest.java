package cn.com.zuoqiang.test;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import pojo.Person;

public class ObejectsTest {
    public static void main(String[] args) {
        //简化为空的参数判断
        boolean[] flags = new boolean[4];
        flags[0] = Objects.equal("a","a");
        flags[0] = Objects.equal(null,"a");
        flags[0] = Objects.equal("a",null);
        flags[0] = Objects.equal(null,null);
        for (boolean flag : flags){
            System.out.println("结果为"+ flag);
        }
        //简化hashcode的方法
        System.out.println(Objects.hashCode("a","b"));
        System.out.println(Objects.hashCode("b","a"));
        //简化toString方法的写法 类名{key = value}
        Object o = new Object();
        Person p = new Person("001","zuoqiang");
        String a = MoreObjects.toStringHelper(o).add("zuo","1111").add("qiang","222").toString();
        String b = MoreObjects.toStringHelper("My hourse").add("home","山西省大同市").toString();
        System.out.println("期望的显示值为Object{zuo=111,qiang=222}-----------"+a);
        System.out.println("期望的显示值为My hourse{home=山西省大同市}---------"+b);

    }
}
