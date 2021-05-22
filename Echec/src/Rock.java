import java.util.ArrayList;

public class Rock extends Piece{

    public Rock(){
        this.color = "";
        this.id = 0;
        this.nom = "Rock";
    }    

    public String toString(){
        String col = "Black";
        if (this.color.equals("blanc")){
            col = "White";
        }
        return  col+" "+this.nom+": "+this.id;
    }
    
    public boolean rule(int[][] ch, int x, int y, int w, int z, ArrayList<Integer> ids){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        if (x == w){
            int i;            
            if (y < z){
                i = y+1;
                while (i < z){
                    pos.add(ch[w][i]);
                    i++;
                }
            }else{
                i = y-1;
                while (i > z){
                    pos.add(ch[w][i]);
                    i--;
                }
            }
        }else if (y == z){
            int i;
            if (x < w){
                i = x+1;
                while (i < w){
                    pos.add(ch[i][z]);
                    i++;
                }
            }else{
                i = x-1;
                while (i > w){
                    pos.add(ch[i][z]);
                    i--;
                }
            }
        }else{
            return false;
        }
        if (check(ch[x], this.getId()) == false){
            return false;
        }else if(ids.contains(ch[w][z])){
            return false;
        }else if (x == w || y == z){
            return this.contientZ(pos);
        }
        return false;
    }
}
