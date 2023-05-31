package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MasinaDeGatit {

    private int id_masina_de_gatit;
    private int id_produs;
    private String proprietati;

    public String toString() {
        return "cod: " + id_masina_de_gatit + "           " +
                "cod_pr: " + id_produs + "           " +
                "prop: " + proprietati;
    }

    public MasinaDeGatit(int id_produs, String proprietati) {
        this.id_produs = id_produs;
        this.proprietati = proprietati;
    }

    public MasinaDeGatit(ResultSet resultSet) throws SQLException {
        this.id_masina_de_gatit = resultSet.getInt("id_masina_de_gatit");
        this.id_produs = resultSet.getInt("id_produs");
        this.proprietati = resultSet.getString("proprietati");
    }

    public int getId_masina_de_gatit() {
        return id_masina_de_gatit;
    }

    public void setId_masina_de_gatit(int id_masina_de_gatit) {
        this.id_masina_de_gatit = id_masina_de_gatit;
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
