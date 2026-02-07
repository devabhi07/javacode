package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {
    public static void main(String[] args) {

        // feature introduced in Java 8
        // process collection of data in a functional and declarative manner
        // simplify Data Processing
        // Embrace Functional Programming


        //How to Use Stream ?

        // Source, intermediate operations & terminal operation

        List<Integer> number = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(number.stream().filter(x -> x%2==0).count());

        //1. From collection
        List<Integer> list =Arrays.asList(1,2,3,4,5);
        Stream<Integer> stream = list.stream();

        //2. From Arrays
        String[] array = {"a","b","c"};
        Stream<String> stream1 = Arrays.stream(array);

        //3. Using Stream.of()
        Stream<String> stream2 =Stream.of("a","b");
        //4. Infinite streams
        Stream<Integer> generate = Stream.generate(() ->1);

       List<Integer> collect = Stream.iterate(1, x ->x +1).limit(100).collect(Collectors.toList());
        System.out.println(collect);



    }
}
