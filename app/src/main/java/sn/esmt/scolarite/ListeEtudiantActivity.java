package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListeEtudiantActivity extends AppCompatActivity {

    private ListView listViewEtudiants;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> listeEtudiants; // Supposons que tu stockes ici une liste de noms d'étudiants

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_etudiant);

        // Liaison de la ListView avec l'élément de l'interface utilisateur
        listViewEtudiants = findViewById(R.id.listViewEtudiants);

        // Initialisation de la liste d'étudiants
        listeEtudiants = new ArrayList<>();
        // Ajoute les noms des étudiants à la liste
        listeEtudiants.add("Jean Dupont");
        listeEtudiants.add("Marie Martin");
        listeEtudiants.add("Ahmed Ben Salah");
        // ...

        // Création de l'adaptateur pour la ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listeEtudiants);

        // Attribution de l'adaptateur à la ListView
        listViewEtudiants.setAdapter(adapter);
    }

    private void retournerVersHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
