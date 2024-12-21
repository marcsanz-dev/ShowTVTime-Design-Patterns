package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LlistarByNotWatchedStrategy implements ListStrategy<ContingutDigital> {

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        List<ContingutDigital> llistaCombinada = new ArrayList<>(contingutDigitals);
        // Ordenar por anyPrimeraEstrena (ascendente)
        llistaCombinada.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int any1 = 0, any2 = 0;

                any1 = ((ContingutDigital) o1).getNumVisualitzacions();

                any2 = ((ContingutDigital) o2).getNumVisualitzacions();

                // Ordenar en orden ascendente (de menos visto a más visto)
                return Integer.compare(any1, any2);
            }
        });

        return llistaCombinada;
    }
}
