package Homework8;

public class Task2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 1, 2, 3, 4};
        int n = nums.length;
        int[] tails = new int[n];
        int overallMax = 0;
        for (int num : nums) {
            int left = 0;
            int right = overallMax;
            while (left < right) {
                int middle = (left + right) / 2;
                if (tails[middle] < num) {
                    left = middle + 1;
                } else {
                    right = middle;
                }
            }
            tails[left] = num;
            if (left == overallMax) {
                overallMax++;
            }
        }
        System.out.println("длина наибольшей возрастающей подпоследовательности: " + overallMax
        );
    }
}