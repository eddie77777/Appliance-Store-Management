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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;




public class ComandaPanel extends JPanel{

    private JList listaComenzi;
    //YYYY-MM-DD
    private JButton btnAdaugare;
    private JButton btnComandaProdus;
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
    private JLabel lblIdPersoane;
    private JComboBox comboBoxIdPersoane;
    private JLabel lblIdAdresa;

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
        btnComandaProdus = new JButton("Alege produs");
        Vector<Adresa> adrese = DBUtils.GetAdrese();
        Vector<Persoana> persoane = DBUtils.GetPersoane();
        lblIdPersoane = new JLabel("Persoana");
        comboBoxIdAdresa = new JComboBox(adrese);
        lblIdAdresa = new JLabel("Adresa");
        comboBoxIdPersoane = new JComboBox(persoane);
        //adjust size and set layout
        setPreferredSize(new Dimension(1500, 568));
        setSize(1500, 568);
        setLayout(null);

        //add components
        add(listaComenzi);
        add(btnAdaugare);
        add(btnComandaProdus);
        add(lblDataPlasare);
        add(tfldDataPlasare);
        add(lblDataLivrare);
        add(tfldDataLivrare);
       /* add(lblCostLivrare);
        add(tfldCostLivrare);
        add(lblPretTotal);
        add(tfldPretTotal);*/
        add(lblMetodaPlata);
        add(tfldMetodaPlata);
        add(lblEsteLivrata);
        add(tfldEsteLivrata);
        add(comboBoxIdPersoane);
        add(comboBoxIdAdresa);
        add(lblIdPersoane);
        add(lblIdAdresa);
        add(btnBack);

        //set component bounds (only needed by Absolute Positioning)
        listaComenzi.setBounds(275, 0, 1000, 375);
        btnAdaugare.setBounds(65, 510, 100, 25);
        btnComandaProdus.setBounds(430, 490, 200, 70);
        lblDataPlasare.setBounds(0, 75, 200, 25);
        tfldDataPlasare.setBounds(0, 95, 250, 25);
        lblDataLivrare.setBounds(0, 120, 200, 25);
        tfldDataLivrare.setBounds(0, 140, 250, 25);
        lblCostLivrare.setBounds(0, 165, 100, 25);
        tfldCostLivrare.setBounds(0, 185, 250, 25);
        lblPretTotal.setBounds(0, 210, 100, 25);
        tfldPretTotal.setBounds(0, 230, 250, 25);
        lblMetodaPlata.setBounds(0, 165, 100, 25);
        tfldMetodaPlata.setBounds(0, 185, 250, 25);
        lblEsteLivrata.setBounds(0, 210, 100, 25);
        tfldEsteLivrata.setBounds(0, 230, 250, 25);
        lblIdPersoane.setBounds(0, 385, 100, 25);
        comboBoxIdPersoane.setBounds(0, 405, 900, 25);
        lblIdAdresa.setBounds(0, 430, 100, 25);
        comboBoxIdAdresa.setBounds(0, 450, 900, 25);
        btnBack.setBounds(0, 0, 50, 25);


        //actions
        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new PersoanaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnComandaProdus.addActionListener(e -> {
            try {
                if(listaComenzi.getModel().getSize() == 0)
                {
                    MainPanel.infoBox("Trebuie sa adaugati o comanda.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new ComandaProdusPanel());

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

                    //VERIFICARE COMBOBOX
                    if(comboBoxIdPersoane.getSelectedItem()==null || comboBoxIdAdresa.getSelectedItem()==null)
                    {
                        MainPanel.infoBox("Nicio persoana selectata sau comanda selectata", "Error");
                        return;
                    }

                    //VERIFICARE DATE
                    String dataPlasareText = tfldDataPlasare.getText();
                    String dataLivrareText = tfldDataLivrare.getText();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date dataPlasare = null;
                    java.util.Date dataLivrare = null;

                    try {
                        dataPlasare = dateFormat.parse(dataPlasareText);
                        dataLivrare = dateFormat.parse(dataLivrareText);
                    } catch (ParseException ex) {
                        MainPanel.infoBox("Data plasare sau data livrare in format nevalid", "Error");
                        return;
                    }

                    //VERIFICARE TEXTFIELDS
                    if (tfldCostLivrare.getText().isEmpty() || tfldPretTotal.getText().isEmpty() ||
                            tfldEsteLivrata.getText().isEmpty() || tfldMetodaPlata.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }


                    //CREARE NOUA COMANDA SI ADAUGARE IN BAZA DE DATE
                    DBUtils.AdaugaComanda(
                            new Comanda(persoanaSelectata.getId_persoana(), 
                                    adresaSelectata.getId_adresa(), 
                                    Date.valueOf(tfldDataPlasare.getText()), 
                                    Date.valueOf(tfldDataLivrare.getText()), 
                                    1,
                                    1,
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
