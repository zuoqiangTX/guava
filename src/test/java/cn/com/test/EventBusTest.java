package cn.com.test;

import com.google.common.collect.Lists;
import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.junit.Test;

public class EventBusTest {

	@Test
	public void test() {
		EventBus eventBus = new EventBus();
		eventBus.register(new Object() {

			@Subscribe
			public void sub(String value) {
				System.out.println(value);
			}
		});

		eventBus.post("1"); //print 1
		eventBus.post("2"); //print 2

		eventBus.register(new Object() {

			@Subscribe
			public void sub(DeadEvent value) {
				System.out.println("receive dead event " + value);
			}
		});

		eventBus.post(1);
		eventBus.post(Lists.newArrayList(1));
	}
}
