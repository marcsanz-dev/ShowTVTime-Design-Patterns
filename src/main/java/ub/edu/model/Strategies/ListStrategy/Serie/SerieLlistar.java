package ub.edu.model.Strategies.ListStrategy.Serie;

import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import ub.edu.model.cataleg.Serie;

import java.util.List;

public class SerieLlistar {
    private ListStrategy<Serie> strategy;

    public void setStrategy(ListStrategy<Serie> strategy) { this.strategy = strategy;}

    public List<Serie> executeList(List<Serie> series) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia");
        }
        return strategy.executeList(series);
    }
}
