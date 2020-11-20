package fr.tguyonnet.Models;

public class Pokemon {
    private int id;
    private int identifiant;
    private String nom;
    private float poids;
    private float taille;
    private String design;
    private Attaque attaque01;
    private Attaque attaque02;
    private Dresseur dresseur;

    public Pokemon(int id, int identifiant, String nom, float poids, float taille, String design, Attaque attaque01, Attaque attaque02, Dresseur dresseur) {
        this.id = id;
        this.identifiant = identifiant;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.design = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + identifiant + ".png";
        this.attaque01 = attaque01;
        this.attaque02 = attaque02;
        this.dresseur = dresseur;
    }

    public Pokemon(int id, String nom, float poids, float taille, Attaque attaque01, Attaque attaque02, Dresseur dresseur) {
        this.id = id;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.design = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + identifiant + ".png";
        this.attaque01 = attaque01;
        this.attaque02 = attaque02;
        this.dresseur = dresseur;
    }

    public Pokemon(int identifiant, String nom, float poids, float taille) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.poids = poids;
        this.taille = taille;
        this.design = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + identifiant + ".png";
    }

    public Pokemon() {
    }

    public int getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(int identifiant) {
        this.identifiant = identifiant;
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

    public float getPoids() {
        return poids;
    }

    public void setPoids(float poids) {
        this.poids = poids;
    }

    public float getTaille() {
        return taille;
    }

    public void setTaille(float taille) {
        this.taille = taille;
    }

    public String getDesign() {
        return design;
    }

    public void setDesign(String design) {
        this.design = design;
    }

    public Attaque getAttaque01() {
        return attaque01;
    }

    public void setAttaque01(Attaque attaque01) {
        this.attaque01 = attaque01;
    }

    public Attaque getAttaque02() {
        return attaque02;
    }

    public void setAttaque02(Attaque attaque02) {
        this.attaque02 = attaque02;
    }

    public Dresseur getDresseur() {
        return dresseur;
    }

    public void setDresseur(Dresseur dresseur) {
        this.dresseur = dresseur;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", identifiant=" + identifiant +
                ", nom='" + nom + '\'' +
                ", poids=" + poids +
                ", taille=" + taille +
                ", design='" + design + '\'' +
                ", attaque01=" + attaque01 +
                ", attaque02=" + attaque02 +
                ", dresseur=" + dresseur +
                '}';
    }
}
