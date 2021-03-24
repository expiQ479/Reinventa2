package com.doubletrouble.covidrun.viewmodel.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.Utilidades;
import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.model.Usuario;

public class EditProfile extends AppCompatActivity {

    String loggedInUser;
    EditText correo, claveUsuario, otraClave, nombrePila, apellidos, pregSeguridad, respSeguridad, telefono, edad;
    Usuario usuario;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        setTitle("Edit Profile");

        loggedInUser = getIntent().getExtras().getString("loggedInUser");
        usuario = AppDatabase.getDatabase(getApplicationContext()).usuarioDao().buscarUsuario(loggedInUser);


        correo = (EditText) findViewById(R.id.reg_correoElectronico);
        claveUsuario = (EditText) findViewById(R.id.reg_claveUsuario);
        otraClave = (EditText) findViewById(R.id.reg_claveUsuario2);
        nombrePila = (EditText) findViewById(R.id.reg_nombrePila);
        apellidos = (EditText) findViewById(R.id.reg_apellidos);
        pregSeguridad = (EditText) findViewById(R.id.reg_pregSeguridad);
        respSeguridad = (EditText) findViewById(R.id.reg_respSeguridad);
        telefono = (EditText) findViewById(R.id.reg_telefono);
        edad = (EditText) findViewById(R.id.reg_edad);

        correo.setText(usuario.getCorreo());
        nombrePila.setText(usuario.getNombrePila());
        apellidos.setText(usuario.getApellidos());
        pregSeguridad.setText(usuario.getPregSeguridad());
        telefono.setText(usuario.getTelefono());
        edad.setText(Integer.toString(usuario.getEdad()));


    }

    @SuppressLint("SetTextI18n")
    public void changeProfile(View view) {

        EditText claveUsuario = findViewById(R.id.reg_claveUsuario);
        EditText otraClave = findViewById(R.id.reg_claveUsuario2);

        String email = correo.getText().toString();
        String password = claveUsuario.getText().toString();
        String otherPassword = otraClave.getText().toString();
        String name = nombrePila.getText().toString();
        String surname = apellidos.getText().toString();
        String secQuest = pregSeguridad.getText().toString();
        String secAnsw = respSeguridad.getText().toString();
        String tlf = telefono.getText().toString();

        if (email.isEmpty() || name.isEmpty() || surname.isEmpty() || secQuest.isEmpty() || tlf.isEmpty()) {
            Toast emptyText = Toast.makeText(getApplicationContext(), "No pueden aparecer campos vacíos", Toast.LENGTH_SHORT);
            emptyText.show();
        } else {
            if (!(password.isEmpty() && otherPassword.isEmpty())) {
                if (!password.equals(otherPassword)) {
                    Toast differentPasswd = Toast.makeText(getApplicationContext(), "Las contraseñas no son iguales", Toast.LENGTH_SHORT);
                    differentPasswd.show();
                } else {
                    usuario.setClaveUsuario(Utilidades.md5(claveUsuario.getText().toString()));
                    irmeDeAqui();
                }
            } else {
                usuario.setNombrePila(name);
                usuario.setApellidos(surname);
                usuario.setCorreo(email);
                usuario.setPregSeguridad(secQuest);
                if (!secAnsw.isEmpty()) {
                    usuario.setRespSeguridad(secAnsw);
                }
                usuario.setTelefono(tlf);
                usuario.setEdad(Integer.parseInt(edad.getText().toString()));

                AppDatabase.getDatabase(getApplicationContext()).usuarioDao().updateUser(usuario);
                irmeDeAqui();
            }
        }
    }

    void irmeDeAqui(){
        Intent goToProfile = new Intent(this, Profile.class);
        goToProfile.putExtra("loggedInUser", loggedInUser);
        startActivity(goToProfile);
    }
}