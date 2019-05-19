package hashTable.cuckoo;

public class CuckooHashTableTest {
    public static void main(String[] args) {
        StringHashFamily stringHashFamily = new StringHashFamily(5);
        //定义布谷鸟散列
        CuckooHashTable<String> cuckooHashTable = new CuckooHashTable<>(stringHashFamily);
        String[] strs = {"abc", "aba", "abcc", "abca"};
        //插入
        for (int i = 0; i < strs.length; i++) {
            cuckooHashTable.insert(strs[i]);
        }
        //打印表
        cuckooHashTable.printArray();
    }
}
