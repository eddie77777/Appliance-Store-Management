package Models;

public class Frigorific {
    private int id_frigorific;
    private int id_produs;
    private String proprietati;

    public Frigorific(int id_frigorific, int id_produs, String proprietati) {
        this.id_frigorific = id_frigorific;
        this.id_produs = id_produs;
        this.proprietati = proprietati;
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
