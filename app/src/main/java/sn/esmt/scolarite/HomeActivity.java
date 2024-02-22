package sn.esmt.scolarite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Bouton Inscription
        Button buttonInscription = findViewById(R.id.buttonInscription);
        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirection vers l'activité InscriptionActivity
                startActivity(new Intent(HomeActivity.this, InscriptionActivity.class));
            }
        });

        // Bouton Liste des Étudiants
        Button buttonListeEtudiants = findViewById(R.id.buttonListeEtudiants);
        buttonListeEtudiants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Redirection vers l'activité ListeEtudiantsActivity
                startActivity(new Intent(HomeActivity.this, ListeEtudiantActivity.class));
            }
        });
    }
}
