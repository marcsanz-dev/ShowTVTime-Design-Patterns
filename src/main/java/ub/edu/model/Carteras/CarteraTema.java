package ub.edu.model.Carteras;

import ub.edu.model.cataleg.Tematica;
import ub.edu.model.exceptions.NotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarteraTema implements CarteraTemaInterface{
    private Map<String, Tematica> llistaTemes;

    public CarteraTema() {
        this.llistaTemes =  new HashMap<>();
    }

    public CarteraTema(List<Tematica> listaTemas) {
        this.llistaTemes = new HashMap<>();
        for (Tematica tema : listaTemas) {
            llistaTemes.put(tema.getNomTematica(), tema);
        }
    }

    public void setLlistaTemes(List<Tematica> listaTemas) {
        this.llistaTemes = new HashMap<>();
        for (Tematica tema : listaTemas) {
            llistaTemes.put(tema.getNomTematica(), tema);
        }
    }

    @Override
    public Tematica get(String name) throws NotFoundException {
        return llistaTemes.get(name);
    }

    @Override
    public void add(Tematica tematica) {
        llistaTemes.put(tematica.getNomTematica(), tematica);
    }

    @Override
    public void delete(Tematica tematica) throws NotFoundException {
        if (llistaTemes.remove(tematica.getNomTematica()) == null){
            throw new NotFoundException();
        }
        else{
            llistaTemes.remove(tematica.getNomTematica());
        }
    }

    public boolean containsKey(String name){
        return llistaTemes.containsKey(name);
    }

    public List<Tematica> getTemes() {
        return (List<Tematica>) llistaTemes.values();
    }


}
