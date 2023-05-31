package Panels;

import DataBase.DBUtils;
import Models.Adresa;
import Models.Produs;
import UpdateDelete.UpdateDeleteProdus;
import Main.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ProdusPanel extends JPanel {
    private JList listaProduse;
    private JButton btnAdaugare;
    private JButton btnFrigorific;
    private JButton btnMasinaDeGatit;
    private JButton btnMasinaDeSpalat;
    private JButton btnElectrocasnicMic;
    private JLabel lblNumeProdus;
    private JTextField tfldNumeProdus;
    private JLabel lblPret;
    private JTextField tfldPret;
    private JLabel lblStoc;
    private JTextField tfldStoc;
    private JLabel lblSpecificatii;
    private JTextField tfldSpecificatii;

    private JButton btnBack;

    public ProdusPanel() throws SQLException {

        listaProduse = new JList(DBUtils.GetProduse());

        btnAdaugare = new JButton("Adaugare");
        btnFrigorific = new JButton("Frigorific");
        btnElectrocasnicMic = new JButton("Electrocasnic mic");
        btnMasinaDeSpalat = new JButton("Masina de spalat");
        btnMasinaDeGatit = new JButton("Masina de gatit");
        lblNumeProdus = new JLabel("Nume produs:");
        tfldNumeProdus = new JTextField(1);
        lblPret = new JLabel("Pret:");
        tfldPret = new JTextField(1);
        lblStoc = new JLabel("Stoc:");
        tfldStoc = new JTextField(1);
        lblSpecificatii = new JLabel("Specificatii:");
        tfldSpecificatii = new JTextField(1);
        btnBack = new JButton("<<");

        //adjust size and set layout
        setPreferredSize(new Dimension(938, 568));
        setLayout(null);

        //add components
        add(listaProduse);
        add(btnAdaugare);
        add(btnElectrocasnicMic);
        add(btnFrigorific);
        add(btnMasinaDeGatit);
        add(btnMasinaDeSpalat);
        add(lblNumeProdus);
        add(tfldNumeProdus);
        add(lblPret);
        add(tfldPret);
        add(lblStoc);
        add(tfldStoc);
        add(lblSpecificatii);
        add(tfldSpecificatii);
        add(btnBack);

        //set component bounds (only needed by Absolute Positioning)
        listaProduse.setBounds(240, 0, 700, 574);
        btnFrigorific.setBounds(10, 335, 200, 25);
        btnElectrocasnicMic.setBounds(10, 375, 200, 25);
        btnMasinaDeGatit.setBounds(10, 415, 200, 25);
        btnMasinaDeSpalat.setBounds(10, 455, 200, 25);
        btnAdaugare.setBounds(10, 250, 100, 25);
        lblNumeProdus.setBounds(10, 55, 100, 25);
        tfldNumeProdus.setBounds(10, 75, 200, 25);
        lblPret.setBounds(10, 100, 100, 25);
        tfldPret.setBounds(10, 120, 200, 25);
        lblStoc.setBounds(10, 145, 100, 25);
        tfldStoc.setBounds(10, 165, 200, 25);
        lblSpecificatii.setBounds(10, 190, 100, 25);
        tfldSpecificatii.setBounds(10, 210, 200, 25);
        btnBack.setBounds(10, 0, 50, 25);

        btnFrigorific.addActionListener(e -> {
            try {
                if(listaProduse.getModel().getSize() == 0)
                {
                    MainPanel.infoBox("Trebuie sa adaugati datele pentru un produs.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new FrigorificPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnElectrocasnicMic.addActionListener(e -> {
            try {
                if(listaProduse.getModel().getSize() == 0)
                {
                    MainPanel.infoBox("Trebuie sa adaugati datele pentru un produs.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new ElectrocasnicMicPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnMasinaDeGatit.addActionListener(e -> {
            try {
                if(listaProduse.getModel().getSize() == 0)
                {
                    MainPanel.infoBox("Trebuie sa adaugati datele pentru un produs.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new FrigorificPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnMasinaDeSpalat.addActionListener(e -> {
            try {
                if(listaProduse.getModel().getSize() == 0)
                {
                    MainPanel.infoBox("Trebuie sa adaugati datele pentru un produs.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new FrigorificPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        //actions
        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tfldNumeProdus.getText().isEmpty() || tfldNumeProdus.getText().isEmpty() ||
                            tfldPret.getText().isEmpty() || tfldStoc.getText().isEmpty()
                            || tfldSpecificatii.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }

                    DBUtils.AdaugaProdus(new Produs(tfldNumeProdus.getText(), Integer.parseInt(tfldPret.getText()),
                            Integer.parseInt(tfldStoc.getText()), tfldSpecificatii.getText()));
                    listaProduse.setListData(DBUtils.GetProduse());
                    tfldNumeProdus.setText("");
                    tfldPret.setText("");
                    tfldStoc.setText("");
                    tfldSpecificatii.setText("");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new MainPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        listaProduse.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();
                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof Produs) {
                        Produs produsSelectat = (Produs) selectedObj;
                        System.out.println(produsSelectat.getId_produs());
                        try {
                            UpdateDeleteProdus udp = new UpdateDeleteProdus(produsSelectat.getId_produs());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }
}
