package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.List;

public class ContingutLlistar {

    private ListStrategy<ContingutDigital> strategy;

    public void setStrategy(ListStrategy<ContingutDigital> strategy) { this.strategy = strategy;}

    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia");
        }
        return strategy.executeList(contingutDigitals);
    }
}
