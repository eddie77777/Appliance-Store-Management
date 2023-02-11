import java.awt.*;
import javax.swing.*;

public class MainPanel extends JPanel {
    ImageIcon img;
    JLabel background;
    private JButton btnPersoana;
    private JButton btnProdus;

    public  MainPanel ()
    {
        img = new ImageIcon(getClass().getResource("bg.jpg"));
        background = new JLabel("", img, JLabel.CENTER);
        background.setLayout(new FlowLayout());
        background.setVisible(true);


        btnPersoana = new JButton ("Persoana");
        btnProdus = new JButton ("Produs");

        //adjust size and set layout
        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        //set component bounds (only needed by Absolute Positioning)
        btnPersoana.setBounds (560, 380, 300, 100);
        btnProdus.setBounds (560, 90, 300, 100);
        background.setBounds(0, 0, 944, 574);

        //add components
        add (btnPersoana);
        add (btnProdus);
        add (background);
    }
}
