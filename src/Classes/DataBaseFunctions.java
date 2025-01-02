package Classes;

import javax.swing.*;
import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataBaseFunctions {
    Connector Objcon = new Connector();
    private Object ob;

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
	// Esta função segue a mesma logica que o de cima
	// Porem pega todos os dados do Produto pois cada um é para um caso especifico
	public void Produtos(Object){
		this.Objcon.OpenConexao();
		String sql = "select * from produtos";
		try{
			PreparedStatement ps = this.Objcon.con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()){
                TableProdutos jb = new TableProdutos();//Object for each product
                jb.ComboItem(rs.getInt("id"),rs.getString("nome"),rs.getInt("quant"),rs.getDouble("preco"));
                box.addItem(jb);
            }
		}
	}
}
