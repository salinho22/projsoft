/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Sasa
 */
public class Knjiga {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String naziv;
    private Autor autor;
    private int godinaIzdanja;
    private String ISBN;
    private Zanr zanr;

    public String getNaziv() {
        return naziv;
    }

    public Autor getAutor() {
        return autor;
    }

    public int getGodinaIzdanja() {
        return godinaIzdanja;
    }

    public String getISBN() {
        return ISBN;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setGodinaIzdanja(int godinaIzdanja) {
        this.godinaIzdanja = godinaIzdanja;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setZanr(Zanr zanr) {
        this.zanr = zanr;
    }

    public Knjiga() {
        
    }

    public Knjiga(String naziv, Autor autor, int godinaIzdanja, String ISBN, Zanr zanr) {
        this.naziv = naziv;
        this.autor = autor;
        this.godinaIzdanja = godinaIzdanja;
        this.ISBN = ISBN;
        this.zanr = zanr;
    }

    public Knjiga(int id, String naziv, Autor autor, int godinaIzdanja, String ISBN, Zanr zanr) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
        this.godinaIzdanja = godinaIzdanja;
        this.ISBN = ISBN;
        this.zanr = zanr;
    }
    
    
    
    
}
