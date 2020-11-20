package fr.tguyonnet.Models;

public class Attaque {
    int id;
    private String nom;
    private int force;

    public Attaque(int id, String nom, int force) {
        this.id = id;
        this.nom = nom;
        this.force = force;
    }

    public Attaque(String nom, int force) {
        this.nom = nom;
        this.force = force;
    }

    public Attaque() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getForce() {
        return force;
    }

    public void setForce(int force) {
        this.force = force;
    }

    @Override
    public String toString() {
        return "Attaque{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", force=" + force +
                '}';
    }
}
