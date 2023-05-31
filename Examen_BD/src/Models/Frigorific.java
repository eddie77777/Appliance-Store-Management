package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Frigorific {
    private int id_frigorific;
    private int id_produs;
    private String proprietati;

    @Override
    public String toString() {
        return "cod: " + id_frigorific + "           " +
                "cod_pr: " + id_produs + "           " +
                "prop: " + proprietati;
    }

    public Frigorific(int id_produs, String proprietati) {
        this.id_produs = id_produs;
        this.proprietati = proprietati;
    }

    public Frigorific(ResultSet resultSet) throws SQLException {
        this.id_frigorific = resultSet.getInt("id_frigorific");
        this.id_produs = resultSet.getInt("id_produs");
        this.proprietati = resultSet.getString("proprietati");
    }

    public int getId_frigorific() {
        return id_frigorific;
    }

    public void setId_frigorific(int id_frigorific) {
        this.id_frigorific = id_frigorific;
    }

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public String getProprietati() {
        return proprietati;
    }

    public void setProprietati(String proprietati) {
        this.proprietati = proprietati;
    }
}
