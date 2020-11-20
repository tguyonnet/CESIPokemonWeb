package fr.tguyonnet.DAO;

import fr.tguyonnet.Models.Attaque;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AttaqueDAO implements DAO<Attaque> {
    final static String SQL_INSERT = "INSERT INTO attaque (nom, force) values(?, ?)";
    final static String SQL_SELECT_ALL = "SELECT id, nom, force FROM attaque";
    final static String SQL_SELECT_1 = "SELECT id, nom, force FROM attaque WHERE id=?";
    final static String SQL_DELETE = "DELETE FROM attaque WHERE id=?";
    final static String SQL_UPDATE = "UPDATE attaque SET nom=?, force=? WHERE id=?";

    @Override
    public Attaque get(int id) {
        Attaque attaque = new Attaque();
        try (PreparedStatement pstmt = this.connect.prepareStatement(SQL_SELECT_1)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                attaque.setId(rs.getInt("id"));
                attaque.setNom(rs.getString("nom"));
                attaque.setForce(rs.getInt("force"));
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return attaque;
    }

    @Override
    public List<Attaque> getAll() {
        // Retourne la liste des Pokémons en base
        List<Attaque> listeDesAttaques = new ArrayList<Attaque>();
        try (Statement stmt = this.connect.createStatement()) {
            ResultSet rs = stmt.executeQuery(SQL_SELECT_ALL);
            while (rs.next()) {
                Attaque attaque = new Attaque(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getInt("force")
                );
                listeDesAttaques.add(attaque);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return listeDesAttaques;
    }

    @Override
    public void update(Attaque attaque) {
        try (PreparedStatement pstmt = this.connect.prepareStatement(SQL_UPDATE)) {
            pstmt.setString(1, attaque.getNom());
            pstmt.setInt(2, attaque.getForce());
            pstmt.setInt(3, attaque.getId());
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
    public Attaque add(Attaque attaqueAinserer) {
        int idGenere = 0;
        try (PreparedStatement pstmt = this.connect.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, attaqueAinserer.getNom());
            pstmt.setInt(2, attaqueAinserer.getForce());
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idGenere = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        attaqueAinserer.setId(idGenere);
        return attaqueAinserer;
    }
}