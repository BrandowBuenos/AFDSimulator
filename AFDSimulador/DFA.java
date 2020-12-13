import java.util.Scanner;

public class DFA {
    static char DfaTable[][];
    static int noOfStates;
    static int noOfTerminals;
    static String[] finalStates;

    public static void GetDFATable() {
        // local scanner
        Scanner dFAScanner = new Scanner(System.in);
        Scanner getValues = new Scanner(System.in);
        Scanner finalStateScanner = new Scanner(System.in);
        // getting the DFA states to initialize the array
        System.out.print("\nInsira o número de estados do autômato: ");
        noOfStates = getValues.nextInt() + 1;
        System.out.print("\nInsira o número de variáveis terminais do autômato: ");
        noOfTerminals = getValues.nextInt() + 1;

        DfaTable = new char[noOfStates][noOfTerminals];

        // storing elements into the DFA table
        System.out.println("\nAgora, insira todos os elementos da tabela de transições");
        for (int i = 0; i < noOfStates; i++) {
            for (int j = 0; j < noOfTerminals; j++) {
                if (i == 0 && j == 0) {
                    DfaTable[0][0] = ' ';
                    continue;
                }
                DfaTable[i][j] = dFAScanner.next().charAt(0);
            }
        }

        System.out.println("\nPara finalizar, indique os estados finais, separados por vírgula: ");
        finalStates = finalStateScanner.nextLine().split(" ");
        // finalStates = DFAScanner.nextLine();

    }

    public static char InitialState() {
        return DfaTable[1][0];
    }

    public static char NextState(char currentstate, char currentchar) {
        for (int i = 1; i < noOfStates; i++) {
            if (currentstate == DfaTable[i][0]) {
                for (int j = 1; j < noOfTerminals; j++) {
                    if (currentchar == DfaTable[0][j]) {
                        return DfaTable[i][j];
                    }
                }
            }
        }
        return '$';
    }

    // return DfaTable[noOfStates-1][0];

    public static boolean FinalState(char currentState) {
        for (String value : finalStates) {
            char charValue = value.charAt(0);
            if (charValue == currentState) {
                return true;
            }
        }
        return false;
    }
}