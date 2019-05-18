package hashTable.cuckoo;

import java.util.Random;

@SuppressWarnings("Duplicates")
public class CuckooHashTable<AnyType> {
    private static final double MAX_LOAD = 0.4;
    private static final int ALLOWED_REHASHES = 1;
    private static final int DEFAULT_TABLE_SIZE = 101;

    private final HashFamily<? super AnyType> hashFunctions;
    private final int numHashFunctions;
    private AnyType[] array;
    private int currentSize;

    /**
     * Construct the hash table.
     *
     * @param hf the hash family.
     */
    public CuckooHashTable(HashFamily<? super AnyType> hf) {
        this(hf, DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param hf   the hash family.
     * @param size size the approximate initial size.
     */
    public CuckooHashTable(HashFamily<? super AnyType> hf, int size) {
        allocateArray(nextPrime(size));
        doClear();
        this.hashFunctions = hf;
        this.numHashFunctions = hf.getNumberOfFunctions();
    }

    public void makeEmpty() {
        doClear();
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return true if item is found
     */
    public boolean contains(AnyType x) {
        return findPos(x) != -1;
    }

    /**
     * Compute the hash code for x using specified hash function
     *
     * @param x     the item
     * @param which which the hash function
     * @return the hash code
     */
    public int myhash(AnyType x, int which) {
        int hashVal = hashFunctions.hash(x, which);
        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;

        return hashVal;
    }

    /**
     * Method that searches all hash function places.
     *
     * @param x the item to search for.
     * @return the position where the search terminate, or -1 if not found.
     */
    private int findPos(AnyType x) {
        for (int i = 0; i < numHashFunctions; i++) {
            int pos = myhash(x, i);
            if (array[pos] != null && array[pos].equals(x))
                return pos;
        }
        return -1;
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     * @return true if item was found and removed
     */
    public boolean remove(AnyType x) {
        int pos = findPos(x);
        if (pos != -1) {
            array[pos] = null;
            currentSize--;
        }
        return pos != -1;
    }

    /**
     * Insert into the hash table. If the item is
     * already present, return false.
     *
     * @param x the item to insert
     * @return
     */
    public boolean insert(AnyType x) {
        if (contains(x))
            return false;

        if (currentSize >= array.length * MAX_LOAD)
            expand();
        return insertHelper1(x);
    }

    private int rehashes = 0;
    private Random r = new Random();

    private boolean insertHelper1(AnyType x) {
        final int COUNT_LIMIT = 100;
        while (true) {
            int lastPos = -1;
            int pos;

            for (int count = 0; count < COUNT_LIMIT; count++) {
                for (int i = 0; i < numHashFunctions; i++) {
                    pos = myhash(x, i);

                    if (array[pos] == null) {
                        array[pos] = x;
                        currentSize++;
                        return true;
                    }
                }
                // none of the spots are available. Evict out a random one
                int i = 0;
                do {
                    pos = myhash(x, r.nextInt(numHashFunctions));
                } while (pos == lastPos && i++ < 5);

                AnyType tmp = array[lastPos = pos];
                array[pos] = x;
                x = tmp;
            }

            if (++rehashes > ALLOWED_REHASHES) {
                expand(); //Make the table bigger
                rehashes = 0; //Reset the # of rehashes
            } else {
                rehash(); //Same table size, new hash functions
            }
        }
    }

    private void expand() {
        rehash((int) (array.length / MAX_LOAD));
    }

    private void rehash() {
        hashFunctions.generateNewFunctions();
        rehash(array.length);
    }

    private void rehash(int newLength) {
        AnyType[] oldArray = array;
        allocateArray(nextPrime(newLength));
        currentSize = 0;

        //Copy table over
        for (AnyType str : oldArray)
            if (str != null)
                insert(str);
    }

    private void doClear() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = null;
        }
    }

    private void allocateArray(int arraySize) {
        array = (AnyType[]) new Object[arraySize];
    }

    private static int nextPrime(int n) {
        if (n <= 0)
            n = 3;
        if (n % 2 == 0)
            n++;
        for (; !isPrime(n); n += 2)
            ;

        return n;
    }

    private static boolean isPrime(int n) {

        if (n == 2 || n == 3)
            return true;
        else if (n % 2 == 0 || n == 1)
            return false;
        else {
            for (int i = 3; i <= Math.sqrt(n); i += 2)
                if (n % i == 0) return false;
            return true;
        }
    }

}
