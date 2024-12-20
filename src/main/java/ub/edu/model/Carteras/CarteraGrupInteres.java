package ub.edu.model.Carteras;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.exceptions.GrupInteresNotFoundException;

import java.util.HashMap;
import java.util.List;

public class CarteraGrupInteres implements CarteraGrupInteresInterface{
    private HashMap<String, GrupInteres> grupsInteres;

    public CarteraGrupInteres() {
        grupsInteres = new HashMap<>();
    }

    public CarteraGrupInteres(List<GrupInteres> grupsInteres) {
        this.grupsInteres = new HashMap<>();
        for (GrupInteres grupInteres : grupsInteres) {
            this.grupsInteres.put(grupInteres.getNom(), grupInteres);
        }
    }

    public void setGrupsInteres(List<GrupInteres> grupsInteres) {
        this.grupsInteres = new HashMap<>();
        for (GrupInteres grupInteres : grupsInteres) {
            this.grupsInteres.put(grupInteres.getNom(), grupInteres);
        }
    }

    public List<GrupInteres> getGrupsInteres() {
        return (List<GrupInteres>) grupsInteres.values();
    }

    public GrupInteres get(String nomGrup) throws GrupInteresNotFoundException {
        for (GrupInteres grupInteres : grupsInteres.values()) {
            if (grupInteres.getNom().equals(nomGrup)) {
                return grupInteres;
            }
        }
        throw new GrupInteresNotFoundException();
    }

    public void add(GrupInteres grupInteres) {
        grupsInteres.put(grupInteres.getNom(), grupInteres);
    }

    public void delete(GrupInteres grupInteres){
        grupsInteres.remove(grupInteres);
    }


}
