package Models;

public class MasinaDeSpalat {

    private int id_masina_de_spalat;
    private int id_produs;
    private String proprietati;

    public MasinaDeSpalat(int id_masina_de_spalat, int id_produs, String proprietati) {
        this.id_masina_de_spalat = id_masina_de_spalat;
        this.id_produs = id_produs;
        this.proprietati = proprietati;
    }

    public int getId_masina_de_spalat() {
        return id_masina_de_spalat;
    }

    public void setId_masina_de_spalat(int id_masina_de_spalat) {
        this.id_masina_de_spalat = id_masina_de_spalat;
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
