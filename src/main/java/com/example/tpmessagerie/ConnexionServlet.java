package com.example.tpmessagerie;

import com.example.tpmessagerie.DAO.DAOServices;
import com.example.tpmessagerie.DAO.HashUtil;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/connexion")
public class ConnexionServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/connexion.jsp")
                .forward(request, response);
    }

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String motDePasse = request.getParameter("motDePasse");

        String hashed = HashUtil.hashPassword(motDePasse);

        Personne user =
                DAOServices.authenticate(nom, prenom, hashed);

        if (user != null) {

            HttpSession session = request.getSession();
            session.setAttribute("user", user);

            List<Message> messages =
                    DAOServices.getUserMessages(user.getIdPersonne());

            request.setAttribute("messages", messages);

            request.getRequestDispatcher("/WEB-INF/compte.jsp")
                    .forward(request, response);

        } else {

            request.setAttribute("error",
                    "Identifiants incorrects !");
            request.getRequestDispatcher("/WEB-INF/connexion.jsp")
                    .forward(request, response);
        }
    }
}