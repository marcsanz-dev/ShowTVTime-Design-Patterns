package ub.edu.model;


import ub.edu.model.Carteras.CarteraGrupInteres;
import ub.edu.model.cataleg.GrupInteres;

public class Persona {

    private String pwd;
    private String nom;
    private CarteraGrupInteres followGrups;
    private CarteraGrupInteres memberGrups;
    private int reputation;

    public Persona(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        followGrups = new CarteraGrupInteres();
        memberGrups = new CarteraGrupInteres();
        reputation = 0;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return nom;
    }

    public void setName(String nom) {
        this.nom = nom;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void followGrupInteres(GrupInteres grup){
        followGrups.add(grup);
    }

    public void memberGrup(GrupInteres grup){
        memberGrups.add(grup);
    }

    public void unfollowGrupInteres(GrupInteres grup){
        followGrups.delete(grup);
    }

    public int getReputation() {
        return reputation;
    }

    public void addReputation(int reputation) {
        this.reputation += reputation;
    }
}
