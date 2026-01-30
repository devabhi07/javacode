package Algo;

public class LinearSearch {

    public static int search(int[] arr, int key){
        for(int i=0; i<arr.length; i++){
            if (arr[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int [] arr = {10,25,30,45,60};
        int key =30;

        int result =search(arr, key);
        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
    }
}

//import java.util.Scanner;
//
//public class LinearSearch {
//
//    public static int search(int[] arr, int key) {
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == key) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        // 1. Take array size
//        System.out.print("Enter array size: ");
//        int size = sc.nextInt();
//
//        int[] arr = new int[size];
//
//        // 2. Take array elements
//        System.out.println("Enter array elements:");
//        for (int i = 0; i < size; i++) {
//            arr[i] = sc.nextInt();
//        }
//
//        // 3. Take key to search
//        System.out.print("Enter element to search: ");
//        int key = sc.nextInt();
//
//        // 4. Search
//        int result = search(arr, key);
//
//        // 5. Output
//        if (result == -1) {
//            System.out.println("Element not found");
//        } else {
//            System.out.println("Element found at index " + result);
//        }
//
//        sc.close();
//    }
//}
