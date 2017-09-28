package cn.com.test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;
import com.google.common.collect.*;
import org.junit.Test;
import pojo.Person;

import java.util.HashMap;
import java.util.Map;

public class NewCollectionsTest {

	//@Test
	public void multisetTest() {
		Iterable<String> words = Splitter
				.on(CharMatcher.breakingWhitespace())
				.split("The traditional way to map values back to keys is to maintain two separate maps and keep them both in sync, but this is bug-prone and can get extremely confusing when a value is already present in the map");
		Map<String, Integer> counts = new HashMap<String, Integer>();
		for (String word : words) {
			Integer count = counts.get(word);
			if (count == null) {
				counts.put(word, 1);
			} else {
				counts.put(word, count + 1);
			}
		}
		System.out.println(counts.get("to"));

		Multiset<String> multiset = HashMultiset.create(words);
		System.out.println(multiset.count("to"));
		multiset.add("to");
		System.out.println(multiset.count("to"));
	}

	@Test
	public void multimapTest() {
		Multimap<String, String> multimap = HashMultimap.create();
		multimap.put("a", "a");
		multimap.put("a", "b");
		multimap.put("a", "a");

		System.out.println(multimap.get("a"));

		multimap = ArrayListMultimap.create();
		multimap.put("a", "a");
		multimap.put("a", "b");
		multimap.put("a", "a");
		System.out.println(multimap.get("a"));
	}

//	@Test
	public void bimapTest() {
		Map<String, Integer> nameToId = Maps.newHashMap();
		Map<Integer, String> idToName = Maps.newHashMap();
		nameToId.put("Bob", 42);
		idToName.put(42, "Bob");

		BiMap<String, Integer> biMap = HashBiMap.create(nameToId);
		System.out.println(biMap.get("Bob"));
		System.out.println(biMap.inverse().get(42));
	}

	@Test
	public void tableTest() {
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
