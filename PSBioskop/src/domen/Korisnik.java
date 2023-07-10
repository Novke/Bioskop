package domen;

import Util.DateParser;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Korisnik implements GenericEntity {
    private long korisnikID;
    private String ime;
    private Date datumRodjenja;

    public Korisnik() {
    }
    public Korisnik(long korisnikID, String ime, Date datumRodjenja) {
        this.korisnikID = korisnikID;
        this.ime = ime;
        this.datumRodjenja = datumRodjenja;
    }

    public long getKorisnikID() {
        return korisnikID;
    }

    public void setKorisnikID(long korisnikID) {
        this.korisnikID = korisnikID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    @Override
    public String toString() {
        return "Korisnik{" +
                "korisnikID=" + korisnikID +
                ", ime='" + ime + '\'' +
                ", datumRodjenja=" + datumRodjenja +
                '}';
    }

    @Override
    public String getTableName() {
        return "korisnik";
    }

    @Override
    public String getColumnNames() {
        return "(korisnikid, ime, datumrodjenja)";
    }

    @Override
    public String getColumnNamesWithoutId() {
        return "(ime, datumrodjenja)";
    }

    @Override
    public String getValues() {
        return "ime = '" + ime + "',datumrodjenja = '" + DateParser.toString(datumRodjenja) + "'";
    }

    @Override
    public String getInsertValues() {
        return "('" + ime + "', '" + DateParser.toString(datumRodjenja) + "')";
    }

    @Override
    public void setId(long id) {
        this.korisnikID = id;
    }

    @Override
    public Long getId() {
        return korisnikID;
    }

    @Override
    public GenericEntity extractFromResultSet(ResultSet rs) throws SQLException {
        Korisnik korisnik = new Korisnik();

        korisnik.setKorisnikID(rs.getLong("korisnikid"));
        korisnik.setIme(rs.getString("ime"));
        korisnik.setDatumRodjenja(rs.getDate("datumrodjenja"));

        return korisnik;
    }

    @Override
    public String getWhereCondition() {
        return "(korisnikid = " + korisnikID + ")";
    }

    @Override
    public String AllDetails() {
        return "KORISNIK: \n"+
                "Ime: " + ime + "\n" +
                "Datum rodjenja: " + DateParser.toString(datumRodjenja);
    }
}
