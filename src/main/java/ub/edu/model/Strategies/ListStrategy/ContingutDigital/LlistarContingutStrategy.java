package ub.edu.model.Strategies.ListStrategy.ContingutDigital;

import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.Strategies.ListStrategy.ListStrategy;

import java.util.ArrayList;
import java.util.List;

public class LlistarContingutStrategy implements ListStrategy<ContingutDigital> {

    @Override
    public List<ContingutDigital> executeList(List<ContingutDigital> contingutDigitals) {
        return new ArrayList<>(contingutDigitals);
    }
}
