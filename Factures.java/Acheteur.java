import java.util.Random;
import java.util.Scanner;
public class Acheteur {
    protected String name,lastName,num;

    protected String getName(){
        return name;
    }
    protected void setName(String n){
        name = n;
    }
    protected String getLastName(){
        return lastName;
    }
    protected void setLastName(String ln){
        lastName = ln;
    }
    protected String getNum(){
        return num;
    }
    protected void setNum(String nu){
        num = nu;
    }
    
    protected void setAcheteur(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nom: ");
        name = sc.nextLine();
        System.out.print("Prénom: ");
        lastName = sc.nextLine();
        int k = 0;
        String res = "";
        while ( k < 8){
            Random rand = new Random();
            int n = rand.nextInt(9);
            res += n;
            k++;
        }
        num = res;
    }
}
