/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.miniprojet2.dto;

/**
 *
 * @author Maison
 */
public class UserDto {

    public String getNom() {
        return _nom;
    }

    public void setNom(String _nom) {
        this._nom = _nom;
    }

    public String getPrenom() {
        return _prenom;
    }

    public void setPrenom(String _prenom) {
        this._prenom = _prenom;
    }

    public String getDdn() {
        return _ddn;
    }

    public void setDdn(String _ddn) {
        this._ddn = _ddn;
    }

    public String getIdentifiant() {
        return _identifiant;
    }

    public void setIdentifiant(String _identifiant) {
        this._identifiant = _identifiant;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String _email) {
        this._email = _email;
    }

    public String getMdp() {
        return _mdp;
    }

    public void setMdp(String _mdp) {
        this._mdp = _mdp;
    }
    
    private String _nom;
    private String _prenom;
    private String _ddn;
    private String _identifiant;
    private String _email;
    private String _mdp;
    
    public UserDto(){
        
    }
    
    public UserDto(String nom, String prenom, String ddn, String identifiant, String email, String mdp){
        this._nom = nom;
        this._prenom = prenom;
        this._ddn = ddn;
        this._identifiant = identifiant;
        this._email = email;
        this._mdp = mdp;
    }
}
