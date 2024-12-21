package ub.edu.model.Strategies.ListStrategy.Pelicula;

import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import ub.edu.model.cataleg.Pelicula;

import java.util.List;

public class PeliculaLlistar {

    private ListStrategy<Pelicula> strategy;

    public void setStrategy(ListStrategy<Pelicula> strategy) { this.strategy = strategy;}

    public List<Pelicula> executeList(List<Pelicula> pelicules) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia");
        }
        return strategy.executeList(pelicules);
    }
}
