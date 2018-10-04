/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ufrsciencestech.panier;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Scanner;

/**
 *
 * @author tf872254
 */
public class Panier extends Observable{
    private ArrayList<Orange> listeOrange;
    private int capacitePanier;
        
    public Panier(int cp){
        listeOrange = new ArrayList();
        capacitePanier = cp;
    }
    
    /*
    private int capacitePositive(int cp){
        Scanner scn = new Scanner(System.in);
        while(cp<0.0){
            System.out.println("Le prix doit etre positif");
            cp = scn.nextInt();
        }
        return cp;
    }
    */
    
    public int getCapa(){
        return this.capacitePanier;
    }
    
    public int getNbOrange(){
        return listeOrange.size();
    }
    
    public boolean estPlein(){
        return capacitePanier == listeOrange.size();
    }
    
    public boolean estVide(){
        return 0 == listeOrange.size();
    }
    
    public void ajouter(Orange o){
        if(!estPlein()){
            listeOrange.add(o);
            setChanged();
            notifyObservers();
        }
    }
    
    public void retire(){
        if(!estVide()){
            listeOrange.remove(listeOrange.size()-1);
            setChanged();
            notifyObservers();
        }
    }
    
    public double getPrix(){
        double somme = 0;
        
        for(Orange o : listeOrange){
            somme += o.getPrix();
        }
        
        return somme;
    }
    
    public void boycotteOrigine(String s){        
        ArrayList<Orange> al = new ArrayList();
        
        for(Orange o: listeOrange){
            if(!o.getOrigine().equals(s)) al.add(o);
        }
        
        this.listeOrange = new ArrayList(al);
        
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString(){
        String s = "";
        for(Orange o : listeOrange){
            s += o.toString() + "\n";
        } 
        return s;
    }
    
    @Override
    public boolean equals(Object obj){
        Panier p;
        if(obj.getClass() == this.getClass()){ 
            p = (Panier)obj;
            if(this.capacitePanier != p.capacitePanier) return false;
            if(this.listeOrange.size() != p.listeOrange.size()) return false;

            for(int i = 0; i < listeOrange.size(); i++){
                if(!this.listeOrange.get(i).equals(p.listeOrange.get(i))) return false;
            }
            return true;
        }
        return false;
    }
}
