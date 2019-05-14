package queue.arrayQueue;

public class ArrayQueueTest {
    public static void main(String[] args){
        ArrayQueueDemo<Integer> arrayQueue = new ArrayQueueDemo<>(20);
        for (int i=1;i<21;i++){
            arrayQueue.enqueue(i);
        }
        arrayQueue.retrieve();
        System.out.println(arrayQueue.dequeue()+"----"+arrayQueue.getFront()+"--"+arrayQueue.getBack());
        System.out.println(arrayQueue.dequeue()+"----"+arrayQueue.getFront()+"--"+arrayQueue.getBack());
        System.out.println(arrayQueue.dequeue()+"----"+arrayQueue.getFront()+"--"+arrayQueue.getBack());
        System.out.println(arrayQueue.dequeue()+"----"+arrayQueue.getFront()+"--"+arrayQueue.getBack());
    }
}
