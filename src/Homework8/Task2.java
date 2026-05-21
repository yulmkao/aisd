package Homework8;

public class Task2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 2, 3, 4};
        int n = nums.length;
        int[] maxLengths = new int[n];
        int overallMax = 1;

        for (int i = n - 1; i >= 0; i--) {
            int localMax = 1;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    localMax = Math.max(localMax, maxLengths[j] + 1);
                }
            }
            maxLengths[i] = localMax;
            overallMax = Math.max(overallMax, localMax);
        }
        System.out.println("длина наибольшей возрастающей подпоследовательности: " + overallMax);
    }
}