package Algo;

public class NegativeNumberPrint {


//    Given an array arr[]  and a positive integer k,
//    find the first negative integer for each and every window(contiguous subarray) of size k.
/*

Input: arr[] = [-8, 2, 3, -6, 10] , k = 2
Output: [-8, 0, -6, -6]
Explanation:
Window [-8, 2] First negative integer is -8.
Window [2, 3] No negative integers, output is 0.
Window [3, -6] First negative integer is -6.
Window [-6, 10] First negative integer is -6.
 */


    public static int findNegative(int[] arr, int k) {

        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                return arr[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] arr = {-8, 2, 3, -6, 10};
        int k = 2;

        int res = findNegative(arr, k);
        System.out.println(res);
    }
}

