/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import fr.ufrsciencestech.exceptions.OrangeNullException;
import fr.ufrsciencestech.exceptions.PanierPleinException;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;



/**
 *
 * @author tf872254
 */
public class Controller implements ActionListener {
    
    private Panier p;
    
    public Controller(Panier pan){
        super();
        this.p = pan;
    }
    
    public void actionPerformed(ActionEvent e){
        Orange o = new Orange(0.65,"France");
        if(((JButton)e.getSource()).getName().equals("plus")){
            try {
                p.ajouter(o);
            } catch (PanierPleinException ex) {
                System.out.println(ex.toString());
            } catch (OrangeNullException ex) {
                System.out.println(ex.toString());
            }
        }
        else{
            p.retire();
        }
    }
    
}
