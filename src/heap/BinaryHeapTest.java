package heap;

public class BinaryHeapTest {
    public static void main(String[] args) {
        Integer[] test = {32, 21, 16, 24, 31, 19, 68, 65, 26, 13};
        BinaryHeap<Integer> binaryHeap = new BinaryHeap<>(test);
        System.out.println(binaryHeap);
        binaryHeap.insert(14);
        System.out.println(binaryHeap);
        binaryHeap.deleteMin();
        System.out.println(binaryHeap);
    }
}
