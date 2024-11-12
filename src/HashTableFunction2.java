public class HashTableFunction2 extends HashTable {
    public HashTableFunction2(int size) {
        super(size);
    }

    @Override
    protected int hash(String key) {
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue += key.charAt(i) * (i + 1);
        }
        return hashValue % size;
    }
}