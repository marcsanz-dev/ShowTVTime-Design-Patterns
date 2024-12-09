package ub.edu.model;

public class Persona {

    private String pwd;
    private String nom;
    private String nompropi;
    private String cognoms;
    private String dni;

    public Persona(String nom, String pwd) {
        this.pwd = pwd;
        this.nom = nom;
    }

    public Persona(String correu, String nom, String cognoms, String dni, String password) {
        this.nom = correu;
        this.nompropi = nom;
        this.cognoms = cognoms;
        this.dni = dni;
        this.pwd = password;
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
}
