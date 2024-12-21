package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.cataleg.*;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.*;

public class LlistarSeriesByNameStrategy implements ListStrategy<ContingutDigital> {

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        List<ContingutDigital> sortedList = new ArrayList<>();
        for (ContingutDigital c : contingutDigitals) {
            if(c instanceof Pelicula){
                sortedList.add(c);
            }
        }
        sortedList.sort(new Comparator<ContingutDigital>() {
            public int compare(ContingutDigital a1, ContingutDigital a2) {
                return (a1.getNom().compareTo(a2.getNom()));
            }
        });

        return sortedList;
    }
}
