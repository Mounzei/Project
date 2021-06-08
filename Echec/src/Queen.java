import java.util.ArrayList;

public class Queen extends Piece {

    public Queen(){
        this.id = 0;
        this.nom = "Queen";
    }    

    public String toString(){
        String col = "Black";
        if (this.color){
            col = "White";
        }
        return  col+" "+this.nom+": "+this.id;
    }

    public boolean rule(int[][] ch, int x, int y, int w, int z, ArrayList<Integer> ids){
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> posb = new ArrayList<Integer>();
        int i,j;
        j = 1;
        if (x == w){   
            int k;         
            if (y < z){
                k = y+1;
                while (k < z){
                    posb.add(ch[w][k]);
                    k++;
                }
            }else{
                k = y-1;
                while (k > z){
                    posb.add(ch[w][k]);
                    k--;
                }
            }
        }else if (y == z){
            int k;
            if (x < w){
                k = x+1;
                while (k < w){
                    posb.add(ch[k][z]);
                    k++;
                }
            }else{
                k = x-1;
                while (k > w){
                    posb.add(ch[k][z]);
                    k--;
                }
            }
        }else if (x > w){
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
                }else{
                    return false;
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
                    
                }else if (z < y){
                    try{
                        pos.add(ch[i][(y-j)]);
                        i++;
                        j++;
                    }catch(Exception e){
                        return false;
                    }                    
                }else{
                    return false;
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
            return this.contientZ(posb);
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
