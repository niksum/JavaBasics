package com.niksum.java.puzzel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.LongAdder;
import static java.lang.Integer.*;
public class ReadingFileUsingStream {
	public static void main(String[] args) {
		System.out.println("ReadingFileUsingStream.main method");
		try {
			wordCount();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void wordCount() throws IOException{
		ConcurrentHashMap<String, LongAdder> wordCounts = new ConcurrentHashMap<>();
		Path path = Paths.get("src/com/niksum/java/puzzel/input.txt");
		 long start = Instant.now().toEpochMilli();
		Files.readAllLines(path)
        .parallelStream()                               // Start streaming the lines
        .map(line -> line.split("\\s+"))                // Split line into individual words
        .flatMap(Arrays::stream)                        // Convert stream of String[] to stream of String
        .parallel()                                     // Convert to parallel stream
        .filter(w -> w.matches("\\w+"))                 // Filter out non-word items
        .map(String::toLowerCase)                       // Convert to lower case
        .forEach(word -> {                              // Use an AtomicAdder to tally word counts
            if (!wordCounts.containsKey(word))          // If a hashmap entry for the word doesn't exist yet
                wordCounts.put(word, new LongAdder());  // Create a new LongAdder
            wordCounts.get(word).increment();           // Increment the LongAdder for each instance of a word
        });
		
		wordCounts
			.keySet()
			.stream()
			.map(key -> String.format("%-10d %s", wordCounts.get(key).intValue(),key))
			.sorted((prev, next) -> compare(parseInt(next.split("\\s+")[0]), parseInt(prev.split("\\s+")[0])))
			.limit(5)
			.forEach(t -> System.out.println("\t"+ t));
		  long end = Instant.now().toEpochMilli();
	        System.out.println(String.format("\tCompleted in %d milliseconds", (end-start)));
	}
	
	// Read http://docs.oracle.com/javase/7/docs/api/java/util/regex/Pattern.html
}
