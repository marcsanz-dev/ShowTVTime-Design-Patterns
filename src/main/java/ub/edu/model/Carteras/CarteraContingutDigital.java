package ub.edu.model.Carteras;

import ub.edu.controller.MessagesCAT;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.*;

import java.util.*;

public class CarteraContingutDigital implements CarteraContingutDigitalInterface{
    private HashMap<String, ContingutDigital> contingut;

    public CarteraContingutDigital() {
        contingut = new HashMap<>();
    }

    public CarteraContingutDigital(List<Serie> listSerie, List<Pelicula> listPelicula) {
        contingut = new HashMap<>();
        for (Serie s : listSerie) {
            contingut.put(s.getNom(), s);
        }
        for (Pelicula p : listPelicula) {
            contingut.put(p.getNom(), p);
        }
    }



    public void add(ContingutDigital contingut) {
        this.contingut.put(contingut.getNom(), contingut);
    }

    public ContingutDigital get(String titol) throws ContingutDigitalNotFoundException {
        if (contingut.containsKey(titol)) {
            return contingut.get(titol);
        } else {
            throw new ContingutDigitalNotFoundException();
        }
    }

    public Pelicula getPelicula(String titol) throws ContingutDigitalNotFoundException {
        if (contingut.containsKey(titol)) {
            return (Pelicula) contingut.get(titol);
        } else {
            throw new ContingutDigitalNotFoundException();
        }
    }

    public Serie getSerie(String titol) throws ContingutDigitalNotFoundException {
        if (contingut.containsKey(titol)) {
            return (Serie) contingut.get(titol);
        } else {
            throw new ContingutDigitalNotFoundException();
        }
    }

    public List<Serie> getSeries() {
        List<Serie> series = new ArrayList<>();
        for(ContingutDigital c : contingut.values()) {
            if (c instanceof Serie) series.add((Serie) c);
        }
        return series;
    }

    public void setSeries(List<Serie> series) {
        for (Serie s : series) {
            contingut.put(s.getNom(), s);
        }
    }

    public List<Pelicula> getPelicules() {
        List<Pelicula> pelicules = new ArrayList<>();
        for(ContingutDigital c : contingut.values()) {
            if (c instanceof Pelicula) pelicules.add((Pelicula) c);
        }
        return pelicules;
    }

    public void setPelicules(List<Pelicula> pelicules) {
        for (Pelicula p : pelicules) {
            contingut.put(p.getNom(), p);
        }
    }

    public boolean containsKey(String titol){
        return contingut.containsKey(titol);
    }

    public void delete(ContingutDigital contingut) {
        this.contingut.remove(contingut.getNom());
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
        for (ContingutDigital c : contingut.values()) {
            if (c instanceof Serie) {
                Serie s = (Serie) c;
                if (s.getNom().equals(titolSerie)) {
                    return s.findEpisodi(numTemporada, numEpisodi);
                }
            }
        }
        return null;
    }

    public Episodi getEpisodi(String nomEpisodi){
        for (ContingutDigital c : contingut.values()) {
            if (c instanceof Serie) {
                Serie s = (Serie) c;
                return s.findEpisodi(nomEpisodi);
            }
        }
        return null;
    }

    public List<ContingutDigital> getContingutDigital() {
        return new ArrayList<>(contingut.values());
    }

    public Temporada findTemporada(String nomSerie, int numTemporada) {
        for (ContingutDigital c : contingut.values()) {
            if (c instanceof Serie) {
                Serie s = (Serie) c;
                if (s.getNom().equals(nomSerie)) {
                    return s.findTemporada(numTemporada);
                }
            }
        }
        return null;
    }

    public boolean esPelicula(String titol) {
        return contingut.get(titol) instanceof Pelicula;
    }

    public List<ContingutDigital> getTop10Valorades(){
        List<ContingutDigital> top10 = new ArrayList<>(contingut.values());
        Collections.sort(top10, new Comparator<ContingutDigital>() {
            @Override
            public int compare(ContingutDigital o1, ContingutDigital o2) {
                return Float.compare(o2.getValoracio(), o1.getValoracio());
            }
        });
        return top10.subList(0, 10);
    }

    public List<ContingutDigital> getTop10Imdb(){
        List<ContingutDigital> top10 = new ArrayList<>(contingut.values());
        Collections.sort(top10, new Comparator<ContingutDigital>() {
            @Override
            public int compare(ContingutDigital o1, ContingutDigital o2) {
                return Float.compare(o2.getValoracioIMDb(), o1.getValoracioIMDb());
            }
        });
        return top10.subList(0, 10);
    }

}
