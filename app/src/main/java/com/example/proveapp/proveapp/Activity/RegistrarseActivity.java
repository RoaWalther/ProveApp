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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proveapp.proveapp.Comun.Global;
import com.example.proveapp.proveapp.Comun.Utils;
import com.example.proveapp.proveapp.Constructor.Tabla;
import com.example.proveapp.proveapp.R;

import java.util.ArrayList;

public class RegistrarseActivity extends AppCompatActivity {

    private TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        this.setTitle("Registrarse");

        txtTitulo = findViewById(R.id.txtTitulo);

        MostrarDialogo();


    }

    private void MostrarDialogo(){

        // Layout para el edittext del dialogo
        LayoutInflater layoutI = LayoutInflater.from(RegistrarseActivity.this);
        View dialogEditText = layoutI.inflate(R.layout.seleccion_categoria, null);

        // Construcción del diálogo
        final AlertDialog.Builder builder = new AlertDialog.Builder(new ContextThemeWrapper(RegistrarseActivity.this,
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
                        crearRegistroCliente();
                        break;

                    case "Tendero":
                        crearRegistroTendero();
                        break;

                    case "Preventista":
                        crearRegistroPreventista();
                        break;

                    default:
                        break;
                }

            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();
                GoToNextActivity(MainActivity.class);
            }
        });

        Dialog dialog = builder.create();
        dialog.show();

        // Cambia el color de la linea horizontal del  AlertDialog
        Utils.pintarLineaDialogo(getApplicationContext(), dialog);
    }

    private void crearRegistroCliente() {

        txtTitulo.setText("DATOS DEL CLIENTE");

        // Llamo la clase Tabla
        Tabla tabla = new Tabla(this, (TableLayout) findViewById(R.id.tabla));
        Global.fila = new TableRow[4 + 1];

        String mnj ="";
        String texto = "";
        boolean isTexto;
        boolean isContraseña;

        // FILAS DE LA GRILLA.....
        for (int i = 0; i <= 4; i++) {
            ArrayList<String> elementos = new ArrayList<String>();

            isTexto = false;
            isContraseña = false;

            switch ( i ){
                case 0:
                    texto = "Nombre Completo";
                    break;

                case  1:
                    isTexto = true;
                    break;

                case 2:
                    texto = "Cédula de Ciudadanía";
                    break;

                case 3:
                    isTexto = false;
                    break;

                default:
                    break;

            }
            mnj += i;
            System.out.println("posicion i: "+ mnj);

            tabla.agregarFilaTabla(elementos,4,texto, isTexto, isContraseña, i);
        }

    }

    private void crearRegistroTendero() {

        txtTitulo.setText("DATOS DEL TENDERO");

        // Llamo la clase Tabla
        Tabla tabla = new Tabla(this, (TableLayout) findViewById(R.id.tabla));
        Global.fila = new TableRow[18 + 1];

        String texto = "";
        boolean isTexto;
        boolean isContraseña;

        // FILAS DE LA GRILLA.....
        for (int i = 0; i <= 18; i++) {
            ArrayList<String> elementos = new ArrayList<String>();

            isTexto = false;
            isContraseña = false;

            switch ( i ){
                case 0:
                    texto = "NIT Establecimiento";
                    break;

                case 1:
                    isTexto = true;
                    break;

                case 2:
                    texto = "Nombre Establecimiento";
                    break;

                case 3:
                    isTexto = true;
                    break;

                case 4:
                    texto = "Direccion Establecimiento";
                    break;

                case 5:
                    break;

                case 6:
                    texto =  "________________________" + "\n\n" + "Nombre Tendero";
                    break;

                case 7:
                    isTexto = true;
                    break;

                case 8:
                    texto = "Cédula de Ciudadanía";
                    break;

                case 9:
                    isTexto = false;
                    break;

                case 10:
                    texto = "Departamento";
                    break;

                case 11:
                    isTexto = true;
                    break;

                case 12:
                    texto = "Ciudad";
                    break;

                case 13:
                    isTexto = true;
                    break;

                case 14:
                    texto = "Celular";
                    break;

                case 15:
                    isTexto = false;
                    break;

                case 16:
                    texto = "Contraseña";
                    break;

                case 17:
                    isTexto = true;
                    isContraseña = true;
                    break;

                default:
                    break;

            }

            tabla.agregarFilaTabla(elementos,18,texto, isTexto, isContraseña, i);
        }

    }

    private void crearRegistroPreventista() {

        txtTitulo.setText("DATOS DEL PREVENTISTA");

        // Llamo la clase Tabla
        Tabla tabla = new Tabla(this, (TableLayout) findViewById(R.id.tabla));
        Global.fila = new TableRow[16 + 1];

        String texto = "";
        boolean isTexto;
        boolean isContraseña;

        // FILAS DE LA GRILLA.....
        for (int i = 0; i <= 16; i++) {
            ArrayList<String> elementos = new ArrayList<String>();

            isTexto = false;
            isContraseña = false;

            switch ( i ){
                case 0:
                    texto = "NIT Empresa";
                    break;

                case  1:
                    isTexto = true;
                    break;

                case 2:
                    texto = "Nombre Empresa";
                    break;

                case 3:
                    isTexto = true;
                    break;

                case 4:
                    texto =  "________________________" + "\n\n" + "Nombre Preventista";
                    break;

                case 5:
                    isTexto = true;
                    break;

                case 6:
                    texto = "Cédula de Ciudadanía";
                    break;

                case 7:
                    isTexto = false;
                    break;

                case 8:
                    texto = "Departamento";
                    break;

                case 9:
                    isTexto = true;
                    break;

                case 10:
                    texto = "Ciudad";
                    break;

                case 11:
                    isTexto = true;
                    break;

                case 12:
                    texto = "Celular";
                    break;

                case 13:
                    isTexto = false;
                    break;

                case 14:
                    texto = "Contraseña";
                    break;

                case 15:
                    isTexto = true;
                    isContraseña = true;
                    break;

                default:
                    break;

            }

            tabla.agregarFilaTabla(elementos,16,texto, isTexto, isContraseña, i);
        }

    }

    private void GoToNextActivity(Class activity){
        finish();
        Intent nuevaActivity = new Intent(this,activity);
        startActivity(nuevaActivity);
    }
}
