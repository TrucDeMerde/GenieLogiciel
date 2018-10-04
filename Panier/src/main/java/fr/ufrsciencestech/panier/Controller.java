/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.awt.event.*;
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
    
    public void actionPerformed(ActionEvent e) {
        Orange o = new Orange(0.65,"France");
        if(((JButton)e.getSource()).getName().equals("plus")){
            p.ajouter(o);
        }
        else{
            p.retire();
        }
    }
    
}
