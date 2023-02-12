package Models;

public class Produs {
    private int id_produs;
    private String nume_produs;
    private float pret;
    private int stoc;
    private String specificatii_comune;

    public Produs(int id_produs, String nume_produs, float pret, int stoc, String specificatii_comune) {
        this.id_produs = id_produs;
        this.nume_produs = nume_produs;
        this.pret = pret;
        this.stoc = stoc;
        this.specificatii_comune = specificatii_comune;
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

    public String getSpecificatii_comune() {
        return specificatii_comune;
    }

    public void setSpecificatii_comune(String specificatii_comune) {
        this.specificatii_comune = specificatii_comune;
    }
}