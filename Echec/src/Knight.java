import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(){
        this.color = "";
        this.id = 0;
        this.nom = "Knight";
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
        }else if( (w == (x+1) || w == (x-1)) ){
            return (z == (y+2) || z == (y-2));            
        }else if( (w == (x+2) || w == (x-2)) ){
            return (z == (y+1) || z == (y-1));            
        }
        return false;
    }
}
