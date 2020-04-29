package com.mycompany.miniprojet2.dao;

import com.mycompany.miniprojet2.dto.ScoreVstimeDto;
import com.mycompany.miniprojet2.utils.Db_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoreVstimeDao {
    
    private static String SQL_GetScore = "SELECT * FROM scores_vstime";
    private static String SQL_NewScore = "INSERT INTO scores_vstime (joueur, difficulte, initial_time, finale_time) VALUES (?, ?, ?, ?);";
    
    private Db_Connect db_connect;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<ScoreVstimeDto> scores;
    
    public ScoreVstimeDao(){
        this.db_connect = new Db_Connect();
        this.connection = null;
        this.rs = null;
        this.ps = null;
        this.scores = new ArrayList<ScoreVstimeDto>();
    }
    
    //
    public List<ScoreVstimeDto> GetScore() throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(this.SQL_GetScore);  
            this.rs = this.ps.executeQuery();
            
            
            
            if(this.rs != null){
                while(this.rs.next()){
                    ScoreVstimeDto score = new ScoreVstimeDto();
                    
                    score.setIdscore(rs.getInt(1));
                    score.setJoueur(rs.getString(2));
                    score.setDifficulte(rs.getString(3));
                    score.setInitial_time(rs.getInt(4));
                    score.setFinale_time(rs.getInt(5));
                    
                    scores.add(score);
                }
            }
        } catch (SQLException ex){
            Logger.getLogger(ScoreNormalDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.rs.close();
                this.db_connect.CloseConnect();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return null;
    }
    
    public void CreateScore(String identifiant, String difficulte, int initialTime, int finalTime) throws SQLException{
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(SQL_NewScore);
            this.ps.setString(1, identifiant);
            this.ps.setString(2, difficulte);
            this.ps.setInt(3, initialTime);
            this.ps.setInt(4, finalTime);
            this.ps.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
}
