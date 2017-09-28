package cn.com.test;

import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CacheTest {

	@Test
	public void test() throws InterruptedException, ExecutionException {

		LoadingCache<Integer, Integer> cache = CacheBuilder.newBuilder() //
				.recordStats() //
				.maximumSize(1000) //
				.expireAfterWrite(5, TimeUnit.SECONDS) //
				.removalListener(new RemovalListener<Integer, Integer>() {

					@Override
					public void onRemoval(RemovalNotification<Integer, Integer> notification) {
						System.out.println("remove " + notification);
					}
				}).build(new CacheLoader<Integer, Integer>() {

					@Override
					public Integer load(Integer key) {
						System.out.println("load " + key);
						return key * key;
					}
				});

		for (int i = 0; i < 110; i++) {
			cache.get(i);
		}
		
		System.out.println(cache.stats());

		for (int i = 0; i < 110; i++) {
			cache.get(i);
		}
		System.out.println(cache.stats());

		Thread.sleep(6000);
		cache.getUnchecked(200);
		System.out.println(cache.stats());
	}
}
