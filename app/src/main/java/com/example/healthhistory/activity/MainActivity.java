package com.example.healthhistory.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.healthhistory.R;
import com.example.healthhistory.activity.config.ConfiguracaoFirebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {


    private Toolbar toolbar;
    private FirebaseAuth usuarioAutenticacao;
    private Button botaoConsultas;
    private Button botaoExames;
    private Button botaoResultados;
    private Button botaoTratamentos;
    private Button botaoRetornos;
    private Button botaoAgenda;
    private TextView userNome;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuarioAutenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();



        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Health History");
        setSupportActionBar(toolbar);

        userNome = (TextView) findViewById(R.id.textView2);



        botaoConsultas = (Button) findViewById(R.id.button6);
        botaoConsultas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaConsultas();
            }
        });

        botaoExames = (Button) findViewById(R.id.button3);
        botaoExames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaExames();
            }
        });

        botaoResultados = (Button) findViewById(R.id.button9);
        botaoResultados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaResultados();
            }
        });

        botaoTratamentos = (Button) findViewById(R.id.button8);
        botaoTratamentos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaTratamentos();
            }
        });

        botaoRetornos = (Button) findViewById(R.id.button2);
        botaoRetornos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaRetornos();
            }
        });

        botaoAgenda = (Button) findViewById(R.id.button10);
        botaoAgenda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaAgenda();
            }
        });




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.item_sair:
                deslogarUsusario();
                return true;
            case R.id.item_configuracoes:
                irParaConfiguração();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }//o que o usuario selecionar tera uma acao segundo esse switch

    }

    public void deslogarUsusario(){
        usuarioAutenticacao.signOut();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }//ao clicar em sair desloga, sai da tela principal pra tela de login.

    public void irParaConfiguração(){
        Intent intent = new Intent(MainActivity.this, ConfiguracaoActivity.class);
        startActivity(intent);
        finish();
    }//ao clicar em configuracao é enviado para a tela de configuracao

    private void abrirTelaConsultas(){ //metodo pra abrir a tela principal
        Intent intent = new Intent(MainActivity.this, ConsultasActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();

    }

    private void abrirTelaExames(){ //metodo pra abrir a tela principal
        Intent intent = new Intent(MainActivity.this, ExamesActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();

    }

    private void abrirTelaResultados(){ //metodo pra abrir a tela principal
        Intent intent = new Intent(MainActivity.this, ResultadosActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();

    }

    private void abrirTelaTratamentos(){ //metodo pra abrir a tela principal
        Intent intent = new Intent(MainActivity.this, TratamentosActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();

    }

    private void abrirTelaRetornos(){ //metodo pra abrir a tela principal
        Intent intent = new Intent(MainActivity.this, RetornosActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();

    }

    private void abrirTelaAgenda(){ //metodo pra abrir a tela principal
        Intent intent = new Intent(MainActivity.this, AgendaActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();

    }


}
