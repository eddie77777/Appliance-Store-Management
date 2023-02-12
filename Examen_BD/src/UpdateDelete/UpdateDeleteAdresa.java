package UpdateDelete;

import javax.swing.*;
import java.awt.*;

public class UpdateDeleteAdresa extends  JFrame{
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
    private JButton modify;
    private JButton delete;

    public static JFrame frame_update_delete_adresa;

    public UpdateDeleteAdresa ()
    {

        frame_update_delete_adresa = new JFrame("Adrese");
        frame_update_delete_adresa.setSize(938, 568);
        frame_update_delete_adresa.setLocationRelativeTo(null);
        frame_update_delete_adresa.setVisible(true);

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
        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        frame_update_delete_adresa.add (lblJudet);
        frame_update_delete_adresa.add (tfldJudet);
        frame_update_delete_adresa.add (lblLocalitate);
        frame_update_delete_adresa.add (tfldLocalitate);
        frame_update_delete_adresa.add (lblStrada);
        frame_update_delete_adresa.add(tfldStrada);
        frame_update_delete_adresa.add (lblNumar);
        frame_update_delete_adresa.add (tfldNumar);
        frame_update_delete_adresa.add (lblBloc);
        frame_update_delete_adresa.add (tfldBloc);
        frame_update_delete_adresa.add (lblScara);
        frame_update_delete_adresa.add (tfldScara);
        frame_update_delete_adresa.add (lblApartament);
        frame_update_delete_adresa.add (tfldApartament);
        frame_update_delete_adresa.add (modify);
        frame_update_delete_adresa.add (delete);

        lblJudet.setBounds (100, 55, 100, 25);
        tfldJudet.setBounds (100, 75, 200, 25);
        lblLocalitate.setBounds (100, 100, 100, 25);
        tfldLocalitate.setBounds (100, 120, 200, 25);
        lblStrada.setBounds (100, 145, 100, 25);
        tfldStrada.setBounds (100, 165, 200, 25);
        lblNumar.setBounds (100, 190, 100, 25);
        tfldNumar.setBounds (100, 210, 200, 25);
        lblBloc.setBounds (100, 235, 100, 25);
        tfldBloc.setBounds (100, 255, 200, 25);
        lblScara.setBounds (100, 280, 100, 25);
        tfldScara.setBounds (100, 300, 200, 25);
        lblApartament.setBounds (100, 325, 100, 25);
        tfldApartament.setBounds (100, 345, 200, 25);
        modify.setBounds(50,500,100,60);
        delete.setBounds(750,500,100,60);

    }
}