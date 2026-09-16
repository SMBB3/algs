import java.util.ArrayList;
import java.util.List;

public class BinaryHeap {
    private List<Integer> heap;

    public BinaryHeap() {
        heap = new ArrayList<>();
    }

    public void insert(int val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (heap.get(i) >= heap.get(parent)) {
                break;
            }
            swap(i, parent);
            i = parent;
        }
    }

    public int extractMin() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Куча пуста");
        }
        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    private void siftDown(int i) {
        int size = heap.size();
        while (true) {
            int left  = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if (left < size && heap.get(left) < heap.get(smallest)) {
                smallest = left;
            }
            if (right < size && heap.get(right) < heap.get(smallest)) {
                smallest = right;
            }
            if (smallest == i) break;

            swap(i, smallest);
            i = smallest;
        }
    }

    public int peek() {
        if (heap.isEmpty()) {
            throw new RuntimeException("Куча пуста");
        }
        return heap.get(0);
    }

    public void buildFromArray(int[] arr) {
        heap.clear();
        for (int v : arr) {
            heap.add(v);
        }
        for (int i = heap.size() / 2 - 1; i >= 0; i--) {
            siftDown(i);
        }
    }

    private void swap(int i, int j) {
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public void print() {
        if (heap.isEmpty()) {
            System.out.println("(пусто)");
            return;
        }
        printRec(0, 0);
    }

    private void printRec(int i, int level) {
        if (i >= heap.size()) return;
        printRec(2 * i + 2, level + 1);
        System.out.println("    ".repeat(level) + heap.get(i));
        printRec(2 * i + 1, level + 1);
    }

    @Override
    public String toString() {
        return heap.toString();
    }
}