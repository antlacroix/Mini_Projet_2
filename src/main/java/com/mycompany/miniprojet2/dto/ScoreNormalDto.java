package com.mycompany.miniprojet2.dto;

public class ScoreNormalDto {
    
    //variable
    private int id;
    private int time;
    private String joueur;
    private String difficulte;

    //get
    public int getId() {
        return id;
    }
    public int getTime() {
        return time;
    }
    public String getJoueur() {
        return joueur;
    }
    public String getDifficulte() {
        return difficulte;
    }
    
    //set
    public void setId(int id) {
        this.id = id;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }
    
    //constructeur
    public ScoreNormalDto(){}
    
    public ScoreNormalDto(int id, int time, String joueur, String difficulte){
        this.id = id;
        this.time = time;
        this.joueur = joueur;
        this.difficulte = difficulte;
    }
    
}
