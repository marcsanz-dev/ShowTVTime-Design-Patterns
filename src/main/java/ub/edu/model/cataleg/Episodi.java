package ub.edu.model.cataleg;

public class Episodi extends ContingutDigital {

    private String nomSerie;
    private int numTemporada;
    private int numEpisodi;

    public Episodi(String nomSerie, int numTemporada, int numEpisodi, String titolEpisodi, String descripcio, int anyEstrena, int durada, String url, float valoracioInicial) {
        super(titolEpisodi, descripcio, anyEstrena, durada, valoracioInicial, url);
        this.nomSerie = nomSerie;
        this.numTemporada = numTemporada;
        this.numEpisodi = numEpisodi;
    }

    public Episodi(String nomSerie, int numTemporada, int numEpisodi, String titolEpisodi, int durada) {
        super(titolEpisodi, durada);
        this.nomSerie = nomSerie;
        this.numTemporada = numTemporada;
        this.numEpisodi = numEpisodi;
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
}
