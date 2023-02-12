package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Produs {
    private int id_produs;
    private String nume_produs;
    private float pret;
    private int stoc;
    private String specificatii;

    @Override
    public String toString() {
        return "id: " + id_produs + "           " +
                "Nume: " + nume_produs + "           " +
                "Pret: " + pret + "             " +
                "Stoc: " + stoc + "             " +
                "Spec: " + specificatii;
    }

    public Produs(String nume_produs, float pret, int stoc, String specificatii) {
        this.nume_produs = nume_produs;
        this.pret = pret;
        this.stoc = stoc;
        this.specificatii = specificatii;
    }

    public Produs(ResultSet resultSet) throws SQLException {
        this.id_produs = resultSet.getInt("id_produs");
        this.nume_produs = resultSet.getString("nume_produs");
        this.pret = resultSet.getInt("pret");
        this.stoc = resultSet.getInt("stoc");
        this.specificatii = resultSet.getString("specificatii");
    }

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public String getNume_produs() {
        return nume_produs;
    }

    public void setNume_produs(String nume_produs) {
        this.nume_produs = nume_produs;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    public String getSpecificatii() {
        return specificatii;
    }

    public void setSpecificatii(String specificatii) {
        this.specificatii = specificatii;
    }

}