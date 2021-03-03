package com.doubletrouble.covidrun.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.doubletrouble.covidrun.model.Usuario;

import java.util.List;

@Dao
public interface UsuarioDAO {
    @Query("SELECT * FROM usuarios")
    List<Usuario> getAll();

    @Query("SELECT * FROM usuarios WHERE nombreUsuario = :nombreUsuario LIMIT 1")
    Usuario buscarUsuario(String nombreUsuario);

    @Query("SELECT * FROM usuarios WHERE correo = :correo LIMIT 1")
    Usuario buscarCorreo(String correo);

    @Query("SELECT COUNT(*) FROM usuarios WHERE nombreUsuario = :nombreUsuario")
    int existeUsuario(String nombreUsuario);

    @Query("UPDATE usuarios SET claveUsuario = :contraseña WHERE correo = :correo")
    void modificarContraseña(String correo,String contraseña);

    @Query("SELECT COUNT(*) FROM usuarios")
    int howManyUsers();

    @Insert
    void insertUser(Usuario user);

    @Delete
    void delete(Usuario user);

    @Query("DELETE FROM usuarios")
    void eliminarTodo();

    @Update
    int updateUser(Usuario usuario);



}
