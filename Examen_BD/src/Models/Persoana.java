package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Persoana {

    private int id_persoana;
    private String nume;
    private String prenume;
    private int id_adresa;
    private String email;
    private String nr_tel;

    public String toString() {
        return  "Cod: " + id_persoana + "           " +
                "Nume: " + nume + "           " +
                "Prenume: " + prenume + "           " +
                "Cod adresa: " + id_adresa + "           " +
                "Email: " + email + "           " +
                "Nr tel: " + nr_tel;
    }

    public Persoana(String nume, String prenume, int id_adresa, String email, String nr_tel) {
        this.nume = nume;
        this.prenume = prenume;
        this.id_adresa = id_adresa;
        this.email = email;
        this.nr_tel = nr_tel;
    }
    public Persoana(ResultSet resultSet) throws SQLException {
        this.id_persoana = resultSet.getInt("id_persoana");
        this.nume = resultSet.getString("nume");
        this.prenume = resultSet.getString("prenume");
        this.id_adresa = resultSet.getInt("id_adresa");
        this.email = resultSet.getString("email");
        this.nr_tel = resultSet.getString("nr_tel");
    }

    public int getId_persoana() {
        return id_persoana;
    }

    public void setId_persoana(int id_persoana) {
        this.id_persoana = id_persoana;
    }

    public String getNume()
    {
        return nume;
    }

    public void setNume(String nume)
    {
        this.nume = nume;
    }

    public String getPrenume()
    {
        return prenume;
    }

    public void setPrenume(String prenume)
    {
        this.prenume = prenume;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getNr_tel()
    {
        return nr_tel;
    }

    public void setNr_tel(String nr_tel)
    {
        this.nr_tel = nr_tel;
    }

    public int getId_adresa() {
        return id_adresa;
    }

    public void setId_adresa(int id_produs) {
        this.id_adresa = id_produs;
    }
}
