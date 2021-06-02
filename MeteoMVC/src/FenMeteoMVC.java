import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*; 

public class FenMeteoMVC extends JFrame implements Controleur{

	static final String MOIS[] = { "Janvier", "Février", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre" };
	static final Integer ANNEES[] = {2019, 2020, 2021, 2022}; 	
	private Meteo modele; 
	private JButton btnSauver;
	private JButton btnCharger;
	private JButton btnQuitter;
	private JButton[] btnJours;
	private JButton[] btnMois;
	private JComboBox<Integer> cbbAnnees;
	private JButton btnAjouter;
	private JTextField txtTemp;
	private JTextField txtPrec;
	private JLabel lblDate;
	private JTabbedPane tbpVues;			
	private JFrame f = new JFrame("Erreur Report!");
    
 
	public FenMeteoMVC(Meteo model) {
		super("Météo M2105");
		this.modele = model;
		this.initComposants();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initEcouteurs();;
		this.centrer(0.4);
		this.setVisible(true);
	}

	public void changerEtat(){
		String jm[] = lblDate.getText().split("/");
		String as = cbbAnnees.getSelectedItem().toString();
		String ts = txtTemp.getText().trim();
		String ps = txtPrec.getText().trim();
		int j,m,a,t,p;
		try{
		j = Integer.parseInt(jm[0]);
		int ii = 0;
		while (ii < MOIS.length){
			if(MOIS[ii].equals(jm[1])){
				break;
			}
			ii++;
		}
		m = ii+1;
		a = Integer.parseInt(as);
		t = Integer.parseInt(ts);
		p = Integer.parseInt(ps);				
		this.modele.ajouter(j, m, a, t, p);	
		}catch(Exception e){
			f.setSize(300, 200);
			if(jm[0].toString().equals("__")){
				f.add(new JTextArea("Désolé il manque le jour !!"));
			}else if(jm[1].toString().equals("__")){
				f.add(new JTextArea("Désolé il manque le mois !!"));
			}else if(as.toString().equals("")){
				f.add(new JTextArea("Désolé il manque l' année !!"));
			}else if(ts.toString().equals("")){
				f.add(new JTextArea("Désolé il manque la temperature !!"));
			}else if(ps.toString().equals("")){
				f.add(new JTextArea("Désolé il manque la precipitation !!"));
			}			
			f.setVisible(true);
		}	
	}
 
	private void initComposants() {
        this.add(this.buildPanelAjout(),BorderLayout.PAGE_START);
		this.add(this.buildPanelJours(),BorderLayout.LINE_START);
        this.add(this.buildPanelMeteo(),BorderLayout.CENTER);
		this.add(this.buildPanelMois(),BorderLayout.LINE_END); 
		this.add(this.buildPanelFichiers(),BorderLayout.PAGE_END);
	}

	/**
	 * Méthode ajouterPanneau
	 * @param title
	 * @param component
	 */

	public void ajouterPanneau(String title, JComponent component){
		Vue v = (Vue) component;
		JPanel ex = new JPanel();
		ex.setLayout(new CardLayout());
		ex.add(component);
		this.modele.enregistrerVue(v);
		// v.setModele(modele);
		this.tbpVues.add(title, component);
	}
 
	public JPanel buildPanelFichiers() {
		JPanel pan = new JPanel();
		btnCharger = new JButton("Charger");
		pan.add(btnCharger);
		btnSauver = new JButton("Sauver");
		pan.add(btnSauver); 
		btnQuitter = new JButton("Quitter");
		pan.add(btnQuitter);
		pan.setBorder(BorderFactory.createEtchedBorder()); 
		return pan;
	}

    public JPanel buildPanelAjout(){
        JPanel pan1 = new JPanel();
		lblDate = new JLabel("__/__/");
        pan1.add(lblDate);
		cbbAnnees = new JComboBox<Integer>(ANNEES);
		pan1.add(cbbAnnees);
        JLabel T = new JLabel("Température (C°)");
        pan1.add(T);
        txtTemp = new JTextField(3);
        pan1.add(txtTemp);
        JLabel P = new JLabel("Précipitations (mm)");
        pan1.add(P);
        txtPrec = new JTextField(3);
        pan1.add(txtPrec); 
		btnAjouter = new JButton("Ajouter");
		pan1.add(btnAjouter); 
		pan1.setBorder(BorderFactory.createEtchedBorder()); 
		return pan1;
    }

    public JPanel buildPanelMeteo() {
		JPanel pan2 = new JPanel();
		pan2.setLayout(new CardLayout());
		this.tbpVues = new JTabbedPane();
		pan2.add(tbpVues);
		pan2.setBorder(BorderFactory.createEtchedBorder()); 
		return pan2;
	}

	public JPanel buildPanelJours() {
		JPanel pan3 = new JPanel();
		pan3.setLayout(new GridLayout(-1, 3));
		btnJours = new JButton[31];
		int i = 0;
		while (i < btnJours.length){
			btnJours[i] = new JButton(""+(i+1));
			pan3.add(btnJours[i]);
			i++;
		}
		pan3.setBorder(BorderFactory.createEtchedBorder());
		return pan3;
	}

	public JPanel buildPanelMois(){
		JPanel pan4 = new JPanel();
		pan4.setLayout(new GridLayout(12,1));
		btnMois = new JButton[12];
		int i = 0;
		while (i < btnMois.length){
			String s = MOIS[i];
			btnMois[i] = new JButton(s);
			pan4.add(btnMois[i]);
			i++;
		}
		pan4.setBorder(BorderFactory.createEtchedBorder());
		return pan4;
	}
 
	public void centrer(double d) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int largeur = (int) (d * dim.width);
		int longueur = (int) (d * dim.height);
		this.setBounds((dim.width - largeur) / 2, (dim.height - longueur) / 2, largeur, longueur);
	}

	public void initEcouteurs() {
		this.btnCharger.addActionListener(new EcouteurBoutons(EcouteurBoutons.ZONE_AUTRE, EcouteurBoutons.CODE_CHARGER));
		this.btnSauver.addActionListener(new EcouteurBoutons(EcouteurBoutons.ZONE_AUTRE, EcouteurBoutons.CODE_SAUVER));
		this.btnQuitter.addActionListener(e -> {this.dispose();});
		this.btnAjouter.addActionListener(new EcouteurBoutons(EcouteurBoutons.ZONE_AUTRE, EcouteurBoutons.CODE_AJOUTER));
		int i = 0;
		while (i < this.btnJours.length){
			int x = i+1;
			this.btnJours[i].addActionListener(new EcouteurBoutons(EcouteurBoutons.ZONE_JOURS, x));
			i++;
		}
		i = 0;
		while (i < this.btnMois.length){
			int x = i+1;
			this.btnMois[i].addActionListener(new EcouteurBoutons(EcouteurBoutons.ZONE_MOIS, x));
			i++;
		}
	}

	class EcouteurBoutons implements ActionListener {

		static final int ZONE_JOURS = 1;
		static final int ZONE_MOIS = 2;
		static final int ZONE_AUTRE = 3;
		static final int CODE_AJOUTER = 1;
		static final int CODE_CHARGER = 2;
		static final int CODE_SAUVER = 3;
		static final int CODE_QUITTER = 4; 
		private int zone;
		private int code;
 
		public EcouteurBoutons(int z, int c) {
			this.zone = z;
			this.code = c;
		}
 
		public void actionPerformed(ActionEvent e) {
			switch (zone) {
			case ZONE_JOURS: {
				Integer c = (Integer) code;
				/*if (r.equals("__/__/")){
					lblDate.setText(c.toString());
					break;
				}else if (r.length() > 2){
					lblDate.setText(c.toString());
					break;
				}*/
				lblDate.setText(c.toString()+"/__/");
				break;
			}
			
			case ZONE_MOIS: 
			String r  = lblDate.getText();
			// Integer c1 = (Integer) code;
			int x = r.indexOf("/");
			String res = r.substring(0, x);
			lblDate.setText(res+"/"+MOIS[code-1]+"/");
			break;
		
			case ZONE_AUTRE:
				switch (code) {
				case CODE_AJOUTER:
					// try{
						changerEtat();
						modele.notifierToutesVues();
					// }catch(Exception m){
					// 	JFrame f = new JFrame("Erreur Report!");
					// 	f.add(new JTextArea("Veillez remplir tous les champs svp !!! "));
					// 	f.setSize(300, 200);
					// 	f.setVisible(true);
					// }
					break;
				case CODE_CHARGER:
					try{
						JFileChooser fc=new JFileChooser();    
						int i = fc.showOpenDialog(rootPane);    
						if(i==JFileChooser.APPROVE_OPTION){    
							File f = fc.getSelectedFile();    
							String filepathn = f.getPath();
							modele.charger(filepathn);
						}
					}catch(Exception a){
						f.add(new JTextArea("Problême lors du chargement."));
						f.setSize(300, 200);
						f.setVisible(true);
					}										
					break;
				case CODE_SAUVER:
					try{
						JFileChooser fs=new JFileChooser();    
						int k = fs.showOpenDialog(rootPane);    
						if(k == JFileChooser.APPROVE_OPTION){    
							File f = fs.getSelectedFile();   
							String filepathn = f.getPath();
							modele.sauver(filepathn);
						}
					}catch(Exception a){
						f.add(new JTextArea("Problême lors de la sauvegarde."));
						f.setSize(300, 200);
						f.setVisible(true);
					}					
					break;
				default:
					break;
				}
			default:
				break;
			}
		}
	}

	public static void main(String[] args) {
		Meteo modele = new Meteo("lib/meteo.txt");
		FenMeteoMVC fenetre = new FenMeteoMVC(modele);
		GraphiqueMeteoMVC graphiqueM = new GraphiqueMeteoMVC();
		TexteMeteo texteM = new TexteMeteo();
		TableMeteo tabM = new TableMeteo();
		fenetre.ajouterPanneau("Liste", texteM);
		fenetre.ajouterPanneau("Tableau", tabM);
		fenetre.ajouterPanneau("Graphique", graphiqueM);
		
	}

}