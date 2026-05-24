package com.example.testecpf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;



    public class tela_home extends AppCompatActivity {
        private Button telaCadastro;

        private Button telalogin;

        @SuppressLint("MissingInflatedId")
        protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            EdgeToEdge.enable(this);
            setContentView(R.layout.tela_home_main);


            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.tela_home), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });



            telaCadastro = findViewById(R.id.botao_cadastro_home); // codigo tela home que faz o botão para ir na tela de cadastro

            telaCadastro.setOnClickListener(view -> {
                startActivity(new Intent(this, tela_cadastro.class));

            });

            telalogin = findViewById(R.id.botao_login_home); // codigo tela home que faz o botão para ir na tela de login

            telalogin.setOnClickListener( view -> {
                startActivity(new Intent(this, tela_login.class));
            });




        }


    }

