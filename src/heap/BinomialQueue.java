package heap;

public class BinomialQueue<AnyType extends Comparable<? super AnyType>> {
    private static final int DEFAULT_TREES = 1;
    private int currentSize; //# items in priority queue
    private Node<AnyType>[] theTrees; //An array of tree roots

    public BinomialQueue() {
    }

    public BinomialQueue(AnyType item) {
    }

    public void merge(BinomialQueue<AnyType> rhs){

    }

    public void insert(AnyType x){}

    public AnyType findMin(){
        return null;
    }

    public AnyType deleteMin(){
        return null;
    }

    public boolean isEmpty(){
        return false;
    }

    public void makeEmpty(){

    }


    private static class Node<AnyType> {

        AnyType element; //The data in the node
        Node<AnyType> leftChild; //Left child
        Node<AnyType> nextSibling; //Right child

        //Constructors
        public Node(AnyType theElement) {
            this(theElement, null, null);
        }

        public Node(AnyType theElement, Node<AnyType> lt, Node<AnyType> nt) {
            this.element = theElement;
            this.leftChild = lt;
            this.nextSibling = nt;
        }
    }

}
