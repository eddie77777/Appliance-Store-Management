package Models;

public class Adresa {
    private int id_adresa;
    private String judet;
    private String localitate;
    private String strada;
    private int numar;
    private int Bloc;
    private int Scara;
    private int apartament;

    public Adresa(int id_adresa, String judet, String localitate, String strada, int numar, int bloc, int scara, int apartament) {
        this.id_adresa = id_adresa;
        this.judet = judet;
        this.localitate = localitate;
        this.strada = strada;
        this.numar = numar;
        Bloc = bloc;
        Scara = scara;
        this.apartament = apartament;
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
        return Bloc;
    }

    public void setBloc(int bloc) {
        Bloc = bloc;
    }

    public int getScara() {
        return Scara;
    }

    public void setScara(int scara) {
        Scara = scara;
    }

    public int getApartament() {
        return apartament;
    }

    public void setApartament(int apartament) {
        this.apartament = apartament;
    }
}
