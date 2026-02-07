package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamQuestion {
    public static void main(String[] args) {
        String s = "I am learning Streams API in Java";
        System.out.println(Arrays.stream(s.split(" ")).max(Comparator.comparing(String::length)).get());

        String s1 = "dabcadefg";
        s1.chars().distinct().mapToObj(x -> (char) x).forEach(System.out::print);
        Arrays.stream(s1.split("")).distinct().forEach(System.out::print);


        String s3 = "I am learning Streams API in Java";// find second nth highest
        System.out.println(":: " + Arrays.stream(s3.split(" ")).sorted(Comparator.comparing(String::length).reversed()).skip(1).findFirst().get());

        String s4 = "I am learning Streams API in Java"; //find second nth highest length

        System.out.println(Arrays.stream(s4.split(" ")).map(String::length).sorted(Comparator.reverseOrder()).skip(1).findFirst().get());

        String s5 = "I am learning Streams API in Java";
        // find the occurrence of each word
        System.out.println(Arrays.stream(s5.split(" ")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));
        System.out.println(Arrays.stream(s5.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));


        String s6 = "I am learning Streams API in Java";
        // find the words with a specified number of vowels.
        // No of vowels: 2
        // o/p Stream,API, JAVA

        System.out.println(Arrays.stream(s6.split(" "))
                .filter(x -> x.chars().map(Character::toLowerCase)
                        .filter(c -> "aeiou".indexOf(c) != -1)
                        .count() == 2).toList());

        Arrays.stream(s6.split(" ")).filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2).forEach(System.out::println);

        //7
        // Given a list of integers, divide it into two lists one having an odd number
        // I/P: int[] arr = {1,2,3,4,5,6,7,8};
        // O/P: [[1,3,5,7][2,4,6,8]]

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        System.out.println(list.stream().collect(Collectors.groupingBy(x->x%2==0,Collectors.toList())));
        System.out.println(list);
    }
}
