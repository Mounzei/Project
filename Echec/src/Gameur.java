/**
 * Joueur
 */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.Serializable;
public class Gameur implements Serializable{

    private String pseudo;
    private MesPieces mesPieces;
    private ArrayList<Integer> pieces_sup;

    public Gameur(){
        this.pseudo = "";
        this.mesPieces = null;
        this.pieces_sup = new ArrayList<Integer>();
    }
    
    public Gameur(String ps, MesPieces p){
        this.pseudo = ps;
        this.mesPieces = p;
        this.pieces_sup = new ArrayList<Integer>();
    }
    
    public Gameur(String ps){
        this.pseudo = ps;
        this.pieces_sup = new ArrayList<Integer>();
    }

    public Gameur(Gameur gm){
        this.pseudo = gm.getPseudo();
        this.mesPieces = gm.getPieces();
        this.pieces_sup = gm.getPiecesSup();
    }

    // Choix ligne et colonne

    public int choixColonne(String c){
        char a = c.charAt(0);
        int y = a - 97;
        return y;
    }

    public int choixLigne(String ligne){
        int l = Integer.parseInt(ligne);
        int x;
        if(l == 1){
            x = 7;
        }else if(l == 2){
            x = 6;
        }else if(l == 3){
            x = 5;
        }else if(l == 4){
            x = 4;
        }else if(l == 5){
            x = 3;
        }else if(l == 6){
            x = 2;
        }else if(l == 7){
            x = 1;
        }else{
            x = 0;
        }
        return x;
    }

    public String choixCase(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Case: ");
        String res = scan.nextLine();
        return res;
    }

    // Jouer

    public void attack(int[][] ech){
        System.out.println("Case où se trouve la piece à déplacer???");
        String co = this.choixCase();
        int y = this.choixColonne(co);
        int x = this.choixLigne(co.substring(1));
        if (x < 0 || x > 7 || y < 0 || y > 7){
            System.out.println("Aucune case correspondante");
            this.attack(ech);
        }
        if (this.mesPieces.getIds().contains(ech[x][y])) {
            System.out.println("Case de destination???");
            String cd = this.choixCase();
            int z = this.choixColonne(cd);
            int w = this.choixLigne(cd.substring(1));
            if (w < 0 || w > 7 || z < 0 || z > 7){
                System.out.println("Aucune case correspondante");
                this.attack(ech);
            }
            System.out.println(this.mesPieces.getPiece(this.mesPieces.getMesPieces(), ech[x][y]));
            if (this.mesPieces.getPiece(this.mesPieces.getMesPieces(), ech[x][y]).rule(ech, x, y, w, z, this.mesPieces.getIds())){
                if (ech[w][z] != 0){
                    this.pieces_sup.add(ech[w][z]);
                }
                int i = this.mesPieces.getPiece(this.mesPieces.getMesPieces(), ech[x][y]).getNb_tour();
                i++;
                this.mesPieces.getPiece(this.mesPieces.getMesPieces(), ech[x][y]).setNb_tour(i);
                ech[w][z] = ech[x][y];
                ech[x][y] = 0;
            }else{
                System.out.println("Déplacement impossible!!!!");
                this.attack(ech);
            }
            
        }else{
            System.out.println("Erreur");
            this.attack(ech);
        }
    }

    // Getters / Setteurs

    public MesPieces getPieces(){
        return this.mesPieces;
    }
    public String getPseudo(){
        return this.pseudo;
    }
    public ArrayList<Integer> getPiecesSup(){
        return this.pieces_sup;
    }

    public void setMesPieces(MesPieces p){
        this.mesPieces = p;
    }
}