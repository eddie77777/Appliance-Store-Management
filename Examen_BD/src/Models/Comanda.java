package Models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Comanda {

    int id_comanda;
    int id_persoana;
    int id_adresa;
    Date data_plasare;
    Date data_livrare;
    float cost_livrare;
    float pret_total;
    String metoda_plata;
    Boolean este_livrata;

    @Override
    public String toString() {
        return "nr: " + id_comanda + "      " +
                "cod_p: " + id_persoana + "      " +
                "cod_a: " + id_adresa + "      " +
                "data_p: " + data_plasare + "      " +
                "data_l: " + data_livrare + "      " +
                "cost: " + cost_livrare + "      " +
                "total: " + pret_total + "      " +
                "metoda: " + metoda_plata + "      " +
                "status: " + este_livrata;
    }

    public Comanda(int id_persoana, int id_adresa, Date data_plasare, Date data_livrare, float cost_livrare, float pret_total, String metoda_plata, Boolean este_livrata) {
        this.id_persoana = id_persoana;
        this.id_adresa = id_adresa;
        this.data_plasare = data_plasare;
        this.data_livrare = data_livrare;
        this.cost_livrare = cost_livrare;
        this.pret_total = pret_total;
        this.metoda_plata = metoda_plata;
        this.este_livrata = este_livrata;
    }

    public Comanda(ResultSet resultSet) throws SQLException {
        this.id_comanda = resultSet.getInt("id_comanda");
        this.id_persoana = resultSet.getInt("id_persoana");
        this.id_adresa = resultSet.getInt("id_adresa");
        this.data_plasare = resultSet.getDate("data_plasare");
        this.data_livrare = resultSet.getDate("data_livrare");
        this.cost_livrare = resultSet.getInt("cost_livrare");
        this.pret_total = resultSet.getInt("pret_total");
        this.metoda_plata = resultSet.getString("metoda_plata");
        this.este_livrata = resultSet.getBoolean("este_livrata");
    }


    public int getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(int id_comanda) {
        this.id_comanda = id_comanda;
    }

    public int getId_persoana() {
        return id_persoana;
    }

    public void setId_persoana(int id_persoana) {
        this.id_persoana = id_persoana;
    }

    public int getId_adresa() {
        return id_adresa;
    }

    public void setId_adresa(int id_adresa) {
        this.id_adresa = id_adresa;
    }

    public Date getData_plasare() {
        return data_plasare;
    }

    public void setData_plasare(Date data_plasare) {
        this.data_plasare = data_plasare;
    }

    public Date getData_livrare() {
        return data_livrare;
    }

    public void setData_livrare(Date data_livrare) {
        this.data_livrare = data_livrare;
    }

    public float getCost_livrare() {
        return cost_livrare;
    }

    public void setCost_livrare(float cost_livrare) {
        this.cost_livrare = cost_livrare;
    }

    public float getPret_total() {
        return pret_total;
    }

    public void setPret_total(float pret_total) {
        this.pret_total = pret_total;
    }

    public String getMetoda_plata() {
        return metoda_plata;
    }

    public void setMetoda_plata(String metoda_plata) {
        this.metoda_plata = metoda_plata;
    }

    public Boolean getEste_livrata() {
        return este_livrata;
    }

    public void setEste_livrata(Boolean este_livrata) {
        this.este_livrata = este_livrata;
    }
}
