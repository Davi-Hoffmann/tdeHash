import java.util.ArrayList;

public abstract class HashTable {
    protected int size;
    protected ArrayList<String>[] table;
    protected int collisions;

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new ArrayList<>();
        }
        this.collisions = 0;
    }

    public void insert(String key) {
        int index = hash(key);
        if (!table[index].isEmpty()) {
            collisions++;
        }
        table[index].add(key);
    }

    public boolean search(String key) {
        int index = hash(key);
        return table[index].contains(key);
    }

    protected abstract int hash(String key);

    public void printReport(long insertionTime, long searchTime) {
        System.out.println("Número de colisões: " + collisions);
        System.out.println("Tempo total de inserção: " + insertionTime + " nanosegundos");
        System.out.println("Tempo total de busca: " + searchTime + " nanosegundos");
        System.out.println("Quantidade de chaves em cada posição da tabela:");

        for (int i = 0; i < size; i++) {
            System.out.println("Posição " + i + ": " + table[i].size() + " chaves");
        }
    }

    public void printCollisionLines() {
        System.out.println("Índices com colisões:");
        for (int i = 0; i < table.length; i++) {
            if (table[i].size() > 1) {
                System.out.print("Índice " + i + ": ");
                for (String element : table[i]) {
                    System.out.print(element + " ");
                }
                System.out.println();
            }
        }
    }
}