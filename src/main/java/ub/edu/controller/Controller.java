package ub.edu.controller;


import ub.edu.model.*;
import ub.edu.resources.ResourcesFacade;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public enum Controller {

    //Apliquem patró Singleton amb enum
    INSTANCE;


    private ResourcesFacade resourcesFacade;
    private ModelFacade modelFacade;
    private ShowTVTimeCataleg showTVTimeCataleg;
    private ShowTVTimePersones showTVTimePersones;
    private ShowTVTimePersonaContingut showTVTimeWatchedHistory;
    private ShowTVTimePersonaContingut showTVTimeWatchNext;
    private ShowTVTimePersonaGrup showTVTimePersonaGrup;
    private SessionMemory sessionMemory;


    private Controller() {
        this.showTVTimeCataleg = new ShowTVTimeCataleg();
        this.showTVTimePersones = new ShowTVTimePersones();
        this.showTVTimeWatchedHistory = new ShowTVTimePersonaContingut();
        this.showTVTimeWatchNext = new ShowTVTimePersonaContingut();
        this.showTVTimePersonaGrup = new ShowTVTimePersonaGrup();

        this.modelFacade = ModelFacade.getInstance(showTVTimeCataleg, showTVTimePersones, showTVTimeWatchedHistory, showTVTimeWatchNext, showTVTimePersonaGrup);
        this.sessionMemory = new SessionMemory();
        resourcesFacade = ResourcesFacade.getInstance(showTVTimeCataleg,showTVTimePersones, this.modelFacade);

        resourcesFacade.populateShowTVTimeCataleg();
        resourcesFacade.populateShowTVTimePersones();
        resourcesFacade.populateFollowersMembersGrups(); // TODO: Cal completar aquest mètode
    }

    public SessionMemory getSessionMemory() {
        return sessionMemory;
    }

    public String registrePersona(String user, String pass, String nom, String cognoms, String dni) {
        try {
            resourcesFacade.addNewPersona(user, pass, nom, cognoms, dni);
            return MessagesCAT.SuccessfulFindPersona.getMessage();
        } catch (Exception e) {
            return MessagesCAT.translate(e);
        }
    }

    public String loguejarPersona(String username, String password) {
        try {
            modelFacade.loguejarSociStatus(username, password);
            return MessagesCAT.SuccessfulLogin.getMessage();
        } catch (Exception e) {
            return MessagesCAT.translate(e);
        }
    }

   // Llistes de contiguts digitals i detalls concrets
    public List<HashMap<Object, Object>> visualitzarContingutsDigitalsPerNom() {
        return modelFacade.getAllContingutsDigitalsPerNom();
    }

    public boolean esPelicula(String nom) {
        return modelFacade.esPelicula(nom);
    }

    public List<HashMap<Object, Object>> visualitzarPelisPerNom() {
        return showTVTimeCataleg.getAllPeliculesPerNom();
    }

    public HashMap<Object, Object> getDetallsPelicula(String nomContingutAudiovisual) {
        return modelFacade.getDetallsPelicula(nomContingutAudiovisual);
    }

    public List<HashMap<Object, Object>> visualitzarSeriesPerNom() {
        return showTVTimeCataleg.getAllSeriesPerNom();
    }
    public HashMap<Object, Object> getDetallsSerie(String nomContingutAudiovisual) {
        return modelFacade.getDetallsSerie(nomContingutAudiovisual);
    }
    public List<HashMap<Object, Object>> getAllTemporadesDeSerie(String nomSerie) {
        return modelFacade.getAllTemporadesDeSerie(nomSerie);
    }
    public List<HashMap<Object, Object>> getAllEpisodis(String id, Integer idTemp) {
        return modelFacade.getAllEpisodis(id, idTemp);
    }
    public HashMap<Object, Object> getEpisodiDetalls(String idContingutAudiovisual, Integer numTemporada, Integer numEpisodi) {
        return modelFacade.getEpisodiDetalls(idContingutAudiovisual, numTemporada, numEpisodi);
    }
    public List<HashMap<Object, Object>> getAllTematiques() {
        return modelFacade.getAllTematiques();
    }

    // TODO Pràctica 4: Mètodes de gestió de la Watched History
    public boolean addToWatchedHistory(String nomContingut, String correuPersona) throws Exception {
        //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
        String data = LocalDate.now().toString();
        return modelFacade.addToWatchedHistoryList(nomContingut, correuPersona, data);
    }

    public boolean addTemporadaToWatchedHistory(String nomSerie, int numTemporada, String correuPersona) throws Exception {
        //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
        String data = LocalDate.now().toString();
        return modelFacade.addTemporadaToWatchedHistoryList(nomSerie, numTemporada, correuPersona, data);
    }
    public boolean addEpisodeToWatchedHistory(String nomSerie, int numTemporada, int numEpisodi, String correuPersona) throws Exception {
        //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
        String data = LocalDate.now().toString();
        return modelFacade.addEpisodiToWatchedHistoryList(nomSerie, numTemporada, numEpisodi, correuPersona, data);
    }

    public List<HashMap<Object, Object>> getWatchedHistory(String correuPersona) {
        try {
            //TODO Pràctica 4: cal implementar aquest mètode a modelFacade
            return modelFacade.getWatchedHistory(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }

    public List<HashMap<Object, Object>> getTop10Watched(){
        return modelFacade.getTop10Watched();
    }

    public List<HashMap<Object, Object>> getWatchNext( String correuPersona) {
        return modelFacade.getWatchNext(correuPersona);
    }

    // TODO Pràctica 4: Mètodes de gestió de grups
    public List<HashMap<Object, Object>> visualitzarGrupsPerNom() {
        // TODO  Practica 4 : canviar el mètode per a visualitzar tots els grups dels que no s'és follower ni membre
        List<HashMap<Object, Object>> llista = new ArrayList<>();
        try {
            llista = modelFacade.visualitzarGrupsPerNom();
            return llista;
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<String> missatge = new ArrayList<>();
            missatge.add(MessagesCAT.translate(e));
            llista.add(new HashMap<>(Collections.singletonMap("nom", missatge)));
            return llista;
        }
    }

    public List<HashMap<Object, Object>> visualitzarNothingGrupsPerPersona(String correuPersona) {
        // TODO  Practica 4 : obtenir tots els grups dels què la persona no és follower ni membre
        try {
            return modelFacade.getNothingGrupsPerPersona(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }

    public List<HashMap<Object, Object>> visualitzarFollowingGrupsPerPersona(String correuPersona) {
        // TODO  Practica 4 : obtenir tots els grups dels què la persona és follower.
        try {
            return modelFacade.getFollowingGrupsPerPersona(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }
    public List<HashMap<Object, Object>> visualitzarMemberGrupsPerPersona(String correuPersona) {
        // TODO  Practica 4 : obtenir tots els grups dels què la persona és membre
        try {
            return modelFacade.getMemberGrupsPerPersona(correuPersona);
        } catch (Exception e) {
            System.out.println(MessagesCAT.translate(e));
            ArrayList<HashMap<Object, Object>> missatge = new ArrayList<>();
            missatge.add(new HashMap<>(Collections.singletonMap("nom", MessagesCAT.translate(e))));
            return missatge;
        }
    }

    public String addFollower2Grup(String nomUsuari, String nomGrup) {
        // TODO  Practica 4 : afegir persona com a follower del grup  mitjançant el modelFacade
        try {
            modelFacade.addFollowerGrup(nomUsuari, nomGrup);
            return MessagesCAT.SuccessfulAddFollowerGrup.getMessage();
        } catch (Exception e) {
            return MessagesCAT.translate(e);
        }
    }

    public String addMember2Grup(String nomUsuari, String nomGrup, int punts) {
        // TODO  Practica 4 : afegir persona com a membre del grup mitjançant el modelFacade
        try {
            modelFacade.addMemberGrup(nomUsuari, nomGrup, punts);
            return MessagesCAT.SuccessfulAddMemberGrup.getMessage();
        } catch (Exception e) {
            return (MessagesCAT.translate(e));
        }
    }

    public String addNothing2Grup(String nomUsuari, String nomGrup) {
        // TODO  Practica 4 : afegir persona com a nothing del grup mitjançant el modelFacade
        try {
            modelFacade.addNothingGrup(nomUsuari, nomGrup);
            return MessagesCAT.SuccessfulAddNothingGrup.getMessage();
        } catch (Exception e) {
            return (MessagesCAT.translate(e));
        }
    }

    // TODO OPT Pràctica 4: Valorar continguts
    public boolean valorarContingut(String nomContingut, String correu, String valortype, String valoracio) {
        // TODO OPT Practica 4 : afegir les valoracions de pel·lícules
        return modelFacade.valorarContingut(nomContingut, correu, valortype, valoracio);
    }

    // TODO  Pràctica 4: Solicitar accés
    public HashMap<String, String> sollicitarAcces(String tipusAcces, String correuPersona, String nomGrup) {
        try {
            return modelFacade.sollicitarAcces(tipusAcces, correuPersona, nomGrup);
        } catch (Exception e) {
            return (null);
        }
    }

    // TODO OPT Pràctica 4: Validar accés
    public String comprovarAcces(String tipusAcces, String correuPersona, String nomGrup, String dadaAcces) {
        try {
            return modelFacade.comprovarAcces(tipusAcces, correuPersona, nomGrup, dadaAcces);
        } catch (Exception e) {
            return (null);
        }
    }

    //Nou Mètode

    public boolean ha_vist(String correu, String nomContingut){
        return modelFacade.ha_vist(correu, nomContingut);
    }

    public boolean ha_vist(String correu, String nomSerie, int numTemporada, int numEpisodi){
        return modelFacade.ha_vist(correu, nomSerie, numTemporada, numEpisodi);
    }


}
