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

public class PreventistaActivity extends AppCompatActivity {

    private EditText nitEmpresa,nomEmpresa,nomPreventista,cedulaPreventista,
            departamento,ciudad,celular,contrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preventista);

        nitEmpresa = findViewById(R.id.edtNitEmpresa);
        nomEmpresa = findViewById(R.id.edtnomEmpresa);
        nomPreventista = findViewById(R.id.edtNomPreventista);
        cedulaPreventista = findViewById(R.id.edtCedulaPreventista);
        departamento = findViewById(R.id.edtDepartamento);
        ciudad = findViewById(R.id.edtCiudad);
        celular = findViewById(R.id.edtCelular);
        contrasena = findViewById(R.id.edtContrasena);
    }

    public void registro (View v){
        AdminSqlitePreventista Administrar = new AdminSqlitePreventista(this,"administracion",null,1);
        SQLiteDatabase base_datos = Administrar.getWritableDatabase();
        String nit = nitEmpresa.getText().toString();
        String nomEsta = nomEmpresa.getText().toString();
        String nompreventista = nomPreventista.getText().toString();
        String cedula = cedulaPreventista.getText().toString();
        String depar = departamento.getText().toString();
        String ciu = ciudad.getText().toString();
        String cel = celular.getText().toString();
        String contra = contrasena.getText().toString();

        if (!nit.isEmpty() && !nomEsta.isEmpty()  && !nompreventista.isEmpty() && !cedula.isEmpty() && !depar.isEmpty()
                && !ciu.isEmpty() && !cel.isEmpty() && !contra.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("cedula",cedula);
            registro.put("nitEmpresa",nit);
            registro.put("nomEmpresa",nomEsta);
            registro.put("nomPreventista",nompreventista);
            registro.put("departamento",depar);
            registro.put("ciudad",ciu);
            registro.put("celular",cel);
            registro.put("contrasena",contra);

            base_datos.insert("preventista",null,registro);
            base_datos.close();
            nitEmpresa.setText("");
            nomEmpresa.setText("");
            nomPreventista.setText("");
            cedulaPreventista.setText("");
            departamento.setText("");
            ciudad.setText("");
            celular.setText("");
            contrasena.setText("");

            Toast.makeText(this,"Inserción exitosa",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(PreventistaActivity.this,MainActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(this,"Debes llenar los campos",Toast.LENGTH_SHORT).show();

        }

    }
}
