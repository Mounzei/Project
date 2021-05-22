import java.util.ArrayList;

public class Bishop extends Piece{
    public Bishop(){
        this.color = "";
        this.id = 0;
        this.nom = "Bishop";
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
        int i,j;
        j = 1;
        if (x > w){
            i = x-1;
            while ( i > w){
                if (y < z){
                    try{
                        pos.add(ch[i][(y+j)]);
                        i--;
                        j++;
                    }catch(Exception e){
                        return false;
                    }
                }else if (y > z){
                    try{
                        pos.add(ch[i][(y-j)]);
                        i--;
                        j++;
                    }catch(Exception e){
                        return false;
                    }
                }
            }
            
        }else if (x < w){
            i = x+1;
            while ( i < w){
                if (y < z){
                    try{
                        pos.add(ch[i][(y+j)]);
                        i++;
                        j++;
                    }catch(Exception e){
                        return false;
                    }
                    
                }else if (z > y){
                    try{
                        pos.add(ch[i][(y-j)]);
                        i++;
                        j++;
                    }catch(Exception e){
                        return false;
                    }                    
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
            return false;
        }else if(x > w ){
            if(y > z){
                return ((x-w) == (y-z) && this.contientZ(pos));
            }else{
                return ((x-w) == (z-y) && this.contientZ(pos));
            }
        }else if(x < w ){
            if(y > z){
                return ((w-x) == (y-z) && this.contientZ(pos));
            }else{
                return ((w-x) == (z-y) && this.contientZ(pos));
            }
        }
        return false;
    }
}
