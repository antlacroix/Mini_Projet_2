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

public class inscription extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
         HttpSession session = request.getSession();
            //Bouton retour 
            String bouttonRetour = request.getParameter("Retour");
            session.setAttribute("back",bouttonRetour);
            //Bouton retour 
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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Bouton retour
        HttpSession session = request.getSession();
        String bouttonRetour = request.getParameter("Retour");
            session.setAttribute("back",bouttonRetour);
        //Bouton retour 
            if(session.getAttribute("back") != null){
                session.setAttribute("identifiant", null); 
                response.sendRedirect(request.getContextPath() + "/Views/home.jsp");
                session.setAttribute("back", null); 
                session.setAttribute("erreur1", "false");
                }
            else{
        
                   //bouton valider
        //recupere les nouvelles infos
        
        session.setAttribute("erreur1", "false");
 
        String nom = request.getParameter("new_user_data_nom");
        String prenom = request.getParameter("new_user_data_prenom");
        String ddn = request.getParameter("new_user_data_ddn");
        String identifiant = request.getParameter("new_user_data_identifiant");
        String email = request.getParameter("new_user_data_email");
        String mdp = request.getParameter("new_user_data_password");
  
        //set les infos
        session.setAttribute("nom", nom);
        session.setAttribute("prenom", prenom);
        session.setAttribute("ddn", ddn); 
        session.setAttribute("identifiant", identifiant);   
        session.setAttribute("email", email); 
        
        UserDao userDao = new UserDao();        
        //enregistre nouvelle user
        try {
            userDao.CreateUser(nom, prenom, ddn, identifiant, email, mdp);
        } catch (SQLException ex) {
            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
        }    
        this.getServletContext().getRequestDispatcher("/Views/jeu.jsp").forward(request, response);
        }
    }


}
