import java.util.*;

public class Main {

    public static void main(String[] args) {
        int numVertices = 6;
        List<List<int[]>> adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 0, 1, 4);
        addEdge(adjList, 0, 2, 4);
        addEdge(adjList, 1, 2, 2);
        addEdge(adjList, 1, 3, 3);
        addEdge(adjList, 2, 3, 4);
        addEdge(adjList, 2, 4, 3);
        addEdge(adjList, 3, 4, 3);
        addEdge(adjList, 3, 5, 5);
        addEdge(adjList, 4, 5, 5);

        try {
            List<int[]> mst = PrimMST.findMST(numVertices, adjList);
            int totalWeight = PrimMST.getTotalWeight(mst);

            System.out.println("Ребра минимального остовного дерева:");
            for (int[] edge : mst) {
                System.out.printf("%d -- %d (вес: %d)%n", edge[0], edge[1], edge[2]);
            }
            System.out.println("Общий вес MST: " + totalWeight);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addEdge(List<List<int[]>> adjList, int u, int v, int weight) {
        adjList.get(u).add(new int[]{v, weight});
        adjList.get(v).add(new int[]{u, weight});
    }
}