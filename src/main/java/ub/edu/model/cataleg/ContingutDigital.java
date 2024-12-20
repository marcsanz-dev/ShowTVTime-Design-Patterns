package ub.edu.model.cataleg;

public abstract class ContingutDigital {
    private String titol;
    private String descripcio;
    private String anyEstrena;
    private int durada;
    private float puntuacio;
    private int numVotants;
    private int numVisualitzacions;
    private String url;
    private String idioma;
    private float valoracioInicial;

    public ContingutDigital() {

    }

    public ContingutDigital(String nom) {
        this.titol = nom;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String nom, int durada) {
        this.titol = nom;
        this.durada = durada;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String titol, String descripcio, String estrena, int durada) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.anyEstrena = estrena;
        this.durada = durada;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String titol, String descripcio, String estrena, int durada, float puntuacio, String url) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.anyEstrena = estrena;
        this.durada = durada;
        this.puntuacio = puntuacio;
        this.url = url;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String titol, String estrena, int durada) {
        this.titol = titol;
        this.durada = durada;
        this.anyEstrena = estrena;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String titol, String estrena, String idioma) {
        this.titol = titol;
        this.idioma = idioma;
        this.anyEstrena = estrena;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String titol, String anyEstrena, String descripcio, String url){
        this.titol = titol;
        this.anyEstrena = anyEstrena;
        this.descripcio = descripcio;
        this.numVisualitzacions = 0;
        this.url = url;
    }

    public ContingutDigital(String titol, String anyEstrena, String descripcio, int durada, float puntuacio, int numVotants, String url, String idioma) {
        this.titol = titol;
        this.anyEstrena = anyEstrena;
        this.descripcio = descripcio;
        this.durada = durada;
        this.puntuacio = puntuacio;
        this.numVotants = numVotants;
        this.url = url;
        this.idioma = idioma;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String titol, String descripcio) {
        this.titol = titol;
        this.descripcio = descripcio;
        this.numVisualitzacions = 0;
    }

    public ContingutDigital(String nom, String descripcio, String url, String anyEstrena, String idioma, int durada, float valoracio) {
        this.titol = nom;
        this.descripcio = descripcio;
        this.url = url;
        this.anyEstrena = anyEstrena;
        this.idioma = idioma;
        this.durada = durada;
        this.valoracioInicial = valoracio;
        this.numVisualitzacions = 0;
    }

    public String getNom() {
        return titol;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public String getAnyEstrena() {
        return anyEstrena;
    }

    public void setAnyEstrena(String anyEstrena) {
        this.anyEstrena = anyEstrena;
    }

    public int getDurada() {
        return durada;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void valorar(int punts) {
        puntuacio = (puntuacio * numVotants + punts) / (numVotants + 1);
        numVotants++;
    }

    public void addVisualitzacio() {
        numVisualitzacions++;
    }

    public int getNumVisualitzacions() {
        return numVisualitzacions;
    }

    public String getUrl() {
        return url;
    }

    public String getIdioma() {
        return idioma;
    }

    public float getValoracioInicial() {
        return valoracioInicial;
    }
}
