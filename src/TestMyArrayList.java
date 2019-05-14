import java.util.Iterator;

public class TestMyArrayList {

    public static void main(String[] args) {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        Iterator<Integer> iterator=arrayList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
