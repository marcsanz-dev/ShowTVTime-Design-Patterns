package ub.edu.model;

import ub.edu.model.Carteras.CarteraContingutDigital;
import ub.edu.model.cataleg.ContingutDigital;

import java.util.HashMap;
import java.util.List;

public class ShowTVTimeWatchedHistory {
    HashMap<String, CarteraContingutDigital> watchedHistory;

    public ShowTVTimeWatchedHistory() {
        watchedHistory = new HashMap<>();
    }

    public void add(String correu, ContingutDigital c, String data){
        if (watchedHistory.containsKey(correu)) {
            watchedHistory.get(correu).add(c);
        } else {
            CarteraContingutDigital ccd = new CarteraContingutDigital();
            ccd.add(c);
            watchedHistory.put(correu, ccd);
        }
    }

    public List<ContingutDigital> getWatchedHistory(String correu) {
        return watchedHistory.get(correu).getContingutDigital();
    }
}
