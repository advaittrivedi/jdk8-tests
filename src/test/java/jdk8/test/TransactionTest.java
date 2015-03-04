package jdk8.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import jdk8.Trader;
import jdk8.Transaction;

import org.junit.Test;

public class TransactionTest {

	@Test
	public void test() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");

		List<Transaction> transactions = Arrays.asList(new Transaction(brian,
				2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012,
						710), new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));

		List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);

		// Find all transactions in the year 2011 and sort them by value (small
		// to high).
		transactions.stream().filter(t -> t.getYear() == 2011)
				.sorted(Comparator.comparing(Transaction::getValue))
				.forEach((Transaction t) -> System.out.println(t));

		// What are all the unique cities where the traders work?
		transactions.stream().map((Transaction t) -> t.getTrader().getCity())
				.distinct().forEach((String city) -> System.out.println(city));

		// Find all traders from Cambridge and sort them by name.
		traders.stream()
				.filter(t -> t.getCity().equals("Cambridge") ? true : false)
				.sorted((t1, t2) -> {
					return t1.getName().compareTo(t2.getName());
				}).forEach(t -> System.out.println(t));

		// Return a string of all traders’ names sorted alphabetically.
		traders.stream().map(Trader::getName).sorted()
				.forEach(t -> System.out.println(t));

		// Are any traders based in Milan?
		System.out.println(traders.stream().anyMatch(
				t -> t.getCity().equals("Milan")));

		// Print all transactions’ values from the traders living in Cambridge.
		transactions.stream()
				.filter(t -> t.getTrader().getCity().equals("Cambridge"))
				.forEach(t -> System.out.println(t.getValue()));

		transactions.stream().max(Comparator.comparing(Transaction::getValue))
				.ifPresent(t -> System.out.println("max=" + t.getValue()));

		transactions.stream().min(Comparator.comparing(Transaction::getValue))
				.ifPresent(t -> System.out.println("min=" + t));

	}
}
