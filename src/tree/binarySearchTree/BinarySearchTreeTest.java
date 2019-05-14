package tree.binarySearchTree;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int i = 20; i >0; i--) {
            binarySearchTree.insert(i);
        }
        boolean contains = binarySearchTree.contains(5);
        System.out.println(contains);
    }
}
