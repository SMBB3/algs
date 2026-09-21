import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arrayForSort = {19, 14, 53, 3, 15, 26, 59, 23, 55, 54};

        System.out.println("Исходный массив: " + Arrays.toString(arrayForSort));

        BinaryHeap.heapSort(arrayForSort);
        System.out.println("Отсортированный массив: " + Arrays.toString(arrayForSort));

        int[] arrayForHeap = {19, 14, 53, 3, 15, 26, 59, 23, 55, 54};
        BinaryHeap heap = new BinaryHeap();

        heap.buildFromArray(arrayForHeap);
        System.out.println("Внутренний массив кучи: " + heap);

        System.out.println("\nВид дерева:");
        heap.print();

        System.out.println("\nМинимум (peek): " + heap.peek());

        System.out.print("Извлечение по возрастанию: ");
        while (!heap.isEmpty()) {
            System.out.print(heap.extractMin() + " ");
        }
        System.out.println();
    }
}