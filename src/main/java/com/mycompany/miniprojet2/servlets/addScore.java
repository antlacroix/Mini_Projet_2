package com.mycompany.miniprojet2.servlets;

import com.mycompany.miniprojet2.dao.ScoreNormalDao;
import com.mycompany.miniprojet2.dao.ScoreVstimeDao;
import com.mycompany.miniprojet2.dto.ScoreVstimeDto;
import com.mycompany.miniprojet2.dao.UserDao;
import com.mycompany.miniprojet2.dto.UserDto;
import com.mycompany.miniprojet2.utils.Db_Connect;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class addScore extends HttpServlet {

    //redirige l'utilisateur
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
       
        if(session.getAttribute("identifiant") != null){
            response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
        } else{
            response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
        }
    }

    //recupere les information necessaire dans des champs caché de
    //la page de jeu et les utilise afin d'ajouter un score a la BD
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //verifie si la partie est de type contre la montre
        if(request.getParameter("scoreType").equals("clocked")){
            ScoreVstimeDao vstimedao = new ScoreVstimeDao();
            try{
                vstimedao.CreateScore(
                    (String)session.getAttribute("identifiant"),
                    request.getParameter("scoreDifficulte"),
                    Integer.parseInt(request.getParameter("scoreTimeInit")),
                    Integer.parseInt(request.getParameter("scoreTimeFinal"))
                );  
            } catch(SQLException ex) {
                Logger.getLogger(addScore.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                response.sendRedirect(request.getContextPath() + "/Views/score.jsp");
            }      
        //verifie si la partie est de type normale
        } else if (request.getParameter("scoreType").equals("normal")){
            
            ScoreNormalDao normaldao = new ScoreNormalDao();
            //transforme un string format "MM : SS" en int qui corespond
            //au nombre de seconde total
            String[] a = request.getParameter("scoreTimeFinal").split(" : ");
            int f = Integer.parseInt(a[0]) + Integer.parseInt(a[1]);
            
            try{
                normaldao.CreateScore(
                    (String)session.getAttribute("identifiant"),
                    request.getParameter("scoreDifficulte"),
                    f
                );  
            } catch(SQLException ex) {
                Logger.getLogger(addScore.class.getName()).log(Level.SEVERE, null, ex);
            } finally{
                response.sendRedirect(request.getContextPath() + "/Views/score.jsp");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/Views/jeu.jsp");
        }

    }

}
