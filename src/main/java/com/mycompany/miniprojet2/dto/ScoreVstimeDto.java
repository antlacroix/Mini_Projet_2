package com.mycompany.miniprojet2.dto;

public class ScoreVstimeDto {
    
    //varriable
    private int idscore;
    private int initial_time;
    private int finale_time;
    private String joueur;
    private String difficulte;

    //set
    public void setIdscore(int idscore) {
        this.idscore = idscore;
    }
    public void setInitial_time(int initial_time) {
        this.initial_time = initial_time;
    }
    public void setFinale_time(int finale_time) {
        this.finale_time = finale_time;
    }
    public void setJoueur(String joueur) {
        this.joueur = joueur;
    }
    public void setDifficulte(String difficulte) {
        this.difficulte = difficulte;
    }
    
    //get
    public int getIdscore() {
        return idscore;
    }
    public int getInitial_time() {
        return initial_time;
    }
    public int getFinale_time() {
        return finale_time;
    }
    public String getJoueur() {
        return joueur;
    }
    public String getDifficulte() {
        return difficulte;
    }
    
    //constructeur
    public ScoreVstimeDto(){}
    
    public ScoreVstimeDto(int id, int initialTime, int finalTime, String joueur, String difficulte){
        this.idscore = id;
        this.initial_time = initialTime;
        this.finale_time = finalTime;
        this.joueur = joueur;
        this.difficulte = difficulte;
    }
}

