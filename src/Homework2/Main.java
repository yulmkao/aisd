package Homework2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        int result = Task1.calculate(line);
        System.out.println("result = " + result);

//        Queue q1 = new Queue();
//        Queue q2 = new Queue();
//        q1.add(1);
//        q1.add(2);
//        q1.add(21);
//        q1.add(87);
//        q2.add(1);
//        q2.add(32);
//        q2.add(67);
//        Queue merge = Task2.merge(q1, q2);
//        merge.print();
    }
}