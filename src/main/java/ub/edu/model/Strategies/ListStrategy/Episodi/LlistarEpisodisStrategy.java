package ub.edu.model.Strategies.ListStrategy.Episodi;

import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.cataleg.Episodi;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LlistarEpisodisStrategy implements ListStrategy<ContingutDigital> {

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> episodis) {
        List<ContingutDigital> episodisSorted = new ArrayList<>(episodis);

        episodisSorted.sort(new Comparator<ContingutDigital>() {
            public int compare(ContingutDigital a1, ContingutDigital a2) {
                return (Integer.compare(((Episodi)a1).getNumEpisodi(), ((Episodi)a2).getNumEpisodi()));
            }
        });

        return episodisSorted;
    }
}
