import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Tela de ínicio
 */
public class AFDGUI implements ActionListener {

    public JPanel panel;
    public static JFrame frame;
    private JLabel lTitulo;

    private JLabel lStep;

    private JLabel lStates;
    private JTextField tfNumStates;

    private JLabel lTerm;
    private JTextField tfTerm;

    private JLabel lTerminal;
    private JTextField tfNumTerminal;

    private JButton bGenerateTable;

    private JTable j;
    private int numLinhas;
    private int numColumns;
    private String[] columnNames;
    private String[][] data;

    private JLabel lFinalStates;
    private JTextField tFinalStates;

    private JButton bSaveTable;

    private JButton bTestTerm;

    private AFD afd;

    public AFDGUI() {

        frame = new JFrame("AFD Simulator");
        frame.getContentPane().setBackground(new Color(70, 130, 180));
        frame.setSize(1366, 768);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lTitulo = new JLabel("AFD Simulator");
        lTitulo.setBounds(40, 40, 400, 60);
        lTitulo.setFont(new Font("Arial", Font.PLAIN, 35));
        lTitulo.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(lTitulo);

        lTitulo = new JLabel("Simulação de AFD");
        lTitulo.setBounds(40, 70, 400, 60);
        lTitulo.setFont(new Font("Arial", Font.PLAIN, 20));
        lTitulo.setForeground(new Color(255, 255, 255));
        frame.getContentPane().add(lTitulo);
        
        panel = new JPanel();
        panel.setBounds(0, 150, 1366, 768);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        lStep = new JLabel("1. Algumas informações");
        lStep.setBounds(40, 40, 350, 60);
        lStep.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
        lStep.setForeground(new Color(70, 130, 180));
        panel.add(lStep);

        lStates = new JLabel("Nº de estados do AFD:");
        lStates.setBounds(40, 140, 350, 40);
        lStates.setFont(new Font("Arial", Font.PLAIN, 20));
        lStates.setForeground(new Color(128, 128, 128));
        panel.add(lStates);

        tfNumStates = new JTextField("");
        tfNumStates.setBounds(40, 200, 300, 50);
        tfNumStates.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(tfNumStates);

        lTerminal = new JLabel("Nº de símbolos terminais:");
        lTerminal.setBounds(40, 280, 350, 40);
        lTerminal.setFont(new Font("Arial", Font.PLAIN, 20));
        lTerminal.setForeground(new Color(128, 128, 128));
        panel.add(lTerminal);

        tfNumTerminal = new JTextField("");
        tfNumTerminal.setBounds(40, 340, 300, 50);
        tfNumTerminal.setFont(new Font("Arial", Font.PLAIN, 20));

        panel.add(tfNumTerminal);

        bGenerateTable = new JButton("Gerar tabela");
        bGenerateTable.setBounds(40, 460, 300, 60);
        bGenerateTable.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bGenerateTable.addActionListener(this);
        bGenerateTable.setBackground(new Color(255, 255, 255));
        bGenerateTable.setForeground(new Color(0, 128, 128));
        panel.add(bGenerateTable);
        bGenerateTable.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                numLinhas = Integer.parseInt(tfNumStates.getText());
                numColumns = Integer.parseInt(tfNumTerminal.getText());
                numColumns = numColumns + 1;
                numLinhas = numLinhas + 1;
                columnNames = new String[numColumns];
                data = new String[numLinhas][numColumns];

                for (int i = 0; i < numLinhas; i++) {
                    for (int j = 0; j < numColumns; j++) {
                        if (j == 0) {
                            columnNames[j] = "-";
                        } else {
                            columnNames[j] = ("C" + (j));
                        }
                    }
                }

                j = new JTable(data, columnNames);
                j.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                j.setBounds(480, 195, 400, 200);
                Dimension dim = new Dimension(50, 2);
                j.setIntercellSpacing(new Dimension(dim));
                bSaveTable.setVisible(true);
                bGenerateTable.setVisible(false);


                JScrollPane sp = new JScrollPane(j);
                sp.setBounds(480, 195, 400, 200);

                panel.add(sp);

            }
        });

        lStep = new JLabel("2. Preencha a tabela");
        lStep.setBounds(480, 40, 350, 60);
        lStep.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
        lStep.setForeground(new Color(70, 130, 180));
        panel.add(lStep);

        bSaveTable = new JButton("Pronto !");
        bSaveTable.setBounds(480, 460, 400, 60);
        bSaveTable.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bSaveTable.addActionListener(this);
        bSaveTable.setBackground(new Color(255, 255, 255));
        bSaveTable.setForeground(new Color(0, 128, 128));
        panel.add(bSaveTable);
        bSaveTable.setVisible(false);
        bSaveTable.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                bSaveTable.setVisible(false);
                tfTerm.setVisible(true);
                lTerm.setVisible(true);
                bTestTerm.setVisible(true);
                lFinalStates.setVisible(true);
                tFinalStates.setVisible(true);
            }
        });

        lStep = new JLabel("3. Teste :)");
        lStep.setBounds(1000, 40, 350, 60);
        lStep.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
        lStep.setForeground(new Color(70, 130, 180));
        panel.add(lStep);

        lFinalStates = new JLabel("Estados finais (separados por vírgula):");
        lFinalStates.setBounds(1000, 140, 350, 40);
        lFinalStates.setFont(new Font("Arial", Font.PLAIN, 20));
        lFinalStates.setForeground(new Color(128, 128, 128));
        panel.add(lFinalStates);
        lFinalStates.setVisible(false);

        tFinalStates = new JTextField("");
        tFinalStates.setBounds(1000, 200, 300, 40);
        tFinalStates.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(tFinalStates);
        tFinalStates.setVisible(false);

        lTerm = new JLabel("Palavra:");
        lTerm.setBounds(1000, 280, 350, 40);
        lTerm.setFont(new Font("Arial", Font.PLAIN, 20));
        lTerm.setForeground(new Color(128, 128, 128));
        panel.add(lTerm);
        lTerm.setVisible(false);

        tfTerm = new JTextField("");
        tfTerm.setBounds(1000, 340, 300, 40);
        tfTerm.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(tfTerm);
        tfTerm.setVisible(false);

        bTestTerm = new JButton("Testar palavra");
        bTestTerm.setBounds(1000, 460, 300, 60);
        bTestTerm.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bTestTerm.addActionListener(this);
        bTestTerm.setBackground(new Color(255, 255, 255));
        bTestTerm.setForeground(new Color(0, 128, 128));
        panel.add(bTestTerm);
        bTestTerm.setVisible(false);
        bTestTerm.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String palavra = getTfTerm().getText();
                int qtd = palavra.length();
                String[] terms = new String[qtd];
                for(int i=0;i<qtd;i++){
                    terms[i] = String.valueOf(palavra.charAt(i));
                }

                afd = new AFD(data, numLinhas, numColumns, getTFinalStates().getText().split(" "), terms, 0);
                afd.iniciarAFD();  
                generateTableData(data, numLinhas, numColumns);
            }
        });

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void generateTableData(String[][] table, int numLinhas, int numColumns) {
        for (int i = 0; i < numLinhas; i++) {
            for (int j = 0; j < numColumns; j++) {
                String test = table[i][j];
                System.out.println(test);
            }
        }
    }

    public static void panelInicio(JPanel j) {
        frame.add(j);
        j.setVisible(true);
    }

    public JTextField getTfNumStates() {
        return tfNumStates;
    }

    public void setTfNumStates(JTextField tfNumStates) {
        this.tfNumStates = tfNumStates;
    }

    public JTextField getTfTerm() {
        return tfTerm;
    }

    public void setTfTerm(JTextField tfTerm) {
        this.tfTerm = tfTerm;
    }

    public JTextField getTfNumTerminal() {
        return tfNumTerminal;
    }

    public void setTfNumTerminal(JTextField tfNumTerminal) {
        this.tfNumTerminal = tfNumTerminal;
    }

    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public JTextField getTFinalStates() {
        return tFinalStates;
    }

    public void setTFinalStates(JTextField tFinalStates) {
        this.tFinalStates = tFinalStates;
    }

}
