package Homework6;

import java.util.HashSet;

public class Task6 {
    public static void main(String[] args) {
        int[] first = {10, 20, 30, 40, 50};
        int[] second = {5, 10, 15, 20, 25, 30};
        int[] third = {1, 2, 10, 30, 40, 60};
        System.out.println(intersection(first, second, third));
    }

    public static HashSet<Integer> intersection(int[] first, int[] second, int[] third) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        for (int i = 0; i < first.length; i++) {
            set1.add(first[i]);
        }

        for (int i = 0; i < second.length; i++) {
            if (set1.contains(second[i])) {
                set2.add(second[i]);
            }
        }

        for (int i = 0; i < third.length; i++) {
            if (set2.contains(third[i])) {
                result.add(third[i]);
            }
        }
        return result;
    }
}