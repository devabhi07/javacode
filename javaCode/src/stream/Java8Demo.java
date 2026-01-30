package stream;

public class Java8Demo {
    public static void main(String[] args){

        //Streams

        // java 8 -->  minimal code, functional programing
        //java 8 --> lambda expression, Streams, Date & Time API

        // lambda expression
        // is an anonymous function ( no name, no return type, no access modifier)

        Thread t1 = new Thread(() -> {
            System.out.println("hello");

        });


    }
}

class Task implements Runnable{

    @Override
    public void run(){
        System.out.println("Hello");
    }
}
