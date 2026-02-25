package com.example.tpmessagerie;

import com.example.tpmessagerie.DAO.DAOServices;
import com.example.tpmessagerie.DAO.HashUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/inscription")
public class InscriptionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/inscription.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String motDePasse = request.getParameter("motDePasse");

        // 🔐 Hash du mot de passe
        String hashedPassword = HashUtil.hashPassword(motDePasse);

        boolean success =
                DAOServices.registerUser(nom, prenom, hashedPassword);

        if (success) {
            response.sendRedirect(
                    request.getContextPath() + "/accueil");
        } else {
            request.setAttribute("message",
                    "Erreur lors de l'inscription !");
            request.getRequestDispatcher("/WEB-INF/inscription.jsp")
                    .forward(request, response);
        }
    }
}