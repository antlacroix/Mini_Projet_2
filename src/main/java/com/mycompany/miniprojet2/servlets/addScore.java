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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet addScore</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet addScore at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        out.println(request.getParameter("scoreType"));
        out.println("normal");
        out.println(request.getParameter("scoreType").equals("normal"));
        out.println(request.getParameter("scoreDifficulte"));
        out.println(request.getParameter("scoreTimeInit"));
        out.println(request.getParameter("scoreTimeFinal"));
        
        if(request.getParameter("scoreType").equals("clocked")){
            out.println("test2");
            ScoreVstimeDao vstimedao = new ScoreVstimeDao();
            try{
                out.println("test vstime");
                vstimedao.CreateScore(
                    (String)session.getAttribute("identifiant"),
                    request.getParameter("scoreDifficulte"),
                    Integer.parseInt(request.getParameter("scoreTimeInit")),
                    Integer.parseInt(request.getParameter("scoreTimeFinal"))
                );  
            } catch(SQLException ex) {
                Logger.getLogger(addScore.class.getName()).log(Level.SEVERE, null, ex);
            }   finally{
                response.sendRedirect(request.getContextPath() + "/Views/score.jsp");
            }      
        } else if (request.getParameter("scoreType").equals("normal")){
            
            ScoreNormalDao normaldao = new ScoreNormalDao();
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
