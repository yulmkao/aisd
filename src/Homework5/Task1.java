package Homework5;

import java.util.HashSet;
import java.util.Arrays;

public class Task1 {
    public static int[] findTwoNumbers(int[] arr, int target) {
        HashSet<Integer> checkedNumbers = new HashSet<>();
        for (int currentNumber : arr) {
            int neededNumber = target - currentNumber;
            if (checkedNumbers.contains(neededNumber)) {
                return new int[]{neededNumber, currentNumber};
            }
            checkedNumbers.add(currentNumber);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {10, 5, 2, 3};
        int target = 8;
        int[] result = findTwoNumbers(numbers, target);
        System.out.println("пара чисел: " + Arrays.toString(result));
    }
}