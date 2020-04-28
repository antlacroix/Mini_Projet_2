/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetweb_jdbc.utils;

import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yacin
 */
public class Db_Connect {
    
    private Connection connection = null;
    private String url;
    private String user;
    private String pass;
    
    public Connection OpenConnect(){
        
        this.url = "jdbc:mysql://localhost:3306/db_users?useUnicode=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        this.user = "root";
        this.pass = "Boston12a";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                this.connection = DriverManager.getConnection(this.url, this.user, this.pass);
                out.println("Connexion réussie !");
            } catch (SQLException ex) {
                Logger.getLogger(Db_Connect.class.getName()).log(Level.SEVERE, null, ex);
                out.println("Connexion échouée !");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Db_Connect.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
        return this.connection;
    }
    
    public void CloseConnect(){
        try {
            if (!this.connection.isClosed()){
                this.connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Db_Connect.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
