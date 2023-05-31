package UpdateDelete;

import DataBase.DBUtils;
import Main.Main;
import Models.Adresa;
import Models.Comanda;
import Models.Persoana;
import Models.Produs;
import Panels.AdresaPanel;
import Panels.ComandaPanel;
import Panels.MainPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UpdateDeleteComanda {
    private JLabel lblDataPlasare;
    private JTextField tfldDataPlasare;
    private JLabel lblDataLivrare;
    private JTextField tfldDataLivrare;
    private JLabel lblCostLivrare;
    private JTextField tfldCostLivrare;
    private JLabel lblPretTotal;
    private JTextField tfldPretTotal;
    private JLabel lblMetodaPlata;
    private JTextField tfldMetodaPlata;
    private JLabel lblEsteLivrata;
    private JTextField tfldEsteLivrata;
    private JButton modify;
    private JButton delete;
    private JLabel lblIdPersoane;
    private JComboBox comboBoxIdPersoane;
    private JLabel lblIdAdresa;

    private JComboBox comboBoxIdAdresa;

    public static JFrame frame_update_delete_adresa;

    public UpdateDeleteComanda(int id_comanda) throws SQLException {
        frame_update_delete_adresa = new JFrame("Edit Comanda");
        frame_update_delete_adresa.setSize(768, 568);
        frame_update_delete_adresa.setLocationRelativeTo(null);
        frame_update_delete_adresa.setVisible(true);
        frame_update_delete_adresa.setLayout(null);

        Comanda cmd = DBUtils.GetComandaForUpdateDelete(id_comanda);

        lblDataPlasare = new JLabel("Data plasare:");
        tfldDataPlasare = new JTextField(1);
        tfldDataPlasare.setText(cmd.getData_plasare().toString());
        lblDataLivrare = new JLabel("Data plasare:");
        tfldDataLivrare = new JTextField(1);
        tfldDataLivrare.setText(cmd.getData_livrare().toString());
        lblCostLivrare = new JLabel("Cost livrare:");
        tfldCostLivrare = new JTextField(1);
        tfldCostLivrare.setText(String.valueOf(cmd.getCost_livrare()));
        lblPretTotal = new JLabel("Pret total");
        tfldPretTotal = new JTextField(1);
        tfldPretTotal.setText(String.valueOf(cmd.getPret_total()));
        lblMetodaPlata = new JLabel("Metoda plata:");
        tfldMetodaPlata = new JTextField(1);
        tfldMetodaPlata.setText(cmd.getMetoda_plata());
        lblEsteLivrata = new JLabel("Este livrata:");
        tfldEsteLivrata = new JTextField(1);
        tfldEsteLivrata.setText(String.valueOf(cmd.getEste_livrata()));
        lblIdPersoane = new JLabel("Persoana:");
        comboBoxIdPersoane = new JComboBox(DBUtils.GetPersoane());
        comboBoxIdPersoane.setSelectedItem(DBUtils.GetPersoanaForUpdateDelete(cmd.getId_persoana()));
        lblIdAdresa = new JLabel("Adresa:");
        comboBoxIdAdresa = new JComboBox(DBUtils.GetAdrese());
        comboBoxIdAdresa.setSelectedItem(DBUtils.GetAdresaForUpdateDelete(cmd.getId_adresa()));

        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        lblDataPlasare.setBounds(184, 55, 400, 25);
        tfldDataPlasare.setBounds(184, 80, 400, 25);
        lblDataLivrare.setBounds(184, 105, 400, 25);
        tfldDataLivrare.setBounds(184, 130, 400, 25);
        lblCostLivrare.setBounds(184, 155, 400, 25);
        tfldCostLivrare.setBounds(184, 180, 400, 25);
        lblPretTotal.setBounds(184, 205, 400, 25);
        tfldPretTotal.setBounds(184, 230, 400, 25);
        lblMetodaPlata.setBounds(184, 155, 400, 25);
        tfldMetodaPlata.setBounds(184, 180, 400, 25);
        lblEsteLivrata.setBounds(184, 205, 400, 25);
        tfldEsteLivrata.setBounds(184, 230, 400, 25);
        lblIdPersoane.setBounds(50, 355, 400, 25);
        comboBoxIdPersoane.setBounds(50, 380, 668, 25);
        lblIdAdresa.setBounds(50, 405, 400, 25);
        comboBoxIdAdresa.setBounds(50, 430, 668, 25);

        modify.setBounds(184, 470, 100, 40);
        delete.setBounds(484, 470, 100, 40);

        frame_update_delete_adresa.add(lblDataLivrare);
        frame_update_delete_adresa.add(tfldDataLivrare);
        frame_update_delete_adresa.add(lblDataPlasare);
        frame_update_delete_adresa.add(tfldDataPlasare);
      /*  frame_update_delete_adresa.add(lblCostLivrare);
        frame_update_delete_adresa.add(tfldCostLivrare);
        frame_update_delete_adresa.add(lblPretTotal);
        frame_update_delete_adresa.add(tfldPretTotal);*/
        frame_update_delete_adresa.add(lblMetodaPlata);
        frame_update_delete_adresa.add(tfldMetodaPlata);
        frame_update_delete_adresa.add(lblEsteLivrata);
        frame_update_delete_adresa.add(tfldEsteLivrata);
        frame_update_delete_adresa.add(lblIdPersoane);
        frame_update_delete_adresa.add(lblIdAdresa);
        frame_update_delete_adresa.add(comboBoxIdPersoane);
        frame_update_delete_adresa.add(comboBoxIdAdresa);
        frame_update_delete_adresa.add(modify);
        frame_update_delete_adresa.add(delete);

        //actiuni
        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //VERIFICARE COMBOBOX
                    if (comboBoxIdPersoane.getSelectedItem() == null || comboBoxIdAdresa.getSelectedItem() == null) {
                        MainPanel.infoBox("Nicio persoana selectata sau comanda selectata", "Error");
                        return;
                    }

                    //VERIFICARE DATE
                    String dataPlasareText = tfldDataPlasare.getText();
                    String dataLivrareText = tfldDataLivrare.getText();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date dataPlasare = null;
                    java.util.Date dataLivrare = null;

                    try {
                        dataPlasare = dateFormat.parse(dataPlasareText);
                        dataLivrare = dateFormat.parse(dataLivrareText);
                    } catch (ParseException ex) {
                        MainPanel.infoBox("Data plasare sau data livrare in format nevalid", "Error");
                        return;
                    }

                    //VERIFICARE TEXTFIELDS
                    if (tfldCostLivrare.getText().isEmpty() || tfldPretTotal.getText().isEmpty() ||
                            tfldEsteLivrata.getText().isEmpty() || tfldMetodaPlata.getText().isEmpty()) {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }
                    Comanda comanda = DBUtils.GetComandaForUpdateDelete(id_comanda);
                    comanda.setData_livrare(Date.valueOf(tfldDataLivrare.getText()));
                    comanda.setData_plasare(Date.valueOf(tfldDataPlasare.getText()));
                    comanda.setCost_livrare(1);
                    comanda.setPret_total(1);
                    comanda.setMetoda_plata(tfldMetodaPlata.getText());
                    comanda.setEste_livrata(Boolean.valueOf(tfldEsteLivrata.getText()));

                    Object selectedObj = comboBoxIdPersoane.getSelectedItem();
                    Persoana prs = (Persoana) selectedObj;
                    comanda.setId_persoana(prs.getId_persoana());

                    Object selectedObj2 = comboBoxIdAdresa.getSelectedItem();
                    Adresa adr = (Adresa) selectedObj2;
                    comanda.setId_adresa(adr.getId_adresa());

                    DBUtils.UpdateComanda(comanda);
                    Main.changeCurrentPanel(new ComandaPanel());
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
                    DBUtils.DeleteComanda(id_comanda);
                    Main.changeCurrentPanel(new ComandaPanel());
                    frame_update_delete_adresa.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
