package ub.edu.model.Strategies.AccessStrategy;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.Persona;
import ub.edu.model.exceptions.GrupInteresNotFoundException;

public class RouletteAccessStrategy implements AccessStrategy {

    private int dice = -1;

    public RouletteAccessStrategy() {
    }

    public RouletteAccessStrategy(int dice) {
        this.dice = dice;
    }

    @Override
    public boolean executeAccess(Persona follower, GrupInteres group) {

        if(dice == -1) {
            dice = (int) (Math.random() * 3) + 1;
        }


        switch (dice) {
                //Segueixes sent follower
            case 1:
                return false;
                //Deixes de seguir el grup
            case 2:
                follower.unfollowGrupInteres(group);
                return false;
                //Et fas membre del grup
            case 3:
                follower.memberGrup(group);
                return true;
            default:
                return false;
        }
    }
}
