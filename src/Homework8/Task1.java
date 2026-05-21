package Homework8;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Task1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        List<List<Set<Integer>>> sumsTable = new ArrayList<>();
        for (int r = 0; r < rows; r++) {
            sumsTable.add(new ArrayList<>());
            for (int c = 0; c < cols; c++) {
                Set<Integer> currentCell = new HashSet<>();
                if (r == 0 && c == 0) {
                    currentCell.add(matrix[0][0]);
                } else {
                    if (r > 0) {
                        for (int sum : sumsTable.get(r - 1).get(c)) {
                            currentCell.add(sum + matrix[r][c]);
                        }
                    }
                    if (c > 0) {
                        for (int sum : sumsTable.get(r).get(c - 1)) {
                            currentCell.add(sum + matrix[r][c]);
                        }
                    }
                }
                sumsTable.get(r).add(currentCell);
            }
        }

        System.out.println("количество уникальных сумм: " + sumsTable.get(rows - 1).get(cols - 1).size());
    }
}