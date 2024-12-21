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
        // Ordenar por anyPrimeraEstrena (descendente)
        llistaCombinada.sort(new Comparator<ContingutDigital>() {
            public int compare(ContingutDigital a1, ContingutDigital a2) {
                return (a2.getAnyEstrena().compareTo(a1.getAnyEstrena()));
            }
        });

        return llistaCombinada;
    }
}
