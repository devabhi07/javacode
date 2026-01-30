package Algo;

public class SlidingWindows {

    public static int findMaxSum(int[] arr, int k) {

        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i <= n - k; i++) {
            int windowSum = 0;

            for (int j = 0; j < k; j++) {
                windowSum += arr[i + j];
            }

            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }

    public static int findMaxUseSliding(int[] arr,int k){

        int n=arr.length;
        if(n<k) return -1;

        int currentSum =0;

        for(int i=0;i<k;i++){
            currentSum +=arr[i];
        }
        int maxSum= currentSum;

        for(int i=k;i<n;i++){
            currentSum +=arr[i]-arr[i-k];
            maxSum=Math.max(maxSum,currentSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {

        int arr[] = {2, 3, 5, 2, 9, 7, 1};
        int k = 3;
        int res = findMaxSum(arr, k);
        int res1= findMaxUseSliding(arr,k);
        System.out.println(res+"  "+res1);
    }
}
