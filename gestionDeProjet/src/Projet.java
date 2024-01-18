package gestionDeProjet.src;
import java.util.*;

public class Projet {
    
    private String numeroDeProjet, nomDeMatiere, sujet;

    /**
     * 
     */
    public Projet(){
        this.numeroDeProjet = "";
        this.nomDeMatiere = "";
        this.sujet = "";
    }
    /**
     * @param numeroDeProjet
     * @param nomDeMatiere
     * @param sujet
     */
    public Projet(String numeroDeProjet, String nomDeMatiere, String sujet) {
        this.numeroDeProjet = numeroDeProjet;
        this.nomDeMatiere = nomDeMatiere;
        this.sujet = sujet;
    }
    /**
     * @param projet
     */
    public Projet(Projet projet){
        this.numeroDeProjet = projet.getNumeroDeProjet();
        this.nomDeMatiere = projet.getNomDeMatiere();
        this.sujet = projet.getSujet();
    }
    
    /**
     * @return numero de l'étudiant
     */
    public String getNumeroDeProjet() {
        return this.numeroDeProjet;
    }
    /**
     * @param numeroDeProjet
     */
    public void setNumeroDeProjet(String numeroDeProjet) {
        this.numeroDeProjet = numeroDeProjet;
    }
    /**
     * @return
     */
    public String getNomDeMatiere() {
        return this.nomDeMatiere;
    }
    /**
     * @param nomDeMatiere
     */
    public void setNomDeMatiere(String nomDeMatiere) {
        this.nomDeMatiere = nomDeMatiere;
    }
    /**
     * @return
     */
    public String getSujet() {
        return this.sujet;
    }
    /**
     * @param sujet
     */
    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    /**
     * 
     */
    public void init(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Numéro du projet ?");
        this.setNumeroDeProjet(scan.nextLine());
        System.out.println("Matiére du projet ?");   
        this.setNomDeMatiere(scan.nextLine());
        System.out.println("Sujet du projet ?");  
        this.setSujet(scan.nextLine());
    }
    /**
     * @param projet
     * @return
     */
    public boolean equals(Projet projet){
        if(projet instanceof Projet){
            if(this.numeroDeProjet == projet.getNumeroDeProjet()){
                if(this.nomDeMatiere == projet.getNomDeMatiere()){
                    if(this.sujet == projet.getSujet()){
                        return true;
                    }
                }
            } 
        }
        return false;
    }
    
    @Override
    public String toString() {
        return "Projet [numeroDeProjet=" + this.numeroDeProjet + ", nomDeMatiere=" + this.nomDeMatiere + ", sujet=" + this.sujet + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroDeProjet == null) ? 0 : numeroDeProjet.hashCode());
        result = prime * result + ((nomDeMatiere == null) ? 0 : nomDeMatiere.hashCode());
        result = prime * result + ((sujet == null) ? 0 : sujet.hashCode());
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
        Projet other = (Projet) obj;
        if (numeroDeProjet == null) {
            if (other.numeroDeProjet != null)
                return false;
        } else if (!numeroDeProjet.equals(other.numeroDeProjet))
            return false;
        if (nomDeMatiere == null) {
            if (other.nomDeMatiere != null)
                return false;
        } else if (!nomDeMatiere.equals(other.nomDeMatiere))
            return false;
        if (sujet == null) {
            if (other.sujet != null)
                return false;
        } else if (!sujet.equals(other.sujet))
            return false;
        return true;
    }
}
