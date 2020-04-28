/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.projetweb_jdbc.dto;

/**
 *
 * @author yacin
 */
public class UserDto {

    public String getUsername() {
        return _username;
    }

    public void setUsername(String _username) {
        this._username = _username;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String _password) {
        this._password = _password;
    }

    public String getFullname() {
        return _fullname;
    }

    public void setFullname(String _fullname) {
        this._fullname = _fullname;
    }

    public String getType() {
        return _type;
    }

    public void setType(String _type) {
        this._type = _type;
    }
    
    private String _username;
    private String _password;
    private String _fullname;
    private String _type;
    
    public UserDto(){
        
    }
    
    public UserDto(String username, String password, String fullname, String type){
        this._username = username;
        this._password = password;
        this._fullname = fullname;
        this._type = type;
    }    
}
