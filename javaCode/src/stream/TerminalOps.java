package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1,2,3);

        // collect
        //list.stream().skip(1).collect(Collectors.toList());
        list.stream().skip(1).toList();

        // 2. forEach
        list.stream().forEach(x -> System.out.println(x));


        // reduce : Combines element to produce a single result
        Optional<Integer> optionalInteger = list.stream().reduce((x ,y) -> x +y);
        System.out.println(optionalInteger.get());

        //4 count

        //5. anyMatch, allMatch, noneMatch

        boolean b = list.stream().anyMatch(x -> x % 2 == 0);
        System.out.println(b);

        boolean b1 = list.stream().allMatch(x -> x >0);
        System.out.println(b1);

        boolean b3 = list.stream().noneMatch(x -> x < 0);
        System.out.println(b3);

        // 6. findFirst, findAny
        System.out.println(list.stream().findFirst().get());

        // Example : Filtering and collecting Names
        List<String> names = Arrays.asList("Anna","Bob","Charlie","David");
        System.out.println(names.stream().filter(x ->x.length()>3).toList());

        // 7. toArray()
        Object[] array = Stream.of(1,2,3).toArray();

        // 8. min/max
        System.out.println("max: "+ Stream.of(2,44,69).max(Comparator.naturalOrder()).get());
        System.out.println("min: "+ Stream.of(2,44,69).min(Comparator.naturalOrder()).get());

        // 9. forEachOrdered
        List<Integer> numbers0= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println("Using forEach with parallel stream: ");
        numbers0.parallelStream().forEach(System.out::println);
        System.out.println("Using forEachOrdered with parallel stream: ");
        numbers0.parallelStream().forEachOrdered(System.out::println);







        // Example: Squaring and Sorting Number

        List<Integer> numbers = Arrays.asList(5,2,9,1,6);
       //numbers.stream().map(x->x*x).sorted().forEach(System.out::println);
        System.out.println(numbers.stream().map(x->x*x).sorted().toList());


        // Example : Summing Values
        List<Integer> integers = Arrays.asList(1,2,3,4,5);
        System.out.println(integers.stream().reduce(Integer::sum).get());

        //Example : Counting Occurrences of a character
        String sentence = "Hello world";
//        long count = sentence.chars().filter(x -> x == 'l').count();
//        System.out.println(count);

        System.out.println(sentence.chars().filter(x->x=='l').count());

        // stateful & stateless

        // Example

        // Streams cannot be reused after a terminal operation has been called
        Stream<String> stream = names.stream();
        stream.forEach(System.out::println);
        //List<String> list1= stream.map(String::toUpperCase).toList(); //exception






    }
}
