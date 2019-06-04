package com.example.healthhistory.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthhistory.R;
import com.example.healthhistory.activity.config.ConfiguracaoFirebase;
import com.example.healthhistory.activity.helper.Permissao;
import com.example.healthhistory.activity.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.database.DatabaseReference;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText senha;
    private Button botaoLogar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        verificarUsusarioLogado();

        email = (EditText) findViewById(R.id.email);
        senha = (EditText) findViewById(R.id.senha);
        botaoLogar = (Button) findViewById(R.id.entrar);

        botaoLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = new Usuario();
                usuario.setEmail(email.getText().toString()); //setar usuario email
                usuario.setSenha(senha.getText().toString());
                validarLogin();

            }
        });



    }

    private void verificarUsusarioLogado(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        if( autenticacao.getCurrentUser() != null ) { //recupera usuario que esta logado no sistem
            abrirTelaPrincipal(); //envia pra tela principal
        }
    }

    private void validarLogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //retorna o objeto task
                if(task.isSuccessful()){
                    abrirTelaPrincipal();
                    Toast.makeText(LoginActivity.this, "Sucesso ao fazer login!", Toast.LENGTH_LONG).show();
                }else{

                    String erroExcecao = "";

                    try{
                        throw task.getException(); //lança uma execao . recupera a execao
                    }catch (FirebaseAuthInvalidUserException e){
                        erroExcecao = "Email invalido!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao = "Senha invalida, digite um novamente!";

                    } catch (Exception e) {
                        erroExcecao = "Erro ao efetuar o login!";
                        e.printStackTrace();
                    }

                    Toast.makeText(LoginActivity.this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void abrirTelaPrincipal(){ //metodo pra abrir a tela principal
        Intent intent = new Intent(LoginActivity.this, MainActivity.class); //indica pra qual tela ira
        startActivity(intent); // abre a tela principal
        finish();

    }

    public void abrirCadastro(View view) {
        Intent intent = new Intent(this, CriarContaActivity.class);
        startActivity(intent);
    }

    public void abrirRecuperacao(View view) {
        Intent intent = new Intent(this, ResetarSenhaActivity.class);
        startActivity(intent);
    }
}
