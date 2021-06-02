import javax.swing.JPanel;
import java.awt.*;
 
public class GraphiqueMeteoMVC extends JPanel implements Vue{
 
	private Meteo modele;
 
	GraphiqueMeteoMVC() {
		super();
	}

	public int[] absJours1900() {
		int[] tab = new int[this.modele.nbJours()];
 
		long tempsMin = this.modele.minJours1900();
		long tempsMax = this.modele.maxJours1900();
 
		for (int i = 0; i < tab.length; i++) {
			long temps = this.modele.getJours1900(i);
			tab[i] = (int) (this.getWidth() * (temps - tempsMin) / (tempsMax - tempsMin));
		}
		return tab;
	}

	public int[] ordTemp() {
		int[] tab = new int[this.modele.nbJours()];
 
		long tempMin = this.modele.minTemp();
		long tempMax = this.modele.maxTemp();
 
		for (int i = 0; i < tab.length; i++) {
			long temp = this.modele.getTemp(i);
			tab[i] = (int) (this.getHeight() * (temp - tempMin) / (tempMax - tempMin));
		}
		return tab;
	}

	public int[] ordPrec() {
		int[] tab = new int[this.modele.nbJours()];
 
		long precMin = this.modele.minPrec();
		long precMax = this.modele.maxPrec();
 
		for (int i = 0; i < tab.length; i++) {
			long prec = this.modele.getPrec(i);
			tab[i] = (int) (this.getHeight() * (prec - precMin) / (precMax - precMin));
		}
		return tab;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
 
		this.modele.triDate();
 
		int[] absJours = this.absJours1900();
		int[] ordTemp = this.ordTemp();
		int[] ordPrec = this.ordPrec();
 
		tracerCourbe(absJours, ordTemp, Color.RED, g);
		tracerCourbe(absJours, ordPrec, Color.BLUE, g);
	}
	
	public void tracerCourbe(int[] a, int[] o, Color c, Graphics g){
		g.setColor(c);
		// g.drawLine(a[0], o[0], a[1], o[1]);
		int i = 1;
		while (i < o.length){
			int j = i-1;
			g.drawLine(a[j], o[j], a[i], o[i]);
			i++;
			if (i == o.length-1 ){
				break;
			}
		}
	}

	// public Meteo getthis.modele(){
	// 	return this.this.modele;
	// }

	public void setModele(Modele m){
		this.modele = new Meteo(m);
		this.notifierChangement();
	}

	public void notifierChangement(){
		this.repaint();
	}
}