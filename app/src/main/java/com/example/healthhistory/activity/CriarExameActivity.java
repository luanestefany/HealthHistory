package com.example.healthhistory.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.healthhistory.R;
import com.example.healthhistory.activity.model.Consultas;
import com.example.healthhistory.activity.model.Exames;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CriarExameActivity extends AppCompatActivity {

    private Exames exame;
    private EditText tipo;
    private EditText convenio;
    private EditText data;
    private EditText clinica;
    private Button botaoSalvarExame;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_exame);

        inicializarFirebase();

        tipo = (EditText) findViewById(R.id.tipoExame);
        convenio = (EditText) findViewById(R.id.convenioExame);
        data = (EditText) findViewById(R.id.dataExame);
        clinica = (EditText) findViewById(R.id.clinicaExame);

        botaoSalvarExame = (Button) findViewById(R.id.bttsalvarExame);
        botaoSalvarExame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exame = new Exames();
                exame.setId(UUID.randomUUID().toString());
                exame.setTipo(tipo.getText().toString());
                exame.setConvenio(convenio.getText().toString());
                exame.setData(data.getText().toString());
                exame.setClinica(clinica.getText().toString());
                exame.salvarExames();
                criarExame();
            }
        });


    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CriarExameActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    private void criarExame() {
        Intent intent = new Intent(CriarExameActivity.this, ExamesActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() // botao so sistema voltar
    {
        Intent intent = new Intent(CriarExameActivity.this, ExamesActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();
    }

}
