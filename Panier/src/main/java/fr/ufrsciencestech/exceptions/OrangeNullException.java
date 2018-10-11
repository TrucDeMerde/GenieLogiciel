/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.exceptions;

/**
 *
 * @author tf872254
 */
public class OrangeNullException extends Exception{
    String text;
    
    public OrangeNullException(){
        text="L'Orange ajoutée est null !";
    }
    
    @Override
    public String toString(){
        return this.text;
    }
}
