/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.ingenieria.prn335.guia03;

import junit.framework.Assert;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;

/**
 *
 * @author bryan
 */
@RunWith(Arquillian.class)
public class UtilitiesTest {
    
    public WebArchive deploy(){
        WebArchive salida = ShrinkWrap.create(WebArchive.class)
                .addClass(Utilities.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE,"beans.xml");
        
        return salida;
    }
   
    
    @Test
    public void testGetResume(){
        String texto = "Bienvenidos a la mat";
        String resul;
        resul = Utilities.getResume("Bienvenidos a la materia de​ Programación​ 3 Ciclo​ II​ 2017.");
        Assert.assertEquals(texto,resul);
    }
    
    @Test
    public void testGetResume2(){
        String texto = "Hola​ Mundo!";
        String resul;
        resul = Utilities.getResume("Hola​ Mundo!");
        Assert.assertEquals(texto,resul);
    }
    
    @Test
    public void testGetResume3(){
        String texto = null;
        String resul;
        resul = Utilities.getResume(null);
        Assert.assertEquals(texto,resul);
    }
    
    @Test
    public void testCapitalizar1(){
        String texto = "Pruebas​ De​ Unidad​ Con​ Junit​ & Arquillian";
        String resul;
        resul = Utilities.capitalizar("prueBas​    de​   UNIDAD​  con​   JUnit​  &   arQuillian");
        Assert.assertEquals(texto,resul);
    }
    
    @Test
    public void testCapitalizar2(){
        String texto = "**";
        String resul;
        resul = Utilities.capitalizar("**");
        Assert.assertEquals(texto,resul);
    }
    
    @Test
    public void testCapitalizar3(){
        String texto = null;
        String resul;
        resul = Utilities.capitalizar(null);
        Assert.assertEquals(texto,resul);
    }
    
    @Test
    public void testContarConcidencias1(){
        int esperado = 1;
        String texto ="Bienvenidos​ a la​ materia​ de​ Programación​ 3 Ciclo​ II​ 2017.";
        int resul;
        resul = Utilities.contarCoincidencias("2017", texto);
        Assert.assertEquals(esperado,resul);
    }
    
    @Test
    public void testContarConcidencias2(){
        int esperado = 2;
        String texto ="Bienvenidos​ a la​ materia​ de​ Programación​ 3 Ciclo​ II​ 2017.";
        int resul;
        resul = Utilities.contarCoincidencias("MA", texto);
        Assert.assertEquals(esperado,resul);
    }
    
    @Test
    public void testContarConcidencias3(){
        int esperado = 0;
        String texto = null;
        int resul;
        resul = Utilities.contarCoincidencias("Bienvenido", texto);
        Assert.assertEquals(esperado,resul);
    }
    
    
}
