package com.mycompany.miniprojet2.dao;

import com.mycompany.miniprojet2.dto.ScoreNormalDto;
import com.mycompany.miniprojet2.utils.Db_Connect;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScoreNormalDao {
    
    private static String SQL_GetScore = "SELECT * FROM scores_normal ORDER BY FIELD(difficulte, 'Difficile','Moyen','Facile'), time_spent LIMIT 10";
    private static String SQL_NewScore = "INSERT INTO scores_normal (joueur, difficulte, time_spent) VALUES (?, ?, ?);";
    
    private Db_Connect db_connect;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    private List<ScoreNormalDto> scores;
    
    //constructeur
    public ScoreNormalDao(){
        this.db_connect = new Db_Connect();
        this.connection = null;
        this.rs = null;
        this.ps = null;
        this.scores = new ArrayList<ScoreNormalDto>();
    }
    
    //utilise la String "SQL_GetScore" afin de
    //retourner une list de ScoreNormal
    public List<ScoreNormalDto> GetScore() throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(this.SQL_GetScore);  
            this.rs = this.ps.executeQuery();
            
            
            
            if(this.rs != null){
                while(this.rs.next()){
                    
                    ScoreNormalDto score = new ScoreNormalDto(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4)
                    );
                    
                    scores.add(score);
                }
                
                return scores;
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
    
    //utilise la String "SQL_NewScore" afin de
    //d'ajouter un nouvel enregistrement dans la BD
    //dans la table scores_normal
    public void CreateScore(String identifiant, String difficulte, int time) throws SQLException{
        try{
            this.connection = this.db_connect.OpenConnect();
            out.println(identifiant);
            out.println(difficulte);
            out.println(time);
            this.ps = this.connection.prepareStatement(SQL_NewScore);
            this.ps.setString(1, identifiant);
            this.ps.setString(2, difficulte);
            this.ps.setInt(3, time);
            this.ps.executeUpdate();
        }catch (SQLException ex){
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
        }
    }
}

