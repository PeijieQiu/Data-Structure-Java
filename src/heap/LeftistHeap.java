package heap;

import java.util.NoSuchElementException;

public class LeftistHeap<AnyType extends Comparable<? super AnyType>> {

    private Node<AnyType> root;

    public LeftistHeap() {
        root = null;
    }

    /**
     * Merge rhs into the priority queue.
     * rhs becomes empty. rhs must be different from this.
     *
     * @param rhs the other leftist heap.
     */
    public void merge(LeftistHeap<AnyType> rhs) {
        if (this == rhs)
            return;

        root = merge(root, rhs.root);
        rhs.root = null;
    }

    public void insert(AnyType x) {
        root = merge(new Node<>(x), root);
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new NoSuchElementException();
        return root.element;
    }

    public AnyType deleteMin() {
        if (isEmpty())
            throw new NoSuchElementException();

        AnyType minItem = root.element;
        root = merge(root.left, root.right);

        return minItem;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    private static class Node<AnyType> {
        AnyType element; //The data in the node
        Node<AnyType> left; //Left child
        Node<AnyType> right; //Right child
        int npl; //null path length


        public Node(AnyType theElement) {
            this(theElement, null, null);
        }

        public Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> rt) {
            this.element = theElement;
            this.left = lt;
            this.right = rt;
            npl = 0;
        }
    }

    /**
     * Internal method to merge two roots.
     * Deals with deviant cases and calls recursive merge1.
     *
     * @param h1
     * @param h2
     * @return
     */
    private Node<AnyType> merge(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        if (h1.element.compareTo(h2.element) < 0)
            return merge1(h1, h2);
        else
            return merge1(h2, h1);
    }

    /**
     * Internal method to merge two roots.
     * Assumes trees are not empty, and h1's root contains smallest item.
     *
     * @param h1
     * @param h2
     * @return
     */
    private Node<AnyType> merge1(Node<AnyType> h1, Node<AnyType> h2) {
        if (h1.left == null) //Single node
            h1.left = h2; //Other field in h1 already accurate
        else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl)
                swapChildren(h1);
            h1.npl = h1.right.npl + 1;
        }
        return h1;
    }

    private void swapChildren(Node<AnyType> t) {
        if (t.left == null || t.right == null)
            return;

        Node<AnyType> temp = t.left;
        t.left = t.right;
        t.right = temp;
    }
}
