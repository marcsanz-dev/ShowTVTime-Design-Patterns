package ub.edu.model.Strategies.ListStrategy.Temporada;

import ub.edu.controller.MessagesCAT;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.cataleg.Pelicula;
import ub.edu.model.cataleg.Temporada;

import java.util.*;

public class LlistarTemporadesStrategy implements ListStrategy<ContingutDigital> {
    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> temporades){
        List<ContingutDigital> sortedList = new ArrayList<>();

        for (ContingutDigital c : temporades) {
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
