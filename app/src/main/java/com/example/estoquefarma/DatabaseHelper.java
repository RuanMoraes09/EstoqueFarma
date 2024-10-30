package com.example.estoquefarma;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "EstoqueFarma.db";
    private static final int DATABASE_VERSION = 1;


    public DatabaseHelper(Context context){
        super(context, "db_senai.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE user("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name VARCHAR(45) NOT NULL,"+
                "email VARCHAR(45) NOT NULL,"+
                "password VARCHAR(45) NOT NULL);";

        sqLiteDatabase.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        String sql="DROP TABLE IF EXISTS user;";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }

    public boolean checkUser(String email, String password) {
        return false;
    }
}