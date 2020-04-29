package com.mycompany.miniprojet2.dao;

import com.mycompany.miniprojet2.dto.ScoreNormalDto;
import com.mycompany.miniprojet2.utils.Db_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoreNormalDao {
    
    private String SQL_GetUser = "SELECT * FROM scores_normal";
    
    private Db_Connect db_connect;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<ScoreNormalDto> scores;
    
    public ScoreNormalDao(){
        this.db_connect = new Db_Connect();
        this.connection = null;
        this.rs = null;
        this.ps = null;
        this.scores = new ArrayList<ScoreNormalDto>();
    }
    
    public List<ScoreNormalDto> GetScore() throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(this.SQL_GetUser);  
            this.rs = this.ps.executeQuery();
            
            
            
            if(this.rs != null){
                while(this.rs.next()){
                    ScoreNormalDto score = new ScoreNormalDto();
                    
                    score.setId(rs.getInt(1));
                    score.setJoueur(rs.getString(2));
                    score.setDifficulte(rs.getString(3));
                    score.setTime(rs.getInt(4));
                    
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
}

