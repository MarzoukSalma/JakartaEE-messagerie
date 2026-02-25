package com.example.tpmessagerie.DAO;

import com.example.tpmessagerie.Message;
import com.example.tpmessagerie.Personne;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOServices {

    // 🔹 1️⃣ Messages publics (idPersonne = 1)
    public static List<Message> getPublicMessages() {

        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM message WHERE idpersonne = 1";

        try (Connection conn = DAOUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Message m = new Message();
                m.setIdMessage(rs.getInt("idmessage"));
                m.setSujet(rs.getString("sujet"));
                m.setContenu(rs.getString("contenu"));
                m.setIdPersonne(rs.getInt("idpersonne"));
                messages.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    // 🔹 2️⃣ Sujets publics uniquement
    public static List<String> getPublicSubjects() {

        List<String> sujets = new ArrayList<>();
        String sql = "SELECT sujet FROM message WHERE idpersonne = 1";

        try (Connection conn = DAOUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                sujets.add(rs.getString("sujet"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sujets;
    }

    // 🔹 3️⃣ Inscription utilisateur
    public static boolean registerUser(String nom, String prenom, String motDePasse) {

        String sql = "INSERT INTO personne (nom, prenom, motdepasse) VALUES (?, ?, ?)";

        try (Connection conn = DAOUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, motDePasse);

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    // 🔹 4️⃣ Authentification utilisateur
    public static Personne authenticate(String nom, String prenom, String motDePasse) {

        String sql = "SELECT * FROM personne WHERE nom = ? AND prenom = ? AND motdepasse = ?";

        try (Connection conn = DAOUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nom);
            ps.setString(2, prenom);
            ps.setString(3, motDePasse);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Personne p = new Personne();
                p.setIdPersonne(rs.getInt("idpersonne"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setMotDePasse(rs.getString("motdepasse"));
                return p;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // 🔹 5️⃣ Messages privés d’un utilisateur
    public static List<Message> getUserMessages(int idPersonne) {

        List<Message> messages = new ArrayList<>();
        String sql = "SELECT * FROM message WHERE idpersonne = ?";

        try (Connection conn = DAOUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idPersonne);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Message m = new Message();
                m.setIdMessage(rs.getInt("idmessage"));
                m.setSujet(rs.getString("sujet"));
                m.setContenu(rs.getString("contenu"));
                m.setIdPersonne(rs.getInt("idpersonne"));
                messages.add(m);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }

    // 🔹 6️⃣ Toutes les personnes
    public static List<Personne> getAllPersonnes() {

        List<Personne> personnes = new ArrayList<>();
        String sql = "SELECT * FROM personne";

        try (Connection conn = DAOUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Personne p = new Personne();
                p.setIdPersonne(rs.getInt("idpersonne"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setMotDePasse(rs.getString("motdepasse"));
                personnes.add(p);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return personnes;
    }
}