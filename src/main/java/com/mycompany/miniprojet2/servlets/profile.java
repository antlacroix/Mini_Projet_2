/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miniprojet2.servlets;

import com.mycompany.miniprojet2.dao.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
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
public class profile extends HttpServlet {

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
            out.println("<title>Servlet profile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet profile at " + request.getContextPath() + "</h1>");
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
        
        HttpSession session = request.getSession();
        
        String bouttonRetour = request.getParameter("Retour");
        session.setAttribute("back",bouttonRetour);
       
            if(session.getAttribute("back") != null){
                response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
                session.setAttribute("back", null); 
                }
            else{
//                if(session.getAttribute("identifiant") == null)
//                    response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
//                else
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
        
        HttpSession session = request.getSession();
       
            String bouttonRetour2 = request.getParameter("Retour");
            session.setAttribute("back",bouttonRetour2);
       
            if(session.getAttribute("back") != null){
                response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
                session.setAttribute("back", null);
                }
            else{
       
        String nom = request.getParameter("new_data_nom");
        String prenom = request.getParameter("new_data_prenom");
        String ddn = request.getParameter("new_data_ddn");
        String mdp = request.getParameter("new_data_password");
        String mdp2 = request.getParameter("new_data_password2");  
        
        session.setAttribute("nom", nom);
        session.setAttribute("prenom", prenom);
        session.setAttribute("ddn", ddn); 
       
        if (!mdp.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()){
        
        if (mdp.equals(mdp2)){
        
        UserDao userDao = new UserDao();
        
        try {
            userDao.UpdateUser(session.getAttribute("identifiant").toString(), nom, prenom, ddn, mdp);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        } 
        this.getServletContext().getRequestDispatcher("/Views/jeu.jsp").forward(request, response);
    }   
       else{
           request.setAttribute("erreur6", "true");
           this.getServletContext().getRequestDispatcher("/Views/profile.jsp").forward(request, response);
        }
        
        } 
         
         else{
           request.setAttribute("erreur", "true");
           this.getServletContext().getRequestDispatcher("/Views/profile.jsp").forward(request, response);
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
