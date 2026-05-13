package Classwork7;

import java.util.Scanner;

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] table = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                table[i][j] = sc.nextInt();
            }
        }

        int[][] minSum = new int[n][m];
        minSum[0][0] = table[0][0];

        for (int j = 1; j < m; j++) {
            minSum[0][j] = minSum[0][j - 1] + table[0][j];
        }

        for (int i = 1; i < n; i++) {
            minSum[i][0] = minSum[i - 1][0] + table[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                minSum[i][j] = table[i][j] + Math.min(minSum[i - 1][j], minSum[i][j - 1]);
            }
        }
        System.out.println(minSum[n - 1][m - 1]);
    }
}