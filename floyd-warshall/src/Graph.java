public class Graph {
    private final int vertices;
    private final int[][] adjacencyMatrix;

    public static final int INF = 99999;

    public Graph(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];

        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (i == j) {
                    adjacencyMatrix[i][j] = 0;
                } else {
                    adjacencyMatrix[i][j] = INF;
                }
            }
        }
    }

    public void addEdge(int u, int v, int weight) {
        adjacencyMatrix[u][v] = weight;
    }

    public int[][] getAdjacencyMatrix() {
        return adjacencyMatrix;
    }

    public int getVertices() {
        return vertices;
    }
}