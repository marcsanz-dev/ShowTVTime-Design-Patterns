package ub.edu.model;

import ub.edu.model.Carteras.CarteraGrupInteres;
import ub.edu.model.cataleg.GrupInteres;

import java.util.HashMap;
import java.util.List;

public class ShowTVTimePersonaGrup {
    HashMap<String, CarteraGrupInteres> followedGroups;
    HashMap<String, CarteraGrupInteres> memberGroups;
    HashMap<String, CarteraGrupInteres> nothingGroups;

    public ShowTVTimePersonaGrup() {
        this.followedGroups = new HashMap<>();
        this.memberGroups = new HashMap<>();
        this.nothingGroups = new HashMap<>();
    }

    public List<GrupInteres> getNothingGrupsPerPersona(String username) {
        return this.nothingGroups.get(username).getGrupsInteres();
    }

    public List<GrupInteres> getFollowedGrupsPerPersona(String username) {
        return this.followedGroups.get(username).getGrupsInteres();
    }

    public List<GrupInteres> getMemberGrupsPerPersona(String username) {
        return this.memberGroups.get(username).getGrupsInteres();
    }

    public void addNothing(String username, GrupInteres grup) {
        if (this.nothingGroups.containsKey(username)) {
            this.nothingGroups.get(username).add(grup);
        } else {
            CarteraGrupInteres cg = new CarteraGrupInteres();
            cg.add(grup);
            this.nothingGroups.put(username, cg);
        }

        if(this.followedGroups.containsKey(username)) {
            this.followedGroups.get(username).delete(grup);
        } else if (this.memberGroups.containsKey(username)) {
            this.memberGroups.get(username).delete(grup);
        }
    }

    public void addFollower(String username, GrupInteres grup) {
        if (this.followedGroups.containsKey(username)) {
            this.followedGroups.get(username).add(grup);
        } else {
            CarteraGrupInteres cg = new CarteraGrupInteres();
            cg.add(grup);
            this.followedGroups.put(username, cg);
        }

        if(this.nothingGroups.containsKey(username)) {
            this.nothingGroups.get(username).delete(grup);
        } else if (this.memberGroups.containsKey(username)) {
            this.memberGroups.get(username).delete(grup);

        }
    }

    public void addMember(String username, GrupInteres grup) {
        if (this.memberGroups.containsKey(username)) {
            this.memberGroups.get(username).add(grup);
        } else {
            CarteraGrupInteres cg = new CarteraGrupInteres();
            cg.add(grup);
            this.memberGroups.put(username, cg);
        }

        if(this.nothingGroups.containsKey(username)) {
            this.nothingGroups.get(username).delete(grup);
        } else if (this.followedGroups.containsKey(username)) {
            this.followedGroups.get(username).delete(grup);

        }
    }
}
