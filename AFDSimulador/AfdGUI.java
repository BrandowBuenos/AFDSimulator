import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Tela de ínicio
 */
public class AfdGUI implements ActionListener {

    public JPanel panel;
    public static JFrame frame;
    private JLabel lTitulo;

    private JLabel lClientes;

    private JLabel lStates;
    private JTextField tfNumStates;

    private JLabel lTerminal;
    private JTextField tfNumTerminal;

    private JButton bEnviar;

    JTable j;

    public AfdGUI() {

        frame = new JFrame("AFD Simulator");
        frame.getContentPane().setBackground(new Color(70, 130, 180));
        frame.setSize(1280, 768);
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
        panel.setBounds(0, 150, 1280, 768);
        panel.setBackground(new Color(255, 255, 255));
        panel.setLayout(null);
        frame.getContentPane().add(panel);

        lClientes = new JLabel("1. Algumas informações");
        lClientes.setBounds(140, 40, 350, 60);
        lClientes.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
        lClientes.setForeground(new Color(70, 130, 180));
        panel.add(lClientes);

        lStates = new JLabel("Número de estados do AFD:");
        lStates.setBounds(40, 160, 350, 40);
        lStates.setFont(new Font("Arial", Font.PLAIN, 20));
        lStates.setForeground(new Color(128, 128, 128));
        panel.add(lStates);

        tfNumStates = new JTextField("");
        tfNumStates.setBounds(330, 160, 120, 40);
        tfNumStates.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(tfNumStates);
        //int numColumns = Integer.parseInt(this.tfNumStates.getText());

        lTerminal = new JLabel("Número de símbolos terminais:");
        lTerminal.setBounds(40, 250, 350, 40);
        lTerminal.setFont(new Font("Arial", Font.PLAIN, 20));
        lTerminal.setForeground(new Color(128, 128, 128));
        panel.add(lTerminal);

        tfNumTerminal = new JTextField("");
        tfNumTerminal.setBounds(330, 250, 120, 40);
        tfNumTerminal.setFont(new Font("Arial", Font.PLAIN, 20));
        panel.add(tfNumTerminal);
        //int numLinhas = Integer.parseInt(this.tfNumTerminal.getText());

        bEnviar = new JButton("Gerar tabela");
        bEnviar.setBounds(40, 360, 430, 60);
        bEnviar.setFont(new Font("Helvetica Neue", Font.PLAIN, 20));
        bEnviar.addActionListener(this);
        bEnviar.setBackground(new Color(255, 255, 255));
        bEnviar.setForeground(new Color(0, 128, 128));
        panel.add(bEnviar);
        bEnviar.addActionListener(new ActionListener() {

            //inicializa a tabela vazia
			public void actionPerformed(ActionEvent e) {

                int numLinhas = Integer.parseInt(tfNumStates.getText());
                int numColumns = Integer.parseInt(tfNumTerminal.getText());
                String[] columnNames = new String[numColumns];
                String[][] data = new String [numLinhas][numColumns];
                for(int i = 0; i < numLinhas; i++){
                    for(int j = 0; j < numColumns; j++){
                        columnNames[j] = "Column" + (j + 1);
                        data[i][j] = " ";
                    }
                }
            // Initializing the JTable
            j = new JTable(data, columnNames);
            j.setBounds(560, 100, 500, 800);
            j.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            Dimension dim = new Dimension(50,2);
            j.setIntercellSpacing(new Dimension(dim));
            //JTable.

            // adding it to JScrollPane
            JScrollPane sp = new JScrollPane(j); 
            sp.setBounds(560, 100, 600, 325);

            panel.add(sp);

            }
            });

        lClientes = new JLabel("2. Preencha a tabela");
        lClientes.setBounds(560, 40, 350, 60);
        lClientes.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));
        lClientes.setForeground(new Color(70, 130, 180));
        panel.add(lClientes);

        // Data to be displayed in the JTable
        String[][] data = { {"GGG","GGG1", "GGG2", "GGGG"}, {"GGG", "GGG3", "GGG4", "GGGG"}, {"","","", "GGGG"} };
        // for(int i = 0; i<5;i++){
        //     for(int j; i<5;j++){

        //         //data[i][j] = { { "Kundan Kumar Jha", "4031", "CSE" },{ "Anand Jha", "6014", "IT" } };
                
        //     }
        // }
        // Column Names
        String[] columnNames = { "-", "a", "b", "c" };
        
        

        frame.setVisible(true);
        

    }

    public void actionPerformed(ActionEvent ae) {

    }

    public static void panelInicio(JPanel j) {
        frame.add(j);
        j.setVisible(true);
    }

}