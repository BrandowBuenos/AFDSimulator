import javax.swing.JOptionPane;

public class AFD {
    private String aFDTable[][];
    private int numEstados;
    private int numTerminais;
    private String[] estadosFinais;
    private String characterAtual;
    private String estadoAtual;
    private String[] characterLinhaArray;
    private int characterLinhaArrayCount = 0;

    public AFD(String[][] aFDTable, int numEstados, int numTerminais, String[] estadosFinais, String[] characterLinhaArray, int characterLinhaArrayCount) {
        this.aFDTable = aFDTable;
        this.numEstados = numEstados;
        this.numTerminais = numTerminais;
        this.estadosFinais = estadosFinais;
        this.characterLinhaArray = characterLinhaArray;
        this.characterLinhaArrayCount = characterLinhaArrayCount;
    }

    private String estadoInicial() {
        return aFDTable[1][0];
    }

    private String proximoEstado(String estadoAtual, String characterAtual) {
        for (int i = 1; i < this.numEstados; i++) {
            System.out.println("ESTADO ATUAL: "+ estadoAtual);
            System.out.println("ESTADO TABELA: "+ this.aFDTable[i][0]);
            if (estadoAtual.charAt(0) == this.aFDTable[i][0].charAt(0)) {
                System.out.println("PASSOU");
                for (int j = 1; j < this.numTerminais; j++) {
                    System.out.println("CARACTERE ATUAL: "+ characterAtual.charAt(0));
                    System.out.println("ATUAL TABELA: "+ this.aFDTable[0][j].charAt(0));
                    if (characterAtual.charAt(0) == this.aFDTable[0][j].charAt(0)) {
                        System.out.println("PASSOU TUDO");
                        return this.aFDTable[i][j];
                    }
                }
            }
        }
        return " ";
    }

    private boolean estadoFinal(String estadoAtual) {
        for (String value : this.estadosFinais) {
            String charValue = value;
            if (charValue.charAt(0) == estadoAtual.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    public void algoritmo() {
        // Algoritmo usado para comparar uma tabela AFD com uma string
        // System.out.println(estadoInicial() + " AQUIIIIIIIIII");
        // for(int i = 0; i<estadosFinais.length; i++){
        //     String test = estadosFinais[i];
        //     System.out.println(test + " DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD");
        // }
        //generateTableData(aFDTable, numEstados, numTerminais);
        this.estadoAtual = estadoInicial(); // denota estado atual
        this.characterAtual = proximoCharacter(); // caractere atual da string de entrada

        while (characterAtual != " ") {
            this.estadoAtual = move(this.estadoAtual, this.characterAtual); // move para proximo transição
            System.out.print("- O símbolo " + this.characterAtual + " foi lido e foi feito a transição para o estado "
                    + estadoAtual + ".\n");
            this.characterAtual = proximoCharacter();
        }

        // verificando se a entrada está correta ou não
        checarEstadoFinal();
    }

    private String proximoCharacter() {
        if (this.characterLinhaArray == null || this.characterLinhaArrayCount == this.characterLinhaArray.length) {
            return " ";
        } else {
            return this.characterLinhaArray[this.characterLinhaArrayCount++];
        }
    }

    private String move(String estadoAtual, String characterAtual) {
        return proximoEstado(estadoAtual, characterAtual);
    }

    private void checarEstadoFinal() {
        if (estadoFinal(this.estadoAtual)) {
            JOptionPane.showMessageDialog(null, "Essa palavra é aceita pela linguagem.");
        } else {
            JOptionPane.showMessageDialog(null, "Essa palavra não é aceita pela linguagem");
        }
    }

    public static void generateTableData(String[][] table, int numLinhas, int numColumns) {
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColumns; j++) {
                String test = table[i][j];
                System.out.println(test);
            }
        }
    }

}