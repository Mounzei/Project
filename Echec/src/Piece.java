import java.util.ArrayList;
import java.io.Serializable;

public abstract class Piece implements Serializable{

    protected boolean check(int[] tab, int val) {
        boolean b = false;    
        for(int i : tab){
            if(i == val){
                b = true;
                break;
            }
        }
        return b;
    }

    // protected int indexOf(int[] t, int val){
    //     int i = 0;
    //     while (i < t.length){
    //         if(t[i] == val){
    //             break;
    //         }
    //         i++;
    //     }
    //     return i;
    // }

    protected boolean contientZ(ArrayList<Integer> t){
        int i = 0;
        while (i < t.size()){
            if(t.get(i) != 0){
                return false;
            }
            i++;
        }
        return true;
    }
    
    protected boolean color;
    protected int id;
    protected String nom;
    protected int nb_tour;

    public Piece(){
        this.id = 0;
        this.nom = "";
    }
    public Piece(Piece p){
        this.color = p.getColor();
        this.id = p.getId();
        this.nom = p.getNom();
    }

    //getters

    protected boolean getColor(){
        return this.color;
    }
    protected int getId(){
        return this.id;
    }
    protected String getNom(){
        return this.nom;
    }

    public int getNb_tour(){
        return this.nb_tour;
    }

    //setters

    protected void setColor(boolean c){
        this.color = c;
    }
    protected void setId(int p){
        this.id = p;
    }
    protected void setNom(String n){
        this.nom = n;
    }

    public void setNb_tour(int i){
        this.nb_tour = i;
    }

    public boolean rule(int[][] ch, int x, int y, int w, int z, ArrayList<Integer> ids){
        return false;
    }
    
}
