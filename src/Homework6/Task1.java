package Homework6;

public class Task1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 7};
        int target = 4;

        System.out.println(searchIndex(arr, target));
    }

    public static int searchIndex(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}