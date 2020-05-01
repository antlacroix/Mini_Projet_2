package com.mycompany.miniprojet2.dto;

public class UserDto {
    //variable
    private String _nom;
    private String _prenom;
    private String _ddn;
    private String _identifiant;
    private String _email;
    private String _mdp;
    
    //get
    public String getNom() {
        return _nom;
    }
    public String getPrenom() {
        return _prenom;
    }
    public String getDdn() {
        return _ddn;
    }
    public String getIdentifiant() {
        return _identifiant;
    }
    public String getEmail() {
        return _email;
    }
    public String getMdp() {
        return _mdp;
    }
    
    //set
    public void setDdn(String _ddn) {
        this._ddn = _ddn;
    }
    public void setIdentifiant(String _identifiant) {
        this._identifiant = _identifiant;
    }
    public void setEmail(String _email) {
        this._email = _email;
    }
    public void setMdp(String _mdp) {
        this._mdp = _mdp;
    }
    public void setNom(String _nom) {
        this._nom = _nom;
    }
    public void setPrenom(String _prenom) {
        this._prenom = _prenom;
    }
    
    
    //constructeur
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
