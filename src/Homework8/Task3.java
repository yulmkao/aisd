package Homework8;

public class Task3 {
    public static void main(String[] args) {
        int[][] graph = {
                {0, 0, 1, 1},
                {0, 0, 0, 0},
                {1, 0, 0, 1},
                {1, 0, 1, 0}
        };

        int roads = 0;
        int activeVertices = 0;

        for (int i = 0; i < graph.length; i++) {
            boolean hasRoad = false;
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1) {
                    roads++;
                    hasRoad = true;
                }
            }
            if (hasRoad) {
                activeVertices++;
            }
        }

        roads /= 2;
        int minimumRoads = (activeVertices > 0) ? (activeVertices - 1) : 0;
        int removableRoads = Math.max(0, roads - minimumRoads);
        System.out.println("дороги, которые можно удалить: " + removableRoads);
    }
}