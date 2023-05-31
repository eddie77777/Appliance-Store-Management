package Panels;

import Main.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class MainPanel extends JPanel {
    ImageIcon img;
    JLabel background;
    private JButton btnGestionareProduse;
    private JButton btnComandaProdus;


    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public MainPanel() {
        img = new ImageIcon(getClass().getResource("bg.jpg"));
        background = new JLabel("", img, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        background.setVisible(true);


        btnGestionareProduse = new JButton("Gestionare produse");
        btnComandaProdus = new JButton("Comanda produs");

        //adjust size and set layout
        setPreferredSize(new Dimension(944, 574));
        setLayout(null);

        //set component bounds (only needed by Absolute Positioning)
        btnGestionareProduse.setBounds(540, 200, 300, 100);
        btnComandaProdus.setBounds(140, 200, 300, 100);
        background.setBounds(0, 0, 944, 574);

        //add components
        add(btnGestionareProduse);
        add(btnComandaProdus);
        add(background);


        //activities
        btnGestionareProduse.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new ProdusPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnComandaProdus.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new AdresaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
