package DataBase;

import Models.Adresa;
import Models.Frigorific;
import Models.MasinaDeSpalat;
import Models.Produs;
import Models.*;

import java.sql.PreparedStatement;
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

    public static Vector<Persoana> GetPersoane() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.persoana;");
        Vector<Persoana> persoana = new Vector<>();
        while(resultSet.next())
        {
            persoana.add(new Persoana(resultSet));
        }
        return persoana;
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
        Vector<MasinaDeGatit> creeazaCont = new Vector<>();
        while(resultSet.next())
        {
            creeazaCont.add(new MasinaDeGatit(resultSet));
        }
        return creeazaCont;
    }

    public static Vector<Comanda> GetComenzi() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.comanda;");
        Vector<Comanda> comenzi = new Vector<>();
        while(resultSet.next())
        {
            comenzi.add(new Comanda(resultSet));
        }
        return comenzi;
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

    public static MasinaDeGatit GetMasinaDeGatitForUpdateDelete(Integer id_masina_de_gatit) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.masina_de_gatit WHERE id_masina_de_gatit = "
                + id_masina_de_gatit + ";");
        resultSet.next();
        return new MasinaDeGatit((resultSet));
    }
    public static ElectrocasnicMic GetElectrocasnicForUpdateDelete(Integer id_electrocasnic) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.electrocasnic_mic WHERE id_electrocasnic_mic = "
                + id_electrocasnic + ";");
        resultSet.next();
        return new ElectrocasnicMic((resultSet));
    }

    public static Comanda GetComandaForUpdateDelete(Integer id_comanda) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.comanda WHERE id_comanda = "
                + id_comanda + ";");
        resultSet.next();
        return new Comanda(resultSet);
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

    public static boolean AdaugaPersoana(Persoana persoana) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.persoana(nume, prenume, id_adresa, email, nr_tel) " +
                "VALUES ('" + persoana.getNume() + "', '" + persoana.getPrenume() + "', '" +
                persoana.getId_adresa() + "', '" + persoana.getEmail() + "', '" + persoana.getNr_tel() + "');");
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

    public static boolean AdaugaComanda(Comanda comanda) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.comanda(id_persoana, id_adresa, data_plasare, " +
                "data_livrare, cost_livrare, pret_total, metoda_plata, este_livrata) VALUES (" + comanda.getId_persoana()
                + ", " + comanda.getId_adresa() +  ", '" + comanda.getData_plasare() +  "', '"
                + comanda.getData_livrare() + "', " + comanda.getPret_total() + ", " + comanda.getCost_livrare()
                + ", '" + comanda.getMetoda_plata() + "', " + comanda.getEste_livrata()+ ");");
        return true;
    }


    public static void UpdateAdresa(Adresa adresa) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.adresa SET judet = '" + adresa.getJudet()  + "' ,localitate = '" + adresa.getLocalitate()  +
                        "' ,strada = '" + adresa.getStrada() + "' ,numar = " + adresa.getNumar() +
                        " ,bloc = " + adresa.getBloc() + " ,scara = '" + adresa.getScara() + "' " +
                        " ,apartament = " + adresa.getApartament() +
                        " WHERE id_adresa = " + adresa.getId_adresa() + ";"
        );
    }

    public static void UpdateComanda(Comanda comanda) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.comanda SET id_persoana = " + comanda.getId_persoana()  + " ,id_adresa = " +
                        comanda.getId_adresa()  +  " ,data_plasare = '" + comanda.getData_plasare() + "' ,data_livrare = '"
                        + comanda.getData_livrare() + "' ,cost_livrare = " + comanda.getCost_livrare() + " ,pret_total = "
                        + comanda.getPret_total() + " " +  " ,metoda_plata = '" + comanda.getMetoda_plata() +
                        "' ,este_livrata = " + comanda.getEste_livrata() +
                        " WHERE id_comanda = " + comanda.getId_comanda() + ";"
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

    public static void UpdateMasinaDeGatit(MasinaDeGatit gatit) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        // ps = "SELECT * FROM ss Where id = ?1"
        // ps.setParameter(1, id)
        statement.executeUpdate(
                "UPDATE public.masina_de_gatit SET proprietati = '" + gatit.getProprietati()  +
                        "' , id_produs = " + gatit.getId_produs() +
                        " WHERE id_masina_de_gatit = " + gatit.getId_masina_de_gatit() + ";"
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

    public static void DeleteComandaProdus(int id_comanda_produs) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM comanda_produs WHERE id_comanda_produs = " + id_comanda_produs + ";"
        );
    }

    public static void DeleteComanda(int id_comanda) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM comanda WHERE id_comanda = " + id_comanda + ";"
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

    public static Persoana GetPersoanaForUpdateDelete(int id_persoana) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.persoana WHERE id_persoana = " + id_persoana + ";");
        resultSet.next();
        return new Persoana(resultSet);
    }

    public static void UpdatePersoana(Persoana persoana) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "UPDATE public.persoana SET nume = '" + persoana.getNume()  +
                        "' , prenume = '" + persoana.getPrenume() + "' , id_adresa = " + persoana.getId_adresa() +
                        ", email = '" + persoana.getEmail() +"' , nr_tel = '" + persoana.getNr_tel() +
                        "' WHERE id_persoana = " + persoana.getId_persoana() + ";"
        );
    }

    public static void DeletePersoana(int id_persoana) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate(
                "DELETE FROM persoana WHERE id_persoana = " + id_persoana + ";"
        );
    }

    public static boolean AdaugaComandaProdus(ComandaProdus comandaProdus) throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        statement.executeUpdate("INSERT INTO public.comanda_produs(id_comanda, id_produs) " +
                "VALUES (" + comandaProdus.getId_comanda() + ", " + comandaProdus.getId_produs() + ");");
        return true;
    }

    public static Vector<ComandaProdus> GetComandaProdus() throws SQLException {
        Statement statement = DatabaseConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM public.comanda_produs;");
        Vector<ComandaProdus> comenziPlasate = new Vector<>();
        while(resultSet.next())
        {
            comenziPlasate.add(new ComandaProdus(resultSet));
        }
        return comenziPlasate;
    }

}
