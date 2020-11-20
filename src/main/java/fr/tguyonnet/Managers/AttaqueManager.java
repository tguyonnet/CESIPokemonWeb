package fr.tguyonnet.Managers;

import fr.tguyonnet.DAO.AttaqueDAO;
import fr.tguyonnet.Models.Attaque;

import java.util.List;

public class AttaqueManager {
    private static AttaqueManager manager;

    // Constructeur privé
    private AttaqueManager() {
    }

    // Retourne une et une seule instance
    public static AttaqueManager getInstance() {
        if (manager == null){
            manager = new AttaqueManager();
        }
        return manager;
    }

    public void insertDresseur(String nom, int force) {
        AttaqueDAO attaqueDAO = new AttaqueDAO();
        Attaque attaque = new Attaque();
        attaque.setNom(nom);
        attaque.setForce(force);
        attaqueDAO.add(attaque);
    }

    public List<Attaque> getDresseurs() {
        AttaqueDAO attaqueDAO = new AttaqueDAO();
        return attaqueDAO.getAll();
    }

    public Attaque getDresseur(int id) {
        AttaqueDAO attaqueDAO = new AttaqueDAO();
        return attaqueDAO.get(id);
    }
}
