package Panels;

import Panels.ProdusPanel;
import Main.Main;

import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
    ImageIcon img;
    JLabel background;
    private JButton btnAdresa;
    private JButton btnProdus;

    public  MainPanel ()
    {
        img = new ImageIcon(getClass().getResource("bg.jpg"));
        background = new JLabel("", img, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        background.setVisible(true);


        btnAdresa = new JButton ("Adresa");
        btnProdus = new JButton ("Produs");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        btnAdresa.setBounds (560, 380, 300, 100);
        btnProdus.setBounds (560, 90, 300, 100);
        background.setBounds(0, 0, 944, 574);

        //add components
        add (btnAdresa);
        add (btnProdus);
        add (background);

        //activities
        btnAdresa.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new AdresaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnProdus.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new ProdusPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

    }
}
