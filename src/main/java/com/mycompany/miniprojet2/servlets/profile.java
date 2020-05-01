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

public class profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // processRequest(request, response);
        
       
        //Bouton retour 
        HttpSession session = request.getSession();
        
        String bouttonRetour = request.getParameter("Retour");
        session.setAttribute("back",bouttonRetour);
        //Bouton retour 
            if(session.getAttribute("back") != null){
                response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
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
        // processRequest(request, response);
        
       
        //Bouton retour
        HttpSession session = request.getSession();
       
        String bouttonRetour2 = request.getParameter("Retour");
        session.setAttribute("back",bouttonRetour2);
        //Bouton retour 
        if(session.getAttribute("back") != null){
            response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
            session.setAttribute("back", null);
        }
        else{
               //Bouton enregistrer
       
            //recupere les nouvelles infos
            String nom = request.getParameter("new_data_nom");
            String prenom = request.getParameter("new_data_prenom");
            String ddn = request.getParameter("new_data_ddn");
            String mdp = request.getParameter("new_data_password");
            String mdp2 = request.getParameter("new_data_password2");  

            //set les nouvelles infos
            session.setAttribute("nom", nom);
            session.setAttribute("prenom", prenom);
            session.setAttribute("ddn", ddn); 

            //test si pas de champs vide
            if (!mdp.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()){
                //test mot de passe paraille
                if (mdp.equals(mdp2)){
        
                    UserDao userDao = new UserDao();
        
                    //mise a jour de user
                    try {
                        userDao.UpdateUser(session.getAttribute("identifiant").toString(), nom, prenom, ddn, mdp);
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    this.getServletContext().getRequestDispatcher("/Views/jeu.jsp").forward(request, response);
                }   
                else{
                    //message erreur mot de passe pas identitique 
                    request.setAttribute("erreur6", "true");
                    this.getServletContext().getRequestDispatcher("/Views/profile.jsp").forward(request, response);
                }
            } 
            else{
               //message erreur champs vide
              request.setAttribute("erreur", "true");
              this.getServletContext().getRequestDispatcher("/Views/profile.jsp").forward(request, response);
            }
        }        
    }
}
