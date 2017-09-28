package cn.com.test;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class CollcectionUtilsTest {

//	@Test
	public void listsTest() {
//		List<Integer> list=new ArrayList<>();
		List<Integer> list = Lists.newArrayList();
		list = Lists.newArrayList(1, 2, 3, 4, 5);
		System.out.println(Lists.reverse(list));
		System.out.println(Lists.partition(list, 2));
		System.out.println(Lists.transform(list, new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer input) {
				return input * input;
			}
		}));
	}

//	@Test
	public void mapsTest() {
		Map<Integer, Integer> map = Maps.newTreeMap();
		map.put(1, 10);
		map.put(2, 20);
		map.put(3, 30);
		map.put(11, 10);
		System.out.println(Maps.filterKeys(map, Predicates.equalTo(2)));
		System.out.println(Maps.filterValues(map, Predicates.equalTo(10)));
		System.out.println(Maps.transformValues(map, new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer input) {
				return input * input;
			}
		}));

		Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
		Map<String, Integer> right = ImmutableMap.of("b", 2, "c", 4, "d", 5);
		MapDifference<String, Integer> diff = Maps.difference(left, right);

		System.out.println(diff.entriesInCommon()); // {"b" => 2}
		System.out.println(diff.entriesDiffering()); // {"c" => (3, 4)}
		System.out.println(diff.entriesOnlyOnLeft()); // {"a" => 1}
		System.out.println(diff.entriesOnlyOnRight()); // {"d" => 5}
	}

	@Test
	public void iterableTest() {
		List<Integer> list = Lists.newArrayList(1, 2, 3, 4, 5);
		System.out.println(Iterables.all(list, Predicates.instanceOf(Integer.class)));
		System.out.println(Iterables.any(list, Predicates.equalTo(2)));
		System.out.println(Iterables.isEmpty(list));
		System.out.println(Iterables.frequency(list, 2));
		System.out.println(Iterables.size(list));
		System.out.println(Iterables.concat(list, Lists.newArrayList(5, 6, 7)));
		System.out.println(Iterables.getFirst(list, 2));
		System.out.println(Iterables.toArray(list, Integer.class));
	}
}
