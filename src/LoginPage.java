import Classes.Connector;
import Telas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage {
    static JFrame frame = new JFrame("Imperio do Açai");
    private JPanel jpPrincipal;
    private JTextField txtUsuario;
    private JPasswordField pssSenha;
    private JButton entrarButton;
    Connector con = new Connector();

    public LoginPage() {
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtUsuario.getText();
                String senha = pssSenha.getText();
                con.setPassword(senha);
                con.setUser(user);
                if (con.OpenConexao()){
                    PrincipalPage.abrir(con);
                    frame.dispose();
                }
            }
        });
    }
    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new LoginPage().jpPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(1000,400);

    }
}
