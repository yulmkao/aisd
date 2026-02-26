import java.util.Scanner;

public class Homework1 {
    public static int euclid(int a, int b) {
        if (a == 0 || b == 0) {
            return 0;
        }
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("число 1: ");
        int number1 = sc.nextInt();
        System.out.print("число 2: ");
        int number2 = sc.nextInt();
        System.out.println("наибольший общий делитель: " + euclid(number1, number2));
    }
}