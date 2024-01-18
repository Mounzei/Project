package gestionDeProjet.src;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Classe {
    private ArrayList<Etudiant> etudiants;
    private ArrayList<Binome> binomes;
    private Projet projet;
    private boolean verf;
    private Vue vue;
    private String lien;
    /**
     * @return un tableau contenant les numéros des différents binôme
     */
    private ArrayList<Integer> idBinomes(){
        ArrayList<Integer> idb = new ArrayList<Integer>();
        for(Binome b : binomes){
            idb.add(b.getNumero());
        }
        return idb;
    }
    /**
     * @return un tableau contenant les numéros des différents projet
     */
    private ArrayList<String> idProjets(){
        ArrayList<String> idp = new ArrayList<String>();
        for(Binome b : binomes){
            idp.add(b.getProjet().getNumeroDeProjet());
        }
        return idp;
    }
    /**
     * @param n
     * @param s
     * @return vrai ou faux par rapport à est ce qu'un binôme est déjâ présent dans la classe
     */
    private boolean isIn(int n, String s){
        if(this.idProjets().contains(s)){
            if(this.idBinomes().contains(n)){
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Crée une classe vide
     */
    public Classe(){
        this.etudiants = new ArrayList<Etudiant>();
        this.binomes = new ArrayList<Binome>();
        this.projet = new Projet();
        this.verf = true;
    }
    /**
     * Crée une classe avec les paramétres fournies en paramètre
     * @param etudiants
     * @param binomes
     * @param projet
     */
    public Classe(ArrayList<Etudiant> etudiants, ArrayList<Binome> binomes, Projet projet) {
        int i = 0;
        this.verf = true;
        while(i < binomes.size()){
            if(!(etudiants.contains(binomes.get(i).getEtudiants().get(0)))){
                this.verf = false;
                break;
            }
            if(!(etudiants.contains(binomes.get(i).getEtudiants().get(1)))){
                this.verf = false;
                break;
            }
            if(!(projet.equals(binomes.get(i).getProjet()))){
                this.verf = false;
                break;
            }
            i++;
        }
        if(this.verf){
            this.etudiants = new ArrayList<Etudiant>(etudiants);
            this.binomes = new ArrayList<Binome>(binomes);
            this.projet = new Projet(projet);
        }else{
            System.out.println("Problème au niveau des éléves !!!");
        }
    }
    /**
     * Crée une classe à partir d'une classe 
     * @param classe
     */
    public Classe(Classe classe){
        this.etudiants = new ArrayList<Etudiant>(classe.getEtudiants());
        this.binomes = new ArrayList<Binome>(classe.getBinomes());
        this.projet = new Projet(classe.getProjet());
        this.verf = true;
    }

    /**
     * @return les étudiants de la classe
     */
    public ArrayList<Etudiant> getEtudiants() {
        return this.etudiants;
    }
    /**
     * Méthode pour mettre à jour les étudiants de la classe
     * @param etudiants
     */
    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
    /**
     * @return les binômes de la classe
     */
    public ArrayList<Binome> getBinomes() {
        return this.binomes;
    }
    /**
     * Méthode pour mettre à jour les binômes de la classe
     * @param binomes
     */
    public void setBinomes(ArrayList<Binome> binomes) {
        this.binomes = binomes;
    }
    /**
     * @return le projet de la classe
     */
    public Projet getProjet() {
        return this.projet;
    }
    /**
     * Méthode pour mettre à jour le projet de la classe
     * @param projet
     */
    public void setProjet(Projet projet) {
        this.projet = new Projet(projet);
    }
    /**
     * @return le lien de la classe
     */
    public String getLien() {
        return this.lien;
    }

    /**
     * Méthode pour ajouter un étudiant à la classe
     * @param etudiant
     */
    public void ajouterEtudiant(Etudiant etudiant){
        this.etudiants.add(etudiant);
    }
    /**
     * Méthode pour ajouter un étudiant à la classe
     * @param num
     * @param nom
     * @param prenom
     * @param numF
     * @param nomF
     * @param prom
     */
    public void ajouterEtudiant(int num, String nom, String prenom, int numF, String nomF, String prom){
        this.etudiants.add(new Etudiant(num, nom, prenom, new Formation(numF, nomF, prom)));
    }
    /**
     * Méthode pour ajouter un binôme à la classe
     * @param binome
     */
    public void ajouterBinome(Binome binome){
        if(!this.isIn(binome.getNumero(), binome.getProjet().getNumeroDeProjet())){
            this.ajouterEtudiant(new Etudiant(binome.getEtudiants().get(0).getNumeroEtudiant(), binome.getEtudiants().get(0).getNom(), binome.getEtudiants().get(0).getPrenom(), binome.getEtudiants().get(0).getFormation()));
            this.ajouterEtudiant(new Etudiant(binome.getEtudiants().get(1).getNumeroEtudiant(), binome.getEtudiants().get(1).getNom(), binome.getEtudiants().get(1).getPrenom(), binome.getEtudiants().get(1).getFormation()));
            this.binomes.add(binome);
            this.setProjet(binome.getProjet());
        }else{
            return;
        }
    }
    /**
     * Méthode pour ajouter un binôme à la classe
     * @param num1
     * @param nom1
     * @param prenom1
     * @param note1
     * @param num2
     * @param nom2
     * @param prenom2
     * @param note2
     * @param numF
     * @param nomF
     * @param prom
     * @param numB
     * @param noteB
     * @param dateP
     * @param dateR
     * @param numP
     * @param nomM
     * @param sujet
     */
    public void ajouterBinome(int num1, String nom1, String prenom1, double note1, 
    int num2, String nom2, String prenom2, double note2, 
    int numF, String nomF, String prom, 
    int numB, double noteB, String dateP, String dateR, String numP, String nomM, String sujet){
        if(!this.isIn(numB, numP)){
            this.ajouterEtudiant(num1, nom1, prenom1, numF, nomF, prom);
            this.ajouterEtudiant(num2, nom2, prenom2, numF, nomF, prom);
            ArrayList<Etudiant> e = new ArrayList<Etudiant>();
            e.add(new Etudiant(num1, nom1, prenom1, new Formation(numF, nomF, prom)));
            e.add(new Etudiant(num2, nom2, prenom2, new Formation(numF, nomF, prom)));
            double[] notes = {noteB,note1,note2};
            this.binomes.add(new Binome(numB, new Projet(numP, nomM, sujet), e, notes, dateP, dateR));
            this.notifierVue();
        }else{
            return;
        }
    }
	/**
     * Méthode pour enregistrer une classe en tant que chaine de caractére
     * @return une classe en chaine de caractére
	 */
	public String versFichier() {
		String str = "";
		for (Binome binome : this.binomes) {
			str += binome.versFichier();
			str += "\n";
		}
		return str;
	}
	/**
     * Méthode pour charger une classe à partir d'un lien
	 * @param nomFichier
	 */
	public void charger(String nomFichier) {
		try {
			// System.out.println(nomFichier);
            this.lien = nomFichier;
            this.etudiants = new ArrayList<Etudiant>();
            this.binomes = new ArrayList<Binome>();
            this.projet = new Projet();
            this.verf = true;
 
			BufferedReader br = Files.newBufferedReader(Paths.get(nomFichier));
			String ligne;
 
			ligne = br.readLine();
			while (ligne != null) {
				this.ajouterBinome(Binome.parse(ligne));
				ligne = br.readLine();
			}
			br.close();
            this.notifierVue();
		} catch (IOException e) {
			System.err.println(e);
		}
	}
	/**
     * Méthode pour sauvegarder une classe
	 * @param chemin
	 */
	public void sauver(String chemin){
		try{
            this.lien = chemin;
			PrintWriter sortie = new PrintWriter(new BufferedWriter(new FileWriter(chemin)));
			// BufferedReader br = new BufferedReader(fichierSave)
			// String ligne = nomFichierSave.readLine();
			sortie.print(this.versFichier());
			sortie.close();
		}catch (Exception e){
			System.err.println(e);
		}
	}
	/**
     * @return un tableau qui servira à contenir les données qu'affichera l'application
	 */
	public String[][] donnees(){
		String[][] donnees = new String[this.getBinomes().size()][9];
		int i = 0;
        while (i < this.getBinomes().size()){
            int j = 0;
            String[] donnee = this.getBinomes().get(i).donnees();
            while (j < 9){
                donnees[i][j] = donnee[j];
                j++;
            }
            i++;
        }
		return donnees;
	}
    /**
     * Méthode pour enregistrer une vue dans la classe
     * @param vue
     */
    public void enregistrerVue(Vue vue){
        vue.setClasse(this);
        this.vue = vue;
    }
    /**
     * Notifier la vue présente dans la classe qu'il y a eu des changements
     */
    public void notifierVue(){
        this.vue.setClasse(this);
    }

    @Override
    public String toString() {
        if(this.verf){
            return "Classe [etudiants=" + etudiants + ", binomes=" + binomes + ", projet=" + projet + "]";
        }
        return "Impossible de créer la classe !!!";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((etudiants == null) ? 0 : etudiants.hashCode());
        result = prime * result + ((binomes == null) ? 0 : binomes.hashCode());
        result = prime * result + ((projet == null) ? 0 : projet.hashCode());
        result = prime * result + (verf ? 1231 : 1237);
        result = prime * result + ((vue == null) ? 0 : vue.hashCode());
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
        Classe other = (Classe) obj;
        if (etudiants == null) {
            if (other.etudiants != null)
                return false;
        } else if (!etudiants.equals(other.etudiants))
            return false;
        if (binomes == null) {
            if (other.binomes != null)
                return false;
        } else if (!binomes.equals(other.binomes))
            return false;
        if (projet == null) {
            if (other.projet != null)
                return false;
        } else if (!projet.equals(other.projet))
            return false;
        if (verf != other.verf)
            return false;
        if (vue == null) {
            if (other.vue != null)
                return false;
        } else if (!vue.equals(other.vue))
            return false;
        return true;
    }
}
