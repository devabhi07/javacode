package stream;

import java.util.List;
import java.util.stream.Stream;

public class JavaTest {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1, x -> x + 1).limit(20000).toList();
        List<Long> factorialsList = list.stream().map(JavaTest::factorial).toList();
        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with sequential stream: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        factorialsList = list.parallelStream().map(JavaTest::factorial).toList();
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with parallel stream :" + (endTime - startTime) + " ms");

    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;

        }
        return result;
    }
}
