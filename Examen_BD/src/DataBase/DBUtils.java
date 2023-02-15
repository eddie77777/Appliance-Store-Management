package DataBase;

import Models.Adresa;
import Models.Frigorific;
import Models.MasinaDeSpalat;
import Models.Produs;
import Models.*;

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

    public static Vector<MasinaDeSpalat> GetMasinaDeSpalat() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.masina_de_spalat;");
        Vector<MasinaDeSpalat> masiniSpalat = new Vector<>();
        while(resultSet.next())
        {
            masiniSpalat.add(new MasinaDeSpalat(resultSet));
        }
        return masiniSpalat;
    }

    public static Vector<Frigorific> GetFrigorifice() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.frigorific;");
        Vector<Frigorific> frigorifice = new Vector<>();
        while(resultSet.next())
        {
            frigorifice.add(new Frigorific(resultSet));
        }
        return frigorifice;
    }

    public static Vector<ElectrocasnicMic> GetElectrocasnice() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.electrocasnic_mic;");
        Vector<ElectrocasnicMic> electrocasnice = new Vector<>();
        while(resultSet.next())
        {
            electrocasnice.add(new ElectrocasnicMic(resultSet));
        }
        return electrocasnice;
    }

    public static Vector<MasinaDeGatit> GetMasiniDeGatit() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.masina_de_gatit;");
        Vector<MasinaDeGatit> masinaDeGatit = new Vector<>();
        while(resultSet.next())
        {
            masinaDeGatit.add(new MasinaDeGatit(resultSet));
        }
        return  masinaDeGatit;
    }

    public static Adresa GetAdresaForUpdateDelete(Integer id_adresa) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.adresa WHERE id_adresa = " + id_adresa + ";");
        resultSet.next();
        return new Adresa((resultSet));
    }

    public static Frigorific GetFrigorificForUpdateDelete(Integer id_frigorific) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.frigorific WHERE id_frigorific = "
                + id_frigorific + ";");
        resultSet.next();
        return new Frigorific((resultSet));
    }

    public static MasinaDeSpalat GetMasinaDeSpalatForUpdateDelete(Integer id_masina_de_spalat) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.masina_de_spalat WHERE id_masina_de_spalat = "
                + id_masina_de_spalat + ";");
        resultSet.next();
        return new MasinaDeSpalat((resultSet));
    }
    public static ElectrocasnicMic GetElectrocasnicForUpdateDelete(Integer id_electrocasnic) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.electrocasnic_mic WHERE id_electrocasnic_mic = "
                + id_electrocasnic + ";");
        resultSet.next();
        return new ElectrocasnicMic((resultSet));
    }

    public static Produs GetProdusById(Integer id_produs) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.produs WHERE id_produs =" +
                " " + id_produs + ";");
        resultSet.next();
        return new Produs((resultSet));
    }

    public static Produs GetProdusForUpdateDelete(int id_produs) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.produs WHERE id_produs = " + id_produs + ";");
        resultSet.next();
        return new Produs((resultSet));
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

    public static boolean AdaugaFrigorific(Frigorific frigorific) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.frigorific(id_produs, proprietati) VALUES ("
                + frigorific.getId_produs() + ", '" + frigorific.getProprietati() + "');");
        return true;
    }

    public static boolean AdaugaMasinaDeSpalat(MasinaDeSpalat masinaDeSpalat) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.masina_de_spalat(id_produs, proprietati) VALUES (" +
                masinaDeSpalat.getId_produs() + ", '" + masinaDeSpalat.getProprietati() + "');");
        return true;
    }

    public static boolean AdaugaElectrocasnic(ElectrocasnicMic electrocasnicMic) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.electrocasnic_mic(id_produs, proprietati) VALUES ("
                + electrocasnicMic.getId_produs() + ", '" + electrocasnicMic.getProprietati() + "');");
        return true;
    }

    public static boolean AdaugaMasinaDeGatit(MasinaDeGatit masinaDeGatit) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.masina_de_gatit(id_produs, proprietati) VALUES ("
                + masinaDeGatit.getId_produs() + ", '" + masinaDeGatit.getProprietati() + "');");
        return true;
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

    public static void UpdateFrigorific(Frigorific frigorific) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.frigorific SET proprietati = '" + frigorific.getProprietati()  +
                        "' , id_produs = " + frigorific.getId_produs() +
                        " WHERE id_frigorific = " + frigorific.getId_frigorific() + ";"
        );
    }

    public static void UpdateMasinaDeSpalat(MasinaDeSpalat spalat) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.masina_de_spalat SET proprietati = '" + spalat.getProprietati()  +
                        "' , id_produs = " + spalat.getId_produs() +
                        " WHERE id_masina_de_spalat = " + spalat.getId_masina_de_spalat() + ";"
        );
    }



    public static void UpdateElectrocasnic(ElectrocasnicMic electrocasnicMic) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.electrocasnic_mic SET proprietati = '" + electrocasnicMic.getProprietati()  +
                        "' , id_produs = " + electrocasnicMic.getId_produs() +
                        " WHERE id_electrocasnic_mic = " + electrocasnicMic.getId_electrocasnic_mic() + ";"
        );
    }

   /* public static void UpdateProdusForAFrigorific(int id_friforific, int id_produs) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.frigorific SET id_produs = " + id_produs + " WHERE id_frigorific =" + id_friforific + ";"
        );
    }*/


    public static void DeleteAdresa(int id_adresa) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM adresa WHERE id_adresa = " + id_adresa + ";"
        );
    }

    public static void DeleteElectrocasnic(int id_electrocasnic) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM electrocasnic_mic WHERE id_electrocasnic_mic = " + id_electrocasnic + ";"
        );
    }

    public static void DeleteFrigorific(int id_frigorific) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM frigorific WHERE id_frigorific = " + id_frigorific + ";"
        );
    }

    public static void DeleteMasinaDeSpalat(int id_masina_de_spalat) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM public.masina_de_spalat WHERE id_masina_de_spalat = " + id_masina_de_spalat + ";"
        );
    }

    public static void UpdateProdus(Produs produs) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.produs SET nume_produs = '" + produs.getNume_produs()  + "' ,pret = " + produs.getPret()  +
                        " ,stoc = " + produs.getStoc() + " ,specificatii = '" + produs.getSpecificatii() +
                        "' WHERE id_produs = " + produs.getId_produs() + ";"
        );
    }

    public static void DeleteProdus(int id_produs) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM produs WHERE id_produs = " + id_produs + ";"
        );
    }

}
