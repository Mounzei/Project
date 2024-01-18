package com.cisse;
import java.util.*;

public class Formation{

    private int numeroFormation;
    private String nom,promotion;
    
    /**
     * Crée une formation vide
     */
    public Formation() {
        this.numeroFormation = 0;
        this.nom = "";
        this.promotion = "";
    }
    /**
     * Crée une formation avec les données fournies en paramétres
     * @param numeroFormation
     * @param nom
     * @param promotion
     */
    public Formation(int numeroFormation, String nom, String promotion) {
        this.numeroFormation = numeroFormation;
        this.nom = nom;
        this.promotion = promotion;
    }
    /**
     * Crée une formation à partir d'une autre formation
     * @param f
     */
    public Formation(Formation f){
        this.numeroFormation = f.getNumeroFormation();
        this.nom = f.getNom();
        this.promotion = f.getPromotion();
    }

    /**
     * @return le numéro de la formation
     */
    public int getNumeroFormation() {
        return this.numeroFormation;
    }
    /**
     * Méthode pour mettre à jour le numéro de la formation
     * @param numeroFormation
     */
    public void setNumeroFormation(int numeroFormation) {
        this.numeroFormation = numeroFormation;
    }
    /**
     * @return le nom de la formation
     */
    public String getNom() {
        return this.nom;
    }
    /**
     * Méthode pour mettre à jour le nom de la formation
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return la promotion de la formation
     */
    public String getPromotion() {
        return this.promotion;
    }
    /**
     * Méthode pour mettre a jour la promotion d'une formation
     * @param promotion
     */
    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    /**
     * Initialise un formation à partir de données fournies par l'utilisateur
     */
    public void init(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Numéro de la formation ?");
        this.setNumeroFormation(scan.nextInt());
        System.out.println("Nom de la formation ?");
        this.setNom(scan.nextLine());
        System.out.println("Promotion de la formation ?");   
        this.setPromotion(scan.nextLine());
    }
    
    @Override
    public String toString() {
        return "Formation [numeroFormation=" + numeroFormation + ", nom=" + nom + ", promotion=" + promotion + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroFormation;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((promotion == null) ? 0 : promotion.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Formation other = (Formation) obj;
        if (numeroFormation != other.numeroFormation)
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (promotion == null) {
            if (other.promotion != null)
                return false;
        } else if (!promotion.equals(other.promotion))
            return false;
        return true;
    }
}