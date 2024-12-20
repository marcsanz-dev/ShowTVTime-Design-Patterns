package ub.edu.model.Carteras;

import ub.edu.controller.MessagesCAT;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.*;

import java.util.*;

public class CarteraContingutDigital implements CarteraContingutDigitalInterface{
    private HashMap<String, Serie> series;
    private HashMap<String, Pelicula> pelicules;

    public CarteraContingutDigital() {
        series = new HashMap<>();
        pelicules = new HashMap<>();
    }

    public CarteraContingutDigital(List<Serie> listSerie, List<Pelicula> listPelicula) {
        series = new HashMap<>();
        pelicules = new HashMap<>();
        for (Serie s : listSerie) {
            series.put(s.getNom(), s);
        }
        for (Pelicula p : listPelicula) {
            pelicules.put(p.getNom(), p);
        }
    }



    public void add(ContingutDigital contingut) {
        if (contingut instanceof Serie) {
            series.put(contingut.getNom(), (Serie)contingut);
        } else if (contingut instanceof Pelicula) {
            pelicules.put(contingut.getNom(), (Pelicula) contingut);
        }
    }

    public ContingutDigital get(String titol) throws ContingutDigitalNotFoundException {
        if (series.containsKey(titol)) {
            return series.get(titol);
        } else if (pelicules.containsKey(titol)) {
            return pelicules.get(titol);
        } else {
            throw new ContingutDigitalNotFoundException();
        }
    }

    public Pelicula getPelicula(String titol) throws ContingutDigitalNotFoundException {
        if (pelicules.containsKey(titol)) {
            return pelicules.get(titol);
        } else {
            throw new ContingutDigitalNotFoundException();
        }
    }

    public Serie getSerie(String titol) throws ContingutDigitalNotFoundException {
        if (series.containsKey(titol)) {
            return series.get(titol);
        } else {
            throw new ContingutDigitalNotFoundException();
        }
    }

    public List<Serie> getSeries() {
        return new ArrayList<>(series.values());
    }

    public void setSeries(List<Serie> series) {
        this.series = new HashMap<>();
        for (Serie s : series) {
            this.series.put(s.getNom(), s);
        }
    }

    public List<Pelicula> getPelicules() {
        return new ArrayList<>(pelicules.values());
    }

    public void setPelicules(List<Pelicula> pelicules) {
        this.pelicules = new HashMap<>();
        for (Pelicula p : pelicules) {
            this.pelicules.put(p.getNom(), p);
        }
    }

    public boolean containsKey(String titol){
        return series.containsKey(titol) || pelicules.containsKey(titol);
    }

    public void delete(ContingutDigital contingut) {
        if (contingut instanceof Serie) {
            series.remove(contingut.getNom());
        } else if (contingut instanceof Pelicula) {
            pelicules.remove(contingut.getNom());
        }
    }

    public void afegirTematicaToPelicula(String titol, Tematica tematica) throws ContingutDigitalNotFoundException {
        if (containsKey(titol)) {
            Pelicula p = (Pelicula) get(titol);
            p.addTematica(tematica);
        } else {
            System.out.println(MessagesCAT.NotAvailableMovieException.getMessage());
        }
    }

    public Episodi getEpisodi(String titolSerie, int numTemporada, int numEpisodi){
        if (series.containsKey(titolSerie)) {
            Serie s = series.get(titolSerie);
            return s.findEpisodi(numTemporada, numEpisodi);
        } else {
            return null;
        }
    }

    public Episodi getEpisodi(String nomEpisodi){
        for (Serie s : series.values()) {
            Episodi e = s.findEpisodi(nomEpisodi);
            if (e!=null) return e;
        }
        return null;
    }

    public List<ContingutDigital> getContingutDigital() {
        List<ContingutDigital> contingutDigitals = new ArrayList<>();
        contingutDigitals.addAll(series.values());
        contingutDigitals.addAll(pelicules.values());
        return contingutDigitals;
    }

    public Temporada findTemporada(String nomSerie, int numTemporada) {
        for (Serie s : series.values()) {
            if (s.getNom().equals(nomSerie)) {
                return s.findTemporada(numTemporada);
            }
        }
        return null;
    }

}
