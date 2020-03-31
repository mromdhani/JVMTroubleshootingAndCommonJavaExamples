package be.businesstraining;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Example1_Hello_Streams {
	
	public static void main(String[] args) {
		System.out.println("Java 8 Streams Demo /Map reduce");
		
		List<String> lines = Arrays.asList("Hibernate", "Struts", "Spring Boot", "Log4j", "Spring MVC");

	   // Predicate<String> criteria= 	; 
	    
        List<String> result = lines.stream()             // convert list to stream
                .filter( s -> s.startsWith("S")   )     // we filter strings starting with S
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());           // collect the output and convert streams to a List

        
        // Consumer<String> cons = o -> System.out.println(o);
        // or
         Consumer<String> cons = System.out::println;
        
        result.forEach(cons);             
	}
}
