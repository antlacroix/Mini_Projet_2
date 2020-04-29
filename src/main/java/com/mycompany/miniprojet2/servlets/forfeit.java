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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet forfeit</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet forfeit at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(session.getAttribute("identifiant") == null)
            response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
        else
            response.sendRedirect(request.getContextPath() + "/Views/score.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        ScoreVstimeDao scoreVstimeDao = new ScoreVstimeDao();
        ScoreNormalDao scoreNormalDao = new ScoreNormalDao();
        
        List<ScoreVstimeDto> scoreVstimesList = null;
        List<ScoreNormalDto> scoreNormalList = null;
        
        
        if(session.getAttribute("identifiant") == null)
            response.sendRedirect(request.getContextPath() + "/Views/login.jsp");
        else{
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
