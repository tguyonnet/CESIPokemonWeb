package fr.tguyonnet.DAO;

import fr.tguyonnet.Models.Dresseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DresseurDAO implements DAO<Dresseur> {

    final static String SQL_INSERT = "INSERT INTO dresseur (nom, prenom) values(?, ?)";
    final static String SQL_SELECT_ALL = "SELECT id, nom, prenom FROM dresseur";
    final static String SQL_SELECT_1 = "SELECT id, nom, prenom FROM dresseur WHERE id=?";
    final static String SQL_DELETE = "DELETE FROM dresseur WHERE id=?";
    final static String SQL_UPDATE = "UPDATE dresseur SET nom=?, prenom=? WHERE id=?";

    @Override
    public Dresseur get(int id) {
        Dresseur dresseur = new Dresseur();
        try (PreparedStatement pstmt = this.connect.prepareStatement(SQL_SELECT_1)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                dresseur.setId(rs.getInt("id"));
                dresseur.setNom(rs.getString("nom"));
                dresseur.setPrenom(rs.getString("prenom"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return dresseur;
    }

    @Override
    public List<Dresseur> getAll() {
        List<Dresseur> listeDesDresseurs = new ArrayList<Dresseur>();
        try (Statement stmt = this.connect.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Dresseur dresseur = new Dresseur(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getString("prenom")
                );
                listeDesDresseurs.add(dresseur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return listeDesDresseurs;
    }

    @Override
    public void update(Dresseur dresseur) {
        try (PreparedStatement pstmt = this.connect.prepareStatement(SQL_UPDATE)) {
            pstmt.setString(1, dresseur.getNom());
            pstmt.setString(2, dresseur.getPrenom());
            pstmt.setInt(3, dresseur.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement pstmt = this.connect.prepareStatement(SQL_DELETE)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    @Override
    public Dresseur add(Dresseur dresseur) {
        int idGenere = 0;
        try (PreparedStatement pstmt = this.connect.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, dresseur.getNom());
            pstmt.setString(2, dresseur.getPrenom());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idGenere = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        dresseur.setId(idGenere);
        return dresseur;
    }
}
