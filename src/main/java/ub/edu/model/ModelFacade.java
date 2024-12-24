package ub.edu.model;

import ub.edu.model.Strategies.AccessStrategy.CodeAccessStrategy;
import ub.edu.model.Strategies.AccessStrategy.GroupAccess;
import ub.edu.model.Strategies.AccessStrategy.QuestionAccessStrategy;
import ub.edu.model.Strategies.AccessStrategy.RouletteAccessStrategy;
import ub.edu.model.cataleg.*;
import ub.edu.model.exceptions.*;
import ub.edu.model.quizz.Pregunta;
import ub.edu.model.quizz.Resposta;

import java.util.*;

public class ModelFacade {
    private ShowTVTimeCataleg showTVTimeCataleg;
    private ShowTVTimePersones showTVTimePersones;
    private ShowTVTimePersonaContingut showTVTimeWatchedHistory;
    private ShowTVTimePersonaContingut showTVTimeWatchNext;
    private ShowTVTimePersonaGrup showTVTimePersonaGrup;

    //Apliquem el patró Singleton
    private static volatile ModelFacade instance;

    private ModelFacade(ShowTVTimeCataleg showCataleg, ShowTVTimePersones showPersones,
                       ShowTVTimePersonaContingut showWatchedHistory, ShowTVTimePersonaContingut showWatchNext, ShowTVTimePersonaGrup showGrup) {
        this.showTVTimeCataleg = showCataleg;
        this.showTVTimePersones = showPersones;
        this.showTVTimeWatchedHistory = showWatchedHistory;
        this.showTVTimeWatchNext = showWatchNext;
        this.showTVTimePersonaGrup = showGrup;

    }

    public static ModelFacade getInstance(ShowTVTimeCataleg showCataleg, ShowTVTimePersones showPersones,
                                         ShowTVTimePersonaContingut showWatchedHistory, ShowTVTimePersonaContingut showWatchNext, ShowTVTimePersonaGrup showGrup) {
        if (instance == null) {
            synchronized (ModelFacade.class) {
                if (instance == null) {
                    instance = new ModelFacade(showCataleg, showPersones, showWatchedHistory, showWatchNext, showGrup);
                }
            }
        }
        return instance;
    }

    // Mètodes de login
    public void loguejarSociStatus(String correu, String password) throws Exception{
        Persona persona = showTVTimePersones.findPersonaCartera(correu);
        if (persona == null) {
            throw new PersonaNotFoundException();
        }
        if (!persona.getPwd().equals(password)) {
            throw new WrongPasswordException();
        }
    }

    // Mètodes de llistes de continguts
    public List<HashMap<Object, Object>> getAllTematiques()  {
        List<Tematica> l = showTVTimeCataleg.getAllTematiques();
        List<HashMap<Object, Object>> tematiquesDisponibles = new ArrayList<>();
        int i;
        i = 0;
        for (Tematica t : l) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id", i++);
            hashMap.put("nom", t.getNomTematica());
            tematiquesDisponibles.add(hashMap);
        }
        return tematiquesDisponibles;
    }

    public List<HashMap<Object, Object>> getAllContingutsDigitalsPerNom() {
        List<HashMap<Object, Object>> contingutsDisponibles = new ArrayList<>();
        Integer id = 0;
        for (ContingutDigital c : showTVTimeCataleg.getAllContingutsDigitals()) {
            HashMap<Object, Object> atributContingut = new HashMap<>();
            atributContingut.put("id", id++);
            String nom = c.getNom();
            atributContingut.put("nom", nom);
            contingutsDisponibles.add(atributContingut);
        }
        return contingutsDisponibles;
    }

    public List<HashMap<Object, Object>> getAllTemporadesDeSerie(String id) {
        List<HashMap<Object, Object>> temporadesDisponibles = new ArrayList<>();
        Serie s = showTVTimeCataleg.findSerie(id);
        for (Temporada t : s.getTemporades()) {
            HashMap<Object, Object> atributTemporada = new HashMap<>();
            atributTemporada.put("numTemporada", t.getNumTemporada());
            temporadesDisponibles.add(atributTemporada);
        }
        return temporadesDisponibles;
    }

    public HashMap<Object, Object> getDetallsSerie(String idContingutAudiovisual) {
        HashMap<Object, Object> atributsSerie = new HashMap<>();
        Serie s = showTVTimeCataleg.findSerie(idContingutAudiovisual);
        atributsSerie.put("imatge", s.getUrl());
        atributsSerie.put("nom", s.getNom());
        atributsSerie.put("descripcio", s.getDescripcio());
        atributsSerie.put("dataAnyPrimeraEmissio", s.getAnyEstrena());
        atributsSerie.put("idioma", s.getIdioma());
        atributsSerie.put("durada", s.getDurada());

        return atributsSerie;
    }

    public HashMap<Object, Object> getDetallsPelicula(String idContingutAudiovisual) {
        HashMap<Object, Object> atributsPelicula = new HashMap<>();
        Pelicula p = showTVTimeCataleg.findPelicula(idContingutAudiovisual);
        atributsPelicula.put("imatge", p.getUrl());
        atributsPelicula.put("nom", p.getNom());
        atributsPelicula.put("descripcio", p.getDescripcio());
        atributsPelicula.put("dataAnyPrimeraEmissio", p.getAnyEstrena());
        atributsPelicula.put("idioma", p.getIdioma());
        atributsPelicula.put("durada", p.getDurada());

        return atributsPelicula;
    }

    public List<HashMap<Object, Object>> getAllEpisodis(String idSerie, int idTemporada) {
        List<HashMap<Object, Object>> episodisDisponibles = new ArrayList<>();
        Serie s = showTVTimeCataleg.findSerie(idSerie);
        Temporada t = s.findTemporada(idTemporada);
        for (Episodi e : t.getEpisodis()) {
            HashMap<Object, Object> atributEpisodi = new HashMap<>();
            atributEpisodi.put("numEpisodi", e.getNumEpisodi());
            episodisDisponibles.add(atributEpisodi);
        }
        return episodisDisponibles;
    }

    public HashMap<Object, Object> getEpisodiDetalls(String idContingutAudiovisual, Integer numTemporada, Integer numEpisodi) {
        HashMap<Object, Object> atributsEpisodi = new HashMap<>();
        Serie s = showTVTimeCataleg.findSerie(idContingutAudiovisual);
        Temporada t = s.findTemporada(numTemporada);
        Episodi e = t.findEpisodi(numEpisodi);
        atributsEpisodi.put("nom", e.getNom());
        atributsEpisodi.put("descripcio", e.getDescripcio());
        atributsEpisodi.put("durada", e.getDurada());
        atributsEpisodi.put("valoracio", e.getValoracioIMDb());
        atributsEpisodi.put("imatge", e.getUrl());
        atributsEpisodi.put("numTemporada", e.getNumTemporada());
        atributsEpisodi.put("numEpisodi", e.getNumEpisodi());
        atributsEpisodi.put("nomSerie", e.getNomSerie());
        atributsEpisodi.put("anyEstrena", e.getAnyEstrena());
        atributsEpisodi.put("url", e.getUrl());
        return atributsEpisodi;
    }

    public boolean esPelicula(String nomContingut) {
        return showTVTimeCataleg.esPelicula(nomContingut);
    }

    // Mètodes de WatchedHistory

    public boolean addToWatchedHistoryList(String nomContingut, String correu, String data) throws Exception {
        // TODO: Pràctica 4: Cal afegir el contingut nomContingut a la WatchedHistory del client amb correu correu
        ContingutDigital c = showTVTimeCataleg.findContingutDigital(nomContingut);
        showTVTimeWatchedHistory.add(correu, c, data);
        if(c instanceof Serie){
            List<Temporada> temporadas = ((Serie) c).getTemporades();
            for (Temporada t : temporadas) {
                List<Episodi> episodis = t.getEpisodis();
                for (Episodi e : episodis) {
                    if(showTVTimeWatchNext.has(correu, e)){
                        showTVTimeWatchNext.remove(correu, e);
                    }
                }
            }
        }
        System.out.println("Model Facade: addToWatchedHistoryList -> nomContingut: " + nomContingut + " correu: " + correu);
        return true;
    }

    public boolean addTemporadaToWatchedHistoryList(String nomContingut, int numTemporada, String correu, String data) throws Exception {
        // TODO: Pràctica 4: Cal afegir el contingut nomContingut a la WatchedHistory del client amb correu correu
        Temporada t = showTVTimeCataleg.findTemporada(nomContingut, numTemporada);
        List<Episodi> episodis = t.getEpisodis();
        for (Episodi e : episodis) {
            showTVTimeWatchedHistory.add(correu, e, data);
            if(showTVTimeWatchNext.has(correu, e)){
                showTVTimeWatchNext.remove(correu, e);
            }
        }

        Serie s = showTVTimeCataleg.findSerie(nomContingut);

        if(s.getNumTemporades() > numTemporada){
            showTVTimeWatchNext.add(correu, s.findEpisodi(numTemporada + 1, 1), data);
        }
        System.out.println("Model Facade: addTemporadaToWatchedHistoryList -> nomContingut: " + nomContingut + " correu: " + correu);
        return true;
    }

    public boolean addEpisodiToWatchedHistoryList(String nomContingut, int numTemporada, int numEpisodi, String correu, String data) throws Exception {
        // TODO: Pràctica 4: Cal afegir el contingut nomContingut a la WatchedHistory del client amb correu correu
        ContingutDigital c = showTVTimeCataleg.findEpisodi(nomContingut, numTemporada, numEpisodi);
        showTVTimeWatchedHistory.add(correu, c, data);

        Serie s = showTVTimeCataleg.findSerie(nomContingut);
        if(s.findTemporada(numTemporada).getNumEpisodis() > numEpisodi){
            showTVTimeWatchNext.add(correu, s.findEpisodi(numTemporada, numEpisodi + 1), data);
        } else if(s.getNumTemporades() > numTemporada){
            showTVTimeWatchNext.add(correu, s.findEpisodi(numTemporada + 1, 1), data);
        }

        if(showTVTimeWatchNext.has(correu, c)){
            showTVTimeWatchNext.remove(correu, c);
        }
        System.out.println("Model Facade: addEpisodiToWatchedHistoryList -> nomContingut: " + nomContingut + " correu: " + correu);
        return true;
    }

    public boolean addToWatchNextList(String nomContingut, int numTemporada, int numEpisodi, String correu, String data) throws Exception {
        ContingutDigital c = showTVTimeCataleg.findEpisodi(nomContingut, numTemporada, numEpisodi);
        showTVTimeWatchNext.add(correu, c, data);
        System.out.println("Model Facade: addEpisodiToWatchedHistoryList -> nomContingut: " + nomContingut + " correu: " + correu);
        return true;
    }

    public List<HashMap<Object, Object>> getWatchedHistory(String correu) {
        List<HashMap<Object, Object>> wishList = new ArrayList<>();
        // TODO: Pràctica 4: Cal retornar els continguts de la personal_content del client amb correu correu

        System.out.println("Model Facade: getWatchedHistory -> correu: " + correu );
        List<ContingutDigital> cd = showTVTimeWatchedHistory.getlist(correu);


        for (ContingutDigital c : cd) {
            if(c instanceof Serie){
                wishList.add(getDetallsSerie(c.getNom()));
            } else if (c instanceof Pelicula){
                wishList.add(getDetallsPelicula(c.getNom()));
            } else if (c instanceof Episodi){
                Episodi e = (Episodi) c;
                wishList.add(getEpisodiDetalls(e.getNomSerie(), e.getNumTemporada(), e.getNumEpisodi()));
            }
        }
        return wishList;
    }


    public List<HashMap<Object, Object>> getWatchNext(String correu) {
        List<HashMap<Object, Object>> contingutsTop = new ArrayList<>();
        // TODO: Pràctica 4: Cal retornar els continguts de la WatchNext List
        System.out.println("Model Facade: getWatchNext -> tipusContingut ");

        List<ContingutDigital> cd = showTVTimeWatchNext.getlist(correu);


        for (ContingutDigital c : cd) {
            if(c instanceof Serie){
                contingutsTop.add(getDetallsSerie(c.getNom()));
            } else if (c instanceof Pelicula){
                contingutsTop.add(getDetallsPelicula(c.getNom()));
            } else if (c instanceof Episodi){
                Episodi e = (Episodi) c;
                contingutsTop.add(getEpisodiDetalls(e.getNomSerie(), e.getNumTemporada(), e.getNumEpisodi()));
            }
        }
        return contingutsTop;
    }

    //Mètode extra

    public List<HashMap<Object, Object>> getTop10Watched(){
        List<HashMap<Object, Object>> contingutsTop = new ArrayList<>();
        // TODO: Pràctica 4: Cal retornar els continguts de la WatchNext List
        System.out.println("Model Facade: getWatchNext -> tipusContingut ");

        List<ContingutDigital> cd = showTVTimeWatchedHistory.getTop10General();


        for (ContingutDigital c : cd) {
            if(c instanceof Serie){
                contingutsTop.add(getDetallsSerie(c.getNom()));
            } else if (c instanceof Pelicula){
                contingutsTop.add(getDetallsPelicula(c.getNom()));
            } else if (c instanceof Episodi){
                Episodi e = (Episodi) c;
                contingutsTop.add(getEpisodiDetalls(e.getNomSerie(), e.getNumTemporada(), e.getNumEpisodi()));
            }
        }
        return contingutsTop;
    }

    // Mètodes relatius a grups

    public List<HashMap<Object, Object>> visualitzarGrupsPerNom() throws Exception {
        Iterable<String> list = showTVTimeCataleg.visualitzarGrupsPerNom();
        List<HashMap<Object, Object>> grupsDisponibles = new ArrayList<>();
        int i;
        i = 0;
        for (String g : list) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id", i++);
            hashMap.put("nom", g);
            grupsDisponibles.add(hashMap);
        }
        return grupsDisponibles;
    }

    // TODO Pràctica 4: Cal afegir un mètode per poder obtenir els grups en els què l'usuari no es ni follower ni membre

    public List<HashMap<Object, Object>> getNothingGrupsPerPersona(String correuPersona)  throws Exception {

        // TODO Pràctica 4: Cal  obtenir els grups en els què l'usuari no es ni follower ni membre
        // Per a cada grup cal omplir la hashMap que espera la vista

        List<HashMap<Object, Object>> grupsDisponibles = new ArrayList<>();

        List<GrupInteres> list = showTVTimePersonaGrup.getNothingGrupsPerPersona(correuPersona);
        int i = 0;
        for (GrupInteres g : list) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id", i++);
            hashMap.put("nom", g.getNom());
            grupsDisponibles.add(hashMap);
        }

        return grupsDisponibles;

    }
    public List<HashMap<Object, Object>> getFollowingGrupsPerPersona(String correuPersona)  throws Exception {

        // TODO Pràctica 4: Cal  obtenir els grups que segueix la persona amb correu "correuPersona"
        // Per a cada grup cal omplir la hashMap que espera la vista

        List<HashMap<Object, Object>> grupsDisponibles = new ArrayList<>();
        // TODO: Cal que omplis list amb llista de grups que segueix la persona
        List<GrupInteres> list = showTVTimePersonaGrup.getFollowedGrupsPerPersona(correuPersona);
        int i = 0;
        for (GrupInteres g : list) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id", i++);
            hashMap.put("nom", g.getNom());
            grupsDisponibles.add(hashMap);
        }

        return grupsDisponibles;
    }

    public List<HashMap<Object, Object>> getMemberGrupsPerPersona(String correuPersona) {
        // TODO Pràctica 4: Cal  obtenir els grups dels què és membre la persona amb correu "correuPersona"
        // Per a cada grup cal omplir la hashMap que espera la vista

        List<HashMap<Object, Object>> grupsDisponibles = new ArrayList<>();
        // TODO: Cal que omplis list amb llista de grups dels què és membre la persona
        List<GrupInteres> list = showTVTimePersonaGrup.getMemberGrupsPerPersona(correuPersona);
        int i = 0;
        for (GrupInteres g : list) {
            HashMap<Object, Object> hashMap = new HashMap<>();
            hashMap.put("id", i++);
            hashMap.put("nom", g.getNom());
            grupsDisponibles.add(hashMap);
        }

         return grupsDisponibles;
    }

    public void addFollowerGrup(String nomUsuari, String nomGrup) throws Exception {
        //Cal buscar la persona i el grup i despres cridar a afegir follower
        Persona persona = showTVTimePersones.findPersonaCartera(nomUsuari);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: Cal afegir l'usuari "persona" com a follower del grup "grup"
        showTVTimePersonaGrup.addFollower(nomUsuari, grup);
    }

    public void addMemberGrup(String nomUsuari, String nomGrup, int punts) throws Exception {
        //Cal buscar la persona i el grup i despres cridar a afegir member de showTVTimeGrups
        Persona persona = showTVTimePersones.findPersonaCartera(nomUsuari);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: Cal afegir l'usuari "persona" com a membre del grup "grup"
        showTVTimePersonaGrup.addMember(nomUsuari, grup);
        persona.addReputation(punts);
    }

    public void addNothingGrup(String nomUsuari, String nomGrup) throws Exception {
        //Cal buscar la persona i el grup i despres cridar a afegir nothing de showTVTimeGrups
        Persona persona = showTVTimePersones.findPersonaCartera(nomUsuari);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: Cal afegir l'usuari "persona" com a nothing del grup "grup"
        showTVTimePersonaGrup.addNothing(nomUsuari, grup);
    }

    public HashMap<String, String> sollicitarAcces(String tipusAcces, String correuPersona, String nomGrup) throws Exception{
        Persona persona = showTVTimePersones.findPersonaCartera(correuPersona);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: Cal sol.licitar accés l'usuari "persona" com a membre del grup "grup" segons el tipusAcces
        // TODO Cal retornar a la hash per exemple, amb la clau "tirada" el resultat de la tirada
        // TODO OPT mirar el que cal retornar en el cas de l'accès per Quizz a la classe EscenaTriviaJoc.java

        if(tipusAcces.equals("RULETA")){
            HashMap<String, String> tirada = new HashMap<>();
            tirada.put("tirada", String.valueOf((int) (Math.random() * 2) + 1));
            return tirada;

        } else if (tipusAcces.equals("QUIZZ")){
            Pregunta p = grup.getRandomPregunta();
            return p.toHash();
        }
        return null;

    }
    public String comprovarAcces(String tipusAcces, String correuPersona, String nomGrup, String dadaAcces) throws Exception{

        Persona persona = showTVTimePersones.findPersonaCartera(correuPersona);
        GrupInteres grup = showTVTimeCataleg.findGrupInteres(nomGrup);
        // TODO Pràctica 4: comprova accés al grup segons el tipus d'acces
        // TODO Cal retornar al String si es "MEMBRE" o no

        GroupAccess groupAccess = new GroupAccess();

        if(tipusAcces.equals("RULETA")){
            groupAccess.setStrategy(new RouletteAccessStrategy(Integer.parseInt(dadaAcces)));
            if(groupAccess.accessGrup(persona, grup)){
                return "MEMBER";
            } else {
                return "NO MEMBRE";
            }
        } else if (tipusAcces.equals("QUIZZ")){
            Resposta r = grup.getResposta(dadaAcces);
            groupAccess.setStrategy(new QuestionAccessStrategy(r));
            if(groupAccess.accessGrup(persona, grup)){
                return "MEMBER";
            } else {
                return "NO MEMBRE";
            }

        } else if (tipusAcces.equals("CODI")){
            groupAccess.setStrategy(new CodeAccessStrategy(dadaAcces));
            if(groupAccess.accessGrup(persona, grup)){
                return "MEMBER";
            } else {
                return "NO MEMBRE";
            }
        }
        return null;
    }
    // TODO OPT Pràctica 4: Fer els mètodes corresponents a treure un usuari com a Follower
    //  //o treure'l com a membre d'un grup.



    // TODO OPT: Pràctica 4: Mètodes per valorar

    public boolean valorarContingut( String nomContingut, String correu, String valortype, String valoracio) {
        // TODO OPT: Pràctica 4: Cal valorar el contingut nomContingut amb la valoració valoracio de tipus valorType pel client amb correu correu
        System.out.println("Model Facade: valorarContingut -> nomContingut: " + nomContingut + " correu: " + correu + " valortype: " + valortype + " valoracio: " + valoracio);

        if(valortype.equals("ValorPunts")){
            showTVTimeCataleg.findContingutDigital(nomContingut).valorar(Integer.parseInt(valoracio));
            showTVTimePersones.findPersonaCartera(correu).addReputation(10);
        } else if (valortype.equals("ValorEstrelles")){
            showTVTimeCataleg.findContingutDigital(nomContingut).valorar(Integer.parseInt(valoracio));
            showTVTimePersones.findPersonaCartera(correu).addReputation(10);
        } else if(valortype.equals("ValorLikes")){
            if (valoracio.equals("Like")){
                showTVTimeCataleg.findContingutDigital(nomContingut).like();
                showTVTimePersones.findPersonaCartera(correu).addReputation(10);
            } else if (valoracio.equals("Dislike")){
                showTVTimeCataleg.findContingutDigital(nomContingut).dislike();
                showTVTimePersones.findPersonaCartera(correu).addReputation(10);
            }
        }


        return false;
    }

    // Mètodes de filtres per pel·liícules o sèries
    public List<HashMap<Object, Object>> getAllPelicules() {
        List<HashMap<Object, Object>> contingutsDisponibles = new ArrayList<>();
        int id = 0;
        for (Pelicula c : showTVTimeCataleg.getAllPelicules()) {
            HashMap<Object, Object> atributContingut = new HashMap<>();
            atributContingut.put("id", id++);
            String nom = c.getNom();
            atributContingut.put("nom", nom);
            contingutsDisponibles.add(atributContingut);
        }

        return contingutsDisponibles;
    }

    public List<HashMap<Object, Object>> getAllSeries() {
        List<HashMap<Object, Object>> contingutsDisponibles = new ArrayList<>();
        int id = 0;
        for (Serie c : showTVTimeCataleg.getAllSeries()) {
            HashMap<Object, Object> atributContingut = new HashMap<>();
            atributContingut.put("id", id++);
            String nom = c.getNom();
            atributContingut.put("nom", nom);
            contingutsDisponibles.add(atributContingut);
        }

        return contingutsDisponibles;
    }



}
