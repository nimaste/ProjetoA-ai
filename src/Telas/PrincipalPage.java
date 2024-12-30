package Telas;

import Classes.Connector;
import Classes.DataBaseFunctions;
import Classes.JBoxPrincipal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.*;

public class PrincipalPage {
    DataBaseFunctions dtB = new DataBaseFunctions();   // Funções para o Banco de Dados
    // Recebe os produtos Cadastrado No Banco de dados Armazenados como Objeto
    private JPanel JpPrincipal;
    private JButton btnNovoProduto;
    private JButton btnProdutos;
    private JButton montarAçaiButton;
    private JButton button4;
    private JLabel Logo;
    private JTable jtblCompra;
    JComboBox <JBoxPrincipal> box;
    private JButton btnFinalizar;
    private JButton btnAdd;

    public PrincipalPage() {
        // Criação do modelo da tabela com colunas iniciais
        String[] columnNames = {"Produto", "Preço"};
        Object[][] data = {};
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        jtblCompra.setModel(model);

        // Colocando todos os produtos do banco de dados no JComboBox
        dtB.Produtos(box);
        box.revalidate();
        box.repaint();
        btnNovoProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmAddProduto.abrir(box);
            }
        });
        //Digitar 1 vai para a sessão de criar um produto novo
        btnNovoProduto.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyChar() == '1'){
                    frmAddProduto.abrir(box);
                }
            }
        });
        //abri o "montador de açai"
        montarAçaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmMontarAcai.abrir();
            }
        });

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void abrir(Connector con) {
        JFrame frame = new JFrame("Imperio do Açai");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PrincipalPage().JpPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1000,400);

    }

}
