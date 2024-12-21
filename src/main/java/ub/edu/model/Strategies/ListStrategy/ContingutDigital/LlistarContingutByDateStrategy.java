package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LlistarContingutByDateStrategy implements ListStrategy<ContingutDigital> {

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        List<ContingutDigital> llistaCombinada = new ArrayList<>(contingutDigitals);
        llistaCombinada.sort(new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                int any1 = 0, any2 = 0;

                any1 = ((ContingutDigital) o1).getAnyEstrena();

                any2 = ((ContingutDigital) o2).getAnyEstrena();

                // Ordenar en orden ascendente (de más nuevo (grande) a más viejo (pequeño)
                return Integer.compare(any2, any1);
            }
        });

        return llistaCombinada;
    }
}
