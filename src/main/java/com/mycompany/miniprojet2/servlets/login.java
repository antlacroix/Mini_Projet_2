/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miniprojet2.servlets;

import com.mycompany.miniprojet2.dao.UserDao;
import com.mycompany.miniprojet2.dto.UserDto;
import com.mycompany.miniprojet2.utils.Db_Connect;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Maison
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       
       
       //Bouton retour 
            HttpSession session = request.getSession();
            String bouttonRetour = request.getParameter("Retour");
            session.setAttribute("back",bouttonRetour);
       
            //Bouton retour et logoff si necessaire
            if(session.getAttribute("back") != null){
                session.setAttribute("identifiant", null); 
                response.sendRedirect(request.getContextPath() + "/Views/home.jsp");
                session.setAttribute("back", null); 
                }
            else{
                //page login si pas connecter sinon page jeu
                if(session.getAttribute("identifiant") == null)
                    response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
                else
                    response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
                }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       
       //Bouton retour
        HttpSession session = request.getSession();
        String bouttonRetour = request.getParameter("Retour");
            session.setAttribute("back",bouttonRetour);
       //Bouton retour et logoff si necessaire
            if(session.getAttribute("back") != null){
                session.setAttribute("identifiant", null); 
                response.sendRedirect(request.getContextPath() + "/Views/home.jsp");
                session.setAttribute("back", null); 
                }
            
            //Bouton valider
            else{
       
       
       
       //recupere les infos de la page
        String login = request.getParameter("data_login");
        String password = request.getParameter("data_password");        
        
        UserDto userDto = null;
        UserDao userDao = new UserDao();        
        
        //verifie la base de donnee
        try {
            userDto = userDao.GetUser(login, password);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //si se log recupere ses infos et renvoie a la page jeu
        if(userDto != null){
            response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
    
            session.setAttribute("nom", userDto.getNom());
            session.setAttribute("prenom", userDto.getPrenom());
            session.setAttribute("ddn", userDto.getDdn()); 
            session.setAttribute("identifiant", userDto.getIdentifiant());   
            session.setAttribute("email", userDto.getEmail()); 
        }
        else{
            //sinon pas valide rreset page login et message erreur
            request.setAttribute("erreur", "true");
            this.getServletContext().getRequestDispatcher("/Views/login.jsp").forward(request, response);
        }
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
