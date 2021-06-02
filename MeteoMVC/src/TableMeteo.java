import javax.swing.*;
// import java.util.ArrayList;

public class TableMeteo extends JScrollPane implements Vue{

    private final String[] column = {"Température (C°)","Précipitation (mm)","Jour","Mois","Années"};
    private Meteo modele;
	// private ArrayList<String> donnees;
	private JTable tabMeteo;

    // private void construtorDatas(){
    //     this.donnees = new ArrayList<String>();
    //     int i = 0;
	// 	while (i < this.modele.getListes().size()){
	// 		donnees.add(this.modele.getListes().get(i).versFichier());
	// 		i++;
	// 	}
    // }

    // private String[][] Datas(){
    //     String[][] datas = new String[this.modele.getListes().size()][5];
    //     int i = 0;
    //     while (i < this.donnees.size()){
    //         int j = 0;
    //         String[] donnee = this.donnees.get(i).split(" ");
    //         while (j < 5){
    //             datas[i][j] = donnee[j];
    //             j++;
    //         }
    //         i++;
    //     }
    //     return datas;
    // }
 
	public TableMeteo() {
        super();
        // String[][] data = {{"B","C","3","1","z"}};
		// this.tabMeteo = new JTable(data,column);
	}
    
    public void setModele(Modele m){;
        this.modele = new Meteo(m);
        this.notifierChangement();
    }

    public void notifierChangement(){
        // this.construtorDatas();
        this.tabMeteo = new JTable(this.modele.Datas(),this.column);
        this.setViewportView(tabMeteo);
    }
}
