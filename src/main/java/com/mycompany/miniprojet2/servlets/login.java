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


public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                session.setAttribute("nom", userDto.getNom());
                session.setAttribute("prenom", userDto.getPrenom());
                session.setAttribute("ddn", userDto.getDdn()); 
                session.setAttribute("identifiant", userDto.getIdentifiant());   
                session.setAttribute("email", userDto.getEmail()); 

                response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
            }
            else{
                //sinon pas valide rreset page login et message erreur
                request.setAttribute("erreur", "true");
                this.getServletContext().getRequestDispatcher("/Views/login.jsp").forward(request, response);
            }
        }
    }
}
