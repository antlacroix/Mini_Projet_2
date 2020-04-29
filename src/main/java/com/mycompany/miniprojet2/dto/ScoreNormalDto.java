package com.mycompany.miniprojet2.dto;

public class ScoreNormalDto {
    
    //variable
    private int id;
    private int time;
    private String temps;
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
    public String getTemps() {
        return temps;
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
    public void setTemps(String temps) {
        this.temps = temps;
    }
    
    
    
    
    //constructeur
    public ScoreNormalDto(){}
    
    public ScoreNormalDto(int id, String joueur, String difficulte, int time){
        this.id = id;
        this.time = time;
        this.temps = "" + String.format("%02d", time/60) + " : " + String.format("%02d", time%60);
        this.joueur = joueur;
        this.difficulte = difficulte;
    }
    
}
