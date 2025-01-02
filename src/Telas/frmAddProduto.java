package Telas;

import Classes.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class frmAddProduto {
    // Criando o objeto frame como statico para conseguir manipular as janelas abertas
    static JFrame frame = new JFrame("Imperio do Açai");
    private JPanel jpPrincipal;
    private JTextField txtNome;
    private JTextField txtPreco;
    private JTextField txtQuantidade;
    private JButton btnAddProduto;
    private JTextField txtIdentificador;

	//FrmAddProdutos (O commit serve para melhor localização)
    public frmAddProduto(JComboBox<JBoxPrincipal> box) {
		
		//Função para adicionar o novo Produto ao Banco de Dados 
        btnAddProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Criando um objeto para fazer coneções com o banco de dados
                Connector Objcon = new Connector();
                Objcon.OpenConexao();
                JBoxPrincipal jb = new JBoxPrincipal();
                try {
					// Inicializando as variaveis que recebe o id , a quantidade, o preço e o nome que é digitado pelo usuario
                    int id = Integer.parseInt(txtIdentificador.getText());
                    int qnt = Integer.parseInt(txtQuantidade.getText());
                    double preco = Double.parseDouble(txtPreco.getText());
                    String nome = txtNome.getText();
					
					//Script sql que salva todos este dados dentro da tabela mySql
                    String sql = "insert into produtos(id,nome,preco,quant) values (?,?,?,?)";
                    PreparedStatement ps = Objcon.con.prepareStatement(sql);
                    ps.setInt(1,id);
                    ps.setString(2,nome);
                    ps.setDouble(3,preco);
                    ps.setInt(4,qnt);
                    ps.executeUpdate();
					
					// Cria um objeto com os dados necessario do produto e coloca no JcomboBox no PrincipalPage
                    jb.ComboItem(nome,id);
                    box.addItem(jb);

					//esvaziando os campos e retornado um feedback para o usuario
                    txtNome.setText("");
                    txtIdentificador.setText("");
                    txtPreco.setText("");
                    txtQuantidade.setText("");
                    JOptionPane.showMessageDialog(null,"Produto Cadastrado com Sucesso","Produto Cadastrado",JOptionPane.INFORMATION_MESSAGE);
                }
                catch (NumberFormatException exception){
                    JOptionPane.showMessageDialog(null, "Verifique se todos os campos estão preenchidos corretamente","ERRO",JOptionPane.ERROR_MESSAGE,null);
                }
                catch (java.sql.SQLIntegrityConstraintViolationException ex){
                    JOptionPane.showMessageDialog(null, "Produto com esse codigo ja esta salvo","ERRO",JOptionPane.ERROR_MESSAGE,null);
                }
                catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                ;

            }
        });
    }
    // o Box vem do PrincipalPage
    // Para addicionar o novo valor a JcomboBox
    public static void abrir(JComboBox<JBoxPrincipal> box) {
        // se ja houver uma janela aberta ele ira colocala na frente e da foco nela
        if (!frame.isDisplayable()){
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setContentPane(new frmAddProduto(box).jpPrincipal);
            frame.setLocationRelativeTo(null);
            frame.setSize(500, 400);
            frame.setVisible(true);

        }
        else{
            frame.toFront();
            frame.requestFocus();
        }

    }
}