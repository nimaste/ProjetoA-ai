package Telas;

import Classes.Connector;
import Classes.DataBaseFunctions;
import Classes.JBoxPrincipal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrincipalPage extends JFrame{
    DataBaseFunctions dtB = new DataBaseFunctions();  // Funções para o Banco de Dados

    //Iterface
    JPanel JpPrincipal;
    private JButton btnNovoProduto;
    private JButton btnProdutos;
    private JButton montarAçaiButton;
    private JButton button4;
    private JLabel Logo;
    JComboBox <JBoxPrincipal> box;
    private JButton btnFinalizar;
    private JButton btnAdd;
    JTable tabela;


    Object [][] dados = {null,null,null};
    String [] colunas = {"Nome", "Telefone", "Email"};

    public PrincipalPage() {

        tabela = new JTable(dados,colunas);
        JScrollPane scroll = new JScrollPane(tabela);

        // Colocando todos os produtos do banco de dados no JComboBox
        dtB.ProdutosCombo(box);
        box.revalidate();
        box.repaint();

        //Listeners
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
		//Abri A Janela Produtos que contem a lista de todos os produtos
        btnProdutos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frmProdutos.abrir();
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
