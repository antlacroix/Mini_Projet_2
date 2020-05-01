package com.mycompany.miniprojet2.servlets;

import com.mycompany.miniprojet2.dao.ScoreNormalDao;
import com.mycompany.miniprojet2.dao.ScoreVstimeDao;
import com.mycompany.miniprojet2.dto.ScoreNormalDto;
import com.mycompany.miniprojet2.dto.ScoreVstimeDto;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class forfeit extends HttpServlet {

    //les deux fonction doGet et doPost recupere les scores de la BD
    //et les passe en argument attribut a la page de score affin
    //qu'elle puisse les aficher
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //verifie si un utilisateur est connecter
        if(session.getAttribute("identifiant") == null)
            response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
        else{
            
            //creation des objet necessaire
            ScoreVstimeDao scoreVstimeDao = new ScoreVstimeDao();
            ScoreNormalDao scoreNormalDao = new ScoreNormalDao();
            //creation des list qui contiendront les scores
            List<ScoreVstimeDto> scoreVstimesList = null;
            List<ScoreNormalDto> scoreNormalList = null;
        
            try{
                scoreVstimesList = scoreVstimeDao.GetScore();
                scoreNormalList = scoreNormalDao.GetScore();

            } catch (SQLException ex){
                Logger.getLogger(forfeit.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(scoreVstimesList != null && scoreNormalList != null){
                request.setAttribute("scoreVstime", scoreVstimesList);
                request.setAttribute("scoreNormal", scoreNormalList);
                this.getServletContext().getRequestDispatcher("/Views/score.jsp").forward(request, response);
            }

        }
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        //verifie si un utilisateur est connecter
        if(session.getAttribute("identifiant") == null)
            response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
        else{
        
            //creation des objet necessaire
            ScoreVstimeDao scoreVstimeDao = new ScoreVstimeDao();
            ScoreNormalDao scoreNormalDao = new ScoreNormalDao();
            //creation des list qui contiendront les scores
            List<ScoreVstimeDto> scoreVstimesList = null;
            List<ScoreNormalDto> scoreNormalList = null;
        
            try{

                scoreVstimesList = scoreVstimeDao.GetScore();
                scoreNormalList = scoreNormalDao.GetScore();

            } catch (SQLException ex){
                Logger.getLogger(forfeit.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(scoreVstimesList != null && scoreNormalList != null){
                request.setAttribute("scoreVstime", scoreVstimesList);
                request.setAttribute("scoreNormal", scoreNormalList);
                this.getServletContext().getRequestDispatcher("/Views/score.jsp").forward(request, response);
            }
        }
    }

}
