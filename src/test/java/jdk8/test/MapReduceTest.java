package jdk8.test;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.groupingByConcurrent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

public class MapReduceTest {
	@Test
	public void testConcurrent() throws IOException {
		Stream<String> lines = Files.lines(Paths
				.get("/Users/atrivedi/Downloads/pg1342_concurrent.txt"));
		long start = System.currentTimeMillis();
		Map<Object, Long> words = lines.parallel()
				.map(line->line.split("\\W"))
				.flatMap(Arrays::stream).map(String::toLowerCase)
				.collect(groupingByConcurrent(s -> s, counting()));
		lines.close();
		System.out.println("time taken concurrent:"
				+ (System.currentTimeMillis() - start));
		System.out.println("concurrent words=" + words);
	}

	@Test
	public void test() throws IOException {
		Stream<String> lines = Files.lines(Paths
				.get("/Users/atrivedi/Downloads/pg1342.txt"));
		long start = System.currentTimeMillis();
		Map<Object, Long> words = lines.map((String line) -> line.split("\\W"))
				.flatMap(Arrays::stream).map(s -> s.toLowerCase())
				.collect(groupingBy(s -> s, counting()));
		lines.close();
		System.out
				.println("time taken:" + (System.currentTimeMillis() - start));
		System.out.println("words=" + words);
	}
}