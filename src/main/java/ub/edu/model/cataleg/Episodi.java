package ub.edu.model.cataleg;

public class Episodi {

    private String nomSerie;
    private int numTemporada;
    private int numEpisodi;
    private String titolEpisodi;
    private int durada;
    private String descripcio;
    private float valoracioInicial;
    private String url;
    private int anyEstrena;

    public Episodi(String nomSerie, int numTemporada, int numEpisodi, String titolEpisodi, int durada) {
        this.nomSerie = nomSerie;
        this.numTemporada = numTemporada;
        this.numEpisodi = numEpisodi;
        this.titolEpisodi = titolEpisodi;
        this.durada = durada;
    }

    public String getNom() {
        return nomSerie;
    }

    public int getNumTemporada() {
        return numTemporada;
    }

    public int getNumEpisodi() {
        return numEpisodi;
    }

    public String getTitolEpisodi() {
        return titolEpisodi;
    }

    public int getDurada() {
        return durada;
    }

    public void setTitolEpisodi(String nom) {
        this.titolEpisodi = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public float getValoracioInicial() {
        return valoracioInicial;
    }

    public String getUrl() {
        return url;
    }

    public int getAnyEstrena() {
        return anyEstrena;
    }
}
