package stack.singleLinkedDemo;

public class LinkedNode<AnyType> {
    private AnyType data;
    private LinkedNode next;

    public AnyType getData() {
        return data;
    }

    public void setData(AnyType data) {
        this.data = data;
    }

    public LinkedNode getNext() {
        return next;
    }

    public void setNext(LinkedNode next) {
        this.next = next;
    }
}
