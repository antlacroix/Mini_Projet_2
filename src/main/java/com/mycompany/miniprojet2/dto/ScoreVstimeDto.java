package com.mycompany.miniprojet2.dto;

public class ScoreVstimeDto {
    
    //varriable
    private int idscore;
    private int initial_time;
    private String temp_init;
    private int finale_time;
    private String temp_fin;
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
    public void setTemp_init(String temp_init) {
        this.temp_init = temp_init;
    }
    public void setTemp_fin(String temp_fin) {
        this.temp_fin = temp_fin;
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
    public String getTemp_init() {
        return temp_init;
    }
    public String getTemp_fin() {
        return temp_fin;
    }
    
    
    //constructeur
    public ScoreVstimeDto(){}
    
    public ScoreVstimeDto(int id, String joueur, String difficulte, int initialTime, int finalTime){
        this.idscore = id;
        this.initial_time = initialTime;
        this.temp_init = "" + String.format("%02d", initialTime/60) + " : " + String.format("%02d", initialTime%60);
        this.finale_time = finalTime;
        this.temp_fin = "" + String.format("%02d", finalTime/60) + " : " + String.format("%02d", finalTime%60);
        this.joueur = joueur;
        this.difficulte = difficulte;
    }
}

