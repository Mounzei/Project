package com.cisse;
import java.util.*;

public class Binome {
    
    private int numero;
    private Projet projet;
    private ArrayList<Etudiant> etudiants;
    private double noteBinome, noteEtudiant1, noteEtudiant2;
    private String datePrevue, dateRemise;

    /**
     * Crée un binôme vide
     */
    public Binome(){
        this.numero = -1;
        projet = new Projet();
        this.etudiants = new ArrayList<Etudiant>();
        this.noteBinome = 0;
        this.noteEtudiant1 = 0;
        this.noteEtudiant2 = 0;
        this.datePrevue = "";
        this.dateRemise = "";
    }
    /**
     * Crée un binôme avec les différents paramétres fournis
     * @param numero
     * @param projet
     * @param e1
     * @param e2
     * @param notes
     * @param datePrevue
     * @param dateRemise
     */
    public Binome(int numero, Projet projet, Etudiant e1, Etudiant e2, double[] notes, String datePrevue, String dateRemise){
        this.numero = numero;
        this.projet = projet;
        etudiants = new ArrayList<Etudiant>();
        etudiants.add(e1);
        etudiants.add(e2);
        this.noteBinome = notes[0];
        this.noteEtudiant1 = notes[1];
        this.noteEtudiant2 = notes[2];
        this.datePrevue = datePrevue;
        this.dateRemise = dateRemise;
    }
    /**
     * Crée un binôme avec les différents paramétres fournis
     * @param numero
     * @param projet
     * @param etudiants
     * @param notes
     * @param datePrevue
     * @param dateRemise
     */
    public Binome(int numero, Projet projet, ArrayList<Etudiant> etudiants, double[] notes, String datePrevue, String dateRemise) {
        if(etudiants.size() > 2){
            System.out.println("Un binome ne peut être composé que de 2 étudiants");
            return;
        }
        this.numero = numero;
        this.projet = new Projet(projet);
        this.etudiants = new ArrayList<Etudiant>(etudiants);
        this.noteBinome = notes[0];
        this.noteEtudiant1 = notes[1];
        this.noteEtudiant2 = notes[2];
        this.datePrevue = datePrevue;
        this.dateRemise = dateRemise;
    }
    /**
     * Crée un binôme à partir d'un binôme fourni
     * @param binome
     */
    public Binome(Binome binome){
        this.numero = binome.getNumero();
        this.projet = new Projet(binome.getProjet());
        this.etudiants = new ArrayList<Etudiant>(binome.getEtudiants());
        this.noteBinome = binome.getNoteBinome();
        this.noteEtudiant1 = binome.getNoteEtudiant1();
        this.noteEtudiant2 = binome.getNoteEtudiant2();
        this.datePrevue = binome.getDatePrevue();
        this.dateRemise = binome.getDateRemise();
    }

    /**
     * @return le numéro du binôme
     */
    public int getNumero() {
        return this.numero;
    }
    /**
     * mettre à jour le numéro du binôme avec le numero fourni
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    /**
     * @return le projet du binôme
     */
    public Projet getProjet() {
        return this.projet;
    }
    /**
     * Méthode pour mettre à jour le projet du binôme
     * @param projet
     */
    public void setProjet(Projet projet) {
        this.projet = new Projet(projet);
    }
    /**
     * @return les étudiants du binôme
     */
    public ArrayList<Etudiant> getEtudiants() {
        return this.etudiants;
    }
    /**
     * Méthode pour mettre à jour les étudiants du binôme
     * @param etudiants
     */
    public void setEtudiants(ArrayList<Etudiant> etudiants) {
        this.etudiants = new ArrayList<Etudiant>(etudiants);
    }
    /**
     * @return la note du binôme
     */
    public double getNoteBinome() {
        return this.noteBinome;
    }
    /**
     * Méthode pour retourner la note du binôme
     * @param noteBinome
     */
    public void setNoteBinome(double noteBinome) {
        this.noteBinome = noteBinome;
    }
    /**
     * @return la note de l'étudiant 1
     */
    public double getNoteEtudiant1() {
        return this.noteEtudiant1;
    }
    /**
     * Méthode pour mettre à jour la note de l'étudiant 1
     * @param noteEtudiant1
     */
    public void setNoteEtudiant1(double noteEtudiant1) {
        this.noteEtudiant1 = noteEtudiant1;
    }
    /**
     * @return la note de l'étudiant 2
     */
    public double getNoteEtudiant2() {
        return this.noteEtudiant2;
    }
    /**
     * Méthode pour mettre à jour la note de l'étudiant 2
     * @param noteEtudiant2
     */
    public void setNoteEtudiant2(double noteEtudiant2) {
        this.noteEtudiant2 = noteEtudiant2;
    }
    /**
     * @return la date prévue pour la remise du projet
     */
    public String getDatePrevue() {
        return this.datePrevue;
    }
    /**
     * Méthode pour mettre à jour la date prévue pour la remise du projet
     * @param datePrevue
     */
    public void setDatePrevue(String datePrevue) {
        this.datePrevue = datePrevue;
    }
    /**
     * @return la date de remise du projet
     */
    public String getDateRemise() {
        return this.dateRemise;
    }
    /**
     * Méthode pour mettre à jour la date de remise du projet
     * @param dateRemise
     */
    public void setDateRemise(String dateRemise) {
        this.dateRemise = dateRemise;
    }

    /**
     * Méthode pour ajouter un étudiant au binôme
     * @param etudiant
     */
    public void ajouterEtudiant(Etudiant etudiant){
        if(this.etudiants.size() > 2){
            return;
        }
        this.etudiants.add(etudiant);
    }
    /**
     * Mettre pour que l'utilisateur puisse remplir les notes
     */
    public void remplirNotes(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Quelle est la note du groupe?");
        this.noteBinome = scan.nextDouble();
        System.out.println("Quelle est la note de "+this.etudiants.get(0)+"?");
        this.noteEtudiant1 = scan.nextDouble();
        System.out.println("Quelle est la note de "+this.etudiants.get(1)+"?");
        this.noteEtudiant2 = scan.nextDouble();
    }
    /**
     * @return le coefficient qui se trouve par rapport à la date de remise du projet
     */
    private double pourcentageParRapportAuDelai(){
        String[] dP = this.datePrevue.split("/");
        String[] dR = this.dateRemise.split("/");
        int[] vDP = new int[3];
        int[] vDR = new int[3];
        int i = 0;
        while (i < 3){
            vDP[i] = Integer.parseInt(dP[i]);
            vDR[i] = Integer.parseInt(dR[i]);
            i++;
        }
        if(vDP[2] == vDR[2]){
            if(vDP[1] == vDR[1]){
                if(vDR[0]-vDP[0] <= 7 & vDR[0]-vDP[0] > 0){
                    switch (vDR[0]-vDP[0]) {
                        case 7:
                            return 0.60;
                        case 6:
                            return 0.65;
                        case 5:
                            return 0.70;
                        case 4:
                            return 0.75;
                        case 3:
                            return 0.80;
                        case 2:
                            return 0.85;
                        case 1:
                            return 0.90;
                    }
                }else if(vDR[0]-vDP[0] <= 0){
                    return 1;
                } 
            }
        }
        return 0;
    }
    /**
     * @return la note finale de l'étudiant 1
     */
    public double NoteFinalEtudiant1(){
        return (this.noteBinome * 0.4 + this.noteEtudiant1 * 0.6) * this.pourcentageParRapportAuDelai();
    }
    /**
     * @return la note finale de l'étudiant 2
     */
    public double NoteFinalEtudiant2(){
        return (this.noteBinome * 0.4 + this.noteEtudiant2 * 0.6) * this.pourcentageParRapportAuDelai();        
    }
    /**
     * initialise un binôme avec les données founies par l'utilisateur 
     */
    public void init(){
        Projet p = new Projet();
        Etudiant e1 = new Etudiant();
        Etudiant e2 = new Etudiant();
        Scanner scan = new Scanner(System.in);
        System.out.println("Numéro du binôme ?");
        this.setNumero(scan.nextInt());
        System.out.println("Projet du binôme ?");
        p.init();
        this.setProjet(p);
        System.out.println("Premier etudiant du binôme ?");
        e1.init();
        this.ajouterEtudiant(e1);
        System.out.println("Deuxieme etudiant du binôme ?");
        e2.init();
        this.ajouterEtudiant(e2);
        System.out.println("Note du binôme ?");
        this.setNoteBinome(scan.nextDouble());
        System.out.println("Note premier etudiant du binôme ?");
        this.setNoteEtudiant1(scan.nextDouble());
        System.out.println("Note deuxiéme etudiant du binôme ?");
        this.setNoteEtudiant2(scan.nextDouble());
        System.out.println("Date de dépot prévue du projet ?");  
        this.setDatePrevue(scan.nextLine());
        System.out.println("Date de remise du projet ?");  
        this.setDateRemise(scan.nextLine());
    }
    /**
     * Méthode pour enregistrer un binôme en tant que chaine de caractére
     * @return un binome en chaine de caractére
     */
    public String versFichier() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.numero);
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(0).getNumeroEtudiant());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(0).getNom());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(0).getPrenom());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(1).getNumeroEtudiant());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(1).getNom());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(1).getPrenom());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(0).getFormation().getNumeroFormation());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(0).getFormation().getNom());
		stringBuilder.append(" ");
		stringBuilder.append(this.etudiants.get(0).getFormation().getPromotion());
		stringBuilder.append(" ");
		stringBuilder.append(this.noteBinome);
		stringBuilder.append(" ");
		stringBuilder.append(this.noteEtudiant1);
		stringBuilder.append(" ");
		stringBuilder.append(this.noteEtudiant2);
		stringBuilder.append(" ");
		stringBuilder.append(this.datePrevue);
		stringBuilder.append(" ");
		stringBuilder.append(this.dateRemise);
		stringBuilder.append(" ");
		stringBuilder.append(this.projet.getNumeroDeProjet());
		stringBuilder.append(" ");
		stringBuilder.append(this.projet.getNomDeMatiere());
		stringBuilder.append(" ");
		stringBuilder.append(this.projet.getSujet());
		return (stringBuilder.toString());
	}
	/**
     * Méthode pour créer un binôme à partir d'une chaîne de caractére
	 * @param str
	 * @return un binôme
	 */
	public static Binome parse(String str) {
		Binome binome = new Binome();
		Scanner scan = new Scanner(str);
		scan.useDelimiter(" ");
        binome.setNumero(scan.nextInt()); 
        int num1 = scan.nextInt();
        String nom1 = scan.next();
        String prenom1 = scan.next(); 
        int num2 = scan.nextInt();
        String nom2 = scan.next();
        String prenom2 = scan.next();
        int numF = scan.nextInt();
        String nomF = scan.next();
        String prom = scan.next();
        double noteB = Double.parseDouble(scan.next());
        double note1 = Double.parseDouble(scan.next());
        double note2 = Double.parseDouble(scan.next());
        String dateP = scan.next();
        String dateR = scan.next();
        String numP = scan.next();
        String nomM = scan.next();
        String sujet = scan.next();
        Formation f = new Formation(numF, nomF, prom);
        Etudiant e1 = new Etudiant(num1, nom1, prenom1, f);
        Etudiant e2 = new Etudiant(num2, nom2, prenom2, f); 
        binome.ajouterEtudiant(e1);
        binome.ajouterEtudiant(e2);
        Projet p = new Projet(numP, nomM, sujet);
        binome.setProjet(p);
        binome.setNoteBinome(noteB);
        binome.setNoteEtudiant1(note1);
        binome.setNoteEtudiant2(note2);
        binome.setDatePrevue(dateP);
        binome.setDateRemise(dateR);
		return binome;
	}
    /**
     * @return un tableau qui servira à contenir les données qu'affichera l'application
     */
    public String[] donnees(){
        // String[] donneesBof = this.versFichier().split(" ");
        // Binome b = parse(this.versFichier());
        String[] donnees = new String[9];
        donnees[0] = this.getNumero() + "";
        donnees[1] = this.getEtudiants().get(0).getFormation().getNom();
        donnees[2] = this.getProjet().getNumeroDeProjet();
        donnees[3] = this.getDatePrevue();
        donnees[4] = this.getDateRemise();
        donnees[5] = this.getEtudiants().get(0).getNumeroEtudiant() + "";
        donnees[6] = this.NoteFinalEtudiant1() + "";
        donnees[7] = this.getEtudiants().get(1).getNumeroEtudiant() + "";
        donnees[8] = this.NoteFinalEtudiant2() + "";
        return donnees;
    }

    @Override
    public String toString() {
        return "Binome [numero=" + this.numero + ", projet=" + this.projet + ", etudiants=" + this.etudiants + ", noteBinome="
                + this.noteBinome + ", noteEtudiant1=" + this.NoteFinalEtudiant1() + ", noteEtudiant2=" + this.NoteFinalEtudiant2() 
                + ", datePrevue=" + this.datePrevue + ", dateRemise=" + this.dateRemise + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numero;
        result = prime * result + ((projet == null) ? 0 : projet.hashCode());
        result = prime * result + ((etudiants == null) ? 0 : etudiants.hashCode());
        long temp;
        temp = Double.doubleToLongBits(noteBinome);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(noteEtudiant1);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(noteEtudiant2);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((datePrevue == null) ? 0 : datePrevue.hashCode());
        result = prime * result + ((dateRemise == null) ? 0 : dateRemise.hashCode());
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
        Binome other = (Binome) obj;
        if (numero != other.numero)
            return false;
        if (projet == null) {
            if (other.projet != null)
                return false;
        } else if (!projet.equals(other.projet))
            return false;
        if (etudiants == null) {
            if (other.etudiants != null)
                return false;
        } else if (!etudiants.equals(other.etudiants))
            return false;
        if (Double.doubleToLongBits(noteBinome) != Double.doubleToLongBits(other.noteBinome))
            return false;
        if (Double.doubleToLongBits(noteEtudiant1) != Double.doubleToLongBits(other.noteEtudiant1))
            return false;
        if (Double.doubleToLongBits(noteEtudiant2) != Double.doubleToLongBits(other.noteEtudiant2))
            return false;
        if (datePrevue == null) {
            if (other.datePrevue != null)
                return false;
        } else if (!datePrevue.equals(other.datePrevue))
            return false;
        if (dateRemise == null) {
            if (other.dateRemise != null)
                return false;
        } else if (!dateRemise.equals(other.dateRemise))
            return false;
        return true;
    }
}
