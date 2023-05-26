package Panels;

import DataBase.DBUtils;
import Main.Main;
import Models.Adresa;
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
    private JLabel lblNume;
    private JTextField tfldNume;
    private JLabel lblPrenume;
    private JTextField tfldPrenume;
    private JLabel lblEmail;
    private JTextField tfldEmail;
    private JLabel lblNumar;
    private JTextField tfldNumar;
    private JButton btnBack;

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
        lblNumar = new JLabel("Numar:");
        tfldNumar = new JTextField(1);
        btnAdaugare = new JButton("Adaugare");
        btnBack = new JButton("<<");
        Vector<Adresa> adrese = DBUtils.GetAdrese();
        comboBoxIdAdresa = new JComboBox(adrese);
        //adjust size and set layout
        setPreferredSize(new Dimension(938, 568));
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
        add(comboBoxIdAdresa);
        add(btnBack);

        //set component bounds (only needed by Absolute Positioning)
        listaPersoane.setBounds(490, 0, 460, 574);
        btnAdaugare.setBounds(65, 405, 100, 25);
        lblNume.setBounds(0, 55, 100, 25);
        tfldNume.setBounds(0, 75, 486, 25);
        lblPrenume.setBounds(0, 100, 100, 25);
        tfldPrenume.setBounds(0, 120, 486, 25);
        lblEmail.setBounds(0, 145, 100, 25);
        tfldEmail.setBounds(0, 165, 486, 25);
        lblNumar.setBounds(0, 190, 100, 25);
        tfldNumar.setBounds(0, 210, 486, 25);
        comboBoxIdAdresa.setBounds(0, 235, 486, 25);
        btnBack.setBounds(0, 0, 50, 25);


        //actions
        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new MainPanel());

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
                    if(comboBoxIdAdresa.getSelectedItem()==null)
                    {
                        MainPanel.infoBox("Nicio adresa selectata.", "Error");
                        return;
                    }
                    DBUtils.AdaugaPersoana(new Persoana(tfldNume.getText(), tfldPrenume.getText(), adresaSelectata.getId_adresa() ,tfldEmail.getText(),
                            tfldNumar.getText()));
                    listaPersoane.setListData(DBUtils.GetPersoane());
                    tfldNume.setText("");
                    tfldPrenume.setText("");
                    tfldEmail.setText("");
                    tfldNumar.setText("");
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
                        UpdateDeletePersoana udprs = new UpdateDeletePersoana(persoanaSelectataLista.getId_persoana());
                    }
                }
            }
        });
    }
}