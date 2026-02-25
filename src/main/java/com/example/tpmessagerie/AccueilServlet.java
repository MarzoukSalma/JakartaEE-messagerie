package com.example.tpmessagerie;

import com.example.tpmessagerie.DAO.DAOServices;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/")
public class AccueilServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("messages",
                DAOServices.getPublicMessages());

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("/WEB-INF/accueil.jsp");

        dispatcher.forward(request, response);
    }
}