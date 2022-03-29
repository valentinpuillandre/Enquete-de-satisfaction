package com.example.mysncf_jv_2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Fin extends AppCompatActivity implements View.OnClickListener {
    private Button btRetour;
    private TextView tvResultat ;
    private ImageView imgSmyle;
    private ListView lvListe;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);

        this.tvResultat=(TextView) findViewById(R.id.idResultat);
        this.imgSmyle= (ImageView) findViewById(R.id.idSmyley);
        this.lvListe = (ListView) findViewById(R.id.idListe);
        this.btRetour = (Button) findViewById(R.id.idRetour);

        this.btRetour.setOnClickListener(this);

        String rer = this.getIntent().getStringExtra("rer").toString();
        String email = this.getIntent().getStringExtra("email").toString();

        float moy = SNCF.getUneEnquete(rer).getUnCandidat(email).moyenne();
        this.tvResultat.setText("Vous avez donné la moyenne : " + moy);

        if(moy < 10)
        {
            this.imgSmyle.setImageResource(R.drawable.smyle_mecontent);
        }
        else if(moy <14)
        {
            this.imgSmyle.setImageResource(R.drawable.smyle_neutre);
        }
        else
        {
            this.imgSmyle.setImageResource(R.drawable.smyle_content);
        }

        //lister tous les candidats
        ArrayList<String> lesLignes = new ArrayList<>();
        for(Candidat unCandidat : SNCF.getUneEnquete(rer).getLesCandidats().values())
        {
            lesLignes.add(unCandidat.getNom() +"    "+unCandidat.getPrenom()+"    "+unCandidat.getEmail());
        }
        ArrayAdapter unAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lesLignes);
        this.lvListe.setAdapter(unAdapter);
     }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idRetour)
        {
            Toast.makeText(this, "Merci d'avoir répondu à nos questions",Toast.LENGTH_LONG).show();
            Intent unIntent = new Intent(this,MainActivity.class);
            this.startActivity(unIntent);
        }

    }
}