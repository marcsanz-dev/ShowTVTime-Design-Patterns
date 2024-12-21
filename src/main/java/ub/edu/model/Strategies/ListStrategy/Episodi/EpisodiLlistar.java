package ub.edu.model.Strategies.ListStrategy.Episodi;

import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.cataleg.Episodi;
import java.util.List;

public class EpisodiLlistar {
    private ListStrategy<ContingutDigital> strategy;

    public void setStrategy(ListStrategy<ContingutDigital> strategy) { this.strategy = strategy;}

    public List<ContingutDigital> executeList(List<ContingutDigital> episodis) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia");
        }
        return strategy.executeList(episodis);
    }
}
