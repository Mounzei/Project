package gestionDeProjet.src;
import javax.swing.*;

public class FenetreBinomes extends JScrollPane implements Vue{
    private final String[] colonnes = {"Numero Binôme", "Formation Binôme", "Projet Binôme", "Date prevue projet Binôme", "Date remise projet Binôme", "id etudiant 1 Binôme", "note finale etudiant 1 Binôme", "id etudiant 2 Binôme", "note finale etudiant 2 Binôme"};
    private Classe classe;
    private JTable table;

    /**
     * Crée une fenêtre pour les inômes
     */
    public FenetreBinomes() {
        super();
	}
    
    public void setClasse(Classe c){;
        this.classe = new Classe(c);
        this.notifierChangement();
    }

    public void notifierChangement(){
        this.table = new JTable(this.classe.donnees(),this.colonnes);
        this.setViewportView(table);
    }
}
