package com.doubletrouble.covidrun;

import com.doubletrouble.covidrun.db.PlanDAO;
import com.doubletrouble.covidrun.db.UsuarioDAO;
import com.doubletrouble.covidrun.model.Plan;
import com.doubletrouble.covidrun.model.Usuario;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void check_newPlan(){
        Plan testPlan = new Plan("test","test",1,1,1);
        Usuario userTest = new Usuario("test","test","test","test","test","test","test","test",1);
        PlanDAO IplanTest = null;
        UsuarioDAO IuserTest;
        List<Plan> planList = new ArrayList<Plan>();
        planList = IplanTest.getAll();
        int numberOfPlans=planList.size();
        IplanTest.insertPlan(testPlan);
        int newNumberOfPlans=planList.size();
        assertEquals(numberOfPlans+1,newNumberOfPlans);

    }
}