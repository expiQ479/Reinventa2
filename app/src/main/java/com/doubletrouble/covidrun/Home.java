package com.doubletrouble.covidrun;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

import com.doubletrouble.covidrun.model.Planes_Usuario;
import com.doubletrouble.covidrun.viewModel.help.Ayuda;

import com.doubletrouble.covidrun.viewModel.loginRegister.Login;
import com.doubletrouble.covidrun.viewModel.plan.PlanGeneration;
import com.doubletrouble.covidrun.viewModel.profile.Profile;
import com.doubletrouble.covidrun.viewModel.plan.PlanCreationUsuario;

public class Home extends AppCompatActivity {

    String loggedInUser;
    String  email, password , name, surname, securityQuestion, securityAnswer, tlf, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home");

        setContentView(R.layout.activity_home);

        loggedInUser = getIntent().getExtras().getString("loggedInUser");
    }

    public void vistaHome(View view) {
        startActivity(new Intent(Home.this, Login.class));
    }

    public void vistaCreatePlan(View view) {
        Intent goToNewPlan = new Intent(Home.this, PlanGeneration.class);
        goToNewPlan.putExtra("loggedInUser", loggedInUser);
        startActivity(goToNewPlan);
    }


    public void vistaProfile(View view) {
        //Mientras no existe la clase Profile redirigira a Inicio
        Intent goToProfile = new Intent(Home.this, Profile.class);
        goToProfile.putExtra("loggedInUser", loggedInUser);


        startActivity(goToProfile);
    }

    public void vistaAyuda(View view){
        Intent goToHelp = new Intent(Home.this, Ayuda.class);
        goToHelp.putExtra("loggedInUser", loggedInUser);

        startActivity(goToHelp);
    }

    public void vistaUsuarioPlan(View view){
        Intent goToCreatePlan = new Intent(Home.this, PlanCreationUsuario.class);
        goToCreatePlan.putExtra("loggedInUser", loggedInUser);

        startActivity(goToCreatePlan);
    }
}
