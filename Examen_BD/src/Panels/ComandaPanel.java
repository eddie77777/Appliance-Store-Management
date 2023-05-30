package Panels;

import DataBase.DBUtils;
import Main.Main;
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




public class ComandaPanel extends JPanel{

    private JList listaPersoane;
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
    private JButton btnBack;

    private JComboBox comboBoxIdPersoane;

    private JComboBox comboBoxIdCOmanda;

    Persoana persoanaSelectata;
    Comanda comandaSelectata;



    public ComandaPanel() throws SQLException {
        //construct components
        listaPersoane = new JList(DBUtils.GetPersoane());


        lblDataPlasare = new JLabel("Data Plasare: YYYY-MM-DD");
        tfldDataPlasare = new JTextField(1);
        lblDataLivrare = new JLabel("Data Livrare: YYYY-MM-DD");
        tfldDataLivrare = new JTextField(1);
        lblCostLivrare = new JLabel("Cost Livrare:");
        tfldCostLivrare = new JTextField(1);
        lblPretTotal = new JLabel("Pret total :");
        tfldPretTotal = new JTextField(1);
        btnAdaugare = new JButton("Adaugare");
        btnBack = new JButton("<<");
        Vector<Comanda> comenzi = new Vector<>();
        Vector<Persoana> persoane = DBUtils.GetPersoane();
        comboBoxIdCOmanda = new JComboBox(comenzi);
        comboBoxIdPersoane = new JComboBox(persoane);
        //adjust size and set layout
        setPreferredSize(new Dimension(938, 568));
        setLayout(null);

        //add components
        add(listaPersoane);
        add(btnAdaugare);
        add(lblDataPlasare);
        add(tfldDataPlasare);
        add(lblDataLivrare);
        add(tfldDataLivrare);
        add(lblCostLivrare);
        add(tfldCostLivrare);
        add(lblPretTotal);
        add(tfldPretTotal);
        add(comboBoxIdPersoane);
        add(comboBoxIdCOmanda);
        add(btnBack);

        //set component bounds (only needed by Absolute Positioning)
        listaPersoane.setBounds(490, 0, 460, 574);
        btnAdaugare.setBounds(65, 405, 100, 25);
        lblDataPlasare.setBounds(0, 55, 100, 25);
        tfldDataPlasare.setBounds(0, 75, 486, 25);
        lblDataLivrare.setBounds(0, 100, 100, 25);
        tfldDataLivrare.setBounds(0, 120, 486, 25);
        lblCostLivrare.setBounds(0, 145, 100, 25);
        tfldCostLivrare.setBounds(0, 165, 486, 25);
        lblPretTotal.setBounds(0, 190, 100, 25);
        tfldPretTotal.setBounds(0, 210, 486, 25);
        comboBoxIdPersoane.setBounds(0, 235, 486, 25);
        comboBoxIdPersoane.setBounds(0, 270, 486, 25);
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


        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(comboBoxIdPersoane.getSelectedItem()==null)
                    {
                        MainPanel.infoBox("Nicio persoana selectata.", "Error");
                        return;
                    }
                    DBUtils.AdaugaPersoana(new Persoana(tfldDataPlasare.getText(), tfldDataLivrare.getText(), persoanaSelectata.getId_adresa() ,tfldCostLivrare.getText(),
                            tfldPretTotal.getText()));
                    listaPersoane.setListData(DBUtils.GetPersoane());
                    tfldDataPlasare.setText("");
                    tfldDataLivrare.setText("");
                    tfldCostLivrare.setText("");
                    tfldPretTotal.setText("");
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
