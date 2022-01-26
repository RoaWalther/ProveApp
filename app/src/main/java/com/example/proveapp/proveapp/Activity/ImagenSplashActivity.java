package com.example.proveapp.proveapp.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.proveapp.proveapp.R;

public class ImagenSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen_splash);

        // Hilo para mostrar por un tiempo la imagenSplash
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                // Se dirige al login
                Intent intentLogin = new Intent(
                        ImagenSplashActivity.this, MainActivity.class);
                startActivity(intentLogin);
            }
        },2000);
    }
}
