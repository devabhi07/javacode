package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StreamEx {
    public static void main(String[] args) {
        String ans = streamExample();
        System.out.println(ans);
    }

    private static String streamExample() {
        //Given a sentence, find the word that has the highest length
        // I/P:  String s="I am learning Streams API in Java";
        // O/P: learning

        String s = "I am Tearning Jearning Streams API in Java";
        return Arrays.stream(s.split(" "))
                .max(Comparator.comparing(String::length)).get();


        // Remove duplicates from the string and return in the same order
        // I/O: String s = "dabcadefg"
        // O/P: dabcefg

//        String s = "dabcadefg";
//        return Arrays.stream(s.split(""))
//                .distinct()
//                .collect(Collectors.joining());
    }
}
