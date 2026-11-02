import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
    public static List<Integer> traverseRecursive(Graph graph, int startVertex) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getNumVertices()];
        dfsUtil(graph, startVertex, visited, result);
        return result;
    }

    private static void dfsUtil(Graph graph, int vertex, boolean[] visited, List<Integer> result) {
        visited[vertex] = true;
        result.add(vertex);

        for (int neighbor : graph.getNeighbors(vertex)) {
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited, result);
            }
        }
    }

    public static List<Integer> traverseIterative(Graph graph, int startVertex) {
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[graph.getNumVertices()];

        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            int current = stack.pop();

            if (!visited[current]) {
                visited[current] = true;
                result.add(current);

                List<Integer> neighbors = graph.getNeighbors(current);
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int neighbor = neighbors.get(i);
                    if (!visited[neighbor]) {
                        stack.push(neighbor);
                    }
                }
            }
        }
        return result;
    }
}