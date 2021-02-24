package com.doubletrouble.covidrun.viewModel.help;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.doubletrouble.covidrun.Home;
import com.doubletrouble.covidrun.R;

public class Ayuda2 extends AppCompatActivity {

    String loggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Ayuda2");

        loggedInUser = getIntent().getExtras().getString("loggedInUser");

        setContentView(R.layout.activity_ayuda2);
    }

    public void vistaHomeAyuda2(View view){
        Intent goToHome = new Intent(Ayuda2.this, Home.class);
        goToHome.putExtra("loggedInUser", loggedInUser);

        startActivity(goToHome);
    }

    public void vistaAnterior(View view){
        Intent goToHelp = new Intent(Ayuda2.this,Ayuda.class);
        goToHelp.putExtra("loggedInUser", loggedInUser);

        startActivity(goToHelp);
    }
}
