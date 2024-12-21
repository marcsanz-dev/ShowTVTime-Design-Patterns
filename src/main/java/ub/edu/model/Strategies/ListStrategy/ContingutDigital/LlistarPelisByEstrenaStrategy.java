package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.cataleg.*;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import ub.edu.model.exceptions.*;

import java.util.*;

public class LlistarPelisByEstrenaStrategy implements ListStrategy<ContingutDigital> {

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        List<ContingutDigital> sortedList = new ArrayList<>();
        for (ContingutDigital c : contingutDigitals) {
            if(c instanceof Pelicula){
                sortedList.add( c);
            }
        }
        sortedList.sort(new Comparator<ContingutDigital>() {
            public int compare(ContingutDigital a1, ContingutDigital a2) {
                return (a2.getAnyEstrena().compareTo(a1.getAnyEstrena()));
            }
        });

        if(sortedList.isEmpty()) throw new NotAvailableMoviesException();
        return sortedList;
    }
}
