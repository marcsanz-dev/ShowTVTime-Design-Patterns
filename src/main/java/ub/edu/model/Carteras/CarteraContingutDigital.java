package ub.edu.model.Carteras;

import ub.edu.controller.MessagesCAT;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.*;

import java.util.*;

public class CarteraContingutDigital implements CarteraContingutDigitalInterface{
    private List<ContingutDigital> contingutDigital;

    public CarteraContingutDigital() {
        contingutDigital = new ArrayList<>();
    }

    public void add(ContingutDigital contingut) {
        contingutDigital.add(contingut);
    }

    public ContingutDigital get(String titol) throws ContingutDigitalNotFoundException {
        for (ContingutDigital contingut : contingutDigital) {
            if (contingut.getNom().equals(titol))
                return contingut;
        }
        throw new ContingutDigitalNotFoundException();
    }

    public List<Serie> getSeries() {
        List<Serie> series = new ArrayList<>();
        for (ContingutDigital c : contingutDigital) {
            if(c instanceof Serie){
                series.add((Serie) c);
            }
        }
        return series;
    }

    public List<Pelicula> getPelicules() {
        List<Pelicula> pelicules = new ArrayList<>();
        for (ContingutDigital c : contingutDigital) {
            if(c instanceof Pelicula){
                pelicules.add((Pelicula) c);
            }
        }
        return pelicules;
    }

    public boolean containsKey(String titol){
        for (ContingutDigital contingut : contingutDigital) {
            if (contingut.getNom().equals(titol))
                return true;
        }
        return false;
    }

    public void delete(ContingutDigital contingut) {
        contingutDigital.remove(contingut);
    }

    public void afegirTematicaToPelicula(String titol, Tematica tematica) throws ContingutDigitalNotFoundException {
        if (containsKey(titol)) {
            Pelicula p = (Pelicula) get(titol);
            p.addTematica(tematica);
        } else {
            System.out.println(MessagesCAT.NotAvailableMovieException.getMessage());
        }
    }

    public List<ContingutDigital> getContingut(){
        return contingutDigital;
    }

}
