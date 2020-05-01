package com.mycompany.miniprojet2.dao;

import com.mycompany.miniprojet2.dto.UserDto;
import com.mycompany.miniprojet2.utils.Db_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


//requete SQL
public class UserDao {
    //verifie le login avec user et password
    private static String SQL_GetUser = "SELECT * FROM users WHERE identifiant=? AND mdp=?";
    //mise a jour de l'user
    private static String SQL_UpdateUser = "UPDATE users SET nom=?, prenom=?, ddn=?, mdp=? WHERE identifiant=?";
    //create new user
    private static String SQL_CreateUser = "INSERT INTO users(nom, prenom, ddn, identifiant, email, mdp) VALUES(?, ?, ?, ?, ?, ?)";
    //verifier sil l'identifiant et ou l'email existe dans la base de donnée
    private static String SQL_Validate = "SELECT * FROM users Where identifiant=? || email=?";
     
    
    //connection a la base de donnee
    private Db_Connect db_connect;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    
    
    //class user
     public UserDao(){
        this.db_connect = new Db_Connect();
        this.connection = null;
        this.rs = null;
        this.ps = null;
    } 
     
     
    //verifie le login avec user et password
    public UserDto GetUser(String identifiant, String mdp) throws SQLException{
        
         
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(this.SQL_GetUser);
            this.ps.setString(1, identifiant);
            this.ps.setString(2, mdp);   
            this.rs = this.ps.executeQuery();
            
            UserDto user = new UserDto();
            
            //si l'user existe, recupere tout ses infos
            if(this.rs != null){
                while(this.rs.next()){   

                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDdn(rs.getString(4));
                    user.setIdentifiant(rs.getString(5));
                    user.setEmail(rs.getString(6));
                    user.setMdp(rs.getString(7));

                    return user;
                }                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
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
     
    //mise a jour de l'user
    public void UpdateUser(String identifiant, String nom, String prenom, String ddn, String mdp) throws SQLException{

        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(SQL_UpdateUser);
            this.ps.setString(1, nom);
            this.ps.setString(2, prenom);
            this.ps.setString(3, ddn);
            this.ps.setString(4, mdp);
            this.ps.setString(5, identifiant);
            this.ps.executeUpdate();      
            
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.ps.close();
                this.db_connect.CloseConnect();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
       
    //create new user
    public void CreateUser(String nom, String prenom, String ddn, String identifiant, String email, String mdp) throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(SQL_CreateUser);
            this.ps.setString(1, nom);
            this.ps.setString(2, prenom);
            this.ps.setString(3, ddn);
            this.ps.setString(4, identifiant);
            this.ps.setString(5, email);
            this.ps.setString(6, mdp);
            this.ps.executeUpdate();   
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                this.ps.close();
                this.db_connect.CloseConnect();
            } catch (SQLException ex) {
                Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    //verifier sil l'identifiant et ou l'email existe dans la base de donnée et creer un objet contenant la liste
    public UserDto ValidateUser(String identifiant, String email) throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(this.SQL_Validate);
            this.ps.setString(1, identifiant);
            this.ps.setString(2, email);   
            this.rs = this.ps.executeQuery();
            
            UserDto user = new UserDto();
            //recupere tout les infos d
            if(this.rs != null){
                while(this.rs.next()){   

                    user.setNom(rs.getString(2));
                    user.setPrenom(rs.getString(3));
                    user.setDdn(rs.getString(4));
                    user.setIdentifiant(rs.getString(5));
                    user.setEmail(rs.getString(6));
                    user.setMdp(rs.getString(7));

                    return user;
                }                
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
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



