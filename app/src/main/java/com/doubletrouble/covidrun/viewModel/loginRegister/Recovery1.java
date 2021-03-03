package com.doubletrouble.covidrun.viewModel.loginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.model.Usuario;
import com.doubletrouble.covidrun.db.AppDatabase;

public class Recovery1 extends AppCompatActivity {

    EditText correo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Recuperar contraseña");
        setContentView(R.layout.activity_recovery1);
    }

    public void recuperarContraseña1(View view) {
        correo = findViewById(R.id.recoveryMail);
        String email = correo.getText().toString();



        Usuario user = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarCorreo(email);

        if (user == null){
            Toast noExisteCorreo = Toast.makeText(getApplicationContext(), "Email no encontrado", Toast.LENGTH_SHORT);
            noExisteCorreo.show();

        } else {
            String emailDB = user.getCorreo();
            Intent RecuperarContraseña2 = new Intent(Recovery1.this, Recovery2.class);
            RecuperarContraseña2.putExtra("email", emailDB);
            RecuperarContraseña2.putExtra("pregSeguridad", user.getPregSeguridad());
            startActivity(RecuperarContraseña2);
        }
    }
}
