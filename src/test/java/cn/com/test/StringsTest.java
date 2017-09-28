package cn.com.test;

import com.google.common.base.CaseFormat;
import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.util.StringUtils;

public class StringsTest {

	//	@Test
	public void joinerTest() {
		String[] strings = { "a", "b", null, "c" };
		System.out.println(StringUtils.arrayToDelimitedString(strings, ","));
		System.out.println(Joiner.on(",").skipNulls().join(strings));
	}

	//		@Test
	public void splitterTest() {
		String string = ",a,,b,";
		System.out.println(Lists.newArrayList(string.split(",")));
		//	    "", "a", "", "b", ""
		//	    null, "a", null, "b", null
		//	    "a", null, "b"
		//	    "a", "b"
		System.out.println(Splitter.on(',').trimResults().omitEmptyStrings().split(string));
	}

//	@Test
	public void charMatchersTest() {
		String string = "notion 1: what constitutes a matching character? It then provides many operations answering notion 2: what to";

		System.out.println(CharMatcher.javaLetter().countIn(string));
		System.out.println(CharMatcher.javaDigit().retainFrom(string));
		System.out.println(CharMatcher.javaDigit().removeFrom(string));
		System.out.println(CharMatcher.javaDigit().or(CharMatcher.javaLetter()).replaceFrom(string, "*"));
	}

		@Test
	public void caseFormatTest() {
		System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "CONSTANT_NAME"));
	}
}
