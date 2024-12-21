package ub.edu.model.Strategies.AccessStrategy;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Persona;
public interface AccessStrategy {

    // Returns true if the follower has access to the group, false otherwise
    boolean executeAccess(Persona follower, GrupInteres group);
}
