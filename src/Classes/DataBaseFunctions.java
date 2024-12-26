package Classes;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

public class DataBaseFunctions {
    Connector Objcon = new Connector();
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

    public ArrayList<JBoxPrincipal> Produtos(){
        // cria uma lista de Array que ira receber os objetos
        ArrayList<JBoxPrincipal> produtos = null;
        // Abrindo a Conexão
        this.Objcon.OpenConexao();
        JBoxPrincipal jb = new JBoxPrincipal();
        String sql = "select id, nome from produtos";
        try {
            PreparedStatement ps = this.Objcon.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                jb.ComboItem(rs.getString("nome"), rs.getInt("id"));
                produtos.add(jb);
            }
            return produtos;
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    public Connector getObjcon() {
        return Objcon;
    }

    public void setObjcon(Connector objcon) {
        Objcon = objcon;
    }
}
