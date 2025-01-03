package Classes;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseFunctions {

    Connector Objcon = new Connector();
    private Object ob;
	// retorna a quantidade de Prodtos existentes no Mysql
	//usado em dados no frmProdutos
    public int qtdProdutos() {
        int resultado = 0;
        this.Objcon.OpenConexao();
        String sql = "SELECT COUNT(*) AS total FROM produtos";
        try {
            PreparedStatement ps = this.Objcon.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                resultado = rs.getInt("total");
            }
            return resultado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	//envia todos os produtos ao JcomBox
	// usado na Jcombox em PrincipalPage
    public void ProdutosCombo(JComboBox<JBoxPrincipal> box){
        // Abrindo a Conexão
        this.Objcon.OpenConexao();

        String sql = "select id, nome from produtos";
        try {
			// Variavel para fazer o "Commit" ao Banco de dados
            PreparedStatement ps = this.Objcon.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
			// Passa por cada produtos dentro do Banco de dados 
            while (rs.next()){
                JBoxPrincipal ob = new JBoxPrincipal();//Object for each product
                ob.ComboItem(rs.getString("nome"), rs.getInt("id"));
                box.addItem(ob);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
	// Função Pega Todos os dados de todos Os produtos para colocar na tabelas em frmProdutos
	//usado por dados em frmProdutos;
	public void Produtos(Object[][] dados){
		this.Objcon.OpenConexao();
		String sql = "select * from produtos";
		try{
			PreparedStatement ps = this.Objcon.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			int linhas = 0;
			// Ve o retorno do Mysql e adiciona os dados do produtos de acordo com a coluna ou seja i
			while (rs.next()){
				//Passsagem por todas as colunas
				for (int i = 0; i<4;i++){
					//de acordo com o valor da coluna e adiciona um valor novo
					switch(i){
						case 0:
							dados[linhas][i] = rs.getInt("id");
							break;
						case 1:
							dados[linhas][i] = rs.getString("nome");
							break;
						case 2:
							dados[linhas][i] = rs.getInt("quant");
							break;
						case 3:
							dados[linhas][i] = rs.getDouble("preco");
					}
				}
				linhas += 1;
			}

		} catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
