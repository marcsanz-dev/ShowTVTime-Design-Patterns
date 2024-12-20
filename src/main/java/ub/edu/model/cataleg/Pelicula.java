package ub.edu.model.cataleg;


import ub.edu.model.Carteras.CarteraTema;

public class Pelicula extends  ContingutDigital{

    private CarteraTema llistaTematiques;

    public Pelicula(String nom, String estrena, int durada) {
        super(nom, estrena, durada);
        llistaTematiques = new CarteraTema();
    }

    public Pelicula(String titol, String descripcio) {
        super(titol, descripcio);
        llistaTematiques = new CarteraTema();
    }

    //Per tal de no modificar el step posant la quantitat de gent que ha votat per tal
    // d'obtenir la valoració, posem un número alt de votants fixe (100)
    public Pelicula(String titol, String descripcio, String url, String estrena, String idioma, int durada, float valoracio) {
        super(titol, estrena, descripcio, durada, valoracio, 100, url, idioma);
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
