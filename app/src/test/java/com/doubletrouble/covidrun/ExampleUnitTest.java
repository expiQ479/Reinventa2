package com.doubletrouble.covidrun;


import com.doubletrouble.covidrun.model.Usuario;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(JUnit4.class)
public class ExampleUnitTest {

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void create_new_user(){
        Usuario user = new Usuario("José","1234","example@gmail.com",
                "Pepe","Esperanza","¿Cómo se llama tu madre?",
                "Ana","6628956861",65 );
        assertEquals(user.getApellidos(),"Esperanza");
    }
}