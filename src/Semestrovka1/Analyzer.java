package Semestrovka1;

import java.io.*;
import java.util.Random;

public class Analyzer {
    public static void main(String[] args) {
        warmup();
        
        String timeFile = "results.csv";
        Random random = new Random();

        try (PrintWriter timeWriter = new PrintWriter(new FileWriter(timeFile))) {
            //заголовок csv
            timeWriter.println("treeSize;insert_time;search_time;delete_time;theory_log");

            double logCoeff = 25.0;  // коэффициент для теоретической сложности
            for (int treeSize = 100; treeSize <= 10000; treeSize += 100) {
                AATree tree = new AATree();
                int[] data = new int[treeSize];

                // проверка вставки
                long startInsert = System.nanoTime();
                for (int i = 0; i < treeSize; i++) {
                    int value = random.nextInt(treeSize * 10);
                    data[i] = value;
                    tree.insert(value);
                }
                long timeInsert = (System.nanoTime() - startInsert) / treeSize; // среднее время вставки одной операции

                // проверка поиска
                long startSearch = System.nanoTime();
                for (int i = 0; i < 500; i++) {
                    tree.find(data[random.nextInt(treeSize)]);
                }
                long timeSearch = (System.nanoTime() - startSearch) / 500;

                // проверка удаления
                // чтобы случайные удаления не ломали массив, копируем его
                int[] deleteData = new int[data.length];
                for (int i = 0; i < data.length; i++) {
                    deleteData[i] = data[i];
                }

                long startDelete = System.nanoTime();
                for (int i = 0; i < 200; i++) {
                    int idx = random.nextInt(deleteData.length);
                    tree.delete(deleteData[idx]);
                }
                long timeDelete = (System.nanoTime() - startDelete) / 200;

                //теоретическая сложность
                double theoryLog = logCoeff * (Math.log(treeSize) / Math.log(2));

                timeWriter.println(treeSize + ";" + timeInsert + ";" + timeSearch + ";" + timeDelete + ";"
                        + (long) theoryLog + ";");
            }
            System.out.println("файлик готов!");

        } catch (IOException e) {
            System.out.println("ошибка: " + e.getMessage());
        }
    }
    private static void warmup() {
        //прогрев jvm
        AATree tree = new AATree();
        Random random = new Random();
        for (int i = 0; i < 200000; i++) {
            int value = random.nextInt(10000);
            tree.insert(value);
            tree.find(value);
            if (i % 2 == 0) {
                tree.delete(value);
            }
        }
    }
}