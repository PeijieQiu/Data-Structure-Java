package hashTable;

@SuppressWarnings("Duplicates")
public class QuadraticProbingHashTable<AnyType> {
    private static final int DEFAULT_TABLE_SIZE = 101;
    private HashEntry<AnyType>[] array;
    private int currentSize;

    /**
     * Construct the hash table.
     */
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param currentSize size the approximate initial size.
     */
    public QuadraticProbingHashTable(int currentSize) {
        allocateArray(currentSize);
        makeEmpty();
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     *
     * @param x the item to insert
     */
    public void insert(AnyType x) {
        //Insert x as active
        System.out.println("CurrentSize:"+currentSize);
        int currentPos = findPos(x);
        if (isActive(currentPos))
            return;
        array[currentPos] = new HashEntry<>(x, true);

        //Rehash
        if (++currentSize > (array.length / 2))
            rehash();
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            array[currentPos].isActive = false;
    }

    private static class HashEntry<AnyType> {
        public AnyType element; // the Element
        public boolean isActive; // false if marked deleted

        public HashEntry(AnyType e) {
            this(e, true);
        }

        public HashEntry(AnyType element, boolean isActive) {
            this.element = element;
            this.isActive = isActive;
        }

    }

    /**
     * Internal method to allocate array.
     *
     * @param arraySize the size of the array.
     */
    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    /**
     * Return true if currentPos exists and is active.
     *
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    /**
     * Method that performs quadratic probing resolution in half-empty table.
     *
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos(AnyType x) {
        int offset = 1;
        int currentPos = myhash(x);
        System.out.println(currentPos);
        while (array[currentPos] != null && !array[currentPos].element.equals(x)) {
            currentPos += offset; //Compute ith probe
            offset += 2;
            if (currentPos >= array.length)
                currentPos -= array.length;
        }
        return currentPos;
    }

    /**
     * Rehashing for quadratic probing hash table.
     */
    private void rehash() {
        HashEntry<AnyType>[] oldArray = array;

        //Create a new double-sized, empty table
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;

        //Copy table over
        for (int i = 0; i < oldArray.length; i++)
            if (oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
    }


    private int myhash(AnyType element) {
        int hashValue = element.hashCode() % (array.length);
        if (hashValue < 0)
            hashValue += array.length;
        return hashValue;
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

