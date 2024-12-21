package ub.edu.model.Strategies.ListStrategy.Temporada;

import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.cataleg.Temporada;
import java.util.List;

public class TemporadaLlistar {
    private ListStrategy<ContingutDigital> strategy;

    public void setStrategy(ListStrategy<ContingutDigital> strategy) { this.strategy = strategy;}

    public List<ContingutDigital> executeList(List<ContingutDigital> temporadas) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia");
        }
        return strategy.executeList(temporadas);
    }
}
