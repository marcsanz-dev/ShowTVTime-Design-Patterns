package ub.edu.model.Strategies.ListStrategy;

import ub.edu.model.cataleg.ContingutDigital;

import java.util.List;

public interface ListStrategy<T> {
    List<T> executeList(List<T> llista);
}
