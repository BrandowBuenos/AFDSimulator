public class Automaton {
    private int numberOfStates;
    private int numberOfTerminalsSymbols;
    private static char automatonTable[][];

    public static void createAutomatonTable(int numberOfStates, int numberOfTerminalsSymbols) {
        automatonTable = new char[numberOfStates][numberOfTerminalsSymbols];

    }

    public int getNumberOfStates() {
        return this.numberOfStates;
    }

    public void setNumberOfStates(int numberOfStates) {
        this.numberOfStates = numberOfStates;
    }

    public int getNumberOfTerminalsSymbols() {
        return this.numberOfTerminalsSymbols;
    }

    public void setNumberOfTerminalsSymbols (int numberOfTerminalsSymbols) {
        this.numberOfTerminalsSymbols = numberOfTerminalsSymbols;
    }
}
