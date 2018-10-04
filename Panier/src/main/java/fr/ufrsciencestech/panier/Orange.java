package fr.ufrsciencestech.panier;
import java.lang.*;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tf872254
 */
public class Orange {
    private double prix;
    private String origine;
    
    public double getPrix(){
        return prix;
    }
    
    public String getOrigine(){
        return origine;
    }
    
    public Orange (double p, String o) {
            origine = o;
            prix = prixPositif(p);
    }
    
    private double prixPositif(double p){
        Scanner scn = new Scanner(System.in);
        while(p<0.0){
            System.out.println("Le prix doit etre positif");
            p = scn.nextDouble();
        }
        return p;
    }
    
    @Override
    public String toString(){
        String s = "Prix: " + prix + "\nOrigine:" + origine;
        return s;
    }
    
    @Override
    public boolean equals(Object obj){
        Orange o;
        if(obj.getClass() == this.getClass()){
            o = (Orange) obj;
            return this.prix == o.prix && this.origine.equals(o.origine);
        }
        return false;
    }
}
