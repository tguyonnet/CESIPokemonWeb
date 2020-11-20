package fr.tguyonnet.Managers;

import fr.tguyonnet.Models.Pokemon;
import fr.tguyonnet.DAO.AttaqueDAO;
import fr.tguyonnet.DAO.DresseurDAO;
import fr.tguyonnet.DAO.PokemonDAO;

import java.util.List;

public class PokemonManager {
    //
    private static PokemonManager manager;

    // Constructeur privé
    private PokemonManager() {
    }

    // Retourne une et une seule instance
    public static PokemonManager getInstance() {
        if (manager == null){
            manager = new PokemonManager();
        }
        return manager;
    }

    /**
     * Create 1 pokemon
     * @param identifiant
     * @param nom
     * @param poids
     * @param taille
     * @param attaque01
     * @param attaque02
     * @param dresseur
     */
    public void insertPokemon(int identifiant, String nom, float poids, float taille, int attaque01, int attaque02, int dresseur) {
        PokemonDAO pokemonDAO = new PokemonDAO();
        AttaqueDAO attaqueDAO = new AttaqueDAO();
        DresseurDAO dresseurDAO = new DresseurDAO();
        Pokemon pokemon = new Pokemon();
        pokemon.setIdentifiant(identifiant);
        pokemon.setNom(nom);
        pokemon.setPoids(poids);
        pokemon.setTaille(taille);
        pokemon.setDesign("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + identifiant + ".png");
        pokemon.setAttaque01(attaqueDAO.get(attaque01));
        pokemon.setAttaque02(attaqueDAO.get(attaque02));
        pokemon.setDresseur(dresseurDAO.get(dresseur));
        pokemonDAO.add(pokemon);
    }

    /**
     * get all pokemons
     * @return
     */
    public List<Pokemon> getPokemons() {
        PokemonDAO pokemonDAO = new PokemonDAO();
        return pokemonDAO.getAll();
    }

    /**
     * get 1 pokemon
     * @param id
     * @return
     */
    public Pokemon getPokemon(int id) {
        PokemonDAO pokemonDAO = new PokemonDAO();
        return pokemonDAO.get(id);

    }
}
