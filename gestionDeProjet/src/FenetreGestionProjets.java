package gestionDeProjet.src;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class FenetreGestionProjets extends JFrame {
    private Classe classe;
	private JButton btnSauver;
	private JButton btnCharger;
	private JButton btnQuitter;
	private JButton btnAjouter;
	private JLabel[] lblFields;
	private JTextField[] txtFields;
	private JTabbedPane tbpVues;
	private JFrame f = new JFrame("Erreur Report!");

	/**
	 * Crée l'application
	 * @param classe
	 */
	public FenetreGestionProjets(Classe classe) {
		super("Gestion de projet");
		this.classe = classe;
		this.initComposants();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.initEcouteurs();
		this.centrer(0.4);
		this.setVisible(true);
	}

	/**
	 * initialise les différents composants de l'application
	 */
	private void initComposants() {
        this.add(this.buildPanelAjout(),BorderLayout.PAGE_START);
        this.add(this.buildPanelClasse(),BorderLayout.CENTER);
		this.add(this.buildPanelFichiers(),BorderLayout.PAGE_END);
	}
	/**
	 * Gére l'ajout des différents binôme dans une classe dans l'application
	 */
	public void changerEtat(){
		try {
			int num1 = Integer.parseInt(txtFields[0].getText()); 
			String nom1 = txtFields[1].getText(); 
			String prenom1 = txtFields[2].getText(); 
			double note1 = Double.parseDouble(txtFields[3].getText()); 
			int num2 = Integer.parseInt(txtFields[4].getText()); 
			String nom2 = txtFields[5].getText(); 
			String prenom2 = txtFields[6].getText(); 
			double note2 = Double.parseDouble(txtFields[7].getText()); 
			int numF = Integer.parseInt(txtFields[8].getText()); 
			String nomF = txtFields[9].getText(); 
			String prom = txtFields[10].getText(); 
			int numB = Integer.parseInt(txtFields[11].getText()); 
			double noteB = Double.parseDouble(txtFields[12].getText()); 
			String dateP = txtFields[13].getText(); 
			String dateR = txtFields[14].getText(); 
			String numP = txtFields[15].getText(); 
			String nomM = txtFields[16].getText(); 
			String sujet = txtFields[17].getText();
			this.classe.ajouterBinome(num1, nom1, prenom1, note1, num2, nom2, prenom2, note2, numF, nomF, prom, numB, noteB, dateP, dateR, numP, nomM, sujet);
			if(this.classe.getLien() != null){
				this.classe.sauver(this.classe.getLien());
			}
			// System.out.println(classe);
		} catch (Exception e) {
			f.setSize(300, 200);
			f.add(new JTextArea("Veillez remplir tous les champs"));
			f.add(new JTextArea(e.toString()));
			f.setVisible(true);
		}
	}
	/**
	 * Méthode pour ajouter un composant à l'application
	 * @param title
	 * @param component
	 */
	public void ajouterPanneau(String title, JComponent component){
		Vue v = (Vue) component;
		JPanel ex = new JPanel();
		ex.setLayout(new CardLayout());
		ex.add(component);
		this.classe.enregistrerVue(v);
		// v.setModele(modele);
		this.tbpVues.add(title, ex);
	}
	/**
	 * @return un composant de l'application
	 */
	public JPanel buildPanelFichiers() {
		JPanel pan = new JPanel();
		this.btnCharger = new JButton("Charger");
		pan.add(btnCharger);
		this.btnSauver = new JButton("Sauvegarder");
		pan.add(btnSauver); 
		this.btnQuitter = new JButton("Quitter");
		pan.add(btnQuitter);
		pan.setBorder(BorderFactory.createEtchedBorder()); 
		return pan;
	}
    /**
     * @return un composant de l'application
     */
    public JPanel buildPanelAjout(){
        JPanel pan1 = new JPanel();
        pan1.setMinimumSize(new Dimension(360, 150));
        pan1.setPreferredSize(new Dimension(360, 150));
        pan1.setMaximumSize(new Dimension(360, 150));
		this.lblFields = new JLabel[18];
		this.txtFields = new JTextField[18];
		this.lblFields[0] = new JLabel("Numéro étudiant 1");
		pan1.add(this.lblFields[0]);
		this.txtFields[0] = new JTextField(10);	
		pan1.add(this.txtFields[0]);
		this.lblFields[1] = new JLabel("Nom étudiant 1");
		pan1.add(this.lblFields[1]);
		this.txtFields[1] = new JTextField(15);	
		pan1.add(this.txtFields[1]);
		this.lblFields[2] = new JLabel("Prénom étudiant 1");
		pan1.add(this.lblFields[2]);
		this.txtFields[2] = new JTextField(15);	
		pan1.add(this.txtFields[2]);
		this.lblFields[3] = new JLabel("Note étudiant 1");
		pan1.add(this.lblFields[3]);
		this.txtFields[3] = new JTextField(3);	
		pan1.add(this.txtFields[3]);
		this.lblFields[4] = new JLabel("Numéro étudiant 2");
		pan1.add(this.lblFields[4]);
		this.txtFields[4] = new JTextField(10);	
		pan1.add(this.txtFields[4]);
		this.lblFields[5] = new JLabel("Nom étudiant 2");
		pan1.add(this.lblFields[5]);
		this.txtFields[5] = new JTextField(15);	
		pan1.add(this.txtFields[5]);
		this.lblFields[6] = new JLabel("Prénom étudiant 2");
		pan1.add(this.lblFields[6]);
		this.txtFields[6] = new JTextField(15);	
		pan1.add(this.txtFields[6]);
		this.lblFields[7] = new JLabel("Note étudiant 2");
		pan1.add(this.lblFields[7]);
		this.txtFields[7] = new JTextField(3);	
		pan1.add(this.txtFields[7]);
		this.lblFields[8] = new JLabel("Numero formation du binôme");
		pan1.add(this.lblFields[8]);
		this.txtFields[8] = new JTextField(10);	
		pan1.add(this.txtFields[8]);
		this.lblFields[9] = new JLabel("Nom formation du binôme");
		pan1.add(this.lblFields[9]);
		this.txtFields[9] = new JTextField(15);	
		pan1.add(this.txtFields[9]);
		this.lblFields[10] = new JLabel("Promotion de la formation du binôme");
		pan1.add(this.lblFields[10]);
		this.txtFields[10] = new JTextField(15);	
		pan1.add(this.txtFields[10]);
		this.lblFields[11] = new JLabel("Numero du binôme");
		pan1.add(this.lblFields[11]);
		this.txtFields[11] = new JTextField(5);	
		pan1.add(this.txtFields[11]);
		this.lblFields[12] = new JLabel("Note du binôme");
		pan1.add(this.lblFields[12]);
		this.txtFields[12] = new JTextField(3);	
		pan1.add(this.txtFields[12]);
		this.lblFields[13] = new JLabel("Date prévue de rendu du projet");
		pan1.add(this.lblFields[13]);
		this.txtFields[13] = new JTextField(10);	
		pan1.add(this.txtFields[13]);
		this.lblFields[14] = new JLabel("Date de remise du projet");
		pan1.add(this.lblFields[14]);
		this.txtFields[14] = new JTextField(10);	
		pan1.add(this.txtFields[14]);
		this.lblFields[15] = new JLabel("Numero du projet");
		pan1.add(this.lblFields[15]);
		this.txtFields[15] = new JTextField(15);	
		pan1.add(this.txtFields[15]);
		this.lblFields[16] = new JLabel("Nom de la matière du projet");
		pan1.add(this.lblFields[16]);
		this.txtFields[16] = new JTextField(15);	
		pan1.add(this.txtFields[16]);
		this.lblFields[17] = new JLabel("Sujet du projet");
		pan1.add(this.lblFields[17]);
		this.txtFields[17] = new JTextField(100);	
		pan1.add(this.txtFields[17]);
		this.btnAjouter = new JButton("Ajouter");
		pan1.add(btnAjouter); 
		pan1.setBorder(BorderFactory.createEtchedBorder()); 
		return pan1;
    }
	/**
	 * @return un composant de l'application
	 */
	public JPanel buildPanelClasse() {
		JPanel pan2 = new JPanel();
		pan2.setLayout(new CardLayout());
		this.tbpVues = new JTabbedPane();
		pan2.add(tbpVues);
		pan2.setBorder(BorderFactory.createEtchedBorder()); 
		return pan2;
	}
	/**
	 * Centre l'application au démarrage par par rapport à votre écran 
	 * @param d
	 */
	public void centrer(double d) {
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int largeur = (int) (d * dim.width);
		int longueur = (int) (d * dim.height);
		this.setBounds((dim.width - largeur) / 2, (dim.height - longueur) / 2, largeur, longueur);
	}
	/**
	 * Méthode pour déléguer des fonctions au bouttons
	 */
	public void initEcouteurs() {
		this.btnCharger.addActionListener(new EcouteurBoutons(EcouteurBoutons.CODE_CHARGER));
		this.btnSauver.addActionListener(new EcouteurBoutons(EcouteurBoutons.CODE_SAUVER));
		this.btnQuitter.addActionListener(e -> {this.dispose();});
		this.btnAjouter.addActionListener(new EcouteurBoutons(EcouteurBoutons.CODE_AJOUTER));
	}
	
	class EcouteurBoutons implements ActionListener {
		static final int CODE_AJOUTER = 1;
		static final int CODE_CHARGER = 2;
		static final int CODE_SAUVER = 3;
		private int code;
		
		/**
		 * Constructeur de la gération des bouttons
		 * @param code
		 */
		public EcouteurBoutons(int code) {
			this.code = code;
		}
		/**
		 * Méthode pour gérer les différents bouttons
		 * @param e
		 */
		public void actionPerformed(ActionEvent e) {
			switch (code) {
			case CODE_AJOUTER:
				// try{
					changerEtat();
					classe.notifierVue();
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
						classe.charger(filepathn);
						// classe.notifierVue();
						// System.out.println(classe);
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
						classe.sauver(filepathn);
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
		}
	}
}
