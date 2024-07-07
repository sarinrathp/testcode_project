package com.sarinrath.testcode_project.logic_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LogicTest3 {
    public static void find(int [] a){

        System.out.println("input => "+ Arrays.toString(a));
        System.out.print("output => ");

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i <a.length ; i++) {
            for (int j = i+1; j <a.length ; j++) {
                for (int l = j+1; l <a.length ; l++) {
                    if(a[i]+a[j]+a[l]==0){
                        result.add(Arrays.asList(a[i],a[j],a[l]));
                    }
                }
            }
        }

        System.out.println(Arrays.toString(result.toArray()));
    }

    public static void main(String[] args) {
        int a1[] = {-1,-5,-3,0,1,2,-1};
        int a2[] = {1,1,2};
        int a3[] = {1};
        find(a1);
        find(a2);
        find(a3);
    }
}
