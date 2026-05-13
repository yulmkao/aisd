package Semestrovka2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Edge> graph = new ArrayList<>();

        graph.add(new Edge(13, 1, 2));
        graph.add(new Edge(18, 1, 3));
        graph.add(new Edge(17, 1, 4));
        graph.add(new Edge(14, 1, 5));
        graph.add(new Edge(22, 1, 6));

        graph.add(new Edge(22, 5, 2));
        graph.add(new Edge(26, 2, 3));
        graph.add(new Edge(3, 3, 4));
        graph.add(new Edge(19, 4, 6));

        //максимальный индекс вершины
        int max = graph.stream()
                .mapToInt(edge -> Integer.max(edge.getEdgeStart(), edge.getEdgeEnd()))
                .max()
                .orElse(0);
        long timeStart = System.nanoTime();

        // Алгоритм Краскала
        List<Edge> minTree = new ArrayList<>();
        UnionFind unionFind = new UnionFind(max+1);

        // 1) Сортируем рёбра по весу
        graph.sort(Comparator.comparing(Edge::getValue));

        // 2) Проходим по рёбрам
        int added = 0;
        for (Edge e : graph) {
            if (unionFind.union(e.getEdgeStart(), e.getEdgeEnd())) { // если концы в разных компонентах
                minTree.add(e);
                added++;
                if (added == max-1) {
                    break;
                } // остов готов
            }
        }

        // Вывод остовного дерева
        System.out.println("Минимальное остовное дерево :");
        for (Edge e : minTree) {
            System.out.println(e);
        }
        long time = System.nanoTime()-timeStart;
        System.out.println(time);
    }
}