package ub.edu.model;

import ub.edu.model.Carteras.CarteraContingutDigital;
import ub.edu.model.cataleg.ContingutDigital;

import java.util.HashMap;

public class ShowTVTimeWatchNext {
    HashMap<String, CarteraContingutDigital> watchNext;

    public ShowTVTimeWatchNext() {
        watchNext = new HashMap<>();
    }

    public void add(String correu, ContingutDigital c, String data){
        if (watchNext.containsKey(correu)) {
            watchNext.get(correu).add(c);
        } else {
            CarteraContingutDigital ccd = new CarteraContingutDigital();
            ccd.add(c);
            watchNext.put(correu, ccd);
        }
    }
}
