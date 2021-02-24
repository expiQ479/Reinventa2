package com.doubletrouble.covidrun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.doubletrouble.covidrun.viewModel.loginRegister.Login;

public class Bienvenida extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // OPERACIONES PARA EJECUTAR JUSTO AL ABRIR LA APP
        // COMO FUNCIONA EN DEMO, CARGA AQUÍ PLANES DEMO
        Utilidades.basicFeeding(getApplicationContext());

        setContentView(R.layout.activity_bienvenida);
    }

    public void irLogin(View view){
        startActivity(new Intent(Bienvenida.this, Login.class));
    }
}