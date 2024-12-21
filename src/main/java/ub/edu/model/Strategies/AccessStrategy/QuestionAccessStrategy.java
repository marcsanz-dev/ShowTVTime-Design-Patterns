package ub.edu.model.Strategies.AccessStrategy;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Persona;

public class QuestionAccessStrategy implements AccessStrategy {

    private String answer;

    public QuestionAccessStrategy(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean executeAccess(Persona follower, GrupInteres group) {
        if (group.getJoc().comprovarResposta(answer)) {
            follower.memberGrup(group);
            return true;
        }
        return false;
    }
}
