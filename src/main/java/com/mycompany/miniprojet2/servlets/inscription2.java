package com.mycompany.miniprojet2.servlets;

import com.mycompany.miniprojet2.dao.UserDao;
import com.mycompany.miniprojet2.dto.UserDto;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class inscription2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
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
            //recupere les nouvelles infos pour validation
            String identifiant = request.getParameter("new_user_data_identifiant");
            String email = request.getParameter("new_user_data_email"); 
            String mdp1 = request.getParameter("new_user_data_password");
            String mdp2 = request.getParameter("new_user_data_password2"); 
            String nom = request.getParameter("new_user_data_nom");
            String prenom = request.getParameter("new_user_data_prenom");
  
            //expression reguliere email
            Pattern p = Pattern.compile(".+@.+\\.[a-z]+"); 
            Matcher m = p.matcher(email); 
            boolean matchFound = m.matches();  
            
            //verifie si pas de champs vide
            if (matchFound && !identifiant.isEmpty() && !email.isEmpty() && !mdp1.isEmpty() && !nom.isEmpty() && !prenom.isEmpty()) {
                //verifie si les mots de passe coresponde
                if (mdp1.equals(mdp2)){
           
                    UserDto userDto2 = null;
                    UserDao userDao = new UserDao();        
                    
                    //verifie si identifiant et ou email sont pas deja dans la base de donne
                    try {
                        userDto2 = userDao.ValidateUser(identifiant, email);
                        if(userDto2!= null){
                            //message erreur identifiant et ou email existe
                            request.setAttribute("erreur1", "true");
                            this.getServletContext().getRequestDispatcher("/Views/inscription.jsp").forward(request, response);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                    this.getServletContext().getRequestDispatcher("/inscription").forward(request, response);
                }  
                else{
                    //message erreur mot de passe pas identitique 
                    request.setAttribute("erreur6", "true");
                    this.getServletContext().getRequestDispatcher("/Views/inscription.jsp").forward(request, response);
                } 
            } 
            //message erreur champs vide
            else{
                request.setAttribute("erreur", "true");
                this.getServletContext().getRequestDispatcher("/Views/inscription.jsp").forward(request, response);
            }   
        }         
    }
}
