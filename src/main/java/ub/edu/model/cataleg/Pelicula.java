package ub.edu.model.cataleg;


import ub.edu.model.Carteras.CarteraTema;

public class Pelicula extends  ContingutDigital{

    public Pelicula(String nom, int estrena, int durada) {
        super(nom, estrena, durada);
    }

    public Pelicula(String titol, String descripcio) {
        super(titol, descripcio);
    }

    //Per tal de no modificar el step posant la quantitat de gent que ha votat per tal
    // d'obtenir la valoració, posem un número alt de votants fixe (100)
    public Pelicula(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        super(titol, estrena, descripcio, durada, valoracio, 100, url, idioma);
    }
}
