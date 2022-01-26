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
public class TenderoActivity extends AppCompatActivity {

    private EditText nitTendero,nomEstablecimiento,dirEstablecimento,nomCompleto,cedulaTendero,departamento,ciudad,celular,contrasena;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tendero);

        nitTendero = findViewById(R.id.edtNitEstablecimiento);
        nomEstablecimiento = findViewById(R.id.edtnomEstablecimiento);
        dirEstablecimento = findViewById(R.id.edtDirEstablecimiento);
        nomCompleto = findViewById(R.id.edtNomTendero);
        cedulaTendero = findViewById(R.id.edtCedulaTendero);
        departamento = findViewById(R.id.edtDepartamento);
        ciudad = findViewById(R.id.edtCiudad);
        celular = findViewById(R.id.edtCelular);
        contrasena = findViewById(R.id.edtContrasena);

    }

    public void registro (View v){
        AdminSqliteTendero Administrar = new AdminSqliteTendero(this,"administracion",null,1);
        SQLiteDatabase base_datos = Administrar.getWritableDatabase();
        String nit = nitTendero.getText().toString();
        String nomEsta = nomEstablecimiento.getText().toString();
        String dir = dirEstablecimento.getText().toString();
        String nomtendero = nomCompleto.getText().toString();
        String cedula = cedulaTendero.getText().toString();
        String depar = departamento.getText().toString();
        String ciu = ciudad.getText().toString();
        String cel = celular.getText().toString();
        String contra = contrasena.getText().toString();

        if (!nit.isEmpty() && !nomEsta.isEmpty() && !dir.isEmpty() && !nomtendero.isEmpty() && !cedula.isEmpty() && !depar.isEmpty()
        && !ciu.isEmpty() && !cel.isEmpty() && !contra.isEmpty() ){
            ContentValues registro = new ContentValues();
            registro.put("nitTendero",nit);
            registro.put("nomestablecimiento",nomEsta);
            registro.put("direccion",dir);
            registro.put("nomTendero",nomtendero);
            registro.put("cedula",cedula);
            registro.put("departamento",depar);
            registro.put("ciudad",ciu);
            registro.put("celular",cel);
            registro.put("contrasena",contra);

            base_datos.insert("tenderos",null,registro);
            base_datos.close();
            nitTendero.setText("");
            nomEstablecimiento.setText("");
            dirEstablecimento.setText("");
            nomCompleto.setText("");
            cedulaTendero.setText("");
            departamento.setText("");
            ciudad.setText("");
            celular.setText("");
            contrasena.setText("");

            Toast.makeText(this,"Inserción exitosa",Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(TenderoActivity.this,MainActivity.class);
            startActivity(intent);

        }else {
            Toast.makeText(this,"Debes llenar los campos",Toast.LENGTH_SHORT).show();

        }

    }
}
