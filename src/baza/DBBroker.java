/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Knjiga;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import model.Autor;
import model.Zanr;

/**
 *
 * @author Sasa
 */
public class DBBroker {

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
       List<Knjiga> lista=new ArrayList<>();
      
        try { 
            String upit="SELECT * FROM KNJIGA K JOIN AUTOR A ON K.autor_id=A.autor_id;";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs =st.executeQuery(upit);
            while(rs.next()){
                int id=rs.getInt("k.id");
                String naslov=rs.getString("k.naslov");
                int godIzdanja=rs.getInt("k.godina_izdanja");
                String ISBN=rs.getString("k.isbn");
                String zanr=rs.getString("k.zanr");
                Zanr z=Zanr.valueOf(zanr);
                
                int idA=rs.getInt("a.autor_id");
                String ime=rs.getString("a.ime");
                String prezime=rs.getString("a.prezime");
                int godinaRodjenja=rs.getInt("a.godina_rodjenja");
                String biografija=rs.getString("a.biografija");
                
                Autor a=new Autor(idA, ime, prezime, godinaRodjenja, biografija);
                Knjiga k=new Knjiga(id,naslov,a,godIzdanja,ISBN,z);
                lista.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lista;
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        List<Autor> lista=new ArrayList<>();
      
        try { 
            String upit="SELECT * FROM AUTOR A";
            Statement st=Konekcija.getInstance().getConnection().createStatement();
            ResultSet rs =st.executeQuery(upit);
            while(rs.next()){
                int idA=rs.getInt("a.autor_id");
                String ime=rs.getString("a.ime");
                String prezime=rs.getString("a.prezime");
                int godinaRodjenja=rs.getInt("a.godina_rodjenja");
                String biografija=rs.getString("a.biografija");
                
                Autor a=new Autor(idA, ime, prezime, godinaRodjenja, biografija);
                
                lista.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return lista;
    }

    public void obrisiKnjigu(int id) {
        try{
            String upit="DELETE FROM KNJIGA WHERE ID=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1,id);
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
        }catch(SQLException ex){
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
        
        try{
            String upit="INSERT INTO KNJIGA (ID,NASLOV,GODINA_IZDANJA,AUTOR_ID,ZANR,ISBN)"
                + " VALUES(?,?,?,?,?,?)";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setInt(1,novaKnjiga.getId());
            ps.setString(2,novaKnjiga.getNaziv());
            ps.setInt(3,novaKnjiga.getGodinaIzdanja());
            ps.setInt(4,novaKnjiga.getAutor().getId());
            ps.setString(5,String.valueOf(novaKnjiga.getZanr()));
            ps.setString(6,novaKnjiga.getISBN());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            System.out.println("KNJIGA JE USPESNO DODATA U BAZU");
        }catch(SQLException ex){
           Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
        try{
            String upit="UPDATE KNJIGA SET NASLOV=?, GODINA_IZDANJA=?, AUTOR_ID=?, ZANR=? WHERE ID=?";
            PreparedStatement ps=Konekcija.getInstance().getConnection().prepareStatement(upit);
            ps.setString(1,knjigaZaIzmenu.getNaziv());
            ps.setInt(2,knjigaZaIzmenu.getGodinaIzdanja());
            ps.setInt(3,knjigaZaIzmenu.getAutor().getId());
            ps.setString(4,String.valueOf(knjigaZaIzmenu.getZanr()));
            ps.setInt(5,knjigaZaIzmenu.getId());
            ps.executeUpdate();
            Konekcija.getInstance().getConnection().commit();
            System.out.println("KNJIGA JE USPESNO AZURIRANO U BAZI");
        }catch(SQLException ex){
           Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex); 
        }
    }
}
