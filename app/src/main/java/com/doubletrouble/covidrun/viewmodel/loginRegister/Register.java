package com.doubletrouble.covidrun.viewmodel.loginRegister;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.doubletrouble.covidrun.R;
import com.doubletrouble.covidrun.model.Usuario;
import com.doubletrouble.covidrun.Utilidades;
import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.db.UsuarioDAO;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Registro");
        setContentView(R.layout.activity_registro);
    }

    private String getTextValue(int id) {
        EditText editText = findViewById(id);
        return editText.getText().toString();
    }

    public void register(View view) {
        // Getting values from View
        String nombreUsuario = getTextValue(R.id.reg_nombreUsuario);
        String correoElectronico = getTextValue(R.id.reg_correoElectronico);
        String claveUsuario = getTextValue(R.id.reg_claveUsuario);
        String otraClave = getTextValue(R.id.reg_claveUsuario2);
        String nombrePila = getTextValue(R.id.reg_nombrePila);
        String apellidos = getTextValue(R.id.reg_apellidos);
        String pregSeguridad = getTextValue(R.id.reg_pregSeguridad);
        String respSeguridad = getTextValue(R.id.reg_respSeguridad);
        String telefono = getTextValue(R.id.reg_telefono);
        String edad = getTextValue(R.id.reg_edad);
        // Validation
        // 1 -> if any of these fields is empty, stop
        if (nombreUsuario.length() == 0 || correoElectronico.length() == 0 || claveUsuario.length() == 0 || nombrePila.length() == 0 || apellidos.length() == 0 || pregSeguridad.length() == 0 || respSeguridad.length() == 0 || telefono.length() == 0 || edad.length() == 0) {
            Toast.makeText(getApplicationContext(), "Alguno de los campos está vacío", Toast.LENGTH_SHORT).show();
        }
        // 2 -> if user exists, stop
        else if (AppDatabase.getDatabase(getApplicationContext()).usuarioDao().existeUsuario(nombreUsuario) > 0) {
            Toast.makeText(getApplicationContext(), "Este nombre de usuario ya está registrado", Toast.LENGTH_SHORT).show();
        }
        // 3 -> if passwords doesn't match, stop
        else if (!claveUsuario.equals(otraClave)) {
            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
        }
        // 4 -> if e-mail is not like an e-mail, stop
        else if (TextUtils.isEmpty(correoElectronico) || !Patterns.EMAIL_ADDRESS.matcher(correoElectronico).matches()) {
            Toast.makeText(getApplicationContext(), "Introduzca un correo electrónico válido", Toast.LENGTH_SHORT).show();
        }
        // 5 -> everything was fine, go on
        else {
            Usuario usuarioNuevo = new Usuario(
                    nombreUsuario,
                    Utilidades.md5(claveUsuario),
                    correoElectronico,
                    nombrePila,
                    apellidos,
                    pregSeguridad,
                    Utilidades.md5(respSeguridad),
                    telefono,
                    Integer.parseInt(edad)
            );

            UsuarioDAO usuarioDAO = AppDatabase.getDatabase(getApplicationContext()).usuarioDao();
            usuarioDAO.insertUser(usuarioNuevo);

            irLogin(view);
        }
    }

    public void irLogin(View view) {
        startActivity(new Intent(this, Login.class));
    }

}