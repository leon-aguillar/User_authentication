package com.example.testecpf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.room.Room;

import validadores.validaCpf;
import validadores.validaEmail;
import validadores.validaSenha;

public class tela_cadastro extends AppCompatActivity {

    //variaveis globais
    String email_Cadastro;
    String senha_Cadastro;
    String cpf_Cadastrado;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.tela_cadastro);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_cadastro), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Switch meuSwitch = findViewById(R.id.switch_tema);

        int modoAtual = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK; // Talvez tirar isso (switch de tema)

        if (modoAtual == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            meuSwitch.setChecked(true);// talvez tirar isso (é do switch do tema )
        }

        meuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            mudarOModoDoTema(isChecked);
        }
    });

    }
    public void mudarOModoDoTema(boolean ativado){ // função do botão switch

        if (ativado) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }

    public void botaoStart(View view) {


        EditText campoCpf = findViewById(R.id.Campo_cpf);   // cria uma variavel que é conectada a caixa de texto e recebe o valor digitado nela
        cpf_Cadastrado = campoCpf.getText().toString();


        EditText texto_email = findViewById(R.id.Campo_email); // cria uma variavel que é conectada a caixa de texto e recebe o valor digitado nela
        email_Cadastro = texto_email.getText().toString();

        EditText texto_senha = findViewById(R.id.Campo_senha); //cia uma variavel que é conectada a caixa de texto e recebe o valor digitado nela
        senha_Cadastro = texto_senha.getText().toString();


        if (validaCpf.ValidadorCpf(cpf_Cadastrado) == true && validaEmail.ValidadorEmail(email_Cadastro) == true && validaSenha.ValidadorSenha(senha_Cadastro) == true){

            Pessoa pessoaCadastro = new Pessoa();
            pessoaCadastro.email = email_Cadastro;
            pessoaCadastro.senha = senha_Cadastro;
            pessoaCadastro.cpf = cpf_Cadastrado;

            dataBaseRoom banco = Room.databaseBuilder(getApplicationContext(),
            dataBaseRoom.class, "bancoLocal")
            .allowMainThreadQueries()
            .build();
            banco.PegarPessoaDao().inserirPessoa(pessoaCadastro);

            Toast.makeText(this, "Deu bom!", Toast.LENGTH_SHORT).show();

            Intent mudarDeTelaCadastro = new Intent(this, tela_Home_Page.class); // delaração de intent para chamar a outra tela
            mudarDeTelaCadastro.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(mudarDeTelaCadastro); // start da activity

        }
        else{
            Toast.makeText(tela_cadastro.this, "Não Deu bom!", Toast.LENGTH_SHORT).show();
        }




    }
}

//  mudança feita 14/02 -> add uma condicional na caixa de texto estado para quando cpf = invalido não mostrar o estado
//  motivo da mudança   -> mesmo quando o cpf = invalido, mostrava algum estado pq a posição 8 do vetor é prenchida


//  mudança feita 19/04 -> add uma um laço que percorre o vetor de cpf, se ele achar algum numero diferente ele faz a função
//  motivo da mudança   -> mesmo quando o cpf = 11111111111, ou seja numeros iguais, marcava como valido

//  mudança feita 20/04 -> retirei toda a parte do codigo sobre o estado(UF) e validação agora é por pop up
//  motivo da mudança   -> como agora é uma tela de cadastro, não faz sentido mostrar validação e estado

//  mudança feita 19/05 -> mudança de xml da tela cadastrto para se adequar a tiferentes fontes padres configuradas no android
//  motivo da mudança   -> ao testar em outro celular a letra ficou maior que sua propria caixa, o que resultou em caixas ilegiveis

//  mudança feita 19/05 -> renomeação de files java e xml
//  motivo da mudança   -> melhor organização e indentificação de conteudo

//  mudança feita 20/04 -> add dependencias no build.grandle.kts(module:app)
//  motivo da mudança   -> funcionar a room

//  mudança feita 22/04 -> exclusao da activity tela cadastro
//  motivo da mudança   -> validação mais eficiente com menor numero de variaveis usadas
// eu teria que usar 4 variaveis diferentes por ser duas informações em cada tela

// mudança feita 23/04 -> refatorei a estruturo do maior bloco de codigo do projeto (a validação do cpf)
// apliquei modularização para separar os validadores e controle de erro da activity
// com isso elas foram para um pacote separado e posso usar em duas activity (login e cadastro)
// podendo deixar na activity apenas o necessario


// conferencia se salvou dia 24 01:48 da manha


// ver se ctrl s salva p ir para o vscode

//novament

