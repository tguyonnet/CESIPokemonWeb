package fr.tguyonnet.Managers;

import fr.tguyonnet.Models.Dresseur;
import fr.tguyonnet.DAO.DresseurDAO;

import java.util.List;

public class DresseurManager {
    private static DresseurManager manager;

    // Constructeur privé
    private DresseurManager() {
    }

    // Retourne une et une seule instance
    public static DresseurManager getInstance() {
        if (manager == null){
            manager = new DresseurManager();
        }
        return manager;
    }

    /**
     * create 1 dresseur
     * @param nom
     * @param prenom
     */
    public void insertDresseur(String nom, String prenom) {
        DresseurDAO dresseurDAO = new DresseurDAO();
        Dresseur dresseur = new Dresseur();
        dresseur.setNom(nom);
        dresseur.setPrenom(prenom);
        dresseurDAO.add(dresseur);
    }

    /**
     * get all dresseurs
     * @return
     */
    public List<Dresseur> getDresseurs() {
        DresseurDAO dresseurDAO = new DresseurDAO();
        return dresseurDAO.getAll();
    }

    /**
     * get 1 dresseur
     * @param id
     * @return
     */
    public Dresseur getDresseur(int id) {
        DresseurDAO dresseurDAO = new DresseurDAO();
        return dresseurDAO.get(id);
    }

}
