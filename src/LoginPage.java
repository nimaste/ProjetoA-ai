import Classes.Connector;
import Telas.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
        entrarButton.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(e);
            }
        });
        txtUsuario.addKeyListener(new KeyAdapter() {
            //se o Usuario pressionar o enter dentro da caixa de texto usuario
            // ou ele ira para a caixa abaixo se estiver vazio caso contrario ele apertara o botão
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10){
                    if (pssSenha.getText().equals("")) {
                        pssSenha.requestFocus();
                    }
                    else{
                        entrarButton.doClick();
                    }
                }

            }
        });
        pssSenha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10){
                    entrarButton.doClick();
                }
            }
        });
    }
    public static void main(String[] args) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new LoginPage().jpPrincipal);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(600,400);

    }
}
