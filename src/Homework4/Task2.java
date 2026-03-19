package Homework4;

public class Task2 {
    public static int findMissingNumber(int[] arr) {
        int n = arr.length;
        int expected = 0;
        int actual = 0;

        for (int i = 0; i <= n; i++) {
            expected += i;
        }

        for (int num : arr) {
            actual += num;
        }
        return expected - actual;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 6};
        System.out.println("пропущенное число: " + findMissingNumber(arr));
    }
}