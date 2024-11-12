public class HashTableFunction1 extends HashTable {
    public HashTableFunction1(int size) {
        super(size);
    }

    @Override
    protected int hash(String key) {
        int hashValue = 0;
        for (char c : key.toCharArray()) {
            hashValue += c;
        }
        return hashValue % size;
    }
}