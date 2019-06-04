package com.example.healthhistory.activity;

import android.content.Intent;
import android.graphics.drawable.Icon;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.healthhistory.R;
import com.example.healthhistory.activity.model.Consultas;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ConsultasActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton botaoCriarConsulta;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        toolbar = (Toolbar) findViewById(R.id.tb_consultas);

        //configura toolbar
        toolbar.setTitle("Consultas");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsultasActivity.this, MainActivity.class); //indica pra qual tela ira
                startActivity(intent); // abre a tela
                finish();
            }
        });

        botaoCriarConsulta = (FloatingActionButton) findViewById(R.id.floatingActionButton2);
        botaoCriarConsulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConsultasActivity.this, CriarConsultaActivity.class);
                startActivity(intent);
                finish();
            }
        });




    }



    @Override
    public void onBackPressed() // botao do sistema voltar
    {
        Intent intent = new Intent(ConsultasActivity.this, MainActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();
    }



}
