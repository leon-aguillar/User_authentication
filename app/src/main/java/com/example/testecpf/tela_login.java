package com.example.testecpf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import validadores.validaCpf;
import validadores.validaEmail;
import validadores.validaSenha;

public class tela_login extends AppCompatActivity {

    //variaveis

    String email_Login;
    String senha_Login;






    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_login);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_login), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button entrar = findViewById(R.id.botao_entrar_login);
        entrar.setOnClickListener(v ->{
            Entrar(v);

        });


    }

    public void Entrar(View view){



        EditText texto_email = findViewById(R.id.Campo_email_login); // cria uma variavel que é conectada a caixa de texto e recebe o valor digitado nela
        email_Login = texto_email.getText().toString();

        EditText texto_senha = findViewById(R.id.Campo_senha_login); //cia uma variavel que é conectada a caixa de texto e recebe o valor digitado nela
        senha_Login = texto_senha.getText().toString();


        if (validaEmail.ValidadorEmail(email_Login) == true && validaSenha.ValidadorSenha(senha_Login) == true){

            Pessoa pessoaLogin = new Pessoa(); //abre instancia
            pessoaLogin.email = email_Login;  //corelaciona variaveis
            pessoaLogin.senha = senha_Login; //correlaciona variaveis

            dataBaseRoom banco = Room.databaseBuilder(getApplicationContext(),
            dataBaseRoom.class, "bancoLocal")
            .allowMainThreadQueries()
            .build();
            Pessoa usuarioEncontardo = banco.PegarPessoaDao().fazerLogin(email_Login, senha_Login); // chama query

            if (usuarioEncontardo != null){ // verifica se encontrou usuario
                Toast.makeText(this, "Login realizado com sucesso!", Toast.LENGTH_SHORT).show();

                Intent mudarDeTela = new Intent(this, tela_Home_Page.class); // delaração de intent para chamar a outra tela
                startActivity(mudarDeTela); // start da activity
                finish();
            }
            else{
                Toast.makeText(this, "Email ou senha incoretos!", Toast.LENGTH_SHORT).show();
            }




        }
        else{
            Toast.makeText(this, "Email ou senha incoretos!", Toast.LENGTH_SHORT).show();
        }


    }

}