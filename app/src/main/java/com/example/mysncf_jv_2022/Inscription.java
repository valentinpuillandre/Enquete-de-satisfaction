package com.example.mysncf_jv_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {
    private EditText txtNom, txtPrenom, txtEmail;
    private Spinner spAge, spFrequence;
    private Button btParticiper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.txtEmail = (EditText) findViewById(R.id.idEmail);

        this.spAge = (Spinner) findViewById(R.id.idAge);
        this.spFrequence = (Spinner) findViewById(R.id.idFrequence);
        this.btParticiper = (Button) findViewById(R.id.idParticiper);

        this.btParticiper.setOnClickListener(this);

        //remplir le Spinner AGE.
        ArrayList<String> lesAges = new ArrayList<>();
        lesAges.add("moins de 18 ans");
        lesAges.add("De 18 ans à 35 ans");
        lesAges.add("De 36 ans à 64 ans");
        lesAges.add("De 65 ans et plus ");
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lesAges);
        this.spAge.setAdapter(unAdapter);

        //remplir le Spinner Fréquence.
        ArrayList<String> lesFrequences = new ArrayList<>();
        lesFrequences.add("Quotidienne");
        lesFrequences.add("Hebdomadaire");
        lesFrequences.add("Mensuelle");
        lesFrequences.add("Annuelle");
        ArrayAdapter unAdapter2 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, lesFrequences);
        this.spFrequence.setAdapter(unAdapter2);
    }

    @Override
    public void onClick(View v) {
    String rer = this.getIntent().getStringExtra("rer").toString();
    if(v.getId() == R.id.idParticiper)
    {
        //on verifie les données d'abord
        String email = this.txtEmail.getText().toString();
        String nom = this.txtNom.getText().toString();
        String prenom = this.txtPrenom.getText().toString();
        String trancheAge = this.spAge.getSelectedItem().toString();
        String frequence = this.spFrequence.getSelectedItem().toString();

        //instanciation d'un candidat
        Candidat unCandidat = new Candidat(nom,prenom,email,trancheAge, frequence);

        //insertion de ce candidat dans l'enquete qu'il aura choisit
        SNCF.getUneEnquete(rer).ajouterCandidat(unCandidat);

        //on passe à la page 1 de l'enquête
        Intent unIntent = new Intent(this,Page1.class);
        unIntent.putExtra("rer",rer);
        unIntent.putExtra("email",email);
        this.startActivity(unIntent);

    }
    }
}