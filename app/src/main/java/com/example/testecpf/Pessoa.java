package com.example.testecpf;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

public class DataBaseRoom {

    @Entity
    public class User {
        @PrimaryKey
        public int uid;

        @ColumnInfo(email ="email")


    }


}



