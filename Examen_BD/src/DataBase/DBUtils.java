package DataBase;

import Models.Adresa;
import Models.Produs;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class DBUtils {
    public static Vector<Produs> GetProduse() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.produs;");
        Vector<Produs> produse = new Vector<>();
        while(resultSet.next())
        {
            produse.add(new Produs(resultSet));
        }
        return produse;
    }

    public static Vector<Adresa> GetAdrese() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.adresa;");
        Vector<Adresa> adrese = new Vector<>();
        while(resultSet.next())
        {
            adrese.add(new Adresa(resultSet));
        }
        return adrese;
    }

    public static boolean AdaugaAdresa(Adresa adresa) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.adresa(judet, localitate,strada, numar, bloc, scara, apartament) VALUES ('"
                + adresa.getJudet() + "', '" + adresa.getLocalitate() + "', '"
                + adresa.getStrada() + "', '" + adresa.getNumar() + "', '"
                + adresa.getBloc() + "', '" + adresa.getScara() + "', '"
                + adresa.getApartament() +
                "');");
        return true;
    }

    public static boolean AdaugaProdus(Produs produs) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.produs(nume_produs,pret, stoc,specificatii) VALUES ('" +
                produs.getNume_produs() + "', '" + produs.getPret() + "', '" + produs.getStoc() + "', '"
                + produs.getSpecificatii() + "');");
        return true;
    }

    public static Adresa GetAdresaForUpdateDelete(Integer id_adresa) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.adresa WHERE id_adresa = " + id_adresa + ";");
        resultSet.next();
        return new Adresa((resultSet));
    }

    public static void UpdateAdresa(Adresa adresa) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        /*statement.executeUpdate(
                "UPDATE public.adresa SET judet = '" + adresa.getJudet()  + "' WHERE id_adresa = " + adresa.getId_adresa() + ";" +
                        "UPDATE public.adresa SET localitate = '" + adresa.getLocalitate()  + "' WHERE id_adresa = " + adresa.getId_adresa() + ";" +
                        "UPDATE public.adresa SET strada = '" + adresa.getStrada()  + "' WHERE id_adresa = " + adresa.getId_adresa() + ";" +
                        "UPDATE public.adresa SET numar = " + adresa.getNumar()  + " WHERE id_adresa = " + adresa.getId_adresa() + ";" +
                        "UPDATE public.adresa SET bloc = " + adresa.getBloc()  + " WHERE id_adresa = " + adresa.getId_adresa() + ";" +
                        "UPDATE public.adresa SET scara = '" + adresa.getScara()  + "' WHERE id_adresa = " + adresa.getId_adresa() + ";" +
                        "UPDATE public.adresa SET apartament = " + adresa.getApartament()  + " WHERE id_adresa = " + adresa.getId_adresa() + ";"
        );*/
        statement.executeUpdate(
                "UPDATE public.adresa SET judet = '" + adresa.getJudet()  + "' ,localitate = '" + adresa.getLocalitate()  +
                        "' ,strada = '" + adresa.getStrada() + "' ,numar = " + adresa.getNumar() +
                        " ,bloc = " + adresa.getBloc() + " ,scara = '" + adresa.getScara() + "' " +
                        " ,apartament = " + adresa.getApartament() +
                        " WHERE id_adresa = " + adresa.getId_adresa() + ";"
        );
    }

    public static void DeleteAdresa(int id_adresa) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM adresa WHERE id_adresa = " + id_adresa + ";"
        );
    }
}
