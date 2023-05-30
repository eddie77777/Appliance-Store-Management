package UpdateDelete;

import DataBase.DBUtils;
import Main.Main;
import Models.Adresa;
import Models.Comanda;
import Panels.AdresaPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateDeleteComanda {
    private JLabel lblDataPlasare;
    private JTextField tfldDataPlasare;
    private JLabel lblDataLivrare;
    private JTextField tfldDataLivrare;
    private JLabel lblCostLivrare;
    private JTextField tfldCostLivrare;
    private JLabel lblMetodaPlata;
    private JTextField tfldMetodaPlata;
    private JLabel lblEsteLivrata;
    private JTextField tfldEsteLivrata;
    private JButton modify;
    private JButton delete;
    private JComboBox comboBoxIdPersoane;

    private JComboBox comboBoxIdAdresa;

    public static JFrame frame_update_delete_adresa;

    public UpdateDeleteComanda (int id_comanda) throws SQLException {
        frame_update_delete_adresa = new JFrame("Edit Comanda");
        frame_update_delete_adresa.setSize(568, 568);
        frame_update_delete_adresa.setLocationRelativeTo(null);
        frame_update_delete_adresa.setVisible(true);
        frame_update_delete_adresa.setLayout(null);

        Comanda cmd = DBUtils.GetComandaForUpdateDelete(id_comanda);

        lblDataPlasare = new JLabel ("Data plasare:");
        tfldDataPlasare = new JTextField (1);
        tfldDataPlasare.setText(cmd.getData_plasare().toString());
        lblDataLivrare = new JLabel ("Data plasare:");
        tfldDataLivrare = new JTextField (1);
        tfldDataLivrare.setText(cmd.getData_livrare().toString());
        lblCostLivrare = new JLabel ("Cost livrare:");
        tfldCostLivrare = new JTextField (1);
        tfldCostLivrare.setText(String.valueOf(cmd.getCost_livrare()));
        lblMetodaPlata = new JLabel ("Metoda plata:");
        tfldMetodaPlata = new JTextField (1);
        tfldMetodaPlata.setText(cmd.getMetoda_plata());
        lblEsteLivrata = new JLabel ("Este livrata:");
        tfldEsteLivrata = new JTextField (1);
        tfldEsteLivrata.setText(String.valueOf(cmd.getEste_livrata()));
        comboBoxIdAdresa = new JComboBox(DBUtils.GetAdrese());
        comboBoxIdAdresa.setSelectedItem(DBUtils.GetAdresa(cmd.getId_adresa()));
        comboBoxIdPersoane = new JComboBox(DBUtils.GetPersoane());

        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        lblDataPlasare.setBounds (184, 55, 100, 25);
        tfldDataPlasare.setBounds (184, 80, 100, 25);
        lblDataLivrare.setBounds (184, 105, 100, 25);
        tfldDataLivrare.setBounds (184, 130, 100, 25);
        lblCostLivrare.setBounds (184, 155, 100, 25);
        tfldCostLivrare.setBounds (184, 180, 100, 25);
        lblMetodaPlata.setBounds (184, 205, 100, 25);
        tfldMetodaPlata.setBounds (184, 230, 100, 25);
        lblEsteLivrata.setBounds (184, 255, 100, 25);
        tfldEsteLivrata.setBounds (184, 280, 100, 25);

        modify.setBounds(50,400,100,60);
        delete.setBounds(418,400,100,60);

        frame_update_delete_adresa.add (lblDataLivrare);
        frame_update_delete_adresa.add (tfldDataLivrare);
        frame_update_delete_adresa.add (lblDataPlasare);
        frame_update_delete_adresa.add (tfldDataPlasare);
        frame_update_delete_adresa.add (lblCostLivrare);
        frame_update_delete_adresa.add (tfldCostLivrare);
        frame_update_delete_adresa.add (lblMetodaPlata);
        frame_update_delete_adresa.add (tfldMetodaPlata);
        frame_update_delete_adresa.add (lblEsteLivrata);
        frame_update_delete_adresa.add (tfldEsteLivrata);
        frame_update_delete_adresa.add (modify);
        frame_update_delete_adresa.add (delete);

        //actiuni
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Adresa adresa = DBUtils.GetAdresaForUpdateDelete(id_adresa);
                    adresa.setJudet(tfldJudet.getText());
                    adresa.setLocalitate(tfldLocalitate.getText());
                    adresa.setStrada(tfldStrada.getText());
                    adresa.setNumar(Integer.parseInt(tfldNumar.getText()));
                    adresa.setBloc(Integer.parseInt(tfldBloc.getText()));
                    adresa.setScara(tfldScara.getText());
                    adresa.setApartament(Integer.parseInt(tfldApartament.getText()));
                    DBUtils.UpdateAdresa(adresa);
                    Main.changeCurrentPanel(new AdresaPanel());
                    frame_update_delete_adresa.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBUtils.DeleteAdresa(id_adresa);
                    Main.changeCurrentPanel(new AdresaPanel());
                    frame_update_delete_adresa.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
