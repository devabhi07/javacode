package Array;

public class TwoSumSorted {

    public static boolean twoSum(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (sum == target) {
                return true;   // pair found
            }
            else if (sum < target) {
                left++;        // increase sum
            }
            else {
                right--;       // decrease sum
            }
        }
        return false;          // no pair found
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 6, 10};
        int target = 8;

        System.out.println(twoSum(arr, target)); // true
    }
}