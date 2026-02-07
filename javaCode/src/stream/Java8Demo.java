package stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java8Demo {
    public static void main(String[] args) {

        //Streams

        // java 8 -->  minimal code, functional programing
        //java 8 --> lambda expression, Streams, Date & Time API

        // lambda expression
        // is an anonymous function ( no name, no return type, no access modifier)

//        Thread t1 = new Thread(() -> {
//            System.out.println("hello");
//
//        });


        // Predicate ---> Functional interface (Boolean value function)
        // Check value
        Predicate<Integer> isEven = x -> x%2 ==0;
        System.out.println(isEven.test(4));
        Predicate<String> isWordStringWithA = x -> x.toLowerCase().startsWith("a");
        Predicate<String> isWordStringWithT = x -> x.toLowerCase().endsWith("v");
        Predicate<String> and =isWordStringWithA.and(isWordStringWithT);
        //System.out.println(isWordStringWithA.test("Abhinav"));



        // Function  (Java 8)

        Function<Integer,Integer> doubleIt = x -> 2*x;
        Function<Integer,Integer> tripleIt = x -> 3*x;
        Function<Integer,Integer> diviedIt = x-> 2/x;
        System.out.println(diviedIt+""+tripleIt+""+diviedIt);




        //Ex
        Predicate<Integer> predicate = x -> x % 2==0;  //hold condition
        Function<Integer, Integer> function =x -> x*x;  //perform task
        Consumer<Integer> consumer = x->System.out.println(x);// only take value
        Supplier<Integer> supplier = () -> 100;

        if(predicate.test(supplier.get())){
            consumer.accept(function.apply(supplier.get()));
        }









        //Method reference --> use method without invoking & in place of lambda expression

        List<String> student = Arrays.asList("Ramesh","Mahesh","Suresh");
        //student.forEach(x-> System.out.println(x));
        student.forEach(System.out::println);























    }
}

//class Task implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Hello");
//    }
// }
