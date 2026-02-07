package Leetcode;

public class MergeSortedArray {
    public static void main(String[] arg) {
        int nums1[] = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int nums2[] = {2, 5, 6};
        int n = 3;

        // int result[]= {};

        int a = m - 1;
        int b = n - 1;
        int c = m + n - 1;

        while (b >= 0) {
            if (a >= 0 && nums1[a] > nums2[b]) {
                nums1[c] = nums1[a];
                a--;

            } else {
                nums1[c] = nums2[b];
                b--;
            }
            c--;
        }


    }
}
