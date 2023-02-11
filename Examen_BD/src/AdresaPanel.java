import javax.swing.*;
import java.awt.*;

public class AdresaPanel extends JPanel{

    private JList listAdrese;
    private JButton btnAdaugare;
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

    public AdresaPanel ()
    {
        //construct preComponents
        String[] component1Items = {"Item 1", "Item 2", "Item 3"};

        //construct components
        listAdrese = new JList (component1Items);
        btnAdaugare = new JButton ("Adaugare");
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
        btnBack = new JButton ("<<");

        //adjust size and set layout
        setPreferredSize (new Dimension(938, 568));
        setLayout (null);

        //add components
        add (listAdrese);
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

        //set component bounds (only needed by Absolute Positioning)
        listAdrese.setBounds (240, 0, 700, 574);
        btnAdaugare.setBounds (65, 405, 100, 25);
        lblJudet.setBounds (0, 55, 100, 25);
        tfldJudet.setBounds (0, 75, 200, 25);
        lblLocalitate.setBounds (0, 100, 100, 25);
        tfldLocalitate.setBounds (0, 120, 200, 25);
        lblStrada.setBounds (0, 145, 100, 25);
        tfldStrada.setBounds (0, 165, 200, 25);
        lblNumar.setBounds (0, 190, 100, 25);
        tfldNumar.setBounds (0, 210, 200, 25);
        lblBloc.setBounds (0, 235, 100, 25);
        tfldBloc.setBounds (0, 255, 200, 25);
        lblScara.setBounds (0, 280, 100, 25);
        tfldScara.setBounds (0, 300, 200, 25);
        lblApartament.setBounds (0, 325, 100, 25);
        tfldApartament.setBounds (0, 345, 200, 25);
        btnBack.setBounds (0, 0, 50, 25);

        //actions
        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new MainPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        listAdrese.addListSelectionListener(e->{
            try {
                Main.changeCurrentPanel(new MainPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });


    }
}
