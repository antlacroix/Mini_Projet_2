package com.mycompany.miniprojet2.dto;

public class ScoreDto {
  
    private int _idscore;
    private String _joueur;
    private String _difficulte;
    private String _temps;
    

    public int getIdscore() {
        return _idscore;
    }

    public String getJoueur() {
        return _joueur;
    }

    public String getDifficulte() {
        return _difficulte;
    }

    public String getTemps() {
        return _temps;
    }

    public void setIdscore(int _idscore) {
        this._idscore = _idscore;
    }

    public void setJoueur(String _joueur) {
        this._joueur = _joueur;
    }

    public void setDifficulte(String _difficulte) {
        this._difficulte = _difficulte;
    }

    public void setTemps(String _temps) {
        this._temps = _temps;
    }
    
    
 //   public ScoreDao(int idscore, String joueur, String difficulte, String temps){
 //       this._idscore = idscore;
 //       this._joueur = joueur;
  //      this._difficulte = difficulte;
  //      this._temps = temps;
   // }
}

