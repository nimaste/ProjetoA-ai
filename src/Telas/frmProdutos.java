package Telas;

import javax.swing.*;

public class frmProdutos extends JFrame {
    private JPanel jpPrincipal;         // Vinculado ao painel principal do XML
    private JTable tabela;              // Vinculado à JTable do XML
    private JScrollPane scrollBar;      // Vinculado ao JScrollPane do XML

    String[] nomeColunas = {"ID", "Nome", "Quantidade", "Preço/unidade"};
    Object[][] dados = {
        {"1", "Produto A", "10", "5.00"},
        {"2", "Produto B", "20", "10.00"}
    };

    public frmProdutos() {
        super("Produtos");
        // Atualiza os dados e colunas da tabela
        tabela.setModel(new javax.swing.table.DefaultTableModel(dados, nomeColunas));
        scrollBar.setViewportView(tabela); // Garante que a tabela esteja no JScrollPane
        setContentPane(jpPrincipal);     // Configura o painel principal da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);     // Centraliza a janela na tela
    }

    public static void abrir() {
        frmProdutos frame = new frmProdutos();
        frame.setVisible(true);
    }
}
