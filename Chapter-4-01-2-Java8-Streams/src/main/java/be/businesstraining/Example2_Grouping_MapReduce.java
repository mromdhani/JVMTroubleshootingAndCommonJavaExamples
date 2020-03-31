package be.businesstraining;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person {
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class Example2_Grouping_MapReduce {
	public static void main(String[] args) {
		System.out.println("Java 8 Streams Demo /Grouping - MapReduce");

		List<Person> persons = Arrays.asList(
				new Person("Max", 44), 
				new Person("Peter", 23), 
				new Person("Pamela", 23),
				new Person("David", 33));

		// Group By
//		Map<Integer, List<Person>> personsByAge = persons
//			    .stream()
//			    .collect(Collectors.groupingBy(p -> p.age));
//
//			personsByAge
//			    .forEach((age, p) -> System.out.format("age %s: %s\n", age, p));
//		
		
		// Map Reduce
		int sumOfAges =persons
		    .stream()
		    .map (p -> p.age)
		    .reduce(0, (p1, p2) -> p1+p2);
		    //.ifPresent(System.out::println);  
		System.out.println(sumOfAges);
	}
}
