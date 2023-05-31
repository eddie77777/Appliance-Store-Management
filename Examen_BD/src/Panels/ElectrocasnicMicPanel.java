package Panels;

import Main.Main;
import Models.ElectrocasnicMic;
import Models.Frigorific;
import Models.Produs;
import DataBase.DBUtils;
import UpdateDelete.UpdateDeleteElectrocasnicMic;
import UpdateDelete.UpdateDeleteFrigorific;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class ElectrocasnicMicPanel extends JPanel {

    private JList listaElectrocasnice;
    //private JList ListaProduse;
    private JLabel lblidProdus;
    private JTextField tfldid_produs;
    private JLabel lblProprietati;
    private JTextArea textProprietati;
    private JButton btnBack;
    private JButton btnAdaugare;

    private JLabel lblIdProdus;
    private JComboBox comboBoxIdProdus;

    Produs produsSelectat;

    public ElectrocasnicMicPanel() throws SQLException {
        //construct components
        listaElectrocasnice = new JList(DBUtils.GetElectrocasnice());
        //ListaProduse = new JList (DBUtils.GetProduse());
        lblidProdus = new JLabel("id_Produs:");
        tfldid_produs = new JTextField(1);
        lblProprietati = new JLabel("Proprietati:");
        textProprietati = new JTextArea(5, 5);
        btnBack = new JButton("<<");
        btnAdaugare = new JButton("Adaugare");
        lblIdProdus = new JLabel("Produs:");
        Vector<Produs> produse = DBUtils.GetProduse();
        comboBoxIdProdus = new JComboBox(produse);


        //adjust size and set layout
        setPreferredSize(new Dimension(944, 574));
        setLayout(null);

        //add components
        add(listaElectrocasnice);
        //add (ListaProduse);
        add(lblidProdus);
        add(tfldid_produs);
        add(lblProprietati);
        add(textProprietati);
        add(btnBack);
        add(btnAdaugare);
        add(comboBoxIdProdus);
        add(lblIdProdus);

        //set component bounds (only needed by Absolute Positioning)
        listaElectrocasnice.setBounds(490, 0, 460, 574);
        //ListaProduse.setBounds (445, 325, 500, 250);
        lblProprietati.setBounds(0, 135, 100, 25);
        textProprietati.setBounds(0, 160, 486, 100);
        btnBack.setBounds(0, 0, 50, 25);
        btnAdaugare.setBounds(193, 270, 100, 25);
        comboBoxIdProdus.setBounds(0, 110, 486, 25);
        lblIdProdus.setBounds(0, 85, 100, 25);

        listaElectrocasnice.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();
                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof ElectrocasnicMic) {
                        ElectrocasnicMic electrocasnicSelectat = (ElectrocasnicMic) selectedObj;
                        System.out.println(electrocasnicSelectat.getId_electrocasnic_mic());
                        try {
                            UpdateDeleteElectrocasnicMic ude = new UpdateDeleteElectrocasnicMic(electrocasnicSelectat.getId_electrocasnic_mic());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Main.changeCurrentPanel(new ProdusPanel());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboBoxIdProdus.getSelectedItem() == null) {
                        MainPanel.infoBox("Niciun produs selectat.", "Error");
                        return;
                    }

                    //VERIFICARE TEXTFIELDS
                    if (textProprietati.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }
                    DBUtils.AdaugaElectrocasnic(new ElectrocasnicMic(produsSelectat.getId_produs(), textProprietati.getText()));
                    listaElectrocasnice.setListData(DBUtils.GetElectrocasnice());
                    textProprietati.setText("");
                    comboBoxIdProdus.setSelectedItem(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        comboBoxIdProdus.setSelectedItem(null);
        comboBoxIdProdus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedObj = comboBoxIdProdus.getSelectedItem();
                if (selectedObj instanceof Produs) {
                    produsSelectat = (Produs) selectedObj;
                }
            }
        });
    }
}
