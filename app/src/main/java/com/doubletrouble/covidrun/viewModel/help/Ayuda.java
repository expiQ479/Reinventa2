package com.doubletrouble.covidrun.viewModel.help;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.doubletrouble.covidrun.Home;
import com.doubletrouble.covidrun.R;

public class Ayuda extends AppCompatActivity {
    String loggedInUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Ayuda");

        loggedInUser = getIntent().getExtras().getString("loggedInUser");

        setContentView(R.layout.activity_ayuda);
    }

    public void vistaHomeAyuda(View view){
        Intent goToHome = new Intent(Ayuda.this, Home.class);
        goToHome.putExtra("loggedInUser", loggedInUser);

        startActivity(goToHome);
    }

    public void vistaSiguiente(View view){
        Intent goToNext = new Intent(Ayuda.this,Ayuda2.class);
        goToNext.putExtra("loggedInUser", loggedInUser);

        startActivity(goToNext);
    }
}
