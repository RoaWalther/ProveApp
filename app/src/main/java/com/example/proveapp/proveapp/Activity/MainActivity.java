package com.example.proveapp.proveapp.Activity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proveapp.proveapp.Comun.Utils;
import com.example.proveapp.proveapp.R;
import com.example.proveapp.proveapp.Comun.Global;

public class MainActivity extends AppCompatActivity {

    // Variable para el botón "BACK" para salir de la aplicación
    private boolean canExitApp = false;

    private TextView registrarse;
    private Button salir, ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrarse = findViewById(R.id.btnRegistrarse);
        ingresar = findViewById(R.id.btnIngresar);
        salir = findViewById(R.id.btnSalir);

        // Permite al CustomToast acceder al layout de personalizacion
        Global.inflater = getLayoutInflater();
        Global.layout = Global.inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMenuPrincipal = new Intent(
                        MainActivity.this, MenuPrincipalActivity.class);
                startActivity(intentMenuPrincipal);
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegistrarse = new Intent(
                        MainActivity.this, RegistroActivity.class);
            }
        });

        // Boton para salir de la aplicacion
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Dialogo de confirmación
                AlertDialog.Builder builder = new AlertDialog.Builder(new
                        ContextThemeWrapper(MainActivity.this,
                        R.style.DialogColor));

                builder.setTitle("Información");
                builder.setMessage("¿Desea salir de la aplicación?" );
                builder.setCancelable(false);

                builder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //Finaliza la aplicación
                        ActivityCompat.finishAffinity(MainActivity.this);
                        finish();
                        System.exit(0);
                    }
                });

                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Cancela la salida
                        dialog.cancel();
                    }
                });

                Dialog dialog = builder.create();
                dialog.show();

                // Cambia el color de la linea horizontal del  AlertDialog
                Utils.pintarLineaDialogo(getApplicationContext(), dialog);

            }
        });
    }

    /*******************************************************************************
     Método       : onBackPressed
     Description  : Al presionar la tecla "Back" del dispositivo 2 veces, se finaliza
     la aplicación
     Input        : canExitApp = Variable booleana que cambia cuando se le presiona la
                    tecla "Back"
     *******************************************************************************/
    @Override
    public void onBackPressed() {

        if (!canExitApp) {
            canExitApp = true;

            Toast.makeText(this,"Presione otra vez para salir de la aplicación...", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    canExitApp = false;
                }

            }, 2000);

        } else {
            ActivityCompat.finishAffinity(MainActivity.this);
            finish();
            System.exit(0);
        }
    }
}
