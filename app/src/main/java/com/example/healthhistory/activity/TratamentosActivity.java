package com.example.healthhistory.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.healthhistory.R;

public class TratamentosActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tratamentos);

        toolbar = (Toolbar) findViewById(R.id.tb_tratamentos);

        //configura toolbar
        toolbar.setTitle("Tratamentos");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TratamentosActivity.this, MainActivity.class); //indica pra qual tela ira
                startActivity(intent); // abre a tela
                finish();
            }
        });

    }

    @Override
    public void onBackPressed()
    {
        Intent intent = new Intent(TratamentosActivity.this, MainActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela
        finish();
    }

}
