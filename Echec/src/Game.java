/**
 * Game
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.Serializable;

public class Game implements Serializable{

    private int[][] chest = 
    {{1,2,3,4,5,6,7,8},
    {9,10,11,12,13,14,15,16},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {0,0,0,0,0,0,0,0},
    {17,18,19,20,21,22,23,24},
    {25,26,27,28,29,30,31,32}};

    private Gameur gameur1,gameur2;

    public Game(){
        this.gameur1 = new Gameur();
        this.gameur2 = new Gameur();
    }

    public Game(Object gO){
        Game g = (Game) gO;
        this.gameur1 = new Gameur(g.getGameur1());
        this.gameur2 = new Gameur(g.getGameur2());
    }

    public Game(Gameur g1,Gameur g2){
        this.gameur1 = g1;
        this.gameur2 = g2;
    }

    public Gameur getGameur1(){
        return this.gameur1;
    }
    public Gameur getGameur2(){
        return this.gameur2;
    }
    public int[][] getChest(){
        return this.chest;
    }

    public static String reglesDeJeu(){
        String regle = "Bonjour, bienvenue sur notre jeu de jeu d'échec.\nSi vous voulez profiter au max du jeu voici quelques régles à suivre.";
        String yep = "\n1. Il faut que les deux joueurs aient déja joué pour que la sauvegarde du jeu soit prix en compte.";
        return regle+yep;
    }

    private boolean check(int[] tab, int val) {
        boolean b = false;    
        for(int i : tab){
            if(i == val){
                b = true;
                break;
            }
        }
        return b;
    }

    public ArrayList<Integer> init(){
        int i = 0;
        ArrayList<Integer> chest_list = new ArrayList<Integer>();
        int[] p_n = {9,10,11,12,13,14,15,16};
        int[] p_b = {17,18,19,20,21,22,23,24};
        System.out.print("    a    b    c    d    e    f    g    h"+"\n  -----------------------------------------\n");
        while (i < chest.length){
            System.out.print(8-i + " | ");
            int j = 0;
            while (j < 8){
                if (chest[i][j] == 1 || chest[i][j] == 8){
                System.out.print("\u265C"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 2 || chest[i][j] == 7){
                System.out.print("\u265E"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 3 || chest[i][j] == 6){
                System.out.print("\u265D"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 4){
                System.out.print("\u265B"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 5){
                System.out.print("\u265A"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 28){
                System.out.print("\u2655"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 29){
                System.out.print("\u2654"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 27 || chest[i][j] == 30){
                System.out.print("\u2657"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 26 || chest[i][j] == 31){
                System.out.print("\u2658"+"  | ");
                chest_list.add(chest[i][j]);
                }else if (chest[i][j] == 25 || chest[i][j] == 32){
                System.out.print("\u2656"+"  | ");
                chest_list.add(chest[i][j]);
                }else if(chest[i][j] == 0) {
                    if(i %2 == 0){
						if(j %2 == 0){ System.out.print("\u25FB  | ");
						}			
						if(j %2 == 1){ System.out.print("\u25FC  | ");
						}		
					}else{						
						if(j %2 == 0){ System.out.print("\u25FC  | ");
					    }			
					    if(j %2 == 1){ System.out.print("\u25FB  | ");
					    }
                    }
                chest_list.add(chest[i][j]);
                }else if(check(p_n, chest[i][j])){
                    System.out.print("\u265F"+"  | "); 
                    chest_list.add(chest[i][j]);
                }else if(check(p_b, chest[i][j])){
                    System.out.print("\u2659"+"  | ");
                    chest_list.add(chest[i][j]);
                }
                j++;                          
            }
            System.out.print("\n"+"  -----------------------------------------\n");
            i+=1;  
        }
        return chest_list;
    }

    public void setChest(int[][] ex){
        this.chest = null;
        this.chest = ex;
    }

    private void maj(ArrayList<Integer> ex){
        int i = 0;
        int k = 0;
        while (i < 8){            
            int j = 0;
            while (j < 8){
                chest[i][j] = ex.get(k);
                k++;
                j++;
            }
            i++;
        }
    }

    public void save(ArrayList<Integer> ex, Game sauvegarde){
            try {
                FileOutputStream fileOut = new FileOutputStream("lib/Sauvegardes/sauvegarde partie entre "+this.gameur1.getPseudo()+" et "+this.gameur2.getPseudo());
                FileOutputStream donnesOut = new FileOutputStream("lib/Donnees/donnees partie entre "+this.gameur1.getPseudo()+" et "+this.gameur2.getPseudo());
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                ObjectOutputStream dOut = new ObjectOutputStream(donnesOut);
                out.writeObject(ex);
                dOut.writeObject(sauvegarde);
                out.close(); dOut.close();
                // fileOut.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void load(String filepath, String donnees){
            ArrayList<Integer> arraylist = new ArrayList<Integer>();
            Game game = new Game();
            try {
                FileInputStream fileIn = new FileInputStream("C:/Users/Mounz/Desktop/Echec/lib/Sauvegardes/"+filepath);
                FileInputStream donneesIn = new FileInputStream("C:/Users/Mounz/Desktop/Echec/lib/Donnees/"+donnees);
                ObjectInputStream ois = new ObjectInputStream(fileIn);
                ObjectInputStream dis = new ObjectInputStream(donneesIn);
                arraylist = (ArrayList<Integer>) ois.readObject();
                game = new Game(dis.readObject());
                ois.close();
                dis.close();
                fileIn.close();
            } catch (FileNotFoundException e) {
                // e.printStackTrace();
                System.out.println("Aucun fichier trouvé !!! ");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if ( (this.gameur1.getPseudo().equals(game.getGameur1().getPseudo()) && this.gameur1.getPieces().getColor() == game.getGameur1().getPieces().getColor() && this.gameur2.getPseudo().equals(game.getGameur2().getPseudo()) && this.gameur2.getPieces().getColor() == game.getGameur2().getPieces().getColor()) || (this.gameur1.getPseudo().equals("") && this.gameur2.getPseudo().equals(""))){
                this.gameur1 = new Gameur(game.getGameur1());
                this.gameur2 = new Gameur(game.getGameur2());
                this.maj(arraylist);
            }else{
                System.out.println("Error Error Error !!");
            }
        }

    public void game(){
        Scanner scan = new Scanner(System.in);
        System.out.print(this.gameur1.getPseudo()+", choisissez la couleur blanche (b) et la noir (n) :");
        String choix = scan.nextLine();
        // while ( !choix.toLowerCase().trim().equals("b") || !choix.toLowerCase().trim().equals("n")){
        //     choix;
        // }
        MesPieces p1 = new MesPieces(true);
        MesPieces p2 = new MesPieces(false);
        if (choix.toLowerCase().trim().equals("b")){
            this.gameur1.setMesPieces(p1);
            this.gameur2.setMesPieces(p2);
        }else{            
            this.gameur2.setMesPieces(p1);
            this.gameur1.setMesPieces(p2);
        }
        System.out.print("Avez vous une sauvegarde à charger? (Y/N): ");
        String r = scan.nextLine();
        if (r.toLowerCase().trim().equals("y")){
            try{
                this.load("sauvegarde partie entre "+gameur1.getPseudo()+" et "+gameur2.getPseudo(), "donnees partie entre "+gameur1.getPseudo()+" et "+gameur2.getPseudo());
            }catch(NoSuchElementException e){
                System.out.println("Pas de données de sauvegarde trouvé.");
            }
        }
        this.gameur1.getPieces().init();
        this.gameur2.getPieces().init();
        this.init();
        while (this.gameur1.getPiecesSup().contains(5) == false || this.gameur2.getPiecesSup().contains(29) == false){
            System.out.println("        "+gameur1.getPseudo());
            this.gameur1.attack(this.chest);
            ArrayList<Integer> sauvegarde = this.init();
            // this.save(sauvegarde, this);
            if (this.gameur1.getPiecesSup().contains(this.gameur2.getPieces().getKing().getId())){
                System.out.println("Bravo "+this.gameur1.getPseudo());
                File file = new File("lib/Sauvegardes/sauvegarde partie entre "+this.gameur1.getPseudo()+" et "+this.gameur2.getPseudo());
                File file1 = new File("lib/Donnees/donnees partie entre "+this.gameur1.getPseudo()+" et "+this.gameur2.getPseudo());
                file.delete();
                file1.delete();
                break;
            }
            System.out.println("        "+gameur2.getPseudo());
            gameur2.attack(this.chest);
            sauvegarde = this.init();
            // this.save(sauvegarde, this);
            if (this.gameur2.getPiecesSup().contains(this.gameur1.getPieces().getKing().getId())){
                System.out.println("Bravo "+this.gameur2.getPseudo());
                File file = new File("lib/Sauvegardes/sauvegarde partie entre "+this.gameur1.getPseudo()+" et "+this.gameur2.getPseudo());
                File file1 = new File("lib/Donnees/donnees partie entre "+this.gameur1.getPseudo()+" et "+this.gameur2.getPseudo());
                file.delete();
                file1.delete();
                break;
            }            
            this.save(sauvegarde, this);
            System.out.print("Voulez vous continuez? (Y/N) :");
            String rep = scan.nextLine();
            if (rep.toLowerCase().trim().equals("n")){
                scan.close();
                System.out.println("Vous pourrez continuez votre partie en chargant la sauvegarde se trouvant dans le dossier Sauvegardes.");
                System.out.println("\nSauvegarde terminée avec succès...\n");
                break;
            }
        }
    }

    

}