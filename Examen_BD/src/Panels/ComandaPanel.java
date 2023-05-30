package Panels;

import DataBase.DBUtils;
import Main.Main;
import Models.Adresa;
import Models.Comanda;
import Models.Persoana;
import Models.Produs;
import UpdateDelete.UpdateDeleteAdresa;
import UpdateDelete.UpdateDeletePersoana;
import UpdateDelete.UpdateDeleteComanda;
import com.sun.nio.sctp.MessageInfo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Vector;




public class ComandaPanel extends JPanel{

    private JList listaComenzi;
    //YYYY-MM-DD
    private JButton btnAdaugare;
    private JLabel lblDataPlasare;
    private JTextField tfldDataPlasare;
    private JLabel lblDataLivrare;
    private JTextField tfldDataLivrare;
    private JLabel lblCostLivrare;
    private JTextField tfldCostLivrare;
    private JLabel lblPretTotal;
    private JTextField tfldPretTotal;
    private JLabel lblMetodaPlata;
    private JTextField tfldMetodaPlata;
    private JLabel lblEsteLivrata;
    private JTextField tfldEsteLivrata;
    private JButton btnBack;

    private JComboBox comboBoxIdPersoane;

    private JComboBox comboBoxIdAdresa;

    Persoana persoanaSelectata;
    Adresa adresaSelectata;



    public ComandaPanel() throws SQLException {
        //construct components
        listaComenzi = new JList(DBUtils.GetComenzi());


        lblDataPlasare = new JLabel("Data Plasare(YYYY-MM-DD):");
        tfldDataPlasare = new JTextField(1);
        lblDataLivrare = new JLabel("Data Livrare(YYYY-MM-DD):");
        tfldDataLivrare = new JTextField(1);
        lblCostLivrare = new JLabel("Cost Livrare:");
        tfldCostLivrare = new JTextField(1);
        lblPretTotal = new JLabel("Pret total :");
        tfldPretTotal = new JTextField(1);
        lblMetodaPlata = new JLabel("Metoda Plata:");
        tfldMetodaPlata = new JTextField(1);
        lblEsteLivrata = new JLabel("Este Livrata:");
        tfldEsteLivrata = new JTextField(1);
        btnAdaugare = new JButton("Adaugare");
        btnBack = new JButton("<<");
        Vector<Adresa> adrese = DBUtils.GetAdrese();
        Vector<Persoana> persoane = DBUtils.GetPersoane();
        comboBoxIdAdresa = new JComboBox(adrese);
        comboBoxIdPersoane = new JComboBox(persoane);
        //adjust size and set layout
        setPreferredSize(new Dimension(1500, 568));
        setLayout(null);

        //add components
        add(listaComenzi);
        add(btnAdaugare);
        add(lblDataPlasare);
        add(tfldDataPlasare);
        add(lblDataLivrare);
        add(tfldDataLivrare);
        add(lblCostLivrare);
        add(tfldCostLivrare);
        add(lblPretTotal);
        add(tfldPretTotal);
        add(lblMetodaPlata);
        add(tfldMetodaPlata);
        add(lblEsteLivrata);
        add(tfldEsteLivrata);
        add(comboBoxIdPersoane);
        add(comboBoxIdAdresa);
        add(btnBack);

        //set component bounds (only needed by Absolute Positioning)
        listaComenzi.setBounds(490, 0, 1000, 574);
        btnAdaugare.setBounds(65, 405, 100, 25);
        lblDataPlasare.setBounds(0, 55, 200, 25);
        tfldDataPlasare.setBounds(0, 75, 486, 25);
        lblDataLivrare.setBounds(0, 100, 200, 25);
        tfldDataLivrare.setBounds(0, 120, 486, 25);
        lblCostLivrare.setBounds(0, 145, 100, 25);
        tfldCostLivrare.setBounds(0, 165, 486, 25);
        lblPretTotal.setBounds(0, 190, 100, 25);
        tfldPretTotal.setBounds(0, 210, 486, 25);
        lblMetodaPlata.setBounds(0, 235, 100, 25);
        tfldMetodaPlata.setBounds(0, 255, 486, 25);
        lblEsteLivrata.setBounds(0, 280, 100, 25);
        tfldEsteLivrata.setBounds(0, 300, 486, 25);
        comboBoxIdPersoane.setBounds(0, 330, 486, 25);
        comboBoxIdAdresa.setBounds(0, 370, 486, 25);
        btnBack.setBounds(0, 0, 50, 25);


        //actions
        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new MainPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        comboBoxIdPersoane.setSelectedItem(null);
        comboBoxIdPersoane.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedObj = comboBoxIdPersoane.getSelectedItem();
                if (selectedObj instanceof Persoana) {
                    persoanaSelectata = (Persoana) selectedObj;
                }
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
                    if(comboBoxIdPersoane.getSelectedItem()==null || comboBoxIdAdresa.getSelectedItem()==null)
                    {
                        MainPanel.infoBox("Nicio persoana selectata sau comanda selectata", "Error");
                        return;
                    }
                    DBUtils.AdaugaComanda(
                            new Comanda(persoanaSelectata.getId_persoana(), 
                                    adresaSelectata.getId_adresa(), 
                                    Date.valueOf(tfldDataPlasare.getText()), 
                                    Date.valueOf(tfldDataLivrare.getText()), 
                                    Float.parseFloat(tfldCostLivrare.getText()),
                                    Float.parseFloat(tfldPretTotal.getText()),
                                    tfldMetodaPlata.getText(),
                                    Boolean.valueOf(tfldEsteLivrata.getText())));
                    listaComenzi.setListData(DBUtils.GetComenzi());
                    tfldDataPlasare.setText("");
                    tfldDataLivrare.setText("");
                    tfldCostLivrare.setText("");
                    tfldPretTotal.setText("");
                    tfldMetodaPlata.setText("");
                    tfldEsteLivrata.setText("");
                    comboBoxIdAdresa.setSelectedItem(null);
                    comboBoxIdPersoane.setSelectedItem(null);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        listaComenzi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();
                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof Comanda) {
                        Comanda comandaSelectataLista = (Comanda) selectedObj;
                        System.out.println(comandaSelectataLista.getId_comanda());
                        try {
                            UpdateDeleteComanda udprs = new UpdateDeleteComanda(comandaSelectataLista.getId_comanda());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });
    }
}
