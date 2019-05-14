package stack.arrayDemo;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayBasedStack<Integer> arrayBasedStack=new ArrayBasedStack<>(100);
        for (int i =1;i<101;i++){
            arrayBasedStack.push(i);
        }
        int size = arrayBasedStack.size();
        System.out.println(arrayBasedStack+"---"+size);
        System.out.println(arrayBasedStack.pop());
        System.out.println(arrayBasedStack.top());
    }
}
