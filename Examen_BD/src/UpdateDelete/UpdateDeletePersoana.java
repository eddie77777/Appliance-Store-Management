package UpdateDelete;

import DataBase.DBUtils;
import Main.Main;
import Models.Persoana;
import Models.Adresa;
import Panels.MainPanel;
import Panels.PersoanaPanel;
import Panels.ProdusPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class UpdateDeletePersoana extends JFrame {
    private JLabel lblNume;
    private JTextField tfldNume;
    private JLabel lblPrenume;
    private JTextField tfldPrenume;
    private JLabel lblEmail;
    private JTextField tfldEmail;
    private JLabel lblNr_tel;
    private JTextField tfldNr_tel;
    private JComboBox comboBoxIdAdresa;
    private JButton modify;
    private JButton delete;

    public static JFrame frame_update_delete_produs;

    public UpdateDeletePersoana(int id_persoana) throws SQLException {

        frame_update_delete_produs = new JFrame("Edit persoana");
        frame_update_delete_produs.setSize(568, 568);
        frame_update_delete_produs.setLocationRelativeTo(null);
        frame_update_delete_produs.setVisible(true);
        frame_update_delete_produs.setLayout(null);

        Persoana prs = DBUtils.GetPersoanaForUpdateDelete(id_persoana);

        lblNume = new JLabel("Nume:");
        tfldNume = new JTextField(1);
        tfldNume.setText(prs.getNume());
        lblPrenume = new JLabel("Prenume:");
        tfldPrenume = new JTextField(1);
        tfldPrenume.setText(String.valueOf(prs.getPrenume()));
        Vector<Adresa> adrese = DBUtils.GetAdrese();
        comboBoxIdAdresa = new JComboBox(adrese);
        lblEmail = new JLabel("Email:");
        tfldEmail = new JTextField(1);
        tfldEmail.setText(String.valueOf(prs.getEmail()));
        lblNr_tel = new JLabel("Nr. tel:");
        tfldNr_tel = new JTextField(1);
        tfldNr_tel.setText(String.valueOf(prs.getNr_tel()));
        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        lblNume.setBounds(184, 55, 100, 25);
        tfldNume.setBounds(184, 75, 200, 25);
        lblPrenume.setBounds(184, 100, 100, 25);
        tfldPrenume.setBounds(184, 120, 200, 25);
        lblEmail.setBounds(184, 145, 100, 25);
        tfldEmail.setBounds(184, 165, 200, 25);
        lblNr_tel.setBounds(184, 190, 100, 25);
        tfldNr_tel.setBounds(184, 210, 200, 25);
        modify.setBounds(50, 400, 100, 60);
        delete.setBounds(418, 400, 100, 60);

        frame_update_delete_produs.add(lblNume);
        frame_update_delete_produs.add(tfldNume);
        frame_update_delete_produs.add(lblPrenume);
        frame_update_delete_produs.add(tfldPrenume);
        frame_update_delete_produs.add(lblEmail);
        frame_update_delete_produs.add(tfldEmail);
        frame_update_delete_produs.add(lblNr_tel);
        frame_update_delete_produs.add(tfldNr_tel);
        frame_update_delete_produs.add(modify);
        frame_update_delete_produs.add(delete);

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (comboBoxIdAdresa.getSelectedItem() == null) {
                        MainPanel.infoBox("Nicio adresa selectata.", "Error");
                        return;
                    }
                    if (tfldNume.getText().isEmpty() || tfldPrenume.getText().isEmpty() ||
                            tfldNr_tel.getText().isEmpty() || tfldEmail.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }

                    prs.setId_persoana(id_persoana);
                    prs.setNume(tfldNume.getText());
                    prs.setPrenume(tfldPrenume.getText());
                    prs.setEmail(tfldEmail.getText());
                    prs.setNr_tel(tfldNr_tel.getText());
                    DBUtils.UpdatePersoana(prs);
                    Main.changeCurrentPanel(new PersoanaPanel());
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
                    DBUtils.DeletePersoana(id_persoana);
                    Main.changeCurrentPanel(new ProdusPanel());
                    frame_update_delete_produs.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

    }
}
