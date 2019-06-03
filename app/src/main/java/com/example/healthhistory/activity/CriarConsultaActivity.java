package com.example.healthhistory.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthhistory.R;
import com.example.healthhistory.activity.model.Consultas;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class CriarConsultaActivity extends AppCompatActivity {


    private Consultas consulta;
    private EditText data;
    private EditText hora;
    private EditText endereco;
    private EditText telefone;
    private EditText convenio;
    private Button botaoSalvar;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_consulta);

        inicializarFirebase();


        data = (EditText) findViewById(R.id.editText13);
        hora = (EditText) findViewById(R.id.editText14);
        endereco = (EditText) findViewById(R.id.editText15);
        telefone = (EditText) findViewById(R.id.editText16);
        convenio = (EditText) findViewById(R.id.editText17);

        botaoSalvar = (Button) findViewById(R.id.button5);
        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consulta = new Consultas();
                consulta.setId(UUID.randomUUID().toString());
                consulta.setData(data.getText().toString());
                consulta.setHora(hora.getText().toString());
                consulta.setEndereco(endereco.getText().toString());
                consulta.setTelefone(telefone.getText().toString());
                consulta.setConvenio(convenio.getText().toString());
                consulta.salvarConsultas();
                criarConsulta();

            }
        });


    }

    private void inicializarFirebase() {
        FirebaseApp.initializeApp(CriarConsultaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

    }

    private void criarConsulta() {
        Intent intent = new Intent(CriarConsultaActivity.this, ConsultasActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void onBackPressed() // botao so sistema voltar
    {
        Intent intent = new Intent(CriarConsultaActivity.this, ConsultasActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();
    }


}
