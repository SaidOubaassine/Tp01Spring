package com.ensa.gi4.controller;

import com.ensa.gi4.modele.Chaise;
import com.ensa.gi4.modele.Livre;
import com.ensa.gi4.modele.Materiel;
import com.ensa.gi4.service.api.GestionMaterielService;

import java.util.Scanner;

public class GestionMaterielController {

    private GestionMaterielService gestionMaterielService;

    public void listerMateriel() {
        gestionMaterielService.listerMateriel();
    }
    public void ajouterNouveauMateriel(Materiel materiel) {
        gestionMaterielService.ajouterNouveauMateriel(materiel);
    }
    public void supprimerMateriel(String name, String type) {
        gestionMaterielService.supprimerMateriel(name, type);
    }
    public Materiel chercherMateriel(String name, String type) {
        return gestionMaterielService.chercherMateriel(name, type);
    }
    

    public void afficherMenu() {
        System.out.println("1- pour lister le matériel, entrer 1");
        System.out.println("2- pour ajouter un nouveau matériel, entrer 2");
        System.out.println("3- pour supprimer un matériel, entrer 3");
        System.out.println("4- pour modifier un matériel, entrer 4");
        System.out.println("5- pour chercher un matériel, entrer 5");
        System.out.println("0- pour sortir de l'application, entrer 0");
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        if ("0".equals(next)) {
            sortirDeLApplication();
        } else if ("1".equals(next)) {
            listerMateriel();
        } else if ("2".equals(next)) {
        	 System.out.println("1- pour livre, entrer 1");
             System.out.println("2- pour chaise, entrer 2");
        	 Scanner sc = new Scanner(System.in);
             String materiel = sc.next();
             if("1".equals(materiel)) {
            	 Materiel livre=new Livre();
            	 ajouterNouveauMateriel(livre);
             }else if("2".equals(materiel)) {
            	 Materiel chaise=new Chaise();
            	 ajouterNouveauMateriel(chaise);
             }else {
            	 System.out.println("choix invalide");
             }
        }else if ("3".equals(next)) {
           System.out.println("pour supprimer un livre taper sur 1");
           System.out.println("pour supprimer un chaise taper sur 2");
           Scanner scanner_3 = new Scanner(System.in);
           String next_3 = scanner.next();
           System.out.println("Donner le nom");
    	   Scanner scanner_type = new Scanner(System.in);
  	       String nom = scanner_type.next();
           if ("1".equals(next_3)) {
               supprimerMateriel(nom, "Livre");
           }else if("2".equals(next_3)) {
               supprimerMateriel(nom, "Chaise");
           }else {
          	 System.out.println("choix invalide");
           }
        }
        else if ("4".equals(next)) {
        	
        }
        else if ("5".equals(next)) {
        	 System.out.println("pour faire la recherche sur un livre taper sur 1");
             System.out.println("pour faire la recherche sur un Chaise taper sur 1");
             Scanner scanner_5 = new Scanner(System.in);
             String next_5 = scanner.next();
             System.out.println("Donner le nom");
      	   Scanner scanner_type = new Scanner(System.in);
    	       String nom = scanner_type.next();
             if ("1".equals(next_5)) {
               System.out.println(chercherMateriel(nom, "Livre"));
             }else if("2".equals(next_5)) {
            	 System.out.println(chercherMateriel(nom, "Chaise"));
             }else {
            	 System.out.println("choix invalide");
             }
        }
        else {
            System.out.println("choix invalide");
        }
    }


	private void sortirDeLApplication() {
        System.exit(0);
    }

    public void setGestionMaterielService(GestionMaterielService gestionMaterielService) {
        // injection par accesseur
        this.gestionMaterielService = gestionMaterielService;
    }
}
