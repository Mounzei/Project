import java.util.ArrayList;

public class King extends Piece{

    public King(){
        this.color = "";
        this.id = 0;
        this.nom = "King";
    }    

    public String toString(){
        String col = "Black";
        if (this.color.equals("blanc")){
            col = "White";
        }
        return  col+" "+this.nom+": "+this.id;
    }
    
    public boolean rule(int[][] ch, int x, int y, int w, int z, ArrayList<Integer> ids){
        if (check(ch[x], this.getId()) == false){
            return false;
        }else if(ids.contains(ch[w][z])){
            return false;
        }else if(w > (x+1) || w < (x-1)){
            return false;
        }else if(z < (y-1) || z > (y+1)){
            return false;
        }
        return true;
    }
}
