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
        frame_update_delete_adresa.setSize(568, 568);
        frame_update_delete_adresa.setLocationRelativeTo(null);
        frame_update_delete_adresa.setVisible(true);
        frame_update_delete_adresa.setLayout(null);

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

        lblJudet.setBounds (184, 55, 100, 25);
        tfldJudet.setBounds (184, 75, 200, 25);
        lblLocalitate.setBounds (184, 100, 100, 25);
        tfldLocalitate.setBounds (184, 120, 200, 25);
        lblStrada.setBounds (184, 145, 100, 25);
        tfldStrada.setBounds (184, 165, 200, 25);
        lblNumar.setBounds (184, 190, 100, 25);
        tfldNumar.setBounds (184, 210, 200, 25);
        lblBloc.setBounds (184, 235, 100, 25);
        tfldBloc.setBounds (184, 255, 200, 25);
        lblScara.setBounds (184, 280, 100, 25);
        tfldScara.setBounds (184, 300, 200, 25);
        lblApartament.setBounds (184, 325, 100, 25);
        tfldApartament.setBounds (184, 345, 200, 25);
        modify.setBounds(50,400,100,60);
        delete.setBounds(418,400,100,60);

        frame_update_delete_adresa.add (lblJudet);
        frame_update_delete_adresa.add (tfldJudet);
        frame_update_delete_adresa.add (lblLocalitate);
        frame_update_delete_adresa.add (tfldLocalitate);
        frame_update_delete_adresa.add (lblStrada);
        frame_update_delete_adresa.add (tfldStrada);
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



    }
}