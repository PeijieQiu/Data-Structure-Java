import java.util.Iterator;

public class MyLinkedListTest {

    public static void main(String[] args) {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 100; i++) {
            myLinkedList.add(i);
        }
//        int size = myLinkedList.size();
        Iterator<Integer> iterator = myLinkedList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());

        myLinkedList.addFirst(0);
        myLinkedList.addLast(0);
        myLinkedList.remove(0);
        myLinkedList.remove(myLinkedList.size()-1);

        System.out.println(myLinkedList.getFirst()+"---"+myLinkedList.getLast() );
    }

}
