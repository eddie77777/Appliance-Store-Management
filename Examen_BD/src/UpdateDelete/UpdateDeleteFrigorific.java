package UpdateDelete;
import DataBase.DBUtils;
import Main.Main;
import Models.Frigorific;
import Models.Produs;
import Panels.AdresaPanel;
import Panels.FrigorificPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

public class UpdateDeleteFrigorific extends  JFrame{
    private JLabel lblIdProdus;
    private JComboBox comboBoxIdProdus;
    private JLabel lblProprietati;
    private JTextField tfldProprietati;
    private JButton modify;
    private JButton delete;

    public static JFrame frame_update_delete_frigorific;

    public UpdateDeleteFrigorific (int id_frigorific) throws SQLException {
        frame_update_delete_frigorific = new JFrame("Adrese");
        frame_update_delete_frigorific.setSize(568, 568);
        frame_update_delete_frigorific.setLocationRelativeTo(null);
        frame_update_delete_frigorific.setVisible(true);
        frame_update_delete_frigorific.setLayout(null);

        lblIdProdus = new JLabel ("Produs:");
        Vector<Produs> produse = DBUtils.GetProduse();
        comboBoxIdProdus = new JComboBox(produse);
        lblProprietati = new JLabel ("Proprietati:");
        tfldProprietati = new JTextField (1);
        tfldProprietati.setText(DBUtils.GetFrigorificForUpdateDelete(id_frigorific).getProprietati());
        modify = new JButton("Modificare");
        delete = new JButton("Stergere");

        //adjust size and set layout
        //setPreferredSize (new Dimension(938, 568));
        //setLayout (null);

        comboBoxIdProdus.setBounds (100, 67, 284, 35);
        lblIdProdus.setBounds (184, 45, 200, 25);
        lblProprietati.setBounds (100, 100, 284, 25);
        tfldProprietati.setBounds (100, 120, 284, 25);
        modify.setBounds(50,400,100,60);
        delete.setBounds(418,400,100,60);

        frame_update_delete_frigorific.add (comboBoxIdProdus);
        frame_update_delete_frigorific.add (lblIdProdus);
        frame_update_delete_frigorific.add (lblProprietati);
        frame_update_delete_frigorific.add (tfldProprietati);
        frame_update_delete_frigorific.add (modify);
        frame_update_delete_frigorific.add (delete);

        int index = 0;
        int idProdus = DBUtils.GetFrigorificForUpdateDelete(id_frigorific).getId_produs();
        Produs produs = DBUtils.GetProdusById(idProdus);
        for(int i=0;i<produse.size();i++)
                if(produse.elementAt(i).getId_produs() == produs.getId_produs())
                    index = i;
        comboBoxIdProdus.setSelectedItem(produse.get(index));

        //inceput de modificare, e inutil acum
       /* comboBoxIdProdus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedObj = comboBoxIdProdus.getSelectedItem();
                if (selectedObj instanceof Produs) {
                    Produs produsSelectat = (Produs) selectedObj;
                    try {
                        DBUtils.UpdateProdusForAFrigorific(id_frigorific, produsSelectat.getId_produs());
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });*/

        modify.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Frigorific frg = DBUtils.GetFrigorificForUpdateDelete(id_frigorific);
                    Object selectedObj = comboBoxIdProdus.getSelectedItem();
                    Produs prd = (Produs) selectedObj;
                    frg.setId_produs(prd.getId_produs());
                    frg.setProprietati(tfldProprietati.getText());
                    DBUtils.UpdateFrigorific(frg);
                    Main.changeCurrentPanel(new FrigorificPanel());
                    frame_update_delete_frigorific.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }
        });

        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    DBUtils.DeleteFrigorific(id_frigorific);
                    Main.changeCurrentPanel(new FrigorificPanel());
                    frame_update_delete_frigorific.setVisible(false);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}