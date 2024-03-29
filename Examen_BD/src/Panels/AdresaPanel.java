package Panels;

import DataBase.DBUtils;
import Main.Main;
import Models.Adresa;
import UpdateDelete.UpdateDeleteAdresa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AdresaPanel extends JPanel{

    private JList listaAdrese;
    private JButton btnAdaugare;
    private JButton btnDatePersonale;
    private JLabel lblJudet;
    private JTextField tfldJudet;
    private JLabel lblLocalitate;
    private JTextField tfldLocalitate;
    private JLabel lblStrada;
    private JTextField tfldStrada;
    private JLabel lblNumar;
    private JTextField tfldNumar;
    private JLabel lblBloc;
    private JTextField tfldBloc;
    private JLabel lblScara;
    private JTextField tfldScara;
    private JLabel lblApartament;
    private JTextField tfldApartament;
    private JButton btnBack;

    public AdresaPanel () throws SQLException {
        //construct components
        listaAdrese = new JList (DBUtils.GetAdrese());


        lblJudet = new JLabel ("Judet:");
        tfldJudet = new JTextField (1);
        lblLocalitate = new JLabel ("Localitate:");
        tfldLocalitate = new JTextField (1);
        lblStrada = new JLabel ("Strada:");
        tfldStrada = new JTextField (1);
        lblNumar = new JLabel ("Numar:");
        tfldNumar = new JTextField (1);
        lblBloc = new JLabel ("Bloc:");
        tfldBloc = new JTextField (1);
        lblScara = new JLabel ("Scara:");
        tfldScara = new JTextField (1);
        lblApartament = new JLabel ("Apartament:");
        tfldApartament = new JTextField (1);
        btnAdaugare = new JButton ("Adaugare");
        btnBack = new JButton ("<<");
        btnDatePersonale = new JButton("Completeaza date personale");

        //adjust size and set layout
        setPreferredSize (new Dimension(938, 568));
        setLayout (null);

        //add components
        add (listaAdrese);
        add (btnAdaugare);
        add (lblJudet);
        add (tfldJudet);
        add (lblLocalitate);
        add (tfldLocalitate);
        add (lblStrada);
        add (tfldStrada);
        add (lblNumar);
        add (tfldNumar);
        add (lblBloc);
        add (tfldBloc);
        add (lblScara);
        add (tfldScara);
        add (lblApartament);
        add (tfldApartament);
        add (btnBack);
        add (btnDatePersonale);

        //set component bounds (only needed by Absolute Positioning)
        listaAdrese.setBounds (240, 0, 700, 574);
        btnAdaugare.setBounds (55, 390, 100, 25);
        lblJudet.setBounds (10, 55, 100, 25);
        tfldJudet.setBounds (10, 75, 200, 25);
        lblLocalitate.setBounds (10, 100, 100, 25);
        tfldLocalitate.setBounds (10, 120, 200, 25);
        lblStrada.setBounds (10, 145, 100, 25);
        tfldStrada.setBounds (10, 165, 200, 25);
        lblNumar.setBounds (10, 190, 100, 25);
        tfldNumar.setBounds (10, 210, 200, 25);
        lblBloc.setBounds (10, 235, 100, 25);
        tfldBloc.setBounds (10, 255, 200, 25);
        lblScara.setBounds (10, 280, 100, 25);
        tfldScara.setBounds (10, 300, 200, 25);
        lblApartament.setBounds (10, 325, 100, 25);
        tfldApartament.setBounds (10, 345, 200, 25);
        btnBack.setBounds (10, 0, 50, 25);
        btnDatePersonale.setBounds (10, 450, 200, 70);

        //actions
        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new MainPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnDatePersonale.addActionListener(e -> {
            try {
                if(listaAdrese.getModel().getSize() == 0)
                {
                    MainPanel.infoBox("Trebuie sa va adaugati adresa de livrare.", "Error");
                    return;
                }
                Main.changeCurrentPanel(new PersoanaPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        btnAdaugare.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //VERIFICARE TEXTFIELDS
                    if (tfldJudet.getText().isEmpty() || tfldJudet.getText().isEmpty() ||
                            tfldLocalitate.getText().isEmpty() || tfldStrada.getText().isEmpty()
                            || tfldNumar.getText().isEmpty() || tfldBloc.getText().isEmpty() || tfldScara.getText().isEmpty()
                            || tfldApartament.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }

                    //ADAUGARE ADRESA
                    DBUtils.AdaugaAdresa(new Adresa(tfldJudet.getText(), tfldLocalitate.getText(), tfldStrada.getText(),
                            Integer.parseInt(tfldNumar.getText()),Integer.parseInt(tfldBloc.getText()) ,
                            tfldScara.getText(), Integer.parseInt(tfldApartament.getText())));
                    listaAdrese.setListData(DBUtils.GetAdrese());
                    tfldJudet.setText("");
                    tfldLocalitate.setText("");
                    tfldStrada.setText("");
                    tfldNumar.setText("");
                    tfldBloc.setText("");
                    tfldScara.setText("");
                    tfldApartament.setText("");
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        listaAdrese.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    JList list = (JList) e.getSource();
                    Object selectedObj = list.getSelectedValue();
                    if (selectedObj instanceof Adresa) {
                        Adresa adresaSelectata = (Adresa) selectedObj;
                        System.out.println(adresaSelectata.getId_adresa());
                        try {
                            UpdateDeleteAdresa uda = new UpdateDeleteAdresa(adresaSelectata.getId_adresa());
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        });


    }
}