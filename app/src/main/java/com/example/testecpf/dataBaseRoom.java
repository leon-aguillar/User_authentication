package com.example.testecpf;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Pessoa.class}, version = 1)
public abstract class dataBaseRoom extends RoomDatabase{

    public abstract Pessoa_dao PegarPessoaDao();

}
