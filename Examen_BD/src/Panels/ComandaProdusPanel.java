package Panels;

import DataBase.DBUtils;
import Main.Main;
import Models.Adresa;
import Models.Comanda;
import Models.ComandaProdus;
import Models.Produs;
import UpdateDelete.UpdateDeleteAdresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ComandaProdusPanel extends JPanel {
    JLabel lblComanda;
    JComboBox comboBoxComanda;
    JLabel lblProdus;
    JComboBox comboBoxProdus;
    JButton btnPlaseazaComanda;
    JButton btnAnuleazaComanda;
    JButton btnModificaComanda;
    JButton btnVizualizareComanda;
    Produs produsSelectat;
    Comanda comandaSelectata;
    JLabel lblComenzileTale;
    JList listaComenziPlasate;
    ComandaProdus comandaSelectataLista;
    private JButton btnBack;

    public ComandaProdusPanel() throws SQLException {
        lblComanda = new JLabel("Alege comanda:");
        comboBoxComanda = new JComboBox(DBUtils.GetComenzi());
        lblProdus = new JLabel("Alege produsul:");
        comboBoxProdus = new JComboBox(DBUtils.GetProduse());
        btnPlaseazaComanda = new JButton("Plaseaza comanda");
        lblComenzileTale = new JLabel("Comenzile tale");
        listaComenziPlasate = new JList(DBUtils.GetComandaProdus());
        btnAnuleazaComanda = new JButton("Anuleaza comanda");
        btnModificaComanda = new JButton("Modifica comanda");
        btnVizualizareComanda = new JButton("Vizualizare comanda");
        btnBack = new JButton ("<<");
        setPreferredSize(new Dimension(900, 500));
        setLayout(null);

        add(lblComanda);
        add(comboBoxComanda);
        add(lblProdus);
        add(comboBoxProdus);
        add(lblComenzileTale);
        add(listaComenziPlasate);
        add(btnPlaseazaComanda);
        add(btnAnuleazaComanda);
        add(btnVizualizareComanda);
       // add(btnModificaComanda);
        add (btnBack);

        lblComanda.setBounds(10, 30, 100, 25);
        comboBoxComanda.setBounds(10, 55, 700, 25);
        lblProdus.setBounds(10, 80, 100, 25);
        comboBoxProdus.setBounds(10, 105, 700, 25);
        btnPlaseazaComanda.setBounds(720, 55, 150, 75);
        lblComenzileTale.setBounds(10, 130, 100, 25);
        listaComenziPlasate.setBounds(10, 155, 500, 250);
        btnVizualizareComanda.setBounds(550, 195, 200, 25);
        btnModificaComanda.setBounds(550, 225, 200, 25);
        btnAnuleazaComanda.setBounds(550, 255, 200, 25);
        btnBack.setBounds (10, 0, 50, 25);

        btnPlaseazaComanda.addActionListener(e -> {
            try {
                if(comboBoxComanda.getSelectedItem()==null || comboBoxProdus.getSelectedItem()==null)
                {
                    MainPanel.infoBox("Niciun produs selectat sau comanda selectata", "Error");
                    return;
                }
                DBUtils.AdaugaComandaProdus(new ComandaProdus(comandaSelectata.getId_comanda(), produsSelectat.getId_produs()));
                listaComenziPlasate.setListData(DBUtils.GetComandaProdus());
                comboBoxComanda.setSelectedItem(null);
                comboBoxProdus.setSelectedItem(null);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnVizualizareComanda.addActionListener(e -> {
            try {
                if(comandaSelectataLista == null)
                {
                    MainPanel.infoBox("Selectati o comanda.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new VizualizareComandaPanel(comandaSelectataLista));
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnAnuleazaComanda.addActionListener(e -> {
            try {
                if(comandaSelectataLista == null)
                {
                    MainPanel.infoBox("Selectati o comanda.", "Error");
                    return;
                }
                DBUtils.DeleteComandaProdus(comandaSelectataLista.getId_comanda_produs());
                listaComenziPlasate.setListData(DBUtils.GetComandaProdus());
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        comboBoxProdus.setSelectedItem(null);
        comboBoxProdus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedObj = comboBoxProdus.getSelectedItem();
                if (selectedObj instanceof Produs) {
                    produsSelectat = (Produs) selectedObj;
                }
            }
        });

        comboBoxComanda.setSelectedItem(null);
        comboBoxComanda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedObj = comboBoxComanda.getSelectedItem();
                if (selectedObj instanceof Comanda) {
                    comandaSelectata = (Comanda) selectedObj;
                }
            }
        });

        listaComenziPlasate.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JList list = (JList) e.getSource();
                Object selectedObj = list.getSelectedValue();
                if (selectedObj instanceof ComandaProdus) {
                    comandaSelectataLista = (ComandaProdus) selectedObj;
                }
            }
        });

        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new PersoanaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
