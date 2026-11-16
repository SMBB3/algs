import java.util.*;

public class KahnTopologicalSort {

    public static List<Integer> topologicalSort(int numVertices, List<List<Integer>> adjList) {
        int[] inDegree = new int[numVertices];
        for (int u = 0; u < numVertices; u++) {
            for (int v : adjList.get(u)) {
                inDegree[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numVertices; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>(numVertices);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result.add(u);

            for (int v : adjList.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    queue.add(v);
                }
            }
        }

        if (result.size() != numVertices) {
            throw new IllegalArgumentException("Граф содержит цикл. Топологическая сортировка невозможна.");
        }

        return result;
    }
}