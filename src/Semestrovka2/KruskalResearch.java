package Semestrovka2;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


/**
 * Класс для экспериментального исследования временной сложности
 * алгоритма Краскала (построение минимального остовного дерева).
 */

public class KruskalResearch {
    public static void main(String[] args) {
        int numDatasets = 60;// Количество тестовых выборок
        int minSize = 100, maxSize = 10_000;// Диапазон числа рёбер
        int numVertices = 1000;  // Фиксированное число вершин

        for (int k = 0; k < numDatasets; k++) {
            //Распределяем размер рёбер равномерно от 100 до 10 000
            int nEdges = minSize + (int) ((double) k / (numDatasets - 1) * (maxSize - minSize));
            nEdges = Math.max(nEdges, 100); // ≥ 100
            // Генерируем случайный граф
            List<Edge> graph = generateRandomGraph(nEdges, numVertices);
            // Замер времени
            long startNano = System.nanoTime();
            List<Edge> minTree = kruskalWithSteps(graph);
            long elapsedNano = System.nanoTime() - startNano;
            double elapsedMs = (elapsedNano / 1_000_000.0);
            // Вывод данных для графиков: размер, время, кол-во рёбер в
            System.out.printf("%d %f %d%n", nEdges, elapsedMs, minTree.size());
            //Вывод времени
            System.out.println("==========" + startNano % 1000);
        }
    }

    /**
     * Генерация случайного связного графа (п. 2 задания).
     */

    private static List<Edge> generateRandomGraph(int nEdges, int maxVertex) {
        Set<String> seen = new HashSet<>();// Чтобы не создавать дубликаты рёбер
        List<Edge> graph = new ArrayList<>();
        ThreadLocalRandom rnd = ThreadLocalRandom.current();

        for (int i = 0; i < nEdges; ) {
            int u = rnd.nextInt(1, maxVertex + 1);
            int v = rnd.nextInt(1, maxVertex + 1);
            if (u == v) {
                continue;
            } // без петель

            int weight = rnd.nextInt(1, 1_000);

            String key = Math.min(u, v) + "-" + Math.max(u, v);
            if (seen.contains(key)) {
                continue;
            }

            seen.add(key);
            graph.add(new Edge(weight, u, v));
            i++;
        }
        return graph;
    }

    /**
     * Реализация алгоритма Краскала с подсчётом итераций (п. 3b).
     */

    private static List<Edge> kruskalWithSteps(List<Edge> graph) {
        // Определяем количество вершин для инициализации DSU
        int maxVertex = graph.stream()
                .mapToInt(edge -> Integer.max(edge.getEdgeStart(), edge.getEdgeEnd()))
                .max()
                .orElse(0);

        UnionFind uf = new UnionFind(maxVertex + 1);

        // 1) Сортировка рёбер по весу (O(E log E))
        graph.sort(Comparator.comparingInt(Edge::getValue));

        List<Edge> minTree = new ArrayList<>();
        int added = 0;
        int iterCount = 0; // внутренний цикл — один проход по ребру = 1 итерация

        // 2) Основной цикл алгоритма: O(E * α(V))
        for (Edge e : graph) {
            iterCount++;// Подсчёт итераций самого вложенного цикла

            // Если концы ребра в разных компонентах — добавляем его
            if (uf.union(e.getEdgeStart(), e.getEdgeEnd())) {
                minTree.add(e);
                added++;
                // Остов готов, когда добавлено V-1 рёбер
                if (added == maxVertex - 1) {
                    break;
                }
            }
        }
        System.out.println("Итераций: " + iterCount);
        return minTree;
    }
}