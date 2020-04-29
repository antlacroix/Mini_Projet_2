package com.mycompany.miniprojet2.dao;

import com.mycompany.miniprojet2.dto.ScoreDto;
import com.mycompany.miniprojet2.dto.UserDto;
import com.mycompany.miniprojet2.utils.Db_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoreDao {
    
    private String SQL_GetUser = "SELECT * FROM scores";
    
    private Db_Connect db_connect;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<ScoreDto> scores;
    
    public ScoreDao(){
        this.db_connect = new Db_Connect();
        this.connection = null;
        this.rs = null;
        this.ps = null;
        this.scores = new ArrayList<ScoreDto>();
    }
    
    public List<ScoreDto> GetScore() throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(this.SQL_GetUser);  
            this.rs = this.ps.executeQuery();
            
            
            
            if(this.rs != null){
                while(this.rs.next()){
                    ScoreDto score = new ScoreDto();
                    
                    score.setIdscore(rs.getInt(1));
                    score.setJoueur(rs.getString(2));
                    score.setDifficulte(rs.getString(3));
                    score.setTemps(rs.getString(4));
                    
                    scores.add(score);
                }
            }
        } catch (SQLException ex){
            Logger.getLogger(ScoreDao.class.getName()).log(Level.SEVERE, null, ex);
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

