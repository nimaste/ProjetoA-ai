package Telas;

import javax.swing.*;

public class frmMontarAcai {
    static JFrame frame = new JFrame("Imperio do Açai");
    private JPanel JpPrincipal;
    private JCheckBox check300;
    private JCheckBox check400;
    private JCheckBox check500;
    private JCheckBox vCheckBox;
    private JCheckBox checkBox1;

    public static void abrir() {
        // se ja houver uma janela aberta ele ira colocala na frente e da foco nela
        if (!frame.isDisplayable()){
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setContentPane(new frmMontarAcai().JpPrincipal);
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
