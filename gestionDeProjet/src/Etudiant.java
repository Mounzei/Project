package gestionDeProjet.src;
import java.util.*;

public class Etudiant{

    private int numeroEtudiant;
    private String nom,prenom;
    private Formation formation;

    /**
     * Crée un étudiant vide
     */
    public Etudiant(){
        this.numeroEtudiant = 0;
        this.nom = "";
        this.prenom = "";
        this.formation = new Formation();
    }
    /**
     * Crée un étudiant avec les données fournies en paramètre
     * @param numeroEtudiant
     * @param nom
     * @param prenom
     * @param formation
     */
    public Etudiant(int numeroEtudiant, String nom, String prenom, Formation formation) {
        this.numeroEtudiant = numeroEtudiant;
        this.nom = nom;
        this.prenom = prenom;
        this.formation = new Formation(formation);
    }
    /**
     * Crée un étudaint à partir d'un autre étudiant
     * @param etudiant
     */
    public Etudiant(Etudiant etudiant){
        this.numeroEtudiant = etudiant.getNumeroEtudiant();
        this.nom = etudiant.getNom();
        this.prenom = etudiant.getPrenom();
        this.formation = new Formation(etudiant.getFormation());
    }

    /**
     * @return le numéro de l'étudiant
     */
    public int getNumeroEtudiant() {
        return this.numeroEtudiant;
    }
    /**
     * Méthode pour mettre à jour le numéro de l'étudiant
     * @param numeroEtudiant
     */
    public void setNumeroEtudiant(int numeroEtudiant) {
        this.numeroEtudiant = numeroEtudiant;
    }
    /**
     * @return le nom de l'étudiant
     */
    public String getNom() {
        return this.nom;
    }
    /**
     * Méthode pour mettre à jour le nom de l'étudiant
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    /**
     * @return le prénom de l'étudiant
     */
    public String getPrenom() {
        return this.prenom;
    }
    /**
     * Méthode pour retourner le prénom de l'étudiant
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    /**
     * @return la formation de l'étudiant
     */
    public Formation getFormation() {
        return this.formation;
    }
    /**
     * Méthode pour mettre à jour la formation de l'étudiant
     * @param formation
     */
    public void setFormation(Formation formation) {
        this.formation = new Formation(formation);
    }

    /**
     * Initialise un etudiant avec des données fournies par l'utilisateur
     */
    public void init(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Numéro de l'étudiant ?");
        this.setNumeroEtudiant(scan.nextInt());
        System.out.println("Nom de l'étudiant ?");
        this.setNom(scan.nextLine());
        System.out.println("Prénom de l'étudiant ?");
        this.setPrenom(scan.nextLine());
        Formation formation = new Formation();
        formation.init();
        this.setFormation(formation);
    }

    @Override
    public String toString(){
        return "Etudiant [numeroEtudiant=" + numeroEtudiant + ", nom=" + nom + ", prenom=" + prenom + ", formation="
                + formation + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numeroEtudiant;
        result = prime * result + ((nom == null) ? 0 : nom.hashCode());
        result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
        result = prime * result + ((formation == null) ? 0 : formation.hashCode());
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
        Etudiant other = (Etudiant) obj;
        if (numeroEtudiant != other.numeroEtudiant)
            return false;
        if (nom == null) {
            if (other.nom != null)
                return false;
        } else if (!nom.equals(other.nom))
            return false;
        if (prenom == null) {
            if (other.prenom != null)
                return false;
        } else if (!prenom.equals(other.prenom))
            return false;
        if (formation == null) {
            if (other.formation != null)
                return false;
        } else if (!formation.equals(other.formation))
            return false;
        return true;
    }
}