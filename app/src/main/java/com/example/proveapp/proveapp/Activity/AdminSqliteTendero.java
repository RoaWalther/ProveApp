package com.example.proveapp.proveapp.Activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqliteTendero extends SQLiteOpenHelper {


    public AdminSqliteTendero(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    // colocamos el nombre que queramos en el metodo onCreate yo le puse BaseDeDatos
    @Override
    public void onCreate(SQLiteDatabase BaseDeDatosTendero) {

        // asi se crea una base de datos 1 el nombre que le pusimos + el ."execSQL"
        BaseDeDatosTendero.execSQL("create table tenderos(nitTendero text primary key, nomestablecimiento text, direccion text, nomTendero text," +
                "cedula int, departamento text , ciudad text, celular int ,contrasena text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
