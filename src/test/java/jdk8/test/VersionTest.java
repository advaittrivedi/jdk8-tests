package jdk8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import jdk8.Version;

import org.junit.Test;

public class VersionTest {

	@Test
	public void test() {
		List<Version> versions = Arrays.asList(new Version("2.4.1"),
				(new Version("2.4.2")), (new Version("2.4.3")), (new Version(
						"2.4.6")), (new Version("2.4.5")),
				(new Version("2.4.4")), (new Version("1.4")), (new Version(
						"1.0")), (new Version("1.55")), new Version("1.41"),
				new Version("1.40"), new Version("2.4.0"), new Version("2.4"), new Version("2.1"), new Version("2.4.51"));

//		List<Version> theVersion = versions.parallelStream()
//				.filter((Version v) -> v.getVersion().equals("1.56"))
//				.collect(Collectors.toList());

		Comparator<Version> versionComparator = Comparator
				.comparing(Version::getVersion);
		versions.sort(versionComparator);
		System.out.println(versions);
		
//		List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
//		List<Integer> numbers2 = Arrays.asList(3, 4, 5);
//		
//		numbers1.stream().flatMap(
//				(Integer i)->numbers2.stream().map(
//						j -> new Integer[]{i, j}
//						)
//					).forEach(
//							aValue -> {
//								System.out.println(((Integer[])aValue)[0]+","+
//								((Integer[])aValue)[1]);	
//										}
//							);
		
		
		//Arrays.stream(numbers).map(i -> i*i).collect(Collectors.);
		
	}
}