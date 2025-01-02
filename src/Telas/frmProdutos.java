package Telas;

import javax.swing.*;

public class frmProdutos extends JFrame {
    private JPanel jpPrincipal;         // Vinculado ao painel principal do XML
    private JTable tabela;              // Vinculado à JTable do XML
    private JScrollPane scrollBar;      // Vinculado ao JScrollPane do XML

    static String[] nomeColunas = {"ID", "Nome", "Quantidade", "Preço/unidade"};
    static Object[][] dados = {};

    public frmProdutos() {
		dados.appendValue()
        super("Produtos");
		//inicialiando a tabela da forma correta
        tabela.setModel(new javax.swing.table.DefaultTableModel(dados, nomeColunas));
        scrollBar.setViewportView(tabela);
        setContentPane(jpPrincipal);  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
    }

    public static void abrir() {
        frmProdutos frame = new frmProdutos();
        frame.setVisible(true);
    }
}
