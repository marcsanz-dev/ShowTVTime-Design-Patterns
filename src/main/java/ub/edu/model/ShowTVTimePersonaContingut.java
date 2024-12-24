package ub.edu.model;

import ub.edu.model.Carteras.CarteraContingutDigital;
import ub.edu.model.cataleg.ContingutDigital;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.time.chrono.JapaneseEra.values;

public class ShowTVTimePersonaContingut {
    HashMap<String, CarteraContingutDigital> personal_content;

    public ShowTVTimePersonaContingut() {
        personal_content = new HashMap<>();
    }

    public void add(String correu, ContingutDigital c, String data){
        if (personal_content.containsKey(correu)) {
            personal_content.get(correu).add(c);
        } else {
            CarteraContingutDigital ccd = new CarteraContingutDigital();
            ccd.add(c);
            personal_content.put(correu, ccd);
        }
    }

    public List<ContingutDigital> getlist(String correu) {
        return personal_content.get(correu).getContingutDigital();
    }

    public boolean has(String correu, ContingutDigital c) {
        return personal_content.get(correu).containsKey(c.getNom());
    }

    public void remove(String correu, ContingutDigital c) {
        personal_content.get(correu).delete(c);
    }

    public List<ContingutDigital> getTop10General(){
        HashMap<ContingutDigital, Integer> frecuencias = new HashMap<>();
        for(String persona : personal_content.keySet()){
            for(ContingutDigital c : personal_content.get(persona).getContingutDigital()){
                frecuencias.put(c, frecuencias.getOrDefault(c, 0) + 1);
            }
        }

        return frecuencias.entrySet()
                .stream()
                .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue())) // Ordenar por valor descendente
                .limit(10) // Limitar a 10 elementos
                .map(Map.Entry::getKey) // Extraer solo las claves (ContingutDigital)
                .collect(Collectors.toList()); // Devolver como lista
    }

}
