package UpdateDelete;
import javax.swing.*;

public class UpdateDeleteProdus extends  JFrame{
    private JLabel lblNumeProdus;
    private JTextField tfldNumeProdus;
    private JLabel lblPret;
    private JTextField tfldPret;
    private JLabel lblStoc;
    private JTextField tfldStoc;
    private JLabel lblSpecificatii;
    private JTextField tfldSpecificatii;
    private JButton modify;
    private JButton delete;

    public static JFrame frame_update_delete_produs;

    public UpdateDeleteProdus ()
    {
        frame_update_delete_produs = new JFrame("Adrese");
        frame_update_delete_produs.setSize(568, 568);
        frame_update_delete_produs.setLocationRelativeTo(null);
        frame_update_delete_produs.setVisible(true);
        frame_update_delete_produs.setLayout(null);

        lblNumeProdus = new JLabel ("Judet:");
        tfldNumeProdus = new JTextField (1);
        lblPret = new JLabel ("Localitate:");
        tfldPret = new JTextField (1);
        lblStoc = new JLabel ("Strada:");
        tfldStoc = new JTextField (1);
        lblSpecificatii = new JLabel ("Numar:");
        tfldSpecificatii = new JTextField (1);
        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        lblNumeProdus.setBounds (184, 55, 100, 25);
        tfldNumeProdus.setBounds (184, 75, 200, 25);
        lblPret.setBounds (184, 100, 100, 25);
        tfldPret.setBounds (184, 120, 200, 25);
        lblStoc.setBounds (184, 145, 100, 25);
        tfldStoc.setBounds (184, 165, 200, 25);
        lblSpecificatii.setBounds (184, 190, 100, 25);
        tfldSpecificatii.setBounds (184, 210, 200, 25);
        modify.setBounds(50,400,100,60);
        delete.setBounds(418,400,100,60);

        frame_update_delete_produs.add (lblNumeProdus);
        frame_update_delete_produs.add (tfldNumeProdus);
        frame_update_delete_produs.add (lblPret);
        frame_update_delete_produs.add (tfldPret);
        frame_update_delete_produs.add (lblStoc);
        frame_update_delete_produs.add (tfldStoc);
        frame_update_delete_produs.add (lblSpecificatii);
        frame_update_delete_produs.add (tfldSpecificatii);
        frame_update_delete_produs.add (modify);
        frame_update_delete_produs.add (delete);

    }
}