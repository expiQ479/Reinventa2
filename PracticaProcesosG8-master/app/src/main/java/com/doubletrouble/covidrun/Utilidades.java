package com.doubletrouble.covidrun;

import android.content.Context;

import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.model.Plan;
import com.doubletrouble.covidrun.model.Usuario;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;

public class Utilidades {
    public static String md5(String input)
    {
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        }

        // For specifying wrong message digest algorithms
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void basicFeeding(Context context){
        // PLANES BASE
        if (AppDatabase.getDatabase(context).planDao().howManyPlans() < 3) {
            AppDatabase.getDatabase(context).planDao().insertPlan(new Plan("Netflix y mantita", "¡Ponte una buena serie de Netflix y tírate horas y horas debajo de tu mantita!", 150, 4, 5.6));
            AppDatabase.getDatabase(context).planDao().insertPlan(new Plan("¡Ya va siendo hora de hacer ejercicio!", "Dedica una horita a alguna rutina de ejercicio. ¡De aquí a la calistenia hay un solo paso!", 220, 1, 8.3));
            AppDatabase.getDatabase(context).planDao().insertPlan(new Plan("¡Recuerda tus buenos tiempos en el terreno de juego!", "De aquí al final de la cuarentena solo podrás jugar al fútbol con tu espejo. ¡Practica y sé el próximo Messi!", 80, 1, 6.7));
        }
    }
}
