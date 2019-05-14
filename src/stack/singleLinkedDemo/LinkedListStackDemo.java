package stack.singleLinkedDemo;

import java.util.LinkedList;

public class LinkedListStackDemo<AnyType> {
    private LinkedList<AnyType> list;

    public LinkedListStackDemo() {
        list = new LinkedList();
    }

    public AnyType top() {   //输出最上面的元素
        if (list.size() != 0) {
            return list.getFirst();
        }
        return null;
    }

    public void pop() {   //出栈
        if (list.size() != 0) {
            list.removeFirst();
        }
    }

    public void push(AnyType v) { //入栈
        list.addFirst(v);
    }

    public int getLen() {
        return list.size();
    }
}
