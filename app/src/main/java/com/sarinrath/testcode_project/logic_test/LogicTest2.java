package com.sarinrath.testcode_project.logic_test;

import java.util.Scanner;

public class LogicTest2 {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            System.out.print("input => ");
            String str = input.nextLine();
            StringBuilder reverseStr = new StringBuilder();
            for (int i = (str.length() - 1); i >= 0; --i) {
                reverseStr.append(str.charAt(i));
            }
            if (str.equalsIgnoreCase(reverseStr.toString())) {
                System.out.println("output => " + str + " is a palindrome");
            } else {
                System.out.println("output => " + str + " isn't a palindrome");
            }
        }
    }
}
