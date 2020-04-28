/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetweb_jdbc.dao;

import com.mycompany.projetweb_jdbc.dto.UserDto;
import com.mycompany.projetweb_jdbc.utils.Db_Connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yacin
 */
public class UserDao {
    private String SQL_GetUser = "SELECT * FROM users WHERE username=? AND password=?";
    private String SQL_UpdatePassword = "UPDATE users SET password=? WHERE username=?";
    private String SQL_CreateUser = "INSERT INTO users(username, password, fullname, type) VALUES(?, ?, ?, ?)";
    
    private Db_Connect db_connect;
    private Connection connection;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public UserDao(){
        this.db_connect = new Db_Connect();
        this.connection = null;
        this.rs = null;
        this.ps = null;
    }    
    
    public UserDto GetUser(String username, String password) throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(this.SQL_GetUser);
            this.ps.setString(1, username);
            this.ps.setString(2, password);   
            this.rs = this.ps.executeQuery();
            
            UserDto user = new UserDto();
            
            if(this.rs != null){
                while(this.rs.next()){   

                    user.setUsername(rs.getString(2));
                    user.setPassword(rs.getString(3));
                    user.setFullname(rs.getString(4));
                    user.setType(rs.getString(5));

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
    
    public void UpdatePassword(String username, String password) throws SQLException{

        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(SQL_UpdatePassword);
            this.ps.setString(1, password);
            this.ps.setString(2, username);
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
    
    public void CreateUser(String username, String password, String fullname, String type) throws SQLException{
        
        try{
            this.connection = this.db_connect.OpenConnect();
            this.ps = this.connection.prepareStatement(SQL_CreateUser);
            this.ps.setString(1, username);
            this.ps.setString(2, password);
            this.ps.setString(3, fullname);
            this.ps.setString(4, type);
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
}
