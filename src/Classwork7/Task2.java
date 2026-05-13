package Classwork7;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("введите номер числа n: ");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("последняя цифра: 0");
            return;
        }
        int fib1 = 0;
        int fib2 = 1;
        for (int i = 2; i <= n; i++) {
            int next = (fib1 + fib2) % 10;
            fib1 = fib2;
            fib2 = next;
        }
        System.out.println("последняя цифра: " + fib2);
    }
}