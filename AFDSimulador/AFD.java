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
            if (estadoAtual.charAt(0) == this.aFDTable[i][0].charAt(0)) {
                for (int j = 1; j < this.numTerminais; j++) {             
                    if (characterAtual.charAt(0) == this.aFDTable[0][j].charAt(0)) {
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

    public void iniciarAFD() {

        this.estadoAtual = estadoInicial(); 
        this.characterAtual = proximoCharacter(); 

        while (characterAtual != " ") {
            this.estadoAtual = move(this.estadoAtual, this.characterAtual); 
            System.out.print("- O símbolo " + this.characterAtual + " foi lido e foi feito a transição para o estado "
                    + estadoAtual + ".\n");
            this.characterAtual = proximoCharacter();
        }
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

}