package com.example.mysncf_jv_2022;

import java.util.HashMap;

public class Enquete {

    private HashMap<String, Candidat> lesCandidats ;

    public Enquete()
    {
        this.lesCandidats = new HashMap<>();
    }
    public void ajouterCandidat(Candidat unCandidat)
    {
        this.lesCandidats.put(unCandidat.getEmail(), unCandidat);
    }
    public Candidat getUnCandidat (String email)
    {
        return this.lesCandidats.get(email);
    }

    public HashMap<String, Candidat> getLesCandidats() {
        return lesCandidats;
    }

    public void setLesCandidats(HashMap<String, Candidat> lesCandidats) {
        this.lesCandidats = lesCandidats;
    }
}
