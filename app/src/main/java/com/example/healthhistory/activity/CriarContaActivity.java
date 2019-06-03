package com.example.healthhistory.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.healthhistory.R;
import com.example.healthhistory.activity.config.ConfiguracaoFirebase;
import com.example.healthhistory.activity.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class CriarContaActivity extends AppCompatActivity {

    private EditText nome;
    private EditText email;
    private EditText senha;
    private Button botaoCadastrar;
    private Usuario usuario;

    private FirebaseAuth autenticacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        nome = (EditText) findViewById(R.id.editText9);
        email = (EditText) findViewById(R.id.editText10);
        senha = (EditText) findViewById(R.id.editText11);
        botaoCadastrar = (Button) findViewById(R.id.button);

        botaoCadastrar.setOnClickListener(new View.OnClickListener() { //evento de click
            @Override
            public void onClick(View v) {
                usuario = new Usuario();
                usuario.setNome(nome.getText().toString()); //recupera nome
                usuario.setEmail(email.getText().toString()); //recupera email
                usuario.setSenha(senha.getText().toString()); //recupera senha
                cadastrarUsuario();

            }
        });

    }

    private void cadastrarUsuario(){
        //fazer o cadastro no banco de dados

        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(
                usuario.getEmail(),
                usuario.getSenha()
        ).addOnCompleteListener(CriarContaActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CriarContaActivity.this, "Sucesso ao cadastrar usuário", Toast.LENGTH_LONG).show();

                    FirebaseUser usuarioFirebase = task.getResult().getUser();
                    usuario.setId(usuarioFirebase.getUid()); //salva o identificador do usuario que esta no firebase
                    usuario.salvar(); //salva os dados do usuario no banco

                    autenticacao.signOut(); // faz os cadasto e desloga pro usuario logar
                    finish();
                }else{

                    String erroExcecao = "";

                    try{
                        throw task.getException(); //lança uma execao . recupera a execao
                    }catch (FirebaseAuthWeakPasswordException e){
                        erroExcecao = "Digite uma senha mais forte, contendo mais caracteres e com letras e numeros!";
                    } catch (FirebaseAuthInvalidCredentialsException e) {
                        erroExcecao = "O e-mail digitado é invalido, digite um novo e-mail!";
                    } catch (FirebaseAuthUserCollisionException e) {
                        erroExcecao = "Esse e-mail ja está em uso no App!";
                    } catch (Exception e) {
                        erroExcecao = "ao efetuar o cadastro!";
                        e.printStackTrace();
                    }

                    Toast.makeText(CriarContaActivity.this, "Erro: " + erroExcecao, Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
