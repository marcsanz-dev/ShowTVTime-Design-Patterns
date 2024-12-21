package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.Carteras.CarteraTema;
import ub.edu.model.cataleg.*;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LlistarPelisByTematicaStrategy implements ListStrategy<ContingutDigital> {

    private String tematica;

    public LlistarPelisByTematicaStrategy(String tematica) { this.tematica = tematica; }

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        List<ContingutDigital> sortedList = new ArrayList<>();
        for (ContingutDigital c : contingutDigitals) {
            if(c instanceof Pelicula){
                CarteraTema tematiques = c.getTematiques();
                if (tematiques.containsKey(tematica)) {
                    sortedList.add(c);
                }
            }
        }
        return sortedList;
    }
}
