package com.doubletrouble.covidrun;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.doubletrouble.covidrun.db.AppDatabase;
import com.doubletrouble.covidrun.model.Plan;
import com.doubletrouble.covidrun.model.Usuario;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.doubletrouble.myapplication", appContext.getPackageName());
    }

    @Test
    public void createNewPlan(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Plan testPlan = new Plan("test","test",1,1,1);
        List<Plan> planList;
        planList = AppDatabase.getDatabase(appContext).planDao().getAll();
        int numberOfPlans= planList.size();
        AppDatabase.getDatabase(appContext).planDao().insertPlan(testPlan);
        planList = AppDatabase.getDatabase(appContext).planDao().getAll();
        int newNumberOfPlans=planList.size();
        assertEquals(numberOfPlans+1,newNumberOfPlans);
    }
    public void createNewUser(){
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        Usuario usuario = new Usuario("Manuel","1234", "manuel99@gmail.com","Manu","Giménez",
                "¿Quien es tu madre?","Ana","611 35 58 47",35);
        Usuario existe;
        existe = AppDatabase.getDatabase(appContext).usuarioDao().buscarUsuario("Manuel");

        assertEquals(existe.nombreUsuario,usuario.getNombreUsuario());
    }
}