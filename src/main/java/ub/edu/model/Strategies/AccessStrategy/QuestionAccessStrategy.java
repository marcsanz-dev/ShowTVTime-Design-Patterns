package ub.edu.model.Strategies.AccessStrategy;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Persona;
import ub.edu.model.quizz.Resposta;

public class QuestionAccessStrategy implements AccessStrategy {

    private Resposta answer;

    public QuestionAccessStrategy(Resposta answer) {
        this.answer = answer;
    }

    @Override
    public boolean executeAccess(Persona follower, GrupInteres group) {
        if (answer.isCorrecta()) {
            follower.memberGrup(group);
            return true;
        }
        return false;
    }
}
