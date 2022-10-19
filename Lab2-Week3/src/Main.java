import domain.Position;
import domain.SymbolTable;

public class Main {
    public static void main(String[] args) {
        SymbolTable symbolTable = new SymbolTable(17);

        Position cat = symbolTable.search("cat");
        System.out.println("\"cat\" does not exist: " + (cat.hashTableIndex == -1));
        cat = symbolTable.add("cat");
        System.out.println("\"cat\" exists in the symbol table on pos: " + cat.hashTableIndex + ", " + cat.linkedListIndex);

        symbolTable.add("car");
        symbolTable.add("rac");
        Position car = symbolTable.search("car");
        Position rac = symbolTable.search("rac");

        // Collision resolution
        System.out.println("\n\"car\" exists in the symbol table on pos: " + car.hashTableIndex + ", " + car.linkedListIndex);
        System.out.println("\"rac\" exists in the symbol table on pos: " + rac.hashTableIndex + ", " + rac.linkedListIndex);

    }
}