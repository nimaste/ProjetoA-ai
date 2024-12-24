package Classes;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    public Connection con;
    Statement stmt;
    ResultSet rs;
    PreparedStatement ps;
    String url = "jdbc:mysql://localhost:3306/imperio_acai";
    String user = "root";
    String password = "nicolas123"; //aluno123
    String driver = "com.mysql.cj.jdbc.Driver";
    public void OpenConexao()
    {
        try{
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, user, password);
            stmt = (Statement) con.createStatement();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro na conexão com o BD ","ERRO",JOptionPane.ERROR_MESSAGE,null);
        }
    }

}
