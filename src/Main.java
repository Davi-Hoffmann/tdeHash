import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = CSVReader.readCSV("female_names.txt");

        HashTable hashTable1 = new HashTableFunction1(1000);
        HashTable hashTable2 = new HashTableFunction2(1000);

        long startTime = System.nanoTime();
        for (String name : names) {
            hashTable1.insert(name);
        }
        long insertionTime1 = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (String name : names) {
            hashTable2.insert(name);
        }
        long insertionTime2 = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (String name : names) {
            hashTable1.search(name);
        }
        long searchTime1 = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        for (String name : names) {
            hashTable2.search(name);
        }
        long searchTime2 = System.nanoTime() - startTime;

        String[] specificNames = {"Adrian", "Adriana", "Adriane"};

        System.out.println("Relatório Final:");
        System.out.println("Tabela Hash 1:");
        hashTable1.printReport(insertionTime1, searchTime1);
        System.out.println("Tabela Hash 2:");
        hashTable2.printReport(insertionTime2, searchTime2);

        System.out.println("Busca específica na Tabela Hash 1:");
        for (String name : specificNames) {
            long searchStartTime = System.nanoTime();
            boolean found = hashTable1.search(name);
            long searchEndTime = System.nanoTime() - searchStartTime;
            System.out.println("Nome: " + name + ": Tempo de busca: " + searchEndTime + " nanosegundos");
        }

        System.out.println("Busca específica na Tabela Hash 2:");
        for (String name : specificNames) {
            long searchStartTime = System.nanoTime();
            boolean found = hashTable2.search(name);
            long searchEndTime = System.nanoTime() - searchStartTime;
            System.out.println("Nome: " + name + ": Tempo de busca: " + searchEndTime + " nanosegundos");
        }

        System.out.println("Hash 1");
        hashTable1.printCollisionLines();
        System.out.println("Hash 2");
        hashTable2.printCollisionLines();
    }
}
