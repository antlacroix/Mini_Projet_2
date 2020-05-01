package com.mycompany.miniprojet2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BackToGame extends HttpServlet {
    //les deux fonction doGet et doPostservent
    //a rediriger l'utilisateur vers
    //la page de jeu si il est coonecter ou 
    //la page de de home si il ne l'est pas
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("identifiant") == null)
            response.sendRedirect(request.getContextPath() + "/Views/home.jsp");
        else
            response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("identifiant") == null)
            response.sendRedirect(request.getContextPath() + "/Views/home.jsp");
        else
            response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
    }
}
