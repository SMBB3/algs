public class FloydWarshall {

    public static void findShortestPaths(Graph graph) {
        int n = graph.getVertices();
        int[][] dist = new int[n][n];
        int[][] original = graph.getAdjacencyMatrix();

        for (int i = 0; i < n; i++) {
            System.arraycopy(original[i], 0, dist[i], 0, n);
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Graph.INF && dist[k][j] != Graph.INF
                            && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        printMatrix(dist);
    }

    private static void printMatrix(int[][] dist) {
        int n = dist.length;
        System.out.println("Матрица кратчайших расстояний:");

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[i][j] == Graph.INF) {
                    System.out.print("INF ");
                } else {
                    System.out.print(dist[i][j] + "   ");
                }
            }
            System.out.println();
        }
    }
}