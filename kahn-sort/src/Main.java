import java.util.*;

public class Main {

    public static void main(String[] args) {
        int numVertices = 6;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        adjList.get(5).add(0);
        adjList.get(5).add(2);
        adjList.get(4).add(0);
        adjList.get(4).add(1);
        adjList.get(2).add(3);
        adjList.get(3).add(1);

        try {
            List<Integer> sortedOrder = KahnTopologicalSort.topologicalSort(numVertices, adjList);
            System.out.println("Топологический порядок: " + sortedOrder);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }
}