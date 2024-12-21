package ub.edu.model;

import java.util.ArrayList;

public class Joc {
    private int punts;
    private String nom;
    private String pregunta;
    private ArrayList<String> respostes;
    private String respostaCorrecta;

    public Joc() {
        punts = 0;
    }

    public Joc(String nom) {
        this.nom = nom;
        punts = 0;
    }

    public Joc(String pregunta, ArrayList<String> respostes, String respostaCorrecta) {
        this.pregunta = pregunta;
        this.respostes = respostes;
        this.respostaCorrecta = respostaCorrecta;
        punts = 0;
    }

    public int getPunts() {
        return punts;
    }

    public void correcta() {
        punts += 10;
    }

    public void incorrecta() {
        punts -= 5;
    }

    public boolean comprovarResposta(String resposta) {
        boolean correcte = resposta.equals(respostaCorrecta);
        if(correcte){
            punts += 10;
        }
        else{
            punts -= 5;
        }
        return correcte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
