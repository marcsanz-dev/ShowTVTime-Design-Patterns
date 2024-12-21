package ub.edu.model.Strategies.AccessStrategy;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Persona;

public class CodeAccessStrategy implements AccessStrategy {

    private String code;

    public CodeAccessStrategy(String code) {
        this.code = code;
    }

    @Override
    public boolean executeAccess(Persona follower, GrupInteres group) {
        if (code != null && group.getCodiAcces().equals(code)) {
            follower.memberGrup(group);
            follower.addReputation(150);
            return true;
        }
        return false;
    }
}
