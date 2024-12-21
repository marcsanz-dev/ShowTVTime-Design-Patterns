package ub.edu.model.Strategies.ListStrategy.Serie;

import ub.edu.model.cataleg.*;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.*;

public class LlistarSeriesByNameStrategy implements ListStrategy<Serie> {

    @Override
    public List<Serie> executeList(List<Serie> contingutDigitals) {
        List<Serie> sortedList = new ArrayList<>(contingutDigitals);
        sortedList.sort(new Comparator<Serie>() {
            public int compare(Serie a1, Serie a2) {
                return (a1.getNom().compareTo(a2.getNom()));
            }
        });

        return sortedList;
    }
}
