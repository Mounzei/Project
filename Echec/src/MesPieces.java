/**
 * Piece
 */

import java.util.ArrayList;
import java.io.Serializable;
// import java.util.Collections;

public class MesPieces implements Serializable{

    private ArrayList<Piece> mesPieces;

    private King k;  
    private Queen q;
    private ArrayList<Bishop> b;    
    private ArrayList<Knight> c;    
    private ArrayList<Rock> r;    
    private ArrayList<Pawn> p;
    // private ArrayList<Integer> b_ids;
    // private ArrayList<Integer> c_ids;
    // private ArrayList<Integer> r_ids;
    // private ArrayList<Integer> p_ids;
    private ArrayList<Integer> ids;
    private String color;
    // private Gameur gameur;

    public MesPieces(String c){
        // this.gameur = g;
        this.color = c;
        this.k = new King();
        this.q = new Queen();
        this.b = new ArrayList<Bishop>();
        this.c = new ArrayList<Knight>();
        this.r = new ArrayList<Rock>();
        this.p = new ArrayList<Pawn>();
        int i = 0, j= 0;
        while (i < 2){
            this.b.add(new Bishop());
            this.c.add(new Knight());
            this.r.add(new Rock());
            i++;
        }
        while (j < 8){
            this.p.add(new Pawn());
            j++;
        }
        this.mesPieces = new ArrayList<Piece>();
        this.ids = new ArrayList<Integer>();
    }


    //getters

    public String getColor(){
        return this.color;
    }
    public String getTrueColor(){
        if (this.getColor().equals("blanc")){
            return this.getColor();
        }
        return this.getColor();
    }
    public ArrayList<Integer> getIds(){
        return this.ids;
    }

    public String getNameOf(int pos){
        String res = "";
        for( Piece p : this.mesPieces){
            if ( p.getId() == pos){
                res = p.getNom();
            }
        }
        return res;
    }

    public ArrayList<Bishop> getBishops(){
        return this.b;
    }
    public ArrayList<Knight> getKnights(){
        return this.c;
    }
    public ArrayList<Rock> getRocks(){
        return this.r;
    }
    public ArrayList<Pawn> getPawns(){
        return this.p;
    }
    public King getKing(){
        return this.k;
    }
    public Queen getQueen(){
        return this.q;
    }
    public ArrayList<Piece> getMesPieces(){
        return this.mesPieces;
    }
    //init

    public void init(){
        if(this.getColor().equals("blanc")){
            this.k.setColor(this.getColor());
            this.k.setId(29);
            //this.mesPieces.add(k);
            this.q.setColor(this.getColor());
            this.q.setId(28);
            //this.mesPieces.add(q);
            this.ids.add(29);
            this.ids.add(28);
            int i = 0;
            int x,y,z;
            x = 25;
            y = 26;
            z = 27;            
            while (i < 2){
                this.r.get(i).setColor(this.getColor());
                this.r.get(i).setId(x);
                this.c.get(i).setColor(this.getColor());
                this.c.get(i).setId(y);
                this.b.get(i).setColor(this.getColor());
                this.b.get(i).setId(z);
                this.ids.add(x);
                this.ids.add(y);
                this.ids.add(z);
                x+=7;
                y+=5;
                z+=3;
                i++;
            }
            int j,w;
            j = 0;
            w = 17;
            while (j < 8){
                this.p.get(j).setColor(this.getColor());
                this.p.get(j).setId(w);
                this.ids.add(w);
                w++;
                j++;
            }
        }else if(this.getColor().equals("noir")){
            this.k.setColor(this.getColor());
            this.k.setId(5);
            this.q.setColor(this.getColor());
            this.q.setId(4);
            this.ids.add(5);
            this.ids.add(4);
            int i = 0;
            int x,y,z;
            x = 1;
            y = 2;
            z = 3;            
            while (i < 2){
                this.r.get(i).setColor(this.getColor());
                this.r.get(i).setId(x);
                this.c.get(i).setColor(this.getColor());
                this.c.get(i).setId(y);
                this.b.get(i).setColor(this.getColor());
                this.b.get(i).setId(z);
                this.ids.add(x);
                this.ids.add(y);
                this.ids.add(z);
                x+=7;
                y+=5;
                z+=3;
                i++;
            }
            int j,w;
            j = 0;
            w = 9;
            while (j < 8){
                this.p.get(j).setColor(this.getColor());
                this.p.get(j).setId(w);
                this.ids.add(w);
                w++;
                j++;
            }
        }else{
            System.out.println("Vous n'avez pas choisit une bonne couleur.\nVeillez choisir entre soit blanc soit noir.");
            this.init();
        }
        this.initMesPieces();
    }

    private void initMesPieces(){
        this.mesPieces.add(this.k);
        this.mesPieces.add(this.q);
        int i,j,u,l;
        i = 0; j = 0; u = 0; l = 0;
        while (i < b.size()){
            this.mesPieces.add(this.b.get(i));
            i++;
        }
        while (j < c.size()){
            this.mesPieces.add(this.c.get(j));
            j++;
        }
        while (u < r.size()){
            this.mesPieces.add(this.r.get(u));
            u++;
        }
        while (l < p.size()){
            this.mesPieces.add(this.p.get(l));
            l++;
        }

    }
    public void show(){
        System.out.println(this.toString());
        System.out.println(k);
        System.out.println(q);
        System.out.println(b);
        System.out.println(c);
        System.out.println(r);
        System.out.println(p);
    }

    public Piece getPiece(ArrayList<Piece> ps, int id){
        int i = 0;
        while (i < ps.size()){
            if ( ps.get(i).getId() == id){
                break;
            }
            i++;
        }
        return ps.get(i);
    }
    public String toString(){
        return "************************\nJEUX AVEC PIECES "+this.getTrueColor().toUpperCase()+"\n************************";
    }
}