package com.sarinrath.testcode_project.logic_test;

import java.util.Arrays;

public class LogicTest1 {

    static int findElement(int arr[], int size){
        int right_sum = 0, left_sum = 0;

        for (int i = 1; i < size; i++)
            right_sum += arr[i];

        for (int i = 0, j = 1; j < size; i++, j++) {
            right_sum -= arr[j];
            left_sum += arr[i];

            if (left_sum == right_sum)
                return i+1;
        }

        return -1;
    }

    static String resultfindElement(int arr[],int n){
        if(findElement(arr, n) == -1){
            return "output => \"index not found\"";
        }else{
            return "output => \"middle index is "+ findElement(arr, n)+ "\"";
        }
    }

    // Driver
    public static void main(String args[]){

        // Case 1
        int arr1[] = { 1, 3, 5, 7, 9 };
        int n1 = arr1.length;
        System.out.println(
                "output => " + Arrays.toString(arr1) + "   " +
                        resultfindElement(arr1,n1));

        // Case 2
        int arr2[] = { 3,6,8,1,5,10,1,7 };
        int n2 = arr2.length;
        System.out.println(
                "output => " + Arrays.toString(arr2) + "   " +
                        resultfindElement(arr2,n2));

        // Case 3
        int arr3[] = { 3,5,6 };
        int n3 = arr3.length;
        System.out.println(
                "output => " + Arrays.toString(arr3) + "   " +
                        resultfindElement(arr3,n3));
    }
}
