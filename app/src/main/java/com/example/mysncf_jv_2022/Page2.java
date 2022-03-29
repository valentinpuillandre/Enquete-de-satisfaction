
package com.example.mysncf_jv_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page2 extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup rgProprete, rgInformation;
    private Button btSuivant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);


        this.rgProprete = (RadioGroup) findViewById(R.id.idProprete);
        this.rgInformation = (RadioGroup) findViewById(R.id.idInformation);
        this.btSuivant =(Button) findViewById(R.id.idSuivant2);

        this.btSuivant.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String rer = this.getIntent().getStringExtra("rer").toString();
        String email = this.getIntent().getStringExtra("email").toString();
        if(view.getId() == R.id.idSuivant2)
        {
            //calcul du score
            int score = 0 ;
            switch (this.rgProprete.getCheckedRadioButtonId())
            {
                case R.id.idProprete1 : score = 16; break;
                case R.id.idProprete2 : score = 12; break;
                case R.id.idProprete3 : score = 8; break;
            }
            //insertion de cette réponse dans le candidat
            SNCF.getUneEnquete(rer).getUnCandidat(email).ajouterReponse("Proprete",score);

            switch (this.rgInformation.getCheckedRadioButtonId())
            {
                case R.id.idInformation1 : score = 16; break;
                case R.id.idInformation2 : score = 12; break;
                case R.id.idInformation3 : score = 8; break;
            }
            //insertion de cette réponse dans le candidat
            SNCF.getUneEnquete(rer).getUnCandidat(email).ajouterReponse("Information",score);
            //passage à la page 2
            Intent unIntent = new Intent(this,Fin.class);
            unIntent.putExtra("rer",rer);
            unIntent.putExtra("email",email);
            this.startActivity(unIntent);
    }
}}