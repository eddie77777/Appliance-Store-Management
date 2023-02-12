import javax.swing.*;
import java.awt.*;
public class ProdusPanel extends JPanel {
    private JList listProduse;
    private JButton btnAdaugare;
    private JLabel lblNumeProdus;
    private JTextField tfldNumeProdus;
    private JLabel lblPret;
    private JTextField tfldPret;
    private JLabel lblStoc;
    private JTextField tfldStoc;
    private JLabel lblSpecificatii;
    private JTextField tfldSpecificatii;

    private JButton btnBack;

    public ProdusPanel() {


        //construct preComponents
        String[] component1Items = {"Item 1", "Item 2", "Item 3"};

        //construct components
        listProduse = new JList(component1Items);
        btnAdaugare = new JButton("Adaugare");
        lblNumeProdus = new JLabel("Nume produs:");
        tfldNumeProdus = new JTextField(1);
        lblPret = new JLabel("Pret:");
        tfldPret = new JTextField(1);
        lblStoc = new JLabel("Stoc:");
        tfldStoc = new JTextField(1);
        lblSpecificatii = new JLabel("Specificatii:");
        tfldSpecificatii = new JTextField(1);
        btnBack = new JButton("<<");

        //adjust size and set layout
        setPreferredSize(new Dimension(938, 568));
        setLayout(null);

        //add components
        add(listProduse);
        add(btnAdaugare);
        add(lblNumeProdus);
        add(tfldNumeProdus);
        add(lblPret);
        add(tfldPret);
        add(lblStoc);
        add(tfldStoc);
        add(lblSpecificatii);
        add(tfldSpecificatii);
        add(btnBack);

        //set component bounds (only needed by Absolute Positioning)
        listProduse.setBounds(240, 0, 700, 574);
        btnAdaugare.setBounds(65, 405, 100, 25);
        lblNumeProdus.setBounds(0, 55, 100, 25);
        tfldNumeProdus.setBounds(0, 75, 200, 25);
        lblPret.setBounds(0, 100, 100, 25);
        tfldPret.setBounds(0, 120, 200, 25);
        lblStoc.setBounds(0, 145, 100, 25);
        tfldStoc.setBounds(0, 165, 200, 25);
        lblSpecificatii.setBounds(0, 190, 100, 25);
        tfldSpecificatii.setBounds(0, 210, 200, 25);
        btnBack.setBounds(0, 0, 50, 25);

        //actions
        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new MainPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        listProduse.addListSelectionListener(e -> {
            try {
                Main.changeCurrentPanel(new MainPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
