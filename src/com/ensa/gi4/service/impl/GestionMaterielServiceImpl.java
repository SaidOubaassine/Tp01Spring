package com.ensa.gi4.service.impl;
import java.util.ArrayList;
import java.util.Scanner;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;

import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

public class GestionMaterielServiceImpl implements GestionMaterielService {
    private ArrayList<Livre> Livres;
    private ArrayList<Chaise> Chaises;
    public GestionMaterielServiceImpl(){
    init();	
    }
    @Override
    public void init() {
    	Livres=new ArrayList<>();
    	Chaises=new ArrayList<>(); 	   			 
    }

    @Override
    public void listerMateriel() {
        System.out.println("Liste de matériel :\n "+this.Livres.size()+" Livres \n "+this.Chaises.size()+" chaises");
    }

    @Override
    public void ajouterNouveauMateriel(Materiel materiel) {
    	System.out.println("Donner le nom");
   	    Scanner sc = new Scanner(System.in);
        String nom = sc.next();
        materiel.setName(nom);
    	if(materiel instanceof Livre ) {		
    		Livre l=new Livre();
    		l=(Livre)materiel;
    		l.setName(nom);
    		Livres.add(l);
    	}
    	else if(materiel instanceof Chaise) {
    		Chaise c=new Chaise();
    		c=(Chaise)materiel;
    		c.setName(nom);
    		Chaises.add(c);
    	}else {
    		System.out.println("errur");
    		System.out.println(materiel.getClass().getName());
    		
    	}
        System.out.println("L'ajout du matériel " + materiel.getName() + " effectué avec succès !");
    }

	

	@Override
	public void supprimerMateriel(String name, String type) {
		if(type.equals("Livre")) {
			Livre li=null;
			if(Livres.size()==0) {
				System.out.println("pas des livres");
			}else {
				for (Livre l : Livres) {
					
				      if(l.getName().equals(name)) {
				    	li=l;
				      }
				    }
				if(li==null) {
					System.out.println("ce livre n'existe pas");
				}else {
					Livres.remove(li);	
				}	
				}
			}
		
			else if(type.equals("Chaise")) {
			Chaise ch=new Chaise();
			if(Livres.size()==0) {
				System.out.println("pas des chaises");
			}else {
				for (Chaise c : Chaises) {
				      if(ch.getName().equals(name)) {
				    	ch=c;
				      }
				    }
				if(ch==null) {
					System.out.println("ce chaise n'existe pas");
				}else {
					Livres.remove(ch);	
				}	
				}
			}	
	}
	

	@Override
	public void modifierMateriel(String newName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Materiel chercherMateriel(String name, String type) {
		if(type.equals("Livre")) {
			Livre li=null;
			if(Livres.size()==0) {
				return null;
			}else {
				for (Livre l : Livres) {
					
				      if(l.getName().equals(name)) {
				    	li=l;
				      }
				    }
					return li;
				}
			}
			else if(type.equals("Chaise")) {
			Chaise ch=new Chaise();
			if(Livres.size()==0) {
				return null;
			}else {
				for (Chaise c : Chaises) {
				      if(ch.getName().equals(name)) {
				    	ch=c;
				      }
				    }
				return ch;
				}
			}	
		return null;
	}
}
