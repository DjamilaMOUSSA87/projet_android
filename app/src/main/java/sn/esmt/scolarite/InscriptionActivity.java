package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

public class InscriptionActivity extends AppCompatActivity {

    private EditText editTextNom, editTextPrenom, editTextAdresse, editTextTelephone, editTextEmail;
    private Spinner spinnerGenre;
    private Button buttonInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Liaison des vues avec les éléments de l'interface utilisateur
        editTextNom = findViewById(R.id.editTextNom);
        editTextPrenom = findViewById(R.id.editTextPrenom);
        editTextAdresse = findViewById(R.id.editTextAdresse);
        editTextTelephone = findViewById(R.id.editTextTelephone);
        editTextEmail = findViewById(R.id.editTextEmail);
        spinnerGenre = findViewById(R.id.spinnerGenre);
        buttonInscription = findViewById(R.id.buttonInscription);

        // Remplir le spinner avec les options de genre
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.genres_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerGenre.setAdapter(adapter);

        // Action lorsque le bouton Inscrire est cliqué
        buttonInscription.setOnClickListener(v -> inscrireEtudiant());
    }

    // Méthode pour inscrire un étudiant
    private void inscrireEtudiant() {
        // Récupérer les valeurs des champs
        String nom = editTextNom.getText().toString().trim();
        String prenom = editTextPrenom.getText().toString().trim();
        String genre = spinnerGenre.getSelectedItem().toString();
        String adresse = editTextAdresse.getText().toString().trim();
        String telephone = editTextTelephone.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        // Vérifier si les champs sont vides
        if (nom.isEmpty() || prenom.isEmpty() || genre.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
        } else {
            // Effectuer l'inscription (sauvegarde des données dans une base de données, envoi à un serveur, etc.)
            // Ici, tu peux mettre la logique pour enregistrer les données dans la base de données ou ailleurs
            // Par exemple :
            // databaseManager.saveEtudiant(nom, prenom, genre, adresse, telephone, email);

            // Afficher un message de succès
            Toast.makeText(this, "Étudiant inscrit avec succès", Toast.LENGTH_SHORT).show();
        }
    }

    private void retournerVersHome() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
