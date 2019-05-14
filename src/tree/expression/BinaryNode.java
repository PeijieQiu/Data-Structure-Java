package tree.expression;

public class BinaryNode {
    Object element;
    private BinaryNode left;  //left child
    private BinaryNode right; //right child

    public BinaryNode(Object element) {
        this.element = element;
    }

    public BinaryNode(Object element, BinaryNode left, BinaryNode right) {
        super();
        this.element = element;
        this.left = left;
        this.right = right;
    }

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public BinaryNode getRight() {
        return right;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }
}
