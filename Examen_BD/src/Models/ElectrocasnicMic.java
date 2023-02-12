package Models;

public class ElectrocasnicMic {

    private int id_electrocasnic_mic;
    private int id_produs;
    private String proprietati;

    public ElectrocasnicMic(int id_electrocasnic_mic, int id_produs, String proprietati) {
        this.id_electrocasnic_mic = id_electrocasnic_mic;
        this.id_produs = id_produs;
        this.proprietati = proprietati;
    }

    public int getId_electrocasnic_mic() {
        return id_electrocasnic_mic;
    }

    public void setId_electrocasnic_mic(int id_electrocasnic_mic) {
        this.id_electrocasnic_mic = id_electrocasnic_mic;
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