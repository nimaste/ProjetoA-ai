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
    private static String user = "root";
    private static String password ;
    String driver = "com.mysql.cj.jdbc.Driver";

    public String getUser(){
        return Connector.user;
    }

    public void setUser(String user){
        Connector.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        Connector.password = password;
    }

    public boolean OpenConexao() {
        try{
            Class.forName(driver).newInstance();
            con = DriverManager.getConnection(url, this.user, getPassword());
            stmt = (Statement) con.createStatement();
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Verifique se a senha e o usuario estão correto","ERRO",JOptionPane.ERROR_MESSAGE,null);
            return false;
        }
    }
}
