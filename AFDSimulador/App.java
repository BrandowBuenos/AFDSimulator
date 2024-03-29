import java.util.Scanner;

public class App {
    static char currentChar;
    static char currentState;
    static char[] LineCharArray;
    static int LineCharArrayCount = 0;

    public static void main(String[] args) {

        Scanner inputScanner = new Scanner(System.in);
        DFA.GetDFATable();

        boolean userSatisfied = false;
        System.out.println(
                "\nVamos lá ! Agora, verifique se as palavras pertencem a linguagem. Para sair, escreva sair.\n");

        while (!userSatisfied) {
            System.out.print("> ");
            String inputString = inputScanner.nextLine();
            if (inputString.contentEquals("sair"))
                break;
            else {
                // converting into readable format
                LineCharArray = inputString.toCharArray();
                LineCharArrayCount = 0;
                // transitions start
                Algorithm(); // string matching algorithm
            }
        }

        inputScanner.close();
    }

    private static void Algorithm() {
        // Algorithm used to match a DFA Table against a string
        currentState = DFA.InitialState(); // denotes current state
        currentChar = NextChar(); // current character from the input string
        while (currentChar != ' ') {
            currentState = Move(currentState, currentChar);
            System.out.print("- O símbolo " + currentChar + " foi lido e foi feito a transição para o estado "
                    + currentState + ".\n");
            currentChar = NextChar();
        }
        // checking if input is correct or not
        System.out.println(FinalStateChecker());
    }

    private static char NextChar() {
        if (LineCharArray == null || LineCharArrayCount == LineCharArray.length) {
            return ' ';
        } else {
            return LineCharArray[LineCharArrayCount++];
        }
    }

    private static char Move(char currentstate, char currentchar) {
        return DFA.NextState(currentstate, currentchar);
    }

    private static String FinalStateChecker() {
        if (DFA.FinalState(currentState)) {
            return "= Esta palavra é aceita pela linguagem :)\n";
        } else {
            return "= Esta palavra não é aceita pela linguagem :'(\n";
        }
    }

}