package domain.scanner;

import domain.pif.PIF;
import domain.symbolTable.Position;
import domain.symbolTable.SymbolTable;
import javafx.util.Pair;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewScanner {
    private String fileName;
    private List<String> reservedWords;
    private List<String> separators;
    private List<String> operators;
    private Map<String, Integer> codification;
    private List<String> reservedTokens;
    public PIF pif;
    public SymbolTable symbolTable;

    public NewScanner(String fileName, SymbolTable symbolTable) throws IOException {
        this.fileName = fileName;
        this.symbolTable = symbolTable;
        this.codification = new HashMap<>();
        this.pif = new PIF();

//        Scanner sc = new Scanner("input/token.in");
//        int lineIndex = 0;
//        while(sc.hasNextLine()) {
//            String line = sc.nextLine();
//            System.out.println("HEEEEEEEEEEEEEEEEEEEEEEE" + line);
//            if(++lineIndex > 3) {
//                // do something
//            }
//        }

//        Scanner scanner = new Scanner(new File("input/token.in"));
//        String separators = scanner.nextLine();
//        String operators = scanner.nextLine();
//        String reservedWords = scanner.nextLine();

        String reservedWords = "if,else,while,number,string,let,const,read,print,true,false,for";
        String separators = "[_]_{_}_(_)_;_:_,_@_ ";
        String operators = "<,<=,>,>=,==,!=,!,&&,||,^,=,+,-,*,%,/,++,--";
        this.reservedWords = Arrays.stream(reservedWords.split(",")).collect(Collectors.toList());
        this.separators = Arrays.stream(separators.split("_")).collect(Collectors.toList());
        this.operators = Arrays.stream(operators.split(",")).collect(Collectors.toList());
        System.out.println(this.operators);


        List<String> allTokens = Stream.of(this.separators, this.operators, this.reservedWords)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        this.reservedTokens = allTokens;

        this.codification.put("identifier", 0);
        this.codification.put("constant", 1);
        for (int i = 0; i < allTokens.size(); i++) {
            this.codification.put(allTokens.get(i), i + 2);
        }
    }

    @Override
    public String toString() {
        return "NewScanner {" +
                " fileName= '" + fileName + '\'' +
                "\n reservedWords= " + reservedWords +
                "\n separators= " + separators +
                "\n operators= " + operators +
                "\n codification= " + codification +
                "\n reservedTokens= " + reservedTokens +
                "\n pif= " + pif +
                "\n symbolTable= " + symbolTable +
                '}';
    }
}
