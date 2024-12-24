package ub.edu.model.cataleg;

import ub.edu.model.Carteras.CarteraTema;

import java.util.List;

public abstract class ContingutDigital {
    private String titol;
    private String descripcio;
    private int  anyEstrena;
    private int durada;
    private String url;
    private String idioma;
    private CarteraTema tematiques;

    private float valoracioIMDb;
    private float puntuacio;
    private int numVotants_punts;
    private float puntuacio_estrelles;
    private int numVotants_estrelles;
    private int likes;
    private int dislikes;

    public ContingutDigital() {
       this.tematiques = new CarteraTema();
       this.numVotants_punts = 0;
    }

    public ContingutDigital(String nom) {
        this.titol = nom;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String nom, int durada) {
        this.titol = nom;
        this.durada = durada;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String titol, String descripcio, int estrena, int durada) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.anyEstrena = estrena;
        this.durada = durada;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String titol, String descripcio, int estrena, int durada, float puntuacio, String url) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.anyEstrena = estrena;
        this.durada = durada;
        this.valoracioIMDb = puntuacio;
        this.url = url;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String titol, int estrena, int durada) {
        this.titol = titol;
        this.durada = durada;
        this.anyEstrena = estrena;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String titol, int estrena, String idioma) {
        this.titol = titol;
        this.idioma = idioma;
        this.anyEstrena = estrena;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String titol, int anyEstrena, String descripcio, String url){
        this.titol = titol;
        this.anyEstrena = anyEstrena;
        this.descripcio = descripcio;
        this.url = url;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String titol, int anyEstrena, String descripcio, int durada, float puntuacio, String url, String idioma) {
        this.titol = titol;
        this.anyEstrena = anyEstrena;
        this.descripcio = descripcio;
        this.durada = durada;
        this.valoracioIMDb = puntuacio;
        this.url = url;
        this.idioma = idioma;
        this.tematiques = new CarteraTema();
    }

    public ContingutDigital(String titol, String descripcio) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public ContingutDigital(String nom, String descripcio, String url, int anyEstrena, String idioma, int durada, float valoracio) {
        this.titol = nom;
        this.descripcio = descripcio;
        this.url = url;
        this.anyEstrena = anyEstrena;
        this.idioma = idioma;
        this.durada = durada;
        this.valoracioIMDb = valoracio;
        this.tematiques = new CarteraTema();
        this.numVotants_punts = 0;
    }

    public String getNom() {
        return titol;
    }

    public void setNom(String nom) {
        this.titol = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public int getAnyEstrena() {
        return anyEstrena;
    }

    public void setAnyEstrena(int anyEstrena) {
        this.anyEstrena = anyEstrena;
    }

    public int getDurada() {
        return durada;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void valorar(int punts) {
        puntuacio = (puntuacio * numVotants_punts + punts) / (numVotants_punts + 1);
        numVotants_punts++;
    }

    public void valorar_estrelles(int punts) {
        puntuacio_estrelles = (puntuacio_estrelles * numVotants_estrelles + punts) / (numVotants_estrelles + 1);
        numVotants_estrelles++;
    }

    public void like() {
        likes++;
    }

    public void dislike() {
        dislikes++;
    }

    public String getUrl() {
        return url;
    }

    public String getIdioma() {
        return idioma;
    }

    public float getValoracioIMDb() {
        return valoracioIMDb;
    }


    public void addTematica(Tematica t) {
        this.tematiques.add(t);
    }

    public List<Tematica> getTematiques() {
        return tematiques.getTemes();
    }

}
