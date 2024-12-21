package ub.edu.model.Strategies.AccessStrategy;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Persona;

public class ReputationAccessStrategy implements AccessStrategy {
    private final int minReputation = 100;

    @Override
    public boolean executeAccess(Persona follower, GrupInteres group) {
        if (follower.getReputation() >= minReputation) {
            follower.memberGrup(group);
            follower.addReputation(-100);
            return true;
        }
        return false;
    }
}
