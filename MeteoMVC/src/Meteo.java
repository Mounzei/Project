import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
 
public class Meteo implements Modele{
	private ArrayList<MeteoJour> liste;
	private ArrayList<Vue> vues;
 
	public Meteo() {
		this.liste = new ArrayList<MeteoJour>();
		this.vues = new ArrayList<Vue>();
	}
 
	public Meteo(String fichier) {
		this();
		this.charger(fichier);
	}

	public Meteo(Modele m){
		this.liste = m.getListes();
		this.vues = m.getVues();
	}

	public int nbJours() {
		return liste.size();
	}
 
	public int getTemp(int i) {
		return liste.get(i).getTemp();
	}
 
	public int getPrec(int i) {
		return liste.get(i).getPrec();
	}
 
	public long getJours1900(int i) {
		return liste.get(i).getJours1900();
	}
 
	public void ajouter(int j, int m, int a, int t, int p) {
		liste.add(new MeteoJour(j, m, a, t, p));
		this.notifierToutesVues();
	}

	public void enregistrerVue(Vue v){
		v.setModele(this);
		this.vues.add(v);
	}

	public ArrayList<MeteoJour> getListes(){
		return this.liste;
	}

	public ArrayList<Vue> getVues(){
		return this.vues;
	}

	public void notifierToutesVues(){
		int i = 0;
		while (i < this.vues.size()){
			// this.vues.get(i).setModele(this);
			this.vues.get(i).notifierChangement();
			i++;
		}
	} 
 
	public void charger(String nomFichier) {
		try {
			System.out.println(nomFichier);
			this.liste = new ArrayList<MeteoJour>();
 
			BufferedReader br = Files.newBufferedReader(Paths.get(nomFichier));
			String ligne;
 
			ligne = br.readLine();
			while (ligne != null) {
				this.liste.add(MeteoJour.parse(ligne));
				ligne = br.readLine();
			}
 
			br.close();
			this.notifierToutesVues();
		} catch (IOException e) {
			System.err.println(e);
		}
	}

	public void sauver(String chemin){
		try{
			PrintWriter sortie = new PrintWriter(new BufferedWriter(new FileWriter(chemin)));
			// BufferedReader br = new BufferedReader(fichierSave)
			// String ligne = nomFichierSave.readLine();
			sortie.print(this.versFichier());
			sortie.close();
		}catch (Exception e){
			System.err.println(e);
		}
	}
 
	public String toString() {
		String str = "";
		for (MeteoJour mj : liste) {
			str += mj.toString();
			str += "\n";
		}
		return str;
	}
 
	public String versFichier() {
		String str = "";
		for (MeteoJour mj : liste) {
			str += mj.versFichier();
			str += "\n";
		}
		return str;
	}

	public String[][] Datas(){
		String[][] datas = new String[this.getListes().size()][5];
		int i = 0;
        while (i < this.getListes().size()){
            int j = 0;
            String[] donnee = this.getListes().get(i).Datas();
            while (j < 5){
                datas[i][j] = donnee[j];
                j++;
            }
            i++;
        }
		return datas;
	}

	public int minTemp() {
		try {
			return Collections.min(liste, MeteoJour.ordreTemp).getTemp();
		} catch (java.util.NoSuchElementException e) {
			return Integer.MIN_VALUE;
		}
	}

	public int maxTemp() {
		try {
			return Collections.max(liste, MeteoJour.ordreTemp).getTemp();
		} catch (java.util.NoSuchElementException e) {
			return Integer.MIN_VALUE;
		}
	}

	public int minPrec() {
		try {
			return Collections.min(liste, MeteoJour.ordrePrec).getPrec();
		} catch (java.util.NoSuchElementException e) {
			return Integer.MIN_VALUE;
		}
	}

	public int maxPrec() {
		try {
			return Collections.max(liste, MeteoJour.ordrePrec).getPrec();
		} catch (java.util.NoSuchElementException e) {
			return Integer.MIN_VALUE;
		}
	}

	public int minJours1900() {
		try {
			int res = (int) Collections.min(liste, MeteoJour.ordreTemps).getJours1900();
			return res;
		} catch (java.util.NoSuchElementException e) {
			return Integer.MIN_VALUE;
		}
	}

	public int maxJours1900() {
		try {
			int res = (int) Collections.max(liste, MeteoJour.ordreTemps).getJours1900();
			return res;
		} catch (java.util.NoSuchElementException e) {
			return Integer.MIN_VALUE;
		}
	}

	public void triDate(){
		Collections.sort(liste,MeteoJour.ordreTemps);
	}

	// public void triTemp(){
	// 	Collections.sort(liste,MeteoJour.ordreTemp);
	// }

	// public void triPrec(){
	// 	Collections.sort(liste,MeteoJour.ordrePrec);
	// }

	public static void main(String[] args) {
		String s ="mouni/jour/";
		String[] s1 = s.split("/");
		int i = 0;
		while(i < s1.length){
			System.out.println(s1[i]);
			i++;
		}

	}

}