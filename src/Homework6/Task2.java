package Homework6;

public class Task2 {
    public static void main(String[] args) {
        int first = 10;
        int second = 100;

        System.out.println(first * first == second);
        System.out.println(square(first, first) == second);
    }

    public static long square(long a, long b) {
        long result = 0;
        long x = Math.abs(a);
        long y = Math.abs(b);

        while (x != 0) {
            if ((x & 1) == 1) {
                result += y;
            }
            x >>= 1;
            y <<= 1;
        }
        return result;
    }
}