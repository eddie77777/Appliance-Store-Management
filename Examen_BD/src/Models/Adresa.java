package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Adresa {
    private int id_adresa;
    private String judet;
    private String localitate;
    private String strada;
    private int numar;
    private int bloc;
    private String scara;
    private int apartament;

    @Override
    public String toString() {
        return judet + "           " +
                localitate + "             " +
                strada + "             " +
                numar + "             " +
                bloc + "             " +
                scara  + "             " +
                apartament;
    }

    public Adresa(int id_adresa, String judet, String localitate, String strada, int numar, int bloc, String scara, int apartament) {
        this.id_adresa = id_adresa;
        this.judet = judet;
        this.localitate = localitate;
        this.strada = strada;
        this.numar = numar;
        this.bloc = bloc;
        this.scara = scara;
        this.apartament = apartament;
    }

    public Adresa(ResultSet resultSet) throws SQLException {
        this.id_adresa = resultSet.getInt("id_adresa");
        this.judet = resultSet.getString("judet");
        this.localitate = resultSet.getString("localitate");
        this.strada = resultSet.getString("strada");
        this.numar = resultSet.getInt("numar");
        this.bloc = resultSet.getInt("bloc");
        this.scara = resultSet.getString("scara");
        this.apartament = resultSet.getInt("apartament");
    }

    public int getId_adresa() {
        return id_adresa;
    }

    public void setId_adresa(int id_adresa) {
        this.id_adresa = id_adresa;
    }

    public String getJudet() {
        return judet;
    }

    public void setJudet(String judet) {
        this.judet = judet;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getStrada() {
        return strada;
    }

    public void setStrada(String strada) {
        this.strada = strada;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public int getBloc() {
        return bloc;
    }

    public void setBloc(int bloc) {
        bloc = bloc;
    }

    public String getScara() {
        return scara;
    }

    public void setScara(int scara) {
        scara = scara;
    }

    public int getApartament() {
        return apartament;
    }

    public void setApartament(int apartament) {
        this.apartament = apartament;
    }
}