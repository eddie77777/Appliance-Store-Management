package Panels;

import Panels.ProdusPanel;
import Main.Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.*;

public class MainPanel extends JPanel {
    ImageIcon img;
    JLabel background;
    private JButton btnAdresa;
    private JButton btnProdus;

    private JButton btnFrigorific;

    private JButton btnElctrocasnic;
    private JButton btnGatit;
    private JButton btnSpalat;
    private JButton btnLogin;

    public static void infoBox(String infoMessage, String titleBar)
    {
        JOptionPane.showMessageDialog(null, infoMessage, "InfoBox: " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public  MainPanel ()
    {
        img = new ImageIcon(getClass().getResource("bg.jpg"));
        background = new JLabel("", img, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        background.setVisible(true);


        btnAdresa = new JButton ("Adresa");
        btnProdus = new JButton ("Produs");
        btnFrigorific = new JButton("Frigorifice");
        btnElctrocasnic = new JButton("Electrocasnice mici");
        btnGatit = new JButton("Masini de gatit");
        btnSpalat = new JButton("Masini de spalat");
        btnLogin = new JButton("Creeaza cont");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        btnAdresa.setBounds (560, 380, 300, 100);
        btnProdus.setBounds (560, 90, 300, 100);
        btnFrigorific.setBounds(100,90,150,50);
        btnSpalat.setBounds(100,203,150,50);
        btnGatit.setBounds(100,316,150,50);
        btnElctrocasnic.setBounds(100,430,150,50);
        btnLogin.setBounds(300,430,150,50);
        background.setBounds(0, 0, 944, 574);

        //add components
        add (btnAdresa);
        add (btnProdus);
        add (btnFrigorific);
        add (btnSpalat);
        add (btnElctrocasnic);
        add (btnGatit);
        add (btnLogin);
        add (background);

        //activities
        btnAdresa.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new AdresaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnLogin.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new PersoanaPanel());

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

        btnFrigorific.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new FrigorificPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnSpalat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.changeCurrentPanel(new MasinaDeSpalatPanel());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnElctrocasnic.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new ElectrocasnicMicPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnGatit.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new MasinaDeGatitPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
