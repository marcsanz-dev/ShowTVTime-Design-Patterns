package ub.edu.model;

import ub.edu.model.Carteras.CarteraContingutDigital;
import ub.edu.model.Carteras.CarteraGrupInteres;
import ub.edu.model.cataleg.ContingutDigital;
import ub.edu.model.cataleg.GrupInteres;
import ub.edu.model.exceptions.GrupInteresNotFoundException;

import java.util.ArrayList;

public class Persona {

    private String pwd;
    private String nom;
    private CarteraGrupInteres followGrups;
    private CarteraGrupInteres memberGrups;
    private WatchedHistory watchedHistory;
    private CarteraContingutDigital watchNext;
    private int reputation;

    public Persona(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
        followGrups = new CarteraGrupInteres();
        memberGrups = new CarteraGrupInteres();
        watchedHistory = new WatchedHistory();
        watchNext = new CarteraContingutDigital();
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

    public WatchedHistory getWatchedHistory(){
        return watchedHistory;
    }

    public CarteraContingutDigital getWatchNext(){
        return watchNext;
    }

    /*
    public boolean ha_vist(ContingutDigital contingut){
        return watchedHistory.containsKey(contingut.getNom());
    }

    public void deleteWatchedHistory(ContingutDigital contingut){
        watchedHistory.delete(contingut);
    }*/

    public void esborrarWatchedHistory(){
        watchedHistory = new WatchedHistory();
    }

    public int getReputation() {
        return reputation;
    }

    public void addReputation(int reputation) {
        this.reputation += reputation;
    }
    /*
    public void addWatchedHistory(ContingutDigital contingut){
        contingut.addVisualitzacio();
        watchedHistory.add(contingut);
    }*/

    public void addWatchNext(ContingutDigital contingut){
        watchNext.add(contingut);
    }
}
