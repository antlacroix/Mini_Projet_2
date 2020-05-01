package com.mycompany.miniprojet2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            //Fonction Bouton s'inscrire
            String bouttonInscrire = request.getParameter("Inscrire");
            HttpSession session=request.getSession();
            session.setAttribute("inscrit",bouttonInscrire);
            //Bouton s'inscrire sinon Connecter
            if(session.getAttribute("inscrit") != null)
                response.sendRedirect(request.getContextPath() + "/Views/inscription.jsp");
            else
                response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            //Fonction Bouton s'inscrire
            String bouttonInscrire = request.getParameter("Inscrire");
            HttpSession session=request.getSession();
            session.setAttribute("inscrit",bouttonInscrire);
            //Bouton s'inscrire sinon Connecter
            if(session.getAttribute("inscrit") != null)
                response.sendRedirect(request.getContextPath() + "/Views/inscription.jsp");
            else
                response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
    }

}
