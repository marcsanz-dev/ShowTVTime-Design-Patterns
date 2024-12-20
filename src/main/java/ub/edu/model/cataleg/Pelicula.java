package ub.edu.model.cataleg;


import ub.edu.model.Carteras.CarteraTema;

public class Pelicula extends  ContingutDigital{
    private String url;
    private String idioma;
    private CarteraTema llistaTematiques;

    public Pelicula(String nom, int estrena, int durada) {
        super(nom, estrena, durada);
        llistaTematiques = new CarteraTema();
    }

    public Pelicula(String titol, String descripcio) {
        super(titol, descripcio);
        this.url = url;
        this.idioma = idioma;
        llistaTematiques = new CarteraTema();
    }

    public Pelicula(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        //Per tal de no modificar el step posant la quantitat de gent que ha votat per tal
        // d'obtenir la valoració, posem un número alt de votants fixe (100)
        super(titol, estrena, descripcio, durada, valoracio, 100);
        this.url = url;
        this.idioma = idioma;
        llistaTematiques = new CarteraTema();
    }

    public void addTematica(Tematica t) {
        this.llistaTematiques.add(t);
    }

    public CarteraTema getTematiques() {
        return llistaTematiques;
    }

    public void setTitol(String titol) {
        super.setTitol(titol);
    }

}
