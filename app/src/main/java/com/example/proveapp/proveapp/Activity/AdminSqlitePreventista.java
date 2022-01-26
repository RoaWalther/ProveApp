package com.example.proveapp.proveapp.Activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSqlitePreventista  extends SQLiteOpenHelper {


    public AdminSqlitePreventista(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    // colocamos el nombre que queramos en el metodo onCreate yo le puse BaseDeDatos
    @Override
    public void onCreate(SQLiteDatabase BaseDeDatosPreventista) {

        BaseDeDatosPreventista.execSQL("create table preventista(cedula int primary key, nitEmpresa text, nomEmpresa text," +
                "nomPreventista text, departamento text , ciudad text, celular int ,contrasena text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
