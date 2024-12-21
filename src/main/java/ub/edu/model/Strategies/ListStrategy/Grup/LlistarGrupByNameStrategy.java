package ub.edu.model.Strategies.ListStrategy.Grup;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LlistarGrupByNameStrategy implements ListStrategy<GrupInteres> {
    @Override
    public List<GrupInteres> executeList(List<GrupInteres> grupsInteres){
        List<GrupInteres> sortedList = new ArrayList<>(grupsInteres);

        sortedList.sort(new Comparator<GrupInteres>() {
            public int compare(GrupInteres a1, GrupInteres a2) {
                return (a1.getNom().compareTo(a2.getNom()));
            }
        });

        return sortedList;
    }
}
