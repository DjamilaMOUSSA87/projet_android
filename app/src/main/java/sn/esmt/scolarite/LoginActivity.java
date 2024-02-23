package sn.esmt.scolarite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText emailtxt;
    private EditText passwordtxt;
    private Button connexionbt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        //recuperation des valeurs saisies
        emailtxt = (EditText) findViewById(R.id.emailtxt);
        passwordtxt = (EditText) findViewById(R.id.passwordtxt);
        connexionbt = (Button) findViewById(R.id.connexionbt);
        connexionbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email= emailtxt.getText().toString();
                String pwd= passwordtxt.getText().toString();
                if (email.isEmpty() || pwd.isEmpty()){
                    Toast.makeText(LoginActivity.this,"Veuillez renseigner tous les champs",Toast.LENGTH_LONG).show();
                }
                else {
                    if (email.equals("esmt@esmt.sn") && pwd.equals("123")){
                        Intent i = new Intent(LoginActivity.this,HomeActivity.class);
                        startActivity(i);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"Email ou Mot de passe incorrect",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}