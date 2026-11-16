import java.util.*;

public class PrimMST {

    public static List<int[]> findMST(int numVertices, List<List<int[]>> adjList) {
        if (numVertices == 0) {
            return new ArrayList<>();
        }

        boolean[] visited = new boolean[numVertices];
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        List<int[]> mstEdges = new ArrayList<>();
        int totalWeight = 0;

        for (int[] edge : adjList.get(0)) {
            pq.offer(new int[]{edge[1], 0, edge[0]});
        }
        visited[0] = true;

        while (!pq.isEmpty() && mstEdges.size() < numVertices - 1) {
            int[] current = pq.poll();
            int weight = current[0];
            int from = current[1];
            int to = current[2];

            if (visited[to]) {
                continue;
            }

            visited[to] = true;
            mstEdges.add(new int[]{from, to, weight});
            totalWeight += weight;

            for (int[] edge : adjList.get(to)) {
                int neighbor = edge[0];
                int edgeWeight = edge[1];
                if (!visited[neighbor]) {
                    pq.offer(new int[]{edgeWeight, to, neighbor});
                }
            }
        }

        if (mstEdges.size() != numVertices - 1) {
            throw new IllegalArgumentException("Граф несвязный. Остовное дерево построить невозможно.");
        }

        return mstEdges;
    }

    public static int getTotalWeight(List<int[]> mstEdges) {
        int total = 0;
        for (int[] edge : mstEdges) {
            total += edge[2];
        }
        return total;
    }
}