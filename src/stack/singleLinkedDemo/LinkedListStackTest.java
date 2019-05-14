package stack.singleLinkedDemo;

public class LinkedListStackTest {
    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack=new LinkedStack<>();
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.retrieve();
        int size = linkedStack.size();
    }
}
