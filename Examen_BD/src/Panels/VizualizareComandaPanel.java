package Panels;

import DataBase.DBUtils;
import Main.Main;
import Models.*;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class VizualizareComandaPanel extends JPanel {

    //Persoana
    JTextArea nume;
    JTextArea prenume;
    JTextArea email;
    JTextArea nr_tel;

    //Adresa
    JTextArea judet;
    JTextArea localitate;
    JTextArea strada;
    JTextArea numar;
    JTextArea bloc;
    JTextArea scara;
    JTextArea apartament;

    //Comanda
    JTextArea data_plasare;
    JTextArea data_livrare;
    JTextArea cost_livrare;
    JTextArea pret_total;
    JTextArea metoda_plata;
    JTextArea este_livrata;


    //Produs
    JTextArea nume_produs;
    JTextArea specificatii;

    JLabel lblAdresa;
    JLabel lblPersoana;
    JLabel lblComanda;
    JLabel lblProdus;

    private JButton btnBack;
    public VizualizareComandaPanel(ComandaProdus comandaProdus) throws SQLException {
        Comanda comanda = DBUtils.GetComandaForUpdateDelete(comandaProdus.getId_comanda());
        Persoana persoana = DBUtils.GetPersoanaForUpdateDelete(comanda.getId_persoana());
        Adresa adresa = DBUtils.GetAdresaForUpdateDelete(persoana.getId_adresa());
        Produs produs = DBUtils.GetProdusForUpdateDelete(comandaProdus.getId_produs());

        nume = new JTextArea("Nume: " + persoana.getNume());
        prenume = new JTextArea("Prenume: " + persoana.getPrenume());
        email = new JTextArea("Email: " + persoana.getEmail());
        nr_tel = new JTextArea("Nr tel:" + persoana.getNr_tel());

        judet = new JTextArea("Judet: " + adresa.getJudet());
        localitate = new JTextArea("Localitate: " + adresa.getLocalitate());
        strada = new JTextArea("Strada" + adresa.getStrada());
        numar = new JTextArea("Numar: " + adresa.getNumar());
        bloc = new JTextArea("Bloc: " + adresa.getBloc());
        scara = new JTextArea("Scara: " + adresa.getScara());
        apartament = new JTextArea("Apartament: " + adresa.getApartament());

        data_plasare = new JTextArea("Data plasare: " + comanda.getData_plasare());
        data_livrare = new JTextArea("Data livrare: " + comanda.getData_livrare());
        cost_livrare = new JTextArea("Cost livrare: " + comanda.getCost_livrare());
        pret_total = new JTextArea("Pret total: " + comanda.getPret_total());
        metoda_plata = new JTextArea("Metoda plata: " + comanda.getMetoda_plata());
        este_livrata = new JTextArea("Status: " + comanda.getEste_livrata());

        nume_produs = new JTextArea("Nume produs: " + produs.getNume_produs());
        specificatii = new JTextArea("Specificatii: " + produs.getSpecificatii());

        lblAdresa = new JLabel("Adresa:");
        lblComanda = new JLabel("Detalii comanda");
        lblProdus = new JLabel("Detalii produs:");
        lblPersoana = new JLabel("Date personale:");

        btnBack = new JButton ("<<");

        setPreferredSize(new Dimension(1500, 568));
        setSize(1500, 568);
        setLayout(null);

        add(nume);
        add(prenume);
        add(email);
        add(nr_tel);

        add(judet);
        add(localitate);
        add(strada);
        add(numar);
        add(bloc);
        add(scara);
        add(apartament);

        add(data_plasare);
        add(data_livrare);
        add(cost_livrare);
        add(pret_total);
        add(metoda_plata);
        add(este_livrata);

        add(nume_produs);
        add(specificatii);

        add(lblAdresa);
        add(lblComanda);
        add(lblProdus);
        add(lblPersoana);

        add (btnBack);

        nume.setBounds(10, 70, 400, 25);
        prenume.setBounds(10, 100, 400, 25);
        email.setBounds(10, 130, 400, 25);
        nr_tel.setBounds(10, 160, 400, 25);

        judet.setBounds(10, 240, 400, 25);
        localitate.setBounds(10, 270, 400, 25);
        strada.setBounds(10, 300, 400, 25);
        numar.setBounds(10, 330, 400, 25);
        bloc.setBounds(10, 360, 400, 25);
        scara.setBounds(10, 390, 400, 25);
        apartament.setBounds(10, 420, 400, 25);

        data_plasare.setBounds(450, 70, 400, 25);
        data_livrare.setBounds(450, 100, 400, 25);
        cost_livrare.setBounds(450, 130, 400, 25);
        pret_total.setBounds(450, 160, 400, 25);
        metoda_plata.setBounds(450, 190, 400, 25);
        este_livrata.setBounds(450, 220, 400, 25);

        nume_produs.setBounds(450, 300, 400, 25);
        specificatii.setBounds(450, 330, 400, 25);

        lblPersoana.setBounds(10, 45, 100, 25);
        lblAdresa.setBounds(10, 215, 100, 25);
        lblComanda.setBounds(450, 45, 100, 25);
        lblProdus.setBounds(450, 275, 100, 25);

        btnBack.setBounds (10, 0, 50, 25);

        btnBack.addActionListener(e -> {
            try {
                Main.changeCurrentPanel(new ComandaProdusPanel());

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });
    }
}
