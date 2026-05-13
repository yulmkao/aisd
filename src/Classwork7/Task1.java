package Classwork7;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("введите число: ");
        long a = sc.nextLong();
        long fib1 = 0;
        long fib2 = 1;
        while (fib2 < a) {
            long next = fib1 + fib2;
            fib1 = fib2;
            fib2 = next;
        }
        if (fib2 == a) {
            System.out.println("ето число фибоначчи");
        } else {
            System.out.println("не число фибоначчи");
        }
    }
}