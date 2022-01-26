package com.example.proveapp.proveapp.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.proveapp.proveapp.Comun.Utils;
import com.example.proveapp.proveapp.R;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        MostrarDialogo();
    }

    private void MostrarDialogo(){

        // Layout para el edittext del dialogo
        LayoutInflater layoutI = LayoutInflater.from(RegistroActivity.this);
        View dialogEditText = layoutI.inflate(R.layout.seleccion_categoria, null);

        // Construcción del diálogo
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(RegistroActivity.this,
                R.style.DialogColor));

        // ubicación del Spinner
        final Spinner categoria = (Spinner) dialogEditText.findViewById(R.id.spinnerCategorias);

        String[] Usuarios = new String[]{"Cliente","Tendero","Preventista"};
        categoria.setAdapter(new ArrayAdapter<String>(this, R.layout.cambio_letra_spinner, Usuarios) );

        builder.setTitle("Selecciona Categoria");
        builder.setMessage("");
        builder.setView(dialogEditText);
        builder.setCancelable(false);

        builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                String spinner = (String) categoria.getSelectedItem();

                switch (spinner){
                    case "Cliente":
                        Intent intentCliente = new Intent(RegistroActivity.this, ClientesActivity.class);
                        startActivity(intentCliente);
                        break;

                    case "Tendero":
                        Intent intentTendero = new Intent(RegistroActivity.this, TenderoActivity.class);
                        startActivity(intentTendero);
                        break;

                    case "Preventista":
                        Intent intentPreventista = new Intent(RegistroActivity.this, PreventistaActivity.class);
                        startActivity(intentPreventista);
                        break;

                    default:
                        break;
                }

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                GoToNextActivity(RegistroActivity.class);
            }
        });

        Dialog dialog = builder.create();
        dialog.show();

        // Cambia el color de la linea horizontal del  AlertDialog
        Utils.pintarLineaDialogo(getApplicationContext(), dialog);
    }

    private void GoToNextActivity(Class activity){
        finish();
        Intent nuevaActivity = new Intent(this,activity);
        startActivity(nuevaActivity);
    }
}
