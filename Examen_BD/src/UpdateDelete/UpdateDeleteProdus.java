package UpdateDelete;

import DataBase.DBUtils;
import Main.Main;
import Models.Produs;
import Panels.AdresaPanel;
import Panels.MainPanel;
import Panels.ProdusPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateDeleteProdus extends JFrame {
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

    public UpdateDeleteProdus(int id_produs) throws SQLException {

        frame_update_delete_produs = new JFrame("Edit produs");
        frame_update_delete_produs.setSize(568, 568);
        frame_update_delete_produs.setLocationRelativeTo(null);
        frame_update_delete_produs.setVisible(true);
        frame_update_delete_produs.setLayout(null);

        Produs prd = DBUtils.GetProdusForUpdateDelete(id_produs);

        lblNumeProdus = new JLabel("Nume produs:");
        tfldNumeProdus = new JTextField(1);
        tfldNumeProdus.setText(prd.getNume_produs());
        lblPret = new JLabel("Pret:");
        tfldPret = new JTextField(1);
        tfldPret.setText(String.valueOf(prd.getPret()));
        lblStoc = new JLabel("Stoc:");
        tfldStoc = new JTextField(1);
        tfldStoc.setText(String.valueOf(prd.getStoc()));
        lblSpecificatii = new JLabel("Specificatii:");
        tfldSpecificatii = new JTextField(1);
        tfldSpecificatii.setText(String.valueOf(prd.getSpecificatii()));
        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        lblNumeProdus.setBounds(184, 55, 100, 25);
        tfldNumeProdus.setBounds(184, 75, 200, 25);
        lblPret.setBounds(184, 100, 100, 25);
        tfldPret.setBounds(184, 120, 200, 25);
        lblStoc.setBounds(184, 145, 100, 25);
        tfldStoc.setBounds(184, 165, 200, 25);
        lblSpecificatii.setBounds(184, 190, 100, 25);
        tfldSpecificatii.setBounds(184, 210, 200, 25);
        modify.setBounds(50, 400, 100, 60);
        delete.setBounds(418, 400, 100, 60);

        frame_update_delete_produs.add(lblNumeProdus);
        frame_update_delete_produs.add(tfldNumeProdus);
        frame_update_delete_produs.add(lblPret);
        frame_update_delete_produs.add(tfldPret);
        frame_update_delete_produs.add(lblStoc);
        frame_update_delete_produs.add(tfldStoc);
        frame_update_delete_produs.add(lblSpecificatii);
        frame_update_delete_produs.add(tfldSpecificatii);
        frame_update_delete_produs.add(modify);
        frame_update_delete_produs.add(delete);

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (tfldNumeProdus.getText().isEmpty() || tfldNumeProdus.getText().isEmpty() ||
                            tfldPret.getText().isEmpty() || tfldStoc.getText().isEmpty()
                            || tfldSpecificatii.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }

                    prd.setId_produs(id_produs);
                    prd.setNume_produs(tfldNumeProdus.getText());
                    prd.setPret(Float.valueOf(tfldPret.getText()));
                    prd.setStoc(Integer.valueOf(tfldStoc.getText()));
                    prd.setSpecificatii(tfldSpecificatii.getText());
                    DBUtils.UpdateProdus(prd);
                    Main.changeCurrentPanel(new ProdusPanel());
                    frame_update_delete_produs.setVisible(false);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBUtils.DeleteProdus(id_produs);
                    Main.changeCurrentPanel(new ProdusPanel());
                    frame_update_delete_produs.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}