/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.ArrayList;
import java.util.List;
import model.Autor;
import model.Knjiga;
import static model.Zanr.Roman;

/**
 *
 * @author Sasa
 */
public class Controller {
    private List <Knjiga> listaKnjiga;
    private List <Autor> listaAutora;
    private DBBroker dbb;
    
    private static Controller instance;
    public static Controller getInstance(){
        if(instance==null){
            instance=new Controller();
        }
        return instance;
    }
    
    private Controller() {
        dbb=new DBBroker();
        Autor autor1=new Autor("Ivo","Andric",1892,"biografija");
        Autor autor2=new Autor("Mesa","Selimovic",1910,"rodjen u BIH");
        Autor autor3=new Autor("Danilo","Kis",1935,"biografija");
        
        Knjiga knjiga1=new Knjiga("Na Drini cuprija",autor1,1945,"123456",Roman);
        Knjiga knjiga2=new Knjiga("Tvrdjava",autor2,1970,"789012",Roman);
        Knjiga knjiga3=new Knjiga("Basta,pepeo",autor3,1982,"345678",Roman);
        
        listaKnjiga=new ArrayList<>();
        listaAutora=new ArrayList<>();
        
        listaKnjiga.add(knjiga1);
        listaKnjiga.add(knjiga2);
        listaKnjiga.add(knjiga3);
        
        listaAutora.add(autor1);
        listaAutora.add(autor2);
        listaAutora.add(autor3);
    }

    public List<Knjiga> getListaKnjiga() {
        return listaKnjiga;
    }

    public void setListaKnjiga(List<Knjiga> listaKnjiga) {
        this.listaKnjiga = listaKnjiga;
    }

    public List<Autor> getListaAutora() {
        return listaAutora;
    }

    public void setListaAutora(List<Autor> listaAutora) {
        this.listaAutora = listaAutora;
    }

    public void obrisiKnjigu(int id) {
        dbb.obrisiKnjigu(id);
    }

    public void dodajKnjigu(Knjiga novaKnjiga) {
       dbb.dodajKnjigu(novaKnjiga);
    //listaKnjiga.add(novaKnjiga);
    //    System.out.println("Knjiga uspesno dodata!");
    //    System.out.println(listaKnjiga);
    }

    public List<Knjiga> ucitajListuKnjigaIzBaze() {
        return dbb.ucitajListuKnjigaIzBaze();
    }

    public List<Autor> ucitajListuAutoraIzBaze() {
        return dbb.ucitajListuAutoraIzBaze();
    }

    public void azurirajKnjigu(Knjiga knjigaZaIzmenu) {
       dbb.azurirajKnjigu(knjigaZaIzmenu);
    }
    
    
}
