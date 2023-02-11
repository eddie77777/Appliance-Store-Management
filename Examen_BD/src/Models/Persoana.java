package Models;

public class Persoana {

    private int id_persoana;
    private String nume;
    private String prenume;
    private int id_adresa;
    private String email;
    private String nr_tel;

    public Persoana(int id_persoana, String nume, String prenume, int id_adresa, String email, String nr_tel) {
        this.id_persoana = id_persoana;
        this.nume = nume;
        this.prenume = prenume;
        this.id_adresa = id_adresa;
        this.email = email;
        this.nr_tel = nr_tel;
    }

    public int getId_persoana() {
        return id_persoana;
    }

    public void setId_persoana(int id_persoana) {
        this.id_persoana = id_persoana;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        prenume = prenume;
    }

    public int getId_adresa() {
        return id_adresa;
    }

    public void setId_adresa(int id_adresa) {
        this.id_adresa = id_adresa;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }
}
