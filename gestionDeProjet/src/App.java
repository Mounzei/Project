package gestionDeProjet.src;

public class App {
    /**
     * L'application de gestion de projets
     * @param args
     */
    public static void main(String[] args) {
        // ArrayList<Etudiant> e = new ArrayList<Etudiant>();
        // ArrayList<Binome> b = new ArrayList<Binome>();
        // Formation f = new Formation(574839, "MIAGE", "Initial");
        // Etudiant e1 = new Etudiant(245869, "Cissé", "Mounirou", f);
        // Etudiant e2 = new Etudiant(245864, "Bah", "Abdou", f);
        // Etudiant e3 = new Etudiant(245865, "Bahou", "Abdou", f);
        // Etudiant e4 = new Etudiant(245866, "Baha", "Abdou", f);
        // Etudiant e5 = new Etudiant(245867, "Baha", "Abdou", f);
        // double[] notes1 = {16,19,15};
        // double[] notes2 = {12,15,12};
        // Projet p = new Projet("MIAGE6JAVA", "JAVA", "yfyegdycdcvzvdtydvzvvcgyvdhce");
        // Binome b1 = new Binome(1, p, e1, e2, notes1, "15/05/2023", "16/05/2023");
        // Binome b2 = new Binome(1, p, e3, e4, notes2, "15/05/2023", "12/05/2023");
        // e.add(e1);e.add(e2);e.add(e3);e.add(e4);b.add(b1);b.add(b2);
        // Classe c = new Classe(e, b, p);
        // c.sauver("C:/Users/mouni/Downloads/Test/test.txt");
        // Classe c = new Classe();
        // c.charger("C:/Users/mouni/Downloads/Test/test.txt");
        // System.out.println(c);
        Classe c = new Classe();
        // c.charger("C:/Users/mouni/Downloads/Test/test.txt");
        FenetreGestionProjets fgp = new FenetreGestionProjets(c);
        FenetreBinomes fb = new FenetreBinomes();
        fgp.ajouterPanneau("Binômes",fb);
    }
}
