package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LlistarContingutByDurationStrategy implements ListStrategy<ContingutDigital> {

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        List<ContingutDigital> llistaCombinada = new ArrayList<>(contingutDigitals);
        llistaCombinada.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int durada1 = 0, durada2 = 0;

                durada1 = ((ContingutDigital) o1).getDurada();

                durada2 = ((ContingutDigital) o2).getDurada();

                // Ordenar en orden ascendente (de más corto a más largo)
                return Integer.compare(durada1, durada2);
            }
        });

        return llistaCombinada;
    }
}
