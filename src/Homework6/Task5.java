package Homework6;

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] arr = {-5, 2, 4, 8, 12};
        int target = 10;
        System.out.println(threeSumClosest(arr, target));
    }

    public static int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int closest = arr[0] + arr[1] + arr[2];

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return closest;
    }
}
