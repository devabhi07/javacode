package stream;

import java.util.*;
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

        System.out.println(Arrays.stream(s6.split(" ")).filter(x -> x.chars().map(Character::toLowerCase).filter(c -> "aeiou".indexOf(c) != -1).count() == 2).toList());

        Arrays.stream(s6.split(" ")).filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == 2).forEach(System.out::println);

        //7
        // Given a list of integers, divide it into two lists one having an odd number
        // I/P: int[] arr = {1,2,3,4,5,6,7,8};
        // O/P: [[1,3,5,7][2,4,6,8]]

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        List<Integer> list = Arrays.stream(arr).boxed().toList();
        System.out.println(list.stream().collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList())));
        System.out.println(list);


        // 8.Given a word, find the occurrence of each character
        // I/P  String s = "Mississippi"
        // O/P: {p=2, s=4, i=4,M=1}

        String s7 = "Mississippi";
        System.out.println(Arrays.stream(s7.split("")).collect(Collectors.groupingBy(x -> x, Collectors.counting())));

        //9. Given an int[] array, re-arrange the elements to from the highest/ lowest possible value
        // int[] arr = {1,2,3,4,5};
        // O/P: 54321/12345

        int[] arr1 = {1, 2, 3, 4, 5};
        Arrays.stream(arr1).mapToObj(x -> x).sorted().forEach(System.out::print);
        Arrays.stream(arr1).mapToObj(x -> x).sorted(Collections.reverseOrder()).forEach(System.out::println);

        // 10. Given an array find the sum of unique elements
        // I/P: int[] arr = {1,6,7,8,1,1,8,8,7}
        // O/P: 22
        int[] arr3 = {1, 6, 7, 8, 1, 1, 8, 8, 7};
        System.out.println(Arrays.stream(arr3).distinct().sum());
        System.out.println(Arrays.stream(arr3).boxed().collect(Collectors.toSet()).stream().mapToInt(Integer::intValue).sum());

        //11. Given a string , find the first non-repeated character
        // I/P: String s = "Hello World"
        // O/P: H

        String s2 = "Hello World";
        String ans = Arrays.stream(s2.split("")).filter(x -> s2.indexOf(x) == s2.lastIndexOf(x)).findFirst().get();
        System.out.println(ans);
        System.out.println(String.valueOf(Arrays.stream(s2.split("")).collect(Collectors.groupingBy(x -> x, LinkedHashMap::new, Collectors.counting())).entrySet().stream().filter(m -> m.getValue() == 1).map(m -> m.getKey()).findFirst().get())

        );

        // Given a String, find the first repeated character
        // I/P: String s = "Hello World"
        // O/P: l

        String s8 = "Hello World";

        System.out.println(Arrays.stream(s8.split(""))
                .collect(Collectors.groupingBy(x -> x,
                        LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(m -> m.getValue() > 1).
                map(Map.Entry::getKey).findFirst().get());


        //13. Given an array of integer, group the numbers by the range in
        // which they belong.
        //O/P: {0=[2,3],10=[10,14],20=[20,24],30=[30,34],40=[40,44],50=[50,54]}
        int[] arr4 = {2, 3, 10, 14, 20, 24, 30, 34, 40, 44, 50, 54};
        //\(Key=(n/10)*10\)
        System.out.println(Arrays.stream(arr4).boxed().collect(Collectors.groupingBy(x -> (x / 10) * 10)));

        //14. Given a list of string, create a list that contains only integers.
        // String[] s ={"abc","123","456","xyz"};
        // O/P: [123,456]

        String[] s9 = {"abc", "123", "456", "xyz"};
        System.out.println(Arrays.stream(s9).filter(x -> x.matches("\\d+")).map(Integer::parseInt)
                //.collect(Collectors.toList())
                .toList()

        );

        //15. Find the product of the first two elements from an array.
        // I/P: int[] arr = {12,5,6,9,2,4};
        // O/P 60
        int[] arr9 = {12, 5, 6, 9, 2, 4};
        System.out.println(Arrays.stream(arr9).boxed().limit(2)
                .reduce(1, (a, b) -> a * b));


        //16. Group / pair anagrams from a list of Strings. For 1 word consider only 1 anagram.
        //I/P : String s = "{"pat","tap","pan","nap","Team","tree","meat"}"

        // O/P: [[pan, nap], [pat, tap], [Team, meat], [tree]]
        String[] ss1 = {"pat", "tap", "pan", "nap", "Team", "tree", "meat"};

        List<String> list2 = Arrays.asList(ss1);

        Collection<List<String>> ans1 = list2.stream().collect(Collectors.groupingBy(x -> Arrays.stream(x.toLowerCase().split(""))
                .sorted().collect(Collectors.toList()))).values();

        System.out.println(ans1);
//
//        Collection<List<String>> result = Arrays.stream(s)
//                .collect(Collectors.groupingBy(word -> {
//                    // Normalize to lowercase and sort characters to create a key
//                    char[] chars = word.toLowerCase().toCharArray();
//                    Arrays.sort(chars);
//                    return new String(chars);
//                }))
//                .values(); // Extract only the grouped lists
//
//        System.out.println(new ArrayList<>(result));


        //17. Write a stream program to multiply alternative numbers in an array.
        // I/P : int[] arr= {4,5,1,7,2,9,2};
        // O/P : 16

        int[] arr2 = {4, 5, 1, 7, 2, 9, 2};

        System.out.println(IntStream.range(0, arr2.length)
                .filter(i -> i % 2 == 0)
                .map(i -> arr2[i])
                .reduce(1, (a, b) -> a * b));

        //18. write a stream program to multiply 1st and last element 2nd and 2nd last element, etc numbers in an array.
        // I/P: int[] arr = {4,5,1,7,2,9};
        // O/P: 36
        //      10
        //      7

        int[] arr12 = {4, 5, 1, 7, 2, 9};
        IntStream.range(0, arr12.length / 2)
                .map(x -> arr12[x] * arr12[arr12.length - 1 - x])
                .forEach(System.out::println);


        //19. Write a stream program to move all zero's beginning of array int[]
        // I/P: int[] arr = {5,0,1,0,8,0}
        // O/P: {0,0,0,5,1,8}

        int[] arr13 = {5, 0, 1, 0, 8, 0};
        int[] result = IntStream.concat(
                        Arrays.stream(arr13).filter(n -> n == 0),
                        Arrays.stream(arr13).filter(n -> n != 0))
                .toArray();
        System.out.println(Arrays.toString(result));


    }
}
