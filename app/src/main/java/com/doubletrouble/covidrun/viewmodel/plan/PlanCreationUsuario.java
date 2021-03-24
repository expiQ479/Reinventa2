package com.doubletrouble.covidrun.viewmodel.plan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.doubletrouble.covidrun.Home;
import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.db.PlanDAO;
import com.doubletrouble.covidrun.model.Plan;

public class PlanCreationUsuario extends AppCompatActivity {
        String loggedInUser;
        Plan plan;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            loggedInUser = getIntent().getExtras().getString("loggedInUser");

            setContentView(R.layout.activity_plan_usuario);
            setTitle("Formular un plan");


        }
    public void vistaHomeFormularPlan(View view){
        Intent goToHome = new Intent(PlanCreationUsuario.this, Home.class);
        goToHome.putExtra("loggedInUser", loggedInUser);
        startActivity(goToHome);
    }

    private String getTextValue(int id) {
        EditText editText = findViewById(id);
        return editText.getText().toString();
    }

    public void vistaGuardarPlan(View view){
        String nombrePlan = getTextValue(R.id.nombre_plan);
        String descripcionPlan = getTextValue(R.id.descripcion_plan);
        String xpPlan = getTextValue(R.id.xp_plan);
        String horasEsperadas = getTextValue(R.id.horas_esperadas);

        if (nombrePlan == null || descripcionPlan == null || xpPlan == null || horasEsperadas == null) {
            Toast.makeText(getApplicationContext(), "Alguno de los campos está vacío", Toast.LENGTH_SHORT).show();
        }
        else{
            Plan planNuevo = new Plan(nombrePlan, descripcionPlan, Integer.parseInt(xpPlan), Integer.parseInt(horasEsperadas), 0);

            PlanDAO planDAO = AppDatabase.getDatabase(getApplicationContext()).planDao();
            planDAO.insertPlan(planNuevo);
            Toast.makeText(getApplicationContext(), "Has creado tu propio plan", Toast.LENGTH_SHORT).show();
            Intent goToHome = new Intent(PlanCreationUsuario.this, Home.class);
            goToHome.putExtra("loggedInUser", loggedInUser);
            startActivity(goToHome);
        }
   }


}
