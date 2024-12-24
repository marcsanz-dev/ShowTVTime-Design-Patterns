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

        //Ara la ruleta es de 50% si toca 1 deixes de seguir el grup, si toca 2 et fas membre del grup

        switch (dice) {
            //Deixes de seguir el grup
            case 1:
                return false;

            //Et fas membre del grup
            case 2:
                return true;

            default:
                return false;
        }
    }
}
