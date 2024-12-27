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
    private Object jb;

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

    public void Produtos(JComboBox<JBoxPrincipal> box){
        // Abrindo a Conexão
        this.Objcon.OpenConexao();

        String sql = "select id, nome from produtos";
        try {
            PreparedStatement ps = this.Objcon.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                JBoxPrincipal jb = new JBoxPrincipal();//Object for each product
                jb.ComboItem(rs.getString("nome"), rs.getInt("id"));
                box.addItem(jb);
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
