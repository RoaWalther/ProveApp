package com.example.proveapp.proveapp.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proveapp.proveapp.R;

public class ClientesActivity extends AppCompatActivity {

    private EditText nomCompleto,cedulaCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clientes);

        nomCompleto = findViewById(R.id.edtNomCliente);
        cedulaCliente = findViewById(R.id.edtCedCliente);

    }
    public void registro (View v){
        AdminSqlite Administrar = new AdminSqlite(this,"administracion",null,1);
        SQLiteDatabase base_datos = Administrar.getWritableDatabase();
        String ceduCliente = cedulaCliente.getText().toString();
        String nomCliente = nomCompleto.getText().toString();

        if (!ceduCliente.isEmpty() && !nomCliente.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("codigo",ceduCliente);
            registro.put("descripcion",nomCliente);

            base_datos.insert("clientes",null,registro);
            base_datos.close();
            nomCompleto.setText("");
            cedulaCliente.setText("");
            Intent intent = new Intent(ClientesActivity.this,ProductosTenderos.class);
            startActivity(intent);

            Toast.makeText(this,"Inserción exitosa",Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(this,"Debes llenar los campos",Toast.LENGTH_SHORT).show();

        }


    }

}
