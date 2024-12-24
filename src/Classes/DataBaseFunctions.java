package Classes;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataBaseFunctions {

    public int qtdProdutos() {
        int resultado = 0; // Inicializar o resultado
        Connector Objcon = new Connector();
        Objcon.OpenConexao();

        // Código SQL para contar os itens na tabela 'produtos'
        String sql = "SELECT COUNT(*) AS total FROM produtos";

        try {
            PreparedStatement ps = Objcon.con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            // Ler o resultado do ResultSet
            if (rs.next()) {
                resultado = rs.getInt("total");
            }

            return resultado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
