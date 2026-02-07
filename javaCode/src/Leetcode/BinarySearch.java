package Leetcode;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5};
        int target = 3;
        int low = 0;
        int high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                high = mid - 1;

            } else if (target < arr[mid]) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return;
    }
}
