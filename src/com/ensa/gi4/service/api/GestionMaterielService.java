package com.ensa.gi4.service.api;

import java.util.List;

import com.ensa.gi4.modele.Materiel;

public interface GestionMaterielService {
    void init();
    void listerMateriel();
    void ajouterNouveauMateriel(Materiel materiel);
    Materiel chercherMateriel(String name, String type);
    void supprimerMateriel(String name, String Type);
    void modifierMateriel(String name);
}
