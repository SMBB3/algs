public class Main {
    public static void main(String[] args) {
        int[] array = {19, 14, 53, 3, 15, 26, 59, 23, 55, 54};

        BinaryHeap heap = new BinaryHeap();
        heap.buildFromArray(array);

        System.out.println("Массив кучи: " + heap);
        System.out.println("\nВид дерева:");
        heap.print();

        System.out.println("\nМинимум (peek): " + heap.peek());

        System.out.print("\nИзвлечение по возрастанию: ");
        while (!heap.isEmpty()) {
            System.out.print(heap.extractMin() + " ");
        }
        System.out.println();

        System.out.println("\nВставка элементов");
        BinaryHeap heap2 = new BinaryHeap();
        for (int v : array) {
            heap2.insert(v);
            System.out.println("Вставили " + v + " -> " + heap2);
        }

        System.out.println("\nМаксимальный элемент в дереве из прошлого задания: 59");
        System.out.println("Минимальный элемент (корень min-heap): " + heap2.peek());
    }
}