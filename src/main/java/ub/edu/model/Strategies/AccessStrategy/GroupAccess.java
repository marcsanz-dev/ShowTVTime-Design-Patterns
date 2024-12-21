package ub.edu.model.Strategies.AccessStrategy;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Persona;
import ub.edu.model.exceptions.GrupInteresNotFoundException;

public class GroupAccess {
    private AccessStrategy strategy;

    public void setStrategy(AccessStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean accessGrup(Persona follower, GrupInteres group) {
        if (strategy == null) {
            throw new IllegalStateException("No se ha definido una estrategia");
        }
        return strategy.executeAccess(follower, group);
    }
}

