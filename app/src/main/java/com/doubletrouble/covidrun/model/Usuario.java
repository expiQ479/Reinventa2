package com.doubletrouble.covidrun.model;

import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.doubletrouble.covidrun.Utilidades;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "usuarios", indices = {@Index(value = {"correo"}, unique = true)})
public class Usuario {

    @NotNull
    @PrimaryKey
    public String nombreUsuario;
    String claveUsuario;
    String correo;
    String nombrePila;
    String apellidos;
    String pregSeguridad;
    String respSeguridad;
    String telefono;
    int edad;
    int nivel;
    int experiencia;

    public Usuario(@NotNull String nombreUsuario, String claveUsuario, String correo, String nombrePila, String apellidos, String pregSeguridad, String respSeguridad, String telefono, int edad) {
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;
        this.correo = correo;
        this.nombrePila = nombrePila;
        this.apellidos = apellidos;
        this.pregSeguridad = pregSeguridad;
        this.respSeguridad = respSeguridad;
        this.telefono = telefono;
        this.edad = edad;
        this.nivel = 0;
        this.experiencia = 0;
    }



    @NotNull
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClaveUsuario() {
        return claveUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombrePila() {
        return nombrePila;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getPregSeguridad() {
        return pregSeguridad;
    }

    public String getRespSeguridad() {
        return respSeguridad;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getEdad() {
        return edad;
    }

    public int getNivel() {
        return nivel;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setClaveUsuario(String claveUsuario) {
        this.claveUsuario = claveUsuario;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setNombrePila(String nombrePila) {
        this.nombrePila = nombrePila;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setPregSeguridad(String pregSeguridad) {
        this.pregSeguridad = pregSeguridad;
    }

    public void setRespSeguridad(String respSeguridad) {
        this.respSeguridad = respSeguridad;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean compararContraseñas(String contraseña) {
        return claveUsuario.equals(Utilidades.md5(contraseña));
    }

}
