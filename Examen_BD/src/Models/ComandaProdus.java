package Models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComandaProdus {
    private int id_comanda_produs;
    private int id_comanda;
    private int id_produs;

    @Override
    public String toString() {
        return "cod_c: " + id_comanda + "      " +
                "cod_pr: " + id_produs;
    }

    public ComandaProdus(int id_comanda, int id_produs) {
        this.id_comanda = id_comanda;
        this.id_produs = id_produs;
    }

    public ComandaProdus(ResultSet resultSet) throws SQLException {
        this.id_comanda_produs = resultSet.getInt("id_comanda_produs");
        this.id_comanda = resultSet.getInt("id_comanda");
        this.id_produs = resultSet.getInt("id_produs");
    }

    public int getId_comanda_produs() {
        return id_comanda_produs;
    }

    public void setId_comanda_produs(int id_comanda_produs) { this.id_comanda_produs = id_comanda_produs;}

    public int getId_produs() {
        return id_produs;
    }

    public void setId_produs(int id_produs) {
        this.id_produs = id_produs;
    }

    public int getId_comanda() {
        return id_comanda;
    }

    public void setId_comanda(int id_comanda) {
        this.id_comanda = id_comanda;
    }

}