import java.util.ArrayList;
import java.util.List;

public class Graph {
    private final int numVertices;
    private final List<List<Integer>> adjList;

    public Graph(int vertices) {
        this.numVertices = vertices;
        this.adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addEdge(int src, int dest) {
        adjList.get(src).add(dest);
    }

    public List<Integer> getNeighbors(int vertex) {
        return adjList.get(vertex);
    }

    public int getNumVertices() {
        return numVertices;
    }
}