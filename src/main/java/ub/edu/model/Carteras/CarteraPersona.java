package ub.edu.model.Carteras;

import ub.edu.model.Persona;
import ub.edu.model.exceptions.PersonaNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CarteraPersona implements CarteraPersonesInterface{

    private List<Persona> persones;

    public CarteraPersona() {
        persones = new ArrayList<>();
    }

    public CarteraPersona(List<Persona> persones) {
        this.persones = persones;
    }

    public Persona get(String username) throws PersonaNotFoundException {
        for (Persona persona: persones) {
            if (persona.getName().equals(username))
                return persona;
        }
        throw new PersonaNotFoundException();
    }

    public void add(Persona persona) {
        persones.add(persona);
    }

    public void delete(Persona persona) throws PersonaNotFoundException {
        try {
            persones.remove(persona);
        } catch (Exception e) {
            throw new PersonaNotFoundException();
        }
    }

}
