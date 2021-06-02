import java.util.ArrayList;

public interface Modele {
    public void enregistrerVue(Vue v);

    // MODIFICATEURS DE CHANGEMENTS D'ETAT : SET, ADD etc
    public void ajouter(int j, int m, int a, int t, int p);
    public void notifierToutesVues();
	// ACCESSEURS DE REQUETES D'ETAT : GET etc
    public ArrayList<MeteoJour> getListes();
    public ArrayList<Vue> getVues();
}
