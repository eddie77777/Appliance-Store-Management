package UpdateDelete;

import DataBase.DBUtils;
import Main.Main;
import Models.MasinaDeGatit;
import Models.Persoana;
import Models.Produs;
import Panels.FrigorificPanel;
import Panels.MainPanel;
import Panels.MasinaDeGatitPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class UpdateDeleteMasinaDeGatit extends JFrame {
    private JLabel lblIdProdus;
    private JComboBox comboBoxIdProdus;
    private JLabel lblProprietati;
    private JTextField tfldProprietati;
    private JButton modify;
    private JButton delete;

    public static JFrame frame_update_delete_masina_de_gatit;

    public UpdateDeleteMasinaDeGatit(int id_masina_de_gatit) throws SQLException {
        frame_update_delete_masina_de_gatit = new JFrame("Masina de Gatit");
        frame_update_delete_masina_de_gatit.setSize(568, 568);
        frame_update_delete_masina_de_gatit.setLocationRelativeTo(null);
        frame_update_delete_masina_de_gatit.setVisible(true);
        frame_update_delete_masina_de_gatit.setLayout(null);

        lblIdProdus = new JLabel("Produs:");
        Vector<Produs> produse = DBUtils.GetProduse();
        comboBoxIdProdus = new JComboBox(produse);
        lblProprietati = new JLabel("Proprietati:");
        tfldProprietati = new JTextField(1);
        tfldProprietati.setText(DBUtils.GetMasinaDeGatitForUpdateDelete(id_masina_de_gatit).getProprietati());   ///////
        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        comboBoxIdProdus.setBounds(30, 67, 490, 35);
        lblIdProdus.setBounds(30, 45, 200, 25);
        lblProprietati.setBounds(30, 100, 284, 25);
        tfldProprietati.setBounds(30, 120, 490, 100);
        modify.setBounds(50, 400, 100, 60);
        delete.setBounds(418, 400, 100, 60);

        frame_update_delete_masina_de_gatit.add(comboBoxIdProdus);
        frame_update_delete_masina_de_gatit.add(lblIdProdus);
        frame_update_delete_masina_de_gatit.add(lblProprietati);
        frame_update_delete_masina_de_gatit.add(tfldProprietati);
        frame_update_delete_masina_de_gatit.add(modify);
        frame_update_delete_masina_de_gatit.add(delete);

        int index = 0;
        int idProdus = DBUtils.GetMasinaDeGatitForUpdateDelete(id_masina_de_gatit).getId_produs();
        Produs produs = DBUtils.GetProdusById(idProdus);
        for (int i = 0; i < produse.size(); i++)
            if (produse.elementAt(i).getId_produs() == produs.getId_produs())
                index = i;
        comboBoxIdProdus.setSelectedItem(produse.get(index));


        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(comboBoxIdProdus.getSelectedItem()==null)
                    {
                        MainPanel.infoBox("Niciun produs selectat.", "Error");
                        return;
                    }

                    //VERIFICARE TEXTFIELDS
                    if(tfldProprietati.getText().isEmpty() )
                    {
                        MainPanel.infoBox("Un camp este necompletat.", "Error");
                        return;
                    }
                    MasinaDeGatit gatit = DBUtils.GetMasinaDeGatitForUpdateDelete(id_masina_de_gatit);
                    Object selectedObj = comboBoxIdProdus.getSelectedItem();
                    Produs prd = (Produs) selectedObj;
                    gatit.setId_produs(prd.getId_produs());
                    gatit.setProprietati(tfldProprietati.getText());
                    DBUtils.UpdateMasinaDeGatit(gatit);
                    Main.changeCurrentPanel(new MasinaDeGatitPanel());
                    frame_update_delete_masina_de_gatit.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBUtils.DeleteMasinaDeSpalat(id_masina_de_gatit);
                    Main.changeCurrentPanel(new FrigorificPanel());
                    frame_update_delete_masina_de_gatit.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}