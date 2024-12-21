package ub.edu.model.Strategies.ListStrategy.Pelicula;

import ub.edu.model.cataleg.*;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import ub.edu.model.exceptions.*;

import java.util.*;

public class LlistarPelisByEstrenaStrategy implements ListStrategy<Pelicula> {

    @Override
    public List<Pelicula> executeList(List<Pelicula> pelicules) {
        List<Pelicula> llistaCombinada = new ArrayList<>(pelicules);
        llistaCombinada.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int any1 = 0, any2 = 0;

                any1 = ((Pelicula) o1).getAnyEstrena();

                any2 = ((Pelicula) o2).getAnyEstrena();

                // Ordenar en orden ascendente (de más nuevo (grande) a más viejo (pequeño)
                return Integer.compare(any2, any1);
            }
        });
        return llistaCombinada;
    }
}
