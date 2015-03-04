package jdk8.test;


import org.junit.Test;

import static java.util.stream.Collectors.*;
import static jdk8.Dish.*;

public class MenuTest {

	@Test
	public void test() {
		System.out.println(menu.stream().collect(counting()));
	}

}
