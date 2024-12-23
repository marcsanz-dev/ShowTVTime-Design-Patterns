package ub.edu.model;

import ub.edu.model.Carteras.CarteraContingutDigital;
import ub.edu.model.Carteras.CarteraGrupInteres;
import ub.edu.model.Carteras.CarteraTema;
import ub.edu.model.Strategies.ListStrategy.ContingutDigital.ContingutLlistar;
import ub.edu.model.Strategies.ListStrategy.Pelicula.LlistarPelisByEstrenaStrategy;
import ub.edu.model.Strategies.ListStrategy.Pelicula.LlistarPelisByNameStrategy;
import ub.edu.model.Strategies.ListStrategy.Pelicula.LlistarPelisByTematicaStrategy;
import ub.edu.model.Strategies.ListStrategy.Pelicula.PeliculaLlistar;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.NotAvailableGroupException;
import ub.edu.model.exceptions.NotAvailableMovieException;
import ub.edu.model.exceptions.NotAvailableShowException;

import java.util.*;

public class ShowTVTimeCataleg {
    private CarteraContingutDigital llistaContingutDigital;
    private CarteraTema llistaTematiques;
    private CarteraGrupInteres llistaGrupsInteres;
    private PeliculaLlistar peliculaLlistar;


    public ShowTVTimeCataleg(){
        llistaContingutDigital = new CarteraContingutDigital();
        llistaTematiques = new CarteraTema();
        llistaGrupsInteres = new CarteraGrupInteres();
        peliculaLlistar = new PeliculaLlistar();
    }
    // Creador el ImUB

    public ShowTVTimeCataleg(List<Serie> llistaSeries, List<Pelicula> llistaPelicules, List<Tematica> llistaTematiques, List<GrupInteres> llistaGrupsInteres) {

        this.llistaContingutDigital = new CarteraContingutDigital(llistaSeries, llistaPelicules);
        this.llistaTematiques = new CarteraTema(llistaTematiques);
        this.llistaGrupsInteres = new CarteraGrupInteres(llistaGrupsInteres);
    }

    public void setLlistaSeries(List<Serie> llistaSeries) {
        this.llistaContingutDigital.setSeries(llistaSeries);
    }

    public void setLlistaPelicules(List<Pelicula> llistaPelicules) {
        this.llistaContingutDigital.setPelicules(llistaPelicules);
    }


    public void setLlistaTematiques(List<Tematica> llistaTematiques) {
        this.llistaTematiques.setLlistaTemes(llistaTematiques);
    }


    public void setLlistaGrupsInteres(List<GrupInteres> llistaGrupsInteres) {
        this.llistaGrupsInteres.setGrupsInteres(llistaGrupsInteres);
    }

    public ContingutDigital findContingutDigital(String nomContingut){
        try {
            return llistaContingutDigital.get(nomContingut);
        } catch (Exception e) {
            return null;
        }
    }

    public Tematica findTematica(String nomTematica) {
        try {
            return llistaTematiques.get(nomTematica);
        } catch (Exception e) {
            return null;
        }
    }
    public Pelicula findPelicula(String nomPeli) {
        try {
            return llistaContingutDigital.getPelicula(nomPeli);
        } catch (Exception e) {
            return null;
        }
    }

    public Serie findSerie(String nomSerie) {
        try {
            return llistaContingutDigital.getSerie(nomSerie);
        } catch (Exception e) {
            return null;
        }
    }

    public GrupInteres findGrupInteres(String nomGrup) throws Exception {
        return llistaGrupsInteres.get(nomGrup);
    }

    public  Episodi findEpisodi(String nomSerie, int numTemporada, int numEpisodi) {
        return llistaContingutDigital.getEpisodi(nomSerie, numTemporada, numEpisodi);
    }

    public  Episodi findEpisodi(String nomEpisodi) {
        return llistaContingutDigital.getEpisodi(nomEpisodi);
    }
    public List<Tematica> getAllTematiques() {
        return llistaTematiques.getTemes();
    }

    public List<Pelicula> getAllPelicules() {
        return llistaContingutDigital.getPelicules();
    }

    public List<Serie> getAllSeries() {
        return llistaContingutDigital.getSeries();
    }

    public List<GrupInteres> getAllGrupsInteres() {
        return llistaGrupsInteres.getGrupsInteres();
    }

    public List<ContingutDigital> getAllContingutsDigitals() {
        return llistaContingutDigital.getContingutDigital();
    }

    public boolean esPelicula(String nomContingut) {
        return llistaContingutDigital.esPelicula(nomContingut);
    }

    public Temporada findTemporada(String nomSerie, int numTemporada) {
        return llistaContingutDigital.findTemporada(nomSerie, numTemporada);
    }

    public List<HashMap<Object, Object>> getLlistaNomsPelicules(List<Pelicula> sortedList) {
        List<HashMap<Object, Object>> pelisDisponibles = new ArrayList<>();
        for (Pelicula p : sortedList) {
            HashMap<Object, Object> atributPelicula = new HashMap<>();
            String nom = p.getNom();
            atributPelicula.put("nom", nom);
            pelisDisponibles.add(atributPelicula);
        }
        return pelisDisponibles;
    }

    public List<HashMap<Object, Object>> getAllPeliculesPerEstrena() {
        peliculaLlistar.setStrategy(new LlistarPelisByEstrenaStrategy());
        return getLlistaNomsPelicules(peliculaLlistar.executeList(llistaContingutDigital.getPelicules()));
    }

    public List<HashMap<Object, Object>> getAllPeliculesPerNom() {
        peliculaLlistar.setStrategy(new LlistarPelisByNameStrategy());
        return getLlistaNomsPelicules(peliculaLlistar.executeList(llistaContingutDigital.getPelicules()));
    }

    public void addPelicula(String nom,  int estrena, int durada) {
        Pelicula p = new Pelicula(nom, estrena, durada);
        llistaContingutDigital.add(p);
    }

    public void addSerie(String nom,  int estrena) {
        Serie s = new Serie(nom, estrena);
        llistaContingutDigital.add(s);
    }
    public void addSerie(String nomSerie, String descripcio, String url, int anyEstrena,
                            String idioma, int durada) {
        Serie s = new Serie(nomSerie, descripcio, url, anyEstrena, idioma, durada);
        llistaContingutDigital.add(s);
    }

    public void addTemporada (String nomSerie, int numTemporada) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();
        } else {
            serie.addTemporada(numTemporada);
        }
    }

    public Iterable<String> visualitzarTemporadesSerie(String nomSerie) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();
        } else {
            return serie.visualitzarTemporadesSerie();
        }
    }

    public void addEpisodi(String nomSerie, int numTemporada, int numEpisodi, String títolEpisodi, int durada) throws Exception{
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();
        } else {
            serie.addEpisodiToTemporada(numTemporada, numEpisodi, títolEpisodi, durada);
        }
    }

    public Iterable<String> visualitzaEpisodisTemporadaSerie(String nomSerie, int numTemporada) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie == null) {
            throw new NotAvailableShowException();

        } else {
            return serie.visualitzarEpisodisTemporada(numTemporada);
        }
    }

    public void addTematica(String tematica) {
        Tematica t = new Tematica(tematica);
        llistaTematiques.add(t);
    }

    public void addPelicula(String titol, String descripcio, String url, int estrena, String idioma, int durada, float valoracio) {
        Pelicula p = new Pelicula(titol, descripcio, url, estrena, idioma, durada, valoracio);
        llistaContingutDigital.add(p);
    }

    public void addTematicaToPelicula(String titol, String tematica) throws Exception {
        Pelicula p = findPelicula(titol);
        if (p!=null) {
            p.addTematica(findTematica(tematica));
        } else {
            throw new NotAvailableMovieException();
        }
    }

    public List<HashMap<Object, Object>> visualitzarPelisPerTematica(String nomTematica) throws Exception{
        peliculaLlistar.setStrategy(new LlistarPelisByTematicaStrategy(nomTematica));
        return getLlistaNomsPelicules(peliculaLlistar.executeList(llistaContingutDigital.getPelicules()));

    }

    public void removeTemporada(String nomSerie, int numTemporada) throws Exception {
        Serie serie = findSerie(nomSerie);
        if (serie != null) {
            serie.removeTemporada(numTemporada);
        } else {
            throw new NotAvailableShowException();
        }
    }

    public void addGrup(String s, String descripcio) {
        GrupInteres g = new GrupInteres(s, descripcio);
        llistaGrupsInteres.add(g);
    }


    public Iterable<String> visualitzarGrupsPerNom() throws Exception {
        ArrayList<String> grupsDisponibles = new ArrayList<>();

        for (GrupInteres grup : getGrupsList()) {
            grupsDisponibles.add(grup.getNom());
        }
        Collections.sort(grupsDisponibles);

        return grupsDisponibles;

    }

    private List<GrupInteres> getGrupsList() throws NotAvailableGroupException {
        List<GrupInteres> grups = llistaGrupsInteres.getGrupsInteres();
        if(grups != null) return grups;
        else throw new NotAvailableGroupException();
    }

    public void afegirSerie2Grup(String grup, String serie) throws Exception{
        GrupInteres gr = findGrupInteres(grup);
        if (gr == null) {
            throw new NotAvailableGroupException();
        }
        gr.addContingutDigital(findSerie(serie));
    }



    public GrupInteres findGrup(String nomGrup) throws Exception {
        return llistaGrupsInteres.get(nomGrup);
    }

    public List<HashMap<Object, Object>> getAllGrupsInteresPerNom() {
        List<HashMap<Object, Object>> GrupsInteresDisponibles = new ArrayList<>();
        for (GrupInteres c : getAllGrupsInteres()) {
            HashMap<Object, Object> atributGrupInteres = new HashMap<>();
            String nom = c.getNom();
            atributGrupInteres.put("nom", nom);
            GrupsInteresDisponibles.add(atributGrupInteres);
        }
        return GrupsInteresDisponibles;
    }

    public List<HashMap<Object, Object>> getAllSeriesPerNom() {
        List<HashMap<Object, Object>> seriesDisponibles = new ArrayList<>();
        for (Serie s : getAllSeries()) {
            HashMap<Object, Object> atributSerie = new HashMap<>();
            String nom = s.getNom();
            atributSerie.put("nom", nom);
            seriesDisponibles.add(atributSerie);
        }
        return seriesDisponibles;
    }
}
