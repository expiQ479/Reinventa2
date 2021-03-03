package com.doubletrouble.covidrun.viewModel.loginRegister;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.model.Usuario;
import com.doubletrouble.covidrun.Utilidades;
import com.doubletrouble.covidrun.db.AppDatabase;

public class Recovery3 extends AppCompatActivity {

    String emailParameter;
    EditText firstPass, secondPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Recuperar contraseña");
        setContentView(R.layout.activity_recovery3);
        recibirDatos();
    }

    private void recibirDatos() {
        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            String emailDB = parametros.getString("email");
            emailParameter = emailDB;
        } else {
            Toast errorAlRecibirDatos = Toast.makeText(getApplicationContext(), "Error interno", Toast.LENGTH_SHORT);
            errorAlRecibirDatos.show();
        }
    }

    public void recuperarContraseña3(View view) {
        firstPass = findViewById(R.id.recoveryNewPass);
        String firstPassString = firstPass.getText().toString();

        secondPass = findViewById(R.id.recoveryNewPass2);
        String secondPassString = secondPass.getText().toString();

        if (!firstPassString.equals(secondPassString)) {
            Toast errorPass = Toast.makeText(getApplicationContext(), "La contraseña no coincide", Toast.LENGTH_SHORT);
            errorPass.show();
        } else {
            Usuario user = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarCorreo(emailParameter);
            AppDatabase.getDatabase(getApplicationContext()).usuarioDao().modificarContraseña(emailParameter, Utilidades.md5(secondPassString));
            startActivity(new Intent(Recovery3.this, Login.class));
        }

    }


}
