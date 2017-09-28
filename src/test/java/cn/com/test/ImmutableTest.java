package cn.com.test;

import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImmutableTest {

	@Test
	public void test() {
		ImmutableList.<Integer> builder().add(1).add(2).add(3).build();
		ImmutableList.of(1, 2, 3);
		ImmutableList.copyOf(new Integer[] { 1, 2, 3 });

		List<Integer> list = Lists.newArrayList(1, 2, 3);             //原始引用类
		ImmutableList<Integer> guavaImmutableList = ImmutableList.copyOf(list);  //guava生成的不可变类
		List<Integer> jdkUnmodifiableList = Collections.unmodifiableList(list); //JDK生成的不可变类

		Stopwatch stopwatch = Stopwatch.createStarted();
		for (int i = 0; i < 10000000; i++) {
			jdkUnmodifiableList.get(0);
		}
		System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));   //遍历da打印的时间

		stopwatch.reset();
		stopwatch.start();
		for (int i = 0; i < 10000000; i++) {
			guavaImmutableList.get(0);                  //遍历打印的时间
		}
		System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));

		list.add(4); //修改原始类
		System.out.println(guavaImmutableList.size());       //观察guava不可变类的内容是否变化
		System.out.println(jdkUnmodifiableList.size());     //观察jdk不可变类的内容是否变化

		//取得前几个元素的值
		ImmutableList<String> imList=ImmutableList.of("peida","jerry","harry","lisa","jerry");
		System.out.println("imList："+imList);
		ImmutableSortedSet<String> imSortList=ImmutableSortedSet.copyOf(imList);
		System.out.println("imSortList："+imSortList);
		System.out.println("imSortList as list："+imSortList.asList().get(2));
	}
}
