package Homework5;

import java.util.Arrays;

public class Task3 {
    public static int[] findSum(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int currentSum = array[left] + array[right];
            if (currentSum == target) {
                return new int[]{array[left], array[right]};
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] data = {2, 4, 5, 7, 11, 15};
        int target = 13;
        int[] result = findSum(data, target);
        System.out.println(Arrays.toString(result));
    }
}