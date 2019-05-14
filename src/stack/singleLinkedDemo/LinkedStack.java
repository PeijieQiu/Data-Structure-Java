package stack.singleLinkedDemo;

import stack.singleLinkedDemo.LinkedNode;

public class LinkedStack<AnyType> {
    //栈底指针
    private LinkedNode base;
    //栈顶指针
    private LinkedNode top;
    //栈的当前大小
    private Integer theSize;

    /**
     * Initializer of a stack
     */
    public LinkedStack(){
        InitStack();
    }

    public void InitStack() {
        top = base = new LinkedNode();
        theSize = 0;
    }

    public int size() {
        return this.theSize;
    }

    public AnyType top() {
        return (AnyType) top.getData();
    }

    /**
     * push an element to a stack
     * @param x
     */
    public void push(AnyType x) {
        LinkedNode<AnyType> newLinkedNode = new LinkedNode<>();
        newLinkedNode.setData(x);
        top.setNext(newLinkedNode);
        top = newLinkedNode;
        theSize++;
    }

    /**
     * pop an element from a stack
     * @return
     */
    public AnyType pop(){
        if (base==top)
            return null;
        AnyType x = (AnyType) top.getData();
        theSize--;
        LinkedNode nowNode=base;

        while (nowNode.getNext().getNext()!=null){
            nowNode=nowNode.getNext();
        }
        nowNode.setNext(null);
        top=nowNode;
        return x;
    }

    public AnyType getElement(int idx){
        LinkedNode nowNode=base;
        int i=1;
        while (nowNode!=null&&nowNode.getNext()!=null){
            nowNode=nowNode.getNext();
            if (idx==i){
                return (AnyType) nowNode.getData();
            }
            i++;
        }
        return null;
    }

    public void retrieve(){
        for (int i=theSize;i>0;i--){
            System.out.print(this.getElement(i));
        }
        System.out.println();
    }

}
