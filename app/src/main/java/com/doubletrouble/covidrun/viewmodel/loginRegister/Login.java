package com.doubletrouble.covidrun.viewmodel.loginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.doubletrouble.covidrun.Home;
import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.model.Usuario;
import com.doubletrouble.covidrun.db.AppDatabase;

public class Login extends AppCompatActivity {

    EditText nombreUsuario, claveUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Inicio de sesión");
        setContentView(R.layout.activity_login);
    }

    public void iniciarSesion(View view) {
        nombreUsuario = findViewById(R.id.login_nombreUsuario);
        claveUsuario = findViewById(R.id.login_claveUsuario);

        String nombre = nombreUsuario.getText().toString();
        String clave = claveUsuario.getText().toString();

        if ((nombre.equals("")) || (clave.equals(""))) {
            Toast cadenaVacia = Toast.makeText(getApplicationContext(), "Usuario o contraseña vacíos", Toast.LENGTH_SHORT);
            cadenaVacia.show();
        } else {
            Usuario usuario = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarUsuario(nombre);
            if (usuario == null) {
                Toast noExiste = Toast.makeText(getApplicationContext(), "No existe el usuario", Toast.LENGTH_SHORT);
                noExiste.show();
            } else {
                if (usuario.compararContraseñas(clave)) {
                    Toast.makeText(getApplicationContext(), "Datos correctos", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(this, Home.class);
                    intent.putExtra("loggedInUser", usuario.nombreUsuario);
                    startActivity(intent);
                } else {
                    Toast datosErroneos = Toast.makeText(getApplicationContext(), "Datos erróneos", Toast.LENGTH_SHORT);
                    datosErroneos.show();
                    claveUsuario.setText("");
                }
            }
        }
    }

    public void vistaRegistro(View view) {
        startActivity(new Intent(Login.this, Register.class));
    }

    public void vistaRecuperarClave(View view) {
        startActivity(new Intent(Login.this, Recovery1.class));
    }
}