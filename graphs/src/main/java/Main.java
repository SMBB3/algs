import java.util.List;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(7);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);

        int startNode = 0;

        System.out.println("Обход графа\n");

        List<Integer> bfsResult = BFS.traverse(graph, startNode);
        System.out.println("BFS (поиск в ширину):");
        System.out.println(bfsResult);

        System.out.println();

        List<Integer> dfsRecResult = DFS.traverseRecursive(graph, startNode);
        System.out.println("DFS рекурсивный (поиск в глубину):");
        System.out.println(dfsRecResult);

        System.out.println();

        List<Integer> dfsIterResult = DFS.traverseIterative(graph, startNode);
        System.out.println("DFS итеративный (через стек):");
        System.out.println(dfsIterResult);
    }
}