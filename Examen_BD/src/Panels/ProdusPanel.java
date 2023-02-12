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

        listaProduse = new JList (DBUtils.GetProduse());

        btnAdaugare = new JButton("Adaugare");
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
        btnAdaugare.setBounds(65, 405, 100, 25);
        lblNumeProdus.setBounds(0, 55, 100, 25);
        tfldNumeProdus.setBounds(0, 75, 200, 25);
        lblPret.setBounds(0, 100, 100, 25);
        tfldPret.setBounds(0, 120, 200, 25);
        lblStoc.setBounds(0, 145, 100, 25);
        tfldStoc.setBounds(0, 165, 200, 25);
        lblSpecificatii.setBounds(0, 190, 100, 25);
        tfldSpecificatii.setBounds(0, 210, 200, 25);
        btnBack.setBounds(0, 0, 50, 25);

        //actions
        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBUtils.AdaugaProdus(new Produs(tfldNumeProdus.getText(), Integer.parseInt(tfldPret.getText()),
                            Integer.parseInt(tfldStoc.getText()),tfldSpecificatii.getText()));
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
                        UpdateDeleteProdus udp = new UpdateDeleteProdus();
                    }
                }
            }
        });
    }
}
