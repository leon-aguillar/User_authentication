package com.example.testecpf;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface Pessoa_dao {

    @Query("SELECT * FROM Pessoa WHERE campo_email = :emailDigitado AND campo_senha = :senhaDigitada")
    Pessoa fazerLogin(String emailDigitado, String senhaDigitada);


@Insert
void inserirPessoa(Pessoa pessoaNova);


}
