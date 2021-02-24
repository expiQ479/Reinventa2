package com.doubletrouble.covidrun.viewModel.profile;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.model.Plan;
import com.doubletrouble.covidrun.model.Usuario;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    String loggedInUser;
    int level, experience;
    String email, password, name, surname, securityQuestion, securityAnswer, tlf, age;
    Usuario usuario;
    private ListView items;
    private PlanListAdapter adaptador;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Profile");


        loggedInUser = getIntent().getExtras().getString("loggedInUser");
        usuario = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarUsuario(loggedInUser);

        level = usuario.getNivel();
        experience = usuario.getExperiencia();

        setContentView(R.layout.activity_profile);

        // Setting name value (TextView)
        TextView nameSurname = findViewById(R.id.profile_nameSurname);
        TextView textLevel = findViewById(R.id.userLevel);
        TextView textExperience = findViewById(R.id.user_Experience);
        textLevel.setText(Integer.toString(level));
        textExperience.setText(experience + "/" + (int) (Math.pow(level + 1, 2)) * 100);
        nameSurname.setText(loggedInUser);

        // Obtain list
        items = (ListView) findViewById(R.id.planContainer);
        adaptador = new PlanListAdapter((ArrayList<Plan>) AppDatabase.getDatabase(getApplicationContext()).planDao().getListForPrinting(loggedInUser), this);
        items.setAdapter(adaptador);

    }

    public void editProfile(View view) {
        Intent goToEditProfile = new Intent(this, EditProfile.class);
        goToEditProfile.putExtra("loggedInUser", loggedInUser);

        startActivity(goToEditProfile);
    }
}
