package stream;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {


        // Collectors is a utility class
        // provides a set of methods to create common collectors

        // 1. Collecting to a List
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> res = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println(res);

        // 2. Collecting to a set
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 4, 5);
        Set<Integer> set = nums.stream().collect(Collectors.toSet());
        System.out.println(set);

        // 3. Collecting to Specific Collection
        ArrayDeque<String> collect = names.stream().collect(Collectors.toCollection(() -> new ArrayDeque<>()));

        // 4. Joining Strings
        // Concatenates stream elements into a single string
        String concatenatedNames = names.stream().map(String::toUpperCase).collect(Collectors.joining(", "));
        System.out.println(concatenatedNames);

        //5. Summarizing Data
        // Generates statistical summary (count, sum , min , average, max)

        List<Integer> numbers = Arrays.asList(2, 3, 5, 7, 11);
        IntSummaryStatistics stats = numbers.stream().collect(Collectors.summarizingInt(x -> x));
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("min: " + stats.getMin());
        System.out.println("average: " + stats.getAverage());
        System.out.println("Max: " + stats.getMax());

        //6. Calculating Averages
        Double average = numbers.stream().collect(Collectors.averagingInt(x -> x));
        System.out.println("Average: " + average);

        //7. Counting Elements
        Long count = numbers.stream().collect(Collectors.counting());
        System.out.println("count: " + count);

        //8 . Grouping Element
        List<String> words = Arrays.asList("hello", "world", "java", "streams", "collecting");
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length)));
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.joining(", "))));
        System.out.println(words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting())));
        TreeMap<Integer, Long> treeMap = words.stream()
                .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.counting()));
        System.out.println(treeMap);

        // 9. Partitioning Elements
        // Partitions elements into two groups (true and false) based on a predicate
        System.out.println(words.stream().collect(Collectors.partitioningBy(x -> x.length() > 5)));

        // 10. Mapping and Collecting
        // Applies a mapping function before collecting
        //System.out.println(words.stream().collect(Collectors.mapping(x -> x.)));

        // 11. toMap
        // Example 1: Collecting Names by Length
        List<String> l1 = Arrays.asList("Anna", "Bob", "Alexander", "Brian", "Alice");
        System.out.println(l1.stream().collect(Collectors.groupingBy(String::length)));

        // Example 2: Counting word Occurrences
        String sentence = "hello word hello java word";
        System.out.println(Arrays.stream(sentence.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        // Example 3: Partitioning Even and Odd Number
        List<Integer> l2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(l2.stream().collect(Collectors.groupingBy(x -> x % 2 == 0)));


        //4 : Summing Value in map
        Map<String, Integer> items = new HashMap<>();
        items.put("Apple", 10);
        items.put("Banana", 20);
        items.put("Orange", 15);

        System.out.println(items.values().stream().reduce(Integer::sum));
        System.out.println(items.values().stream().collect(Collectors.summingInt(x -> x)));

        // Example 5: Creating a Map from Stream Elements
        //toMap
        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println(fruits.stream().collect(Collectors.toMap(x -> x.toUpperCase(), x -> x.length())));

        // Example 6:
        List<String> word2 = Arrays.asList("apple", "banana", "orange", "apple", "banana", "apple");
        System.out.println(word2.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));
        System.out.println(word2.stream().collect(Collectors.toMap(k -> k, v -> 1, (x, y) -> x + y)));
    }
}
