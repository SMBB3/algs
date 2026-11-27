public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(4);

        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 3, 10);
        graph.addEdge(1, 2, 3);
        graph.addEdge(2, 3, 1);

        FloydWarshall.findShortestPaths(graph);
    }
}