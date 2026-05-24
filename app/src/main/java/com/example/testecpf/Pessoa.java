package com.example.testecpf;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pessoa {



        @PrimaryKey(autoGenerate = true)
        public int id;

        @ColumnInfo(name = "campo_email")
        public String email;

        @ColumnInfo(name = "campo_senha")
        public String senha;

        @ColumnInfo(name = "campo_cpf")
        public String cpf;
}




