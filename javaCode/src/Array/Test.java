package Array;

public class Test {
//    public static int search(int[] arr, int key){
//        for(int i=0; i<arr.length; i++){
//            if (arr[i] == key){
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public static void main(String[] args){
//        int [] arr = {10,25,30,45,60};
//        int key =30;
//
//        int result =search(arr, key);
//        System.out.println(result == -1 ? "Not Found" : "Found at index " + result);
//    }

    public static void main(String[] args) {


        int arr[] = {1, 2, 4, 6, 10};
        int target = 8;
        System.out.println(printArray(arr, target));

    }

    static int printArray(int[] arr, int target) {
        int n = arr.length + 1;
        int exSum = n * (n + 1) / 2;
        int asum = 0;
        for (int num : arr) {
            asum += num;

        }
        return exSum - asum;

    }
}
//   int left = 0, right = arr.length - 1;
//
//while (left < right) {
//int temp = arr[left];
//arr[left] = arr[right];
//arr[right] = temp;
//left++;
//right--;
//        }









