package Homework5;

import java.util.Arrays;
import java.util.Comparator;

public class Task4 {
    public static void findLargestNumber(int[] numbers) {
        String[] stringNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }

        Comparator<String> customComparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String combination1 = a + b;
                String combination2 = b + a;
                return combination2.compareTo(combination1);
            }
        };
        Arrays.sort(stringNumbers, customComparator);

        if (stringNumbers[0].equals("0")) {
            System.out.println("0");
            return;
        }

        String result = "";
        for (String number : stringNumbers) {
            result += number;
        }
        System.out.println("наибольшее число: " + result);
    }

    public static void main(String[] args) {
        int[] data = {3, 30, 34, 5, 9};
        findLargestNumber(data);
    }
}