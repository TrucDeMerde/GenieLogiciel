/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.exceptions.PanierPleinException;
import fr.ufrsciencestech.exceptions.OrangeNullException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author tf872254
 */
public class PanierTest {
    
    Panier pVide, p1, p2, pPlein;
    Orange o1, o2;
    
    
    public PanierTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws PanierPleinException, OrangeNullException{
        pVide = new Panier(4);
        p1 = new Panier(4);
        p2 = new Panier(4);
        pPlein = new Panier(0);
        
        o1 = new Orange();
        o2 = new Orange(0.5, "Espagne");
        
        p1.ajouter(o1);
        p2.ajouter(o1);
        p2.ajouter(o2);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test (expected = OrangeNullException.class)
    public void OrangeNULL() throws PanierPleinException, OrangeNullException {
        Orange o = null;
        p1.ajouter(o);
    }
    
    @Test
    public void TestPrixPanierA2Oranges() throws PanierPleinException, OrangeNullException{
        Orange om1 = mock(Orange.class);
        Orange om2 = mock(Orange.class);
        when(om1.getPrix()).thenReturn(1.0); //remplace 
        when(om2.getPrix()).thenReturn(0.5);
        pVide.ajouter(om1);
        pVide.ajouter(om2);
        assertTrue(pVide.getNbOrange()==2);
        assertTrue(pVide.getPrix()==1.5);
        verify(om1,times(1)).getPrix();
        verify(om2,times(1)).getPrix();
    }
    
    @Test (expected = PanierPleinException.class)
    public void testAjoutDansPanierPlein() throws PanierPleinException, OrangeNullException{
        pPlein.ajouter(o1);
    }
    
    @Test
    public void testAjoutDansPanierVide() throws OrangeNullException, PanierPleinException{
        pVide.ajouter(o1);
        assertTrue(pVide.getNbOrange()==1);
    }
    
    /*
    @Test
    public void testOrangePrixNegatif(){
        Orange o = new Orange(-1,"");
        assertTrue(o.getPrix()==1);
    }
    */
    

    private void assertType(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
