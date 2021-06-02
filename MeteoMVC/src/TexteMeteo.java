
import javax.swing.*;

public class TexteMeteo extends JScrollPane implements Vue{
 
	private Meteo modele;
	private JTextArea txtMeteo;
 
	public TexteMeteo() {
		super();	
		txtMeteo = new JTextArea(15, 40);
		txtMeteo.setEditable(false);
		this.setViewportView(txtMeteo);
	}

	// public Meteo getModele(){
	// 	return this.modele;
	// }

	public void notifierChangement(){
		this.afficherModele();
	}
	
	public void setModele(Modele m){
		this.modele = new Meteo(m);
		this.notifierChangement();
	}

	public void afficherModele () {
		txtMeteo.setText(this.modele.toString());
	}
}