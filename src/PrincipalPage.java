
import Classes.DataBaseFunctions;
import Telas.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PrincipalPage {
    private JPanel JpPrincipal;
    private JButton btnNovoProduto;
    private JButton btnProdutos;
    private JButton montarAçaiButton;
    private JButton button4;
    private JLabel Logo;
    private JTable JtableUsuario;
    private JComboBox CBProdutos;
    private JButton button1;

    public PrincipalPage() {
        btnNovoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAddProduto.abrir();

            }
        });

        btnNovoProduto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == '1'){
                    frmAddProduto.abrir();
                }
            }
        });
        montarAçaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMontarAcai.abrir();
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Imperio do Açai");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PrincipalPage().JpPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1000,400);
        DataBaseFunctions dtB = new DataBaseFunctions();
        System.out.println(dtB.qtdProdutos());
    }
}
