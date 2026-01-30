package controlFlow;

import java.util.Scanner;

public class LadderPractice {
    public static void main(String[] args){
//        int num1,num2,num3, max;
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter three number: ");
//        num1 = scanner.nextInt();
//        num2 = scanner.nextInt();
//        num3 = scanner.nextInt();
//
//        if(num1> num2 && num1> num3){
//            max = num1;
//        }else if (num2 > num3){
//            max= num2;
//        }else {
//            max = num3;
//        }
//        System.out.println("Maximum among all three number is "+ max+":"+num1+":"+num2+":"+num2);
//        scanner.close();


        int arr[] = {1, 2, 4, 6, 10};
        int target = 8;
        int left =0,right=arr.length-1;
        while (left < right){
            int temp = arr[left];
            arr[left] =arr[right];
            left++;
            right--;
            System.out.println(temp);
        }


    }
}

/*

int left = 0, right = arr.length - 1;

while (left < right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
    left++;
    right--;
}
 */
