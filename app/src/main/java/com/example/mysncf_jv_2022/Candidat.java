package com.example.mysncf_jv_2022;

import java.util.HashMap;

public class Candidat {
    private String nom, prenom, email, trancheAge, frequence;

    private HashMap<String, Integer> lesReponses;

    public Candidat(String nom, String prenom, String email, String trancheAge, String frequence) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.trancheAge = trancheAge;
        this.frequence = frequence;
        this.lesReponses = new HashMap<>();
    }
    public void ajouterReponse (String question, int score)
    {
        this.lesReponses.put(question,score);
    }
    public float moyenne ()
    {
     float moy = 0;
     for(Integer score : this.lesReponses.values())
     {
         moy += score;
     }
     return (moy/this.lesReponses.size());
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTrancheAge() {
        return trancheAge;
    }

    public void setTrancheAge(String trancheAge) {
        this.trancheAge = trancheAge;
    }

    public String getFrequence() {
        return frequence;
    }

    public void setFrequence(String frequence) {
        this.frequence = frequence;
    }

    public HashMap<String, Integer> getLesReponses() {
        return lesReponses;
    }

    public void setLesReponses(HashMap<String, Integer> lesReponses) {
        this.lesReponses = lesReponses;
    }
}
