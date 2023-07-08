package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

import models.Temperatura;

public class TemperaturaTest {

    Temperatura t1 = new Temperatura("Celsius", 10);

    @Test 
    public void testConverter(){

        //Celsius para *
        assertEquals(283, Double.parseDouble(t1.converter(t1, new Temperatura("Kelvin", t1.getValor()))));
        assertEquals(50, Double.parseDouble(t1.converter(t1, new Temperatura("Fahrenheit", t1.getValor()))));
        assertEquals(t1.getValor(), Double.parseDouble(t1.converter(t1, new Temperatura("Celsius", t1.getValor()))));

        //Kelvin para *
        t1.setEscala("Kelvin");
        assertEquals(-263, Double.parseDouble(t1.converter(t1, new Temperatura("Celsius", t1.getValor()))));
        assertEquals(-441.40000000000003, Double.parseDouble(t1.converter(t1, new Temperatura("Fahrenheit", t1.getValor()))));
        assertEquals(t1.getValor(), Double.parseDouble(t1.converter(t1, new Temperatura("Kelvin", t1.getValor()))));

        //Fahrenheit para *
        t1.setEscala("Fahrenheit");
        assertEquals(-12.222222222222221, Double.parseDouble(t1.converter(t1, new Temperatura("Celsius", t1.getValor()))));
        assertEquals(260.77777777777777, Double.parseDouble(t1.converter(t1, new Temperatura("Kelvin", t1.getValor()))));
        assertEquals(t1.getValor(), Double.parseDouble(t1.converter(t1, new Temperatura("Fahrenheit", t1.getValor()))));
    }
}

