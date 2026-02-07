package Algo;

import java.util.Scanner;

public class LinearSearchQ1 {

    public static int search(int[] arr, int key, int size) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int key = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        int result = search(arr, key, size);
        if (result == -1) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
        sc.close();
        //System.out.println(result == -1 ? "No": "Yes");
    }
}
