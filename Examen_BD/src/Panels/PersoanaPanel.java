package Panels;

import DataBase.DBUtils;
import Main.Main;
import Models.Adresa;
import Models.Comanda;
import Models.Persoana;
import Models.Produs;
import UpdateDelete.UpdateDeleteAdresa;
import UpdateDelete.UpdateDeletePersoana;
import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.Vector;

public class PersoanaPanel extends JPanel {
    private JList listaPersoane;
    private JButton btnAdaugare;
    private JButton btnComanda;
    private JLabel lblNume;
    private JTextField tfldNume;
    private JLabel lblPrenume;
    private JTextField tfldPrenume;
    private JLabel lblEmail;
    private JTextField tfldEmail;
    private JLabel lblNumar;
    private JTextField tfldNumar;
    private JButton btnBack;
    private JLabel lblAdresa;
    private JComboBox comboBoxIdAdresa;

    Adresa adresaSelectata;


    public PersoanaPanel() throws SQLException {
        //construct components
        listaPersoane = new JList(DBUtils.GetPersoane());


        lblNume = new JLabel("Nume:");
        tfldNume = new JTextField(1);
        lblPrenume = new JLabel("Prenume:");
        tfldPrenume = new JTextField(1);
        lblEmail = new JLabel("Email:");
        tfldEmail = new JTextField(1);
        lblNumar = new JLabel("Numar telefon:");
        tfldNumar = new JTextField(1);
        btnAdaugare = new JButton("Adaugare");
        btnComanda = new JButton("Finalizeaza datele comenzii");
        lblAdresa = new JLabel("Adresa de livrare:");
        btnBack = new JButton("<<");
        Vector<Adresa> adrese = DBUtils.GetAdrese();
        comboBoxIdAdresa = new JComboBox(adrese);
        //adjust size and set layout
        setPreferredSize(new Dimension(938, 400));
        setLayout(null);

        //add components
        add(listaPersoane);
        add(btnAdaugare);
        add(lblNume);
        add(tfldNume);
        add(lblPrenume);
        add(tfldPrenume);
        add(lblEmail);
        add(tfldEmail);
        add(lblNumar);
        add(tfldNumar);
        add(lblAdresa);
        add(btnComanda);
        add(comboBoxIdAdresa);
        add(btnBack);

        //set component bounds (only needed by Absolute Positioning)
        listaPersoane.setBounds(490, 0, 460, 270);
        btnAdaugare.setBounds(250, 345, 375, 25);

        lblNume.setBounds(0, 105, 100, 25);
        tfldNume.setBounds(0, 125, 486, 25);
        lblPrenume.setBounds(0, 150, 100, 25);
        tfldPrenume.setBounds(0, 170, 486, 25);
        lblEmail.setBounds(0, 195, 100, 25);
        tfldEmail.setBounds(0, 215, 486, 25);
        lblNumar.setBounds(0, 240, 100, 25);
        tfldNumar.setBounds(0, 260, 486, 25);
        lblAdresa.setBounds(0, 285, 100, 25);
        btnComanda.setBounds(250, 375, 375, 70);
        comboBoxIdAdresa.setBounds(0, 305, 900, 25);
        btnBack.setBounds(0, 0, 50, 25);


        //actions
        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new AdresaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnComanda.addActionListener(e -> {
            try {
                if(listaPersoane.getModel().getSize() == 0)
                {
                    MainPanel.infoBox("Trebuie sa va adaugati datele personale.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new ComandaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        comboBoxIdAdresa.setSelectedItem(null);
        comboBoxIdAdresa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedObj = comboBoxIdAdresa.getSelectedItem();
                if (selectedObj instanceof Adresa) {
                    adresaSelectata = (Adresa) selectedObj;
                }
            }
        });


        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboBoxIdAdresa.getSelectedItem() == null) {
                        MainPanel.infoBox("Nicio adresa selectata.", "Error");
                        return;
                    }

                    if (tfldNume.getText().isEmpty() || tfldPrenume.getText().isEmpty() ||
                            tfldNumar.getText().isEmpty() || tfldEmail.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }
                    DBUtils.AdaugaPersoana(new Persoana(tfldNume.getText(), tfldPrenume.getText(), adresaSelectata.getId_adresa(), tfldEmail.getText(),
                            tfldNumar.getText()));
                    listaPersoane.setListData(DBUtils.GetPersoane());
                    tfldNume.setText("");
                    tfldPrenume.setText("");
                    tfldEmail.setText("");
                    tfldNumar.setText("");
                    comboBoxIdAdresa.setSelectedItem(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        listaPersoane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();
                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof Persoana) {
                        Persoana persoanaSelectataLista = (Persoana) selectedObj;
                        System.out.println(persoanaSelectataLista.getId_persoana());
                        try {
                            UpdateDeletePersoana udprs = new UpdateDeletePersoana(persoanaSelectataLista.getId_persoana());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }
}