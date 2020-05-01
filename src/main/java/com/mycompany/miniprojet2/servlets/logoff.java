package com.mycompany.miniprojet2.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class logoff extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //logoff et renvoie a la page acceuil
        HttpSession session = request.getSession();
        session.setAttribute("identifiant", null); 
        this.getServletContext().getRequestDispatcher("/Views/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
        //logoff et renvoie a la page acceuil
        HttpSession session = request.getSession();
         session.setAttribute("identifiant", null); 
         this.getServletContext().getRequestDispatcher("/Views/home.jsp").forward(request, response);
    }
}
