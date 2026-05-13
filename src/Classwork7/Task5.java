package Classwork7;

import java.util.Arrays;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coords = new int[n];
        for (int i = 0; i < n; i++) {
            coords[i] = sc.nextInt();
        }
        Arrays.sort(coords);
        int[] minLen = new int[n];
        minLen[1] = coords[1] - coords[0];
        if (n > 2) {
            minLen[2] = (coords[1]-coords[0]) + (coords[2]-coords[1]);
        }
        for (int i = 3; i < n; i++) {
            int currentGap = coords[i] - coords[i - 1];
            minLen[i] = Math.min(minLen[i - 1], minLen[i - 2]) + currentGap;
        }
        System.out.println(minLen[n - 1]);
    }
}