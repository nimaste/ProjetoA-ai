
import Classes.DataBaseFunctions;
import Classes.JBoxPrincipal;
import Telas.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class PrincipalPage {

    DataBaseFunctions dtB = new DataBaseFunctions();   // Funções para o Banco de Dados

    List <JBoxPrincipal> produtos = dtB.Produtos();   // Recebe os produtos Cadastrado No Banco de dados Armazenados como Objeto
    private JPanel JpPrincipal;
    private JButton btnNovoProduto;
    private JButton btnProdutos;
    private JButton montarAçaiButton;
    private JButton button4;
    private JLabel Logo;
    private JTable JtableUsuario;
    JComboBox <JBoxPrincipal> box;
    private JButton button1;

    public PrincipalPage() {
        for (JBoxPrincipal produto : produtos) {
            box.addItem(produto);
        }
        box.revalidate();
        box.repaint();
        btnNovoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAddProduto.abrir(box);
            }
        });
        btnNovoProduto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == '1'){
                    frmAddProduto.abrir(box);
                }
            }
        });
        montarAçaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMontarAcai.abrir();
            }
        });

        System.out.println(produtos.get(0).toString());
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Imperio do Açai");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PrincipalPage().JpPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1000,400);

    }
}
