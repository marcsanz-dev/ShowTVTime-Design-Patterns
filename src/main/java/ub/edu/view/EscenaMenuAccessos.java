package ub.edu.view;

import javafx.scene.control.Button;

public class EscenaMenuAccessos  extends Escena{


    private Button codiAcces;
    private Button ruleta;
    private Button triviaJoc;

    private EscenaPerfil escenaPerfil;

    public void start() throws Exception{
        //TODO
    }


    public void onCodiAcces() throws Exception{
        Escena escena = EscenaFactory.INSTANCE.creaEscena("InvitacioCodi-view", "Invitacio" );
        EscenaInvitacioCodi escenaInvitacio = (EscenaInvitacioCodi) escena;
        escenaInvitacio.setController(controller);
        escenaInvitacio.setEscenaPerfil(escenaPerfil);
        escenaInvitacio.setParentStage(this.stage);
        escenaInvitacio.start();
    }

    public void onRuleta() throws Exception{
        Escena escena = EscenaFactory.INSTANCE.creaEscena("Ruleta-view", "Ruleta" );
        EscenaRuleta escenaRuleta = (EscenaRuleta) escena;
        escenaRuleta.setController(controller);
        escenaRuleta.setEscenaPerfil(escenaPerfil);
        escenaRuleta.setParentStage(this.stage);
        escenaRuleta.start();

    }

    public void onTriviaJoc() throws Exception{
        Escena escena = EscenaFactory.INSTANCE.creaEscena("TriviaJoc-view", "Trivia Joc" );
        EscenaTriviaJoc escenaTrivia = (EscenaTriviaJoc) escena;
        escenaTrivia.setController(controller);
        escenaTrivia.setEscenaPerfil(escenaPerfil);
        escenaTrivia.setParentStage(this.stage);
        escenaTrivia.start();
    }


    public void setEscenaPerfil(EscenaPerfil escenaPerfil) {
        this.escenaPerfil = escenaPerfil;
    }

}
