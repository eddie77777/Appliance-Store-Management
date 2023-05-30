package Models;

import java.sql.Date;

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
        return "id: " + id_comanda + "           " +
                "id_persoana: " +id_persoana + "           " +
                "id_adresa: " +id_adresa  + "           " +
                "data_plasare: "+data_plasare  + "           " +
                "data_livrare: "+data_livrare  + "           " +
                "cost_livrare: "+cost_livrare  + "           " +
                "pret_total: "+pret_total  + "           " +
                "metoda_plata: "+metoda_plata  + "           " +
                "este livrata: "+este_livrata;
    }

    public Comanda(int id_comanda, int id_persoana, int id_adresa, Date data_plasare, Date data_livrare, float cost_livrare, float pret_total, String metoda_plata, Boolean este_livrata) {
        this.id_comanda = id_comanda;
        this.id_persoana = id_persoana;
        this.id_adresa = id_adresa;
        this.data_plasare = data_plasare;
        this.data_livrare = data_livrare;
        this.cost_livrare = cost_livrare;
        this.pret_total = pret_total;
        this.metoda_plata = metoda_plata;
        this.este_livrata = este_livrata;
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
