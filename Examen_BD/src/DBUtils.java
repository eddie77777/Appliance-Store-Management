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
}