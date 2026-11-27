import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Создаем список ребер
        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 6));
        edges.add(new Edge(0, 3, 5));
        edges.add(new Edge(1, 3, 15));
        edges.add(new Edge(2, 3, 4));

        // 2. Сортируем ребра по весу
        Collections.sort(edges);

        // 3. Инициализируем систему непересекающихся множеств (для 4 вершин)
        int n = 4;
        DSU dsu = new DSU(n);

        int totalWeight = 0;
        System.out.println("Рёбра минимального остовного дерева:");

        // 4. Проходим по всем ребрам
        for (Edge e : edges) {
            if (dsu.find(e.u) != dsu.find(e.v)) {
                dsu.union(e.u, e.v);
                totalWeight += e.weight;
                System.out.println(e.u + " - " + e.v + " (вес " + e.weight + ")");
            }
        }

        System.out.println("Общий вес: " + totalWeight);
    }
}
