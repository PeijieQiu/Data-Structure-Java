package hashTable;

public class QuadraticProbingHashTableTest {
    public static void main(String[] args) {
        QuadraticProbingHashTable<String> H = new QuadraticProbingHashTable<>();

        final int NUMS = 40000;        final int GAP = 37;

        System.out.println("Checking... (no more output means success)");


        for (int i = GAP; i != 0; i = (i + GAP) % NUMS)
            H.insert("" + i);
        for (int i = 1; i < NUMS; i += 2)
            H.remove("" + i);

        for (int i = 2; i < NUMS; i += 2)
            if (!H.contains("" + i))
                System.out.println("Find fails " + i);

        for (int i = 1; i < NUMS; i += 2) {
            if (H.contains("" + i))
                System.out.println("OOPS!!! " + i);
        }
    }

}

