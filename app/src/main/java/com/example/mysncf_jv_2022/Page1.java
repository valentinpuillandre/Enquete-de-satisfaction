package com.example.mysncf_jv_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RadioGroup;

public class Page1 extends AppCompatActivity  implements View.OnClickListener{
    private RadioGroup rgPonctualite, rgService;
    private Button btSuivant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        this.rgPonctualite = (RadioGroup) findViewById(R.id.idPonctualite);
        this.rgService = (RadioGroup) findViewById(R.id.idService);
        this.btSuivant =(Button) findViewById(R.id.idSuivant1);
        this.btSuivant.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
    String rer = this.getIntent().getStringExtra("rer").toString();
        String email = this.getIntent().getStringExtra("email").toString();
        if(view.getId() == R.id.idSuivant1)
        {
            //calcul du score
            int score = 0 ;
            switch (this.rgPonctualite.getCheckedRadioButtonId())
            {
                case R.id.idPonctualite1 : score = 16; break;
                case R.id.idPonctualite2 : score = 12; break;
                case R.id.idPonctualite3 : score = 8; break;
            }
            //insertion de cette réponse dans le candidat
            SNCF.getUneEnquete(rer).getUnCandidat(email).ajouterReponse("Ponctualité",score);

            switch (this.rgService.getCheckedRadioButtonId())
            {
                case R.id.idService1 : score = 16; break;
                case R.id.idService2 : score = 12; break;
                case R.id.idService3 : score = 8; break;
            }
            //insertion de cette réponse dans le candidat
            SNCF.getUneEnquete(rer).getUnCandidat(email).ajouterReponse("Service",score);
            //passage à la page 2
            Intent unIntent = new Intent(this,Page2.class);
            unIntent.putExtra("rer",rer);
            unIntent.putExtra("email",email);
            this.startActivity(unIntent);
        }

    }
}