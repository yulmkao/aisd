package Classwork7;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int fib1 = 1;
        int fib2 = 1;
        if (n >= 1) {
            result.append(s.charAt(0));
        }
        while (true) {
            int next = fib1 + fib2;
            fib1 = fib2;
            fib2 = next;
            if (next > n) {
                break;
            }
            result.append(s.charAt(next - 1));
        }
        System.out.println(result);
    }
}