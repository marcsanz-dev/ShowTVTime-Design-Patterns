package ub.edu.model.Strategies.ListStrategy.Pelicula;

import ub.edu.model.Carteras.CarteraTema;
import ub.edu.model.cataleg.*;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LlistarPelisByTematicaStrategy implements ListStrategy<Pelicula> {

    private String tematica;

    public LlistarPelisByTematicaStrategy(String tematica) { this.tematica = tematica; }

    @Override
    public List<Pelicula> executeList(List<Pelicula> pelicules) {
        List<Pelicula> sortedList = new ArrayList<>();
        for (Pelicula p : pelicules) {
            List<Tematica> tematiques = p.getTematiques();

            for (Tematica t : tematiques) {
                if (t.getNomTematica().equals(tematica)) {
                    sortedList.add(p);
                }
            }
        }
        sortedList.sort(new Comparator<Pelicula>() {
            public int compare(Pelicula a1, Pelicula a2) {
                return (a1.getNom().compareTo(a2.getNom()));
            }
        });
        return sortedList;
    }
}
