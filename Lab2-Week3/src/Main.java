import domain.pif.PIF;
import domain.scanner.NewScanner;
import domain.symbolTable.Position;
import domain.symbolTable.SymbolTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("File name for input: ");
        String fileName = reader.readLine();

        NewScanner scanner = new NewScanner(fileName, new SymbolTable(71));
        scanner.startScanning();
        System.out.println(scanner);

//        SymbolTable symbolTable = new SymbolTable(17);
//
//        Position cat = symbolTable.search("cat");
//        System.out.println("\"cat\" does not exist: " + (cat.hashTableIndex == -1));
//        cat = symbolTable.add("cat");
//        System.out.println("\"cat\" exists in the symbol table on pos: " + cat.hashTableIndex + ", " + cat.linkedListIndex);
//
//        symbolTable.add("car");
//        symbolTable.add("rac");
//        Position car = symbolTable.search("car");
//        Position rac = symbolTable.search("rac");
//
//        // Collision resolution
//        System.out.println("\n\"car\" exists in the symbol table on pos: " + car.hashTableIndex + ", " + car.linkedListIndex);
//        System.out.println("\"rac\" exists in the symbol table on pos: " + rac.hashTableIndex + ", " + rac.linkedListIndex);
//        PIF pif = new PIF();
//        pif.addElement("new_val", new Position(-1,-1));
//        pif.addElement("second_val", new Position(-1,1));
//
//        // TODO: define regexes
//        System.out.println(pif);
//
//        ArrayList<String> separators_for_reading = []
//        String[] splits = test.txt.split("((?=@)|(?<=@))");
    }
}