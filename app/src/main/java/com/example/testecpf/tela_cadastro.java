// importaçoes do mobile

package com.example.testecpf;

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


public class tela_cadastro extends AppCompatActivity {


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

        int modoAtual = getResources().getConfiguration().uiMode & android.content.res.Configuration.UI_MODE_NIGHT_MASK; // Talvez tirar isso

        if (modoAtual == android.content.res.Configuration.UI_MODE_NIGHT_YES) {
            meuSwitch.setChecked(true);// talvez tirar isso
        }

        meuSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            mudarOModoDoTema(isChecked);
        }
    });

    }

    public void mudarOModoDoTema(boolean ativado){ // função do switch

        if (ativado) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }

    }





    public void botaoStart(View view) {   // oq eu fiz

        int[] vetor;
        int mutiplicar = 10;
        int mutiplicar2 = 11;
        int soma = 0;                   // variaveis que usei
        int soma2 = 0;
        int digitovec1;
        int digitovec2;
        String estado;

// metodo principal


        EditText campoCpf = findViewById(R.id.Campo_cpf);   // funcionar a caixa de texto cpf
        String cpfTexto = campoCpf.getText().toString();

        if (cpfTexto.length() == 11) {


            vetor = new int[cpfTexto.length()];// cria o vetor

            for (int i = 0; i < cpfTexto.length(); i++) {
                vetor[i] = Integer.parseInt(cpfTexto.substring(i, i + 1)); // transforma o texto em numero
            }

            boolean iguais = true;

            for (int i = 1; i < 11; i++) {
                if (vetor[i] != vetor[0]) {
                    iguais = false;
                    break;
                }
            }

            if (iguais == false) {

                for (int i = 0; i < 9; i++) {
                    soma = soma + (vetor[i] * mutiplicar); // primeiro digito verificador
                    mutiplicar--;
                }

                for (int i = 0; i < 10; i++) {
                    soma2 = soma2 + (vetor[i] * mutiplicar2); // segundo digito verificador
                    mutiplicar2--;
                }

                digitovec1 = 11 - (soma % 11); // os resultados finais
                digitovec2 = 11 - (soma2 % 11);

                // as condicionais estão incompletas, depois vo terminar

                if (digitovec1 > 9) {
                    digitovec1 = 0;
                }
                if (digitovec2 > 9) {
                    digitovec2 = 0;
                }

                if (vetor[9] == digitovec1 && vetor[10] == digitovec2) {
                    Toast.makeText(tela_cadastro.this, "cpf valido!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(tela_cadastro.this, "cpf invalido!", Toast.LENGTH_SHORT).show();

                }





                if (vetor[9] == digitovec1 && vetor[10] == digitovec2) {

                    switch (vetor[8]) {

                        case 0:
                            estado = "RS";
                            break;
                        case 1:
                            estado = "DF/GO/MT/MS/TO";
                            break;

                        case 2:
                            estado = "AC/AM/AP/PA/RO/RR";
                            break;
                        case 3:
                            estado = "CE/MA/PI";
                            break;
                        case 4:
                            estado = "AL/PB/PE/RN";
                            break;

                        case 5:
                            estado= "BA/SE";
                            break;
                        case 6:
                            estado = "MG";
                            break;
                        case 7:
                            estado = "ES/RJ";
                            break;

                        case 8:
                            estado = "SP";
                            break;
                        case 9:
                            estado = "PR/SC";
                            break;
                        default:
                            estado = "INVALIDO";
                            break;


                    }

                }



            } else {
                Toast.makeText(tela_cadastro.this, "Não coloque numeros iguais!", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(tela_cadastro.this, "coloque 11 digitos!", Toast.LENGTH_SHORT).show();
        }



        EditText texto_email = findViewById(R.id.Campo_email); // cria uma variavel que é conectada a caixa de texto e recebe o valor digitado nela
        String Email = texto_email.getText().toString();

        EditText texto_senha = findViewById(R.id.Campo_senha); //cia uma variavel que é conectada a caixa de texto e recebe o valor digitado nela
        String Senha = texto_senha.getText().toString();












    }




}

//  mudança feita 14/02 -> add uma condicional na caixa de texto estado para quando cpf = invalido não mostrar o estado
//  motivo da mudança   -> mesmo quando o cpf = invalido, mostrava algum estado pq a posição 8 do vetor é prenchida


//  mudança feita 19/04 -> add uma um laço que percorre o vetor de cpf, se ele achar algum numero diferente ele faz a função
//  motivo da mudança   -> mesmo quando o cpf = 11111111111, ou seja numeros iguais, marcava como valido

//  mudança feita 20/04 -> retirei toda a parte do codigo sobre o estado(UF) e validação agora é por pop up
//  motivo da mudança   -> como agora é uma tela de cadastro, não faz sentido mostrar validação e estado

//  mudança feita 19/04 -> mudança de xml da tela cadastrto para se adequar a tiferentes fontes padres configuradas no android
//  motivo da mudança   -> ao testar em outro celular a letra ficou maior que sua propria caixa, o que resultou em caixas ilegiveis

//  mudança feita 19/04 -> renomeação de files java e xml
//  motivo da mudança   -> melhor organização e indentificação de conteudo