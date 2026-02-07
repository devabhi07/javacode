package stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStream {
    public static void main(String[] args) {
        // A type of stream that enable parallel processing of elements

        // Allowing multiple threads to process part of the stream simultaneously
        // This can significantly improve performance for large data sets
        // Working is distributed across multiple threads

        long startTime =System.currentTimeMillis();
        List<Integer> list = Stream.iterate(1,x->x+1).limit(20000).toList();
        List<Long> factorialsList = list.stream().map(ParallelStream::factorial).toList();
        long endTime =System.currentTimeMillis();
        System.out.println("Time taken with stream: "+(endTime - startTime)+" ms");

        startTime=System.currentTimeMillis();
        List<Integer> list1 = Stream.iterate(1,x->x+1).limit(20000).toList();
        List<Long> factorialsList1 = list1.parallelStream().map(ParallelStream::factorial).toList();
        endTime=System.currentTimeMillis();
        System.out.println("Time taken with stream: "+(endTime - startTime)+" ms");

        // parallel stream are most effective for CPU-intensive or large dataset where tasks are independent
        // They may add overhead for simple task or small datasets


        // Cumulative sum

        //[1,2,3,4,5] ---> [1,3,6,10,15]
        List<Integer> numbers= Arrays.asList(1,2,3,4,5);
        AtomicInteger sum=new AtomicInteger(0);
        System.out.println(numbers.stream().map(sum::addAndGet).toList());

    }

    private static long factorial(int n){
        long result = 1;
        for(int i =2;i<=n;i++){
            result *=i;
        }
        return result;
    }

}
