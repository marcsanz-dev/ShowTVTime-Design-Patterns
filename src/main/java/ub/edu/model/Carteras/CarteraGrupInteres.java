package ub.edu.model.Carteras;

import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.exceptions.GrupInteresNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CarteraGrupInteres implements CarteraGrupInteresInterface{
    private List<GrupInteres> grupsInteres;

    public CarteraGrupInteres() {
        grupsInteres = new ArrayList<>();
    }

    public CarteraGrupInteres(List<GrupInteres> grupsInteres) {
        this.grupsInteres = grupsInteres;
    }

    public GrupInteres get(String nomGrup) throws GrupInteresNotFoundException {
        for (GrupInteres grupInteres : grupsInteres) {
            if (grupInteres.getNom().equals(nomGrup)) {
                return grupInteres;
            }
        }
        throw new GrupInteresNotFoundException();
    }

    public void add(GrupInteres grupInteres) {
        grupsInteres.add(grupInteres);
    }

    public void delete(GrupInteres grupInteres){
        grupsInteres.remove(grupInteres);
    }

    public List<GrupInteres> getGrups() {
        return grupsInteres;
    }

}
