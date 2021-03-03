package com.doubletrouble.covidrun.viewModel.plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.doubletrouble.covidrun.Home;
import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.model.Plan;
import com.doubletrouble.covidrun.model.Planes_Usuario;
import com.doubletrouble.covidrun.model.Usuario;

import java.util.Random;

public class PlanGeneration extends AppCompatActivity {

    String loggedInUser;
    Plan plan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loggedInUser = getIntent().getExtras().getString("loggedInUser");

        setContentView(R.layout.activity_plan_generation);
        setTitle("Plan");


        int random = new Random().nextInt(AppDatabase.getDatabase(getApplicationContext()).planDao().howManyPlans()) + 1 ;
        System.out.println("\n\n\n\n\n\n\n\n-------------------\n\n\n\n\n\n\n\n" + random + "\n");
        plan = AppDatabase.getDatabase(getApplicationContext()).planDao().findConcretePlan(random);
        TextView shortName = findViewById(R.id.planazoSemanal);
        TextView description = findViewById(R.id.masSobreElPlanazoSemanal);
        shortName.setText(plan.getShortName());
        description.setText(plan.getDescription());
    }

    public void goBack(View view) {
        Intent goBack = new Intent(PlanGeneration.this, Home.class);
        goBack.putExtra("loggedInUser", loggedInUser);

        startActivity(goBack);
    }

    public void done(View view){
        // Guardarme que el usuario ha completado un plan
        Planes_Usuario pu = new Planes_Usuario(plan.getId(), loggedInUser);
        AppDatabase.getDatabase(getApplicationContext()).planesUsuarioDao().registerNewPlan(pu);

        Usuario usuario = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarUsuario(loggedInUser);
        int experienciaFinal = (int) (usuario.getExperiencia() + plan.getExperiencePoints());
        if (experienciaFinal > (int) (Math.pow(usuario.getNivel() + 1, 2)) * 100){
            usuario.setNivel(usuario.getNivel() + 1);
        }
        usuario.setExperiencia(experienciaFinal);
        AppDatabase.getDatabase(getApplicationContext()).usuarioDao().updateUser(usuario);

        // todo sumar experiencia

        Intent goBack = new Intent(PlanGeneration.this, Home.class);
        goBack.putExtra("loggedInUser", loggedInUser);

        startActivity(goBack);

    }
}