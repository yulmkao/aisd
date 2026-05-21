package Homework8;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введите n и k:");
        int n = sc.nextInt();
        long k = sc.nextLong();

        System.out.println("введите массив:");
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        Map<Long, Long> before = new HashMap<>();
        Map<Long, Long> after = new HashMap<>();

        for (long v : arr) {
            after.put(v, after.getOrDefault(v, 0L) + 1);
        }

        long result = 0;
        for (long x : arr) {
            long count = after.get(x);
            after.put(x, count - 1);
            if (after.get(x) == 0) {
                after.remove(x);
            }
            if (k != 0 && x % k == 0) {
                long leftNeed = x / k;
                long rightNeed = x * k;
                long leftWays = before.getOrDefault(leftNeed, 0L);
                long rightWays = after.getOrDefault(rightNeed, 0L);
                result += leftWays * rightWays;
            }
            before.put(x, before.getOrDefault(x, 0L) + 1);
        }
        System.out.println("ответ: " + result);
    }
}