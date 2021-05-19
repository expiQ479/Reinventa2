package com.doubletrouble.covidrun.viewmodel.loginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.Utilidades;
import com.doubletrouble.covidrun.db.AppDatabase;

public class Recovery2 extends AppCompatActivity {

    String emailParameter;
    String pregSeguridad;
    EditText respuestaInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Recuperar contraseña");
        setContentView(R.layout.activity_recovery2);
        recibirDatos();
    }

    private void recibirDatos(){
        Bundle parametros = getIntent().getExtras();
        if (parametros != null) {
            emailParameter = parametros.getString("email");
            pregSeguridad = parametros.getString("pregSeguridad");
            TextView vista = (TextView) findViewById(R.id.recoveryQuestion);
            vista.setText(pregSeguridad);
        } else {
            Toast errorAlRecibirDatos = Toast.makeText(getApplicationContext(), "Error interno", Toast.LENGTH_SHORT);
            errorAlRecibirDatos.show();
        }
    }

    public void recuperarContraseña2(View view) {
        String pregunta = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarCorreo(emailParameter).getPregSeguridad();
        String respuesta = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarCorreo(emailParameter).getRespSeguridad();

        respuestaInput = findViewById(R.id.recoveryAnswer);
        String respuestaUser = Utilidades.md5(respuestaInput.getText().toString());

        if (!respuestaUser.equals(respuesta)) {
            Toast errorDeRespuestas = Toast.makeText(getApplicationContext(), "La respuesta de seguridad no coincide", Toast.LENGTH_SHORT);
            errorDeRespuestas.show();
        } else {
            Intent RecuperarContraseña3 = new Intent(Recovery2.this, Recovery3.class);
            RecuperarContraseña3.putExtra("email",emailParameter);
            startActivity(RecuperarContraseña3);
        }
    }


}