package com.aulas.controleaulas.basedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Base extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "BASEDADOS";
    private static final String TABLE_CADASTRO = "cadastro";

    private static final String TABLE_CREATE_CADASTRO = "create table if not exists cadastro (id integer primary key autoincrement, "
            + "nome VARCHAR not null, matricula VARCHAR not null, email VARCHAR not null, contaGit VARCHAR, "
            + "curso VARCHAR, senha VARCHAR);";

    public Base(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE_CADASTRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
