package ub.edu.model.Strategies.ListStrategy.Pelicula;


import ub.edu.model.cataleg.*;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.*;

public class LlistarPelisByNameStrategy implements ListStrategy<Pelicula> {
    @Override
    public List<Pelicula> executeList(List<Pelicula> pelicules)  {
        List<Pelicula> sortedList = new ArrayList<>(pelicules);
        sortedList.sort(new Comparator<Pelicula>() {
            public int compare(Pelicula a1, Pelicula a2) {
                return (a1.getNom().compareTo(a2.getNom()));
            }
        });

        return sortedList;
    }
}
