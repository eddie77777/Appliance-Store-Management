package Panels;

import Main.Main;
import Models.ElectrocasnicMic;
import Models.MasinaDeGatit;
import Models.Produs;
import DataBase.DBUtils;
import UpdateDelete.UpdateDeleteElectrocasnicMic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

public class MasinaDeGatitPanel extends JPanel {

    private JList listaMasiniDeGatit;
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

    public MasinaDeGatitPanel() throws SQLException {
        //construct components
        listaMasiniDeGatit = new JList (DBUtils.GetMasiniDeGatit());
        //ListaProduse = new JList (DBUtils.GetProduse());
        lblidProdus = new JLabel ("id_Produs:");
        tfldid_produs = new JTextField (1);
        lblProprietati = new JLabel ("Proprietati:");
        textProprietati = new JTextArea (5, 5);
        btnBack = new JButton ("<<");
        btnAdaugare = new JButton ("Adaugare");
        lblIdProdus = new JLabel ("Produs:");
        Vector<Produs> produse = DBUtils.GetProduse();
        comboBoxIdProdus = new JComboBox(produse);


        //adjust size and set layout
        setPreferredSize (new Dimension(944, 574));
        setLayout (null);

        //add components
        add (listaMasiniDeGatit);
        //add (ListaProduse);
        add (lblidProdus);
        add (tfldid_produs);
        add (lblProprietati);
        add (textProprietati);
        add (btnBack);
        add (btnAdaugare);
        add (comboBoxIdProdus);
        add (lblIdProdus);

        //set component bounds (only needed by Absolute Positioning)
        listaMasiniDeGatit.setBounds (490, 0, 460, 574);
        //ListaProduse.setBounds (445, 325, 500, 250);
        lblProprietati.setBounds (0, 135, 100, 25);
        textProprietati.setBounds (0, 160, 486, 100);
        btnBack.setBounds (0, 0, 50, 25);
        btnAdaugare.setBounds (193, 270, 100, 25);
        comboBoxIdProdus.setBounds (0, 110, 486, 25);
        lblIdProdus.setBounds (0, 85, 100, 25);

        listaMasiniDeGatit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();
                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof MasinaDeGatit) {
                        MasinaDeGatit masinaSelectata = (MasinaDeGatit) selectedObj;
                        System.out.println(masinaSelectata.getId_masina_de_gatit());
                       /* try {
                            UpdateDeleteElectrocasnicMic ude = new UpdateDeleteElectrocasnicMic(masinaSelectata.getId_masina_de_gatit());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }*/
                    }
                }
            }
        });

        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Main.changeCurrentPanel(new MainPanel());
                }
                catch (Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBUtils.AdaugaMasinaDeGatit(new MasinaDeGatit(produsSelectat.getId_produs(), textProprietati.getText()));
                    listaMasiniDeGatit.setListData(DBUtils.GetMasiniDeGatit());
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
