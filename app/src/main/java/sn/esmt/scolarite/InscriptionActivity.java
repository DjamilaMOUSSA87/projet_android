package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import sn.esmt.scolarite.http.Api;
import sn.esmt.scolarite.http.EtudiantResponce;

public class InscriptionActivity extends AppCompatActivity {

    private EditText editTextNom, editTextPrenom, editTextAdresse, editTextTelephone, editTextFrais, editTextmat;
    private Button buttonInscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        // Liaison des vues avec les éléments de l'interface utilisateur
        editTextmat = (EditText) findViewById(R.id.editTextmat);
        editTextNom = (EditText) findViewById(R.id.editTextNom);
        editTextPrenom = (EditText) findViewById(R.id.editTextPrenom);
        editTextAdresse = (EditText) findViewById(R.id.editTextAdresse);
        editTextTelephone = (EditText) findViewById(R.id.editTextTelephone);
        editTextFrais = (EditText) findViewById(R.id.editTextFrais);
        buttonInscription = (Button) findViewById(R.id.buttonInscription);
        buttonInscription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://10.0.2.2:8082/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                Api api = retrofit.create(Api.class);

                //Creation d'un objet etudiant a ajouter dans la base
                EtudiantResponce e = new EtudiantResponce();
                e.getMat(editTextmat.getText().toString());
                e.setNom(editTextNom.getText().toString());
                e.setPrenom(editTextPrenom.getText().toString());
                e.setAdr(editTextAdresse.getText().toString());
                e.setTel(Integer.parseInt(editTextTelephone.getText().toString()));
                e.setFrais(Double.parseDouble(editTextFrais.getText().toString()));
                Call<EtudiantResponce> callSave = api.saveEtudiant(e);
                callSave.enqueue(new Callback<EtudiantResponce>() {
                    @Override
                    public void onResponse(Call<EtudiantResponce> call, Response<EtudiantResponce> response) {
                        Toast.makeText(InscriptionActivity.this,"Etudiant inscrit avec succes",Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onFailure(Call<EtudiantResponce> call, Throwable t) {
                        Toast.makeText(InscriptionActivity.this,"Impossible d'acceder au serveur",Toast.LENGTH_LONG);

                    }
                });


            }
        });
    }
}
