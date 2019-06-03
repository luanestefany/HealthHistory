package com.example.healthhistory.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.healthhistory.R;

public class ExamesActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private FloatingActionButton botaoCriarExame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exames);

        toolbar = (Toolbar) findViewById(R.id.tb_exames);

        //configura toolbar
        toolbar.setTitle("Exames");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamesActivity.this, MainActivity.class); //indica pra qual tela ira
                startActivity(intent); // abre a tela
                finish();
            }
        });

        botaoCriarExame = (FloatingActionButton) findViewById(R.id.floatingActionButton3);
        botaoCriarExame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExamesActivity.this, CriarExameActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(ExamesActivity.this, MainActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();
    }

}
