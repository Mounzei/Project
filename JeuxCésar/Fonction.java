import java.util.Random;
import java.util.Scanner;

public class Fonction {
    private int x;
    private int tour = 0;

    public Fonction(int a){
        this.x = a;
    }

    public void Cesar(){
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        int num = rand.nextInt(x);
        int nbr = 0;
        System.out.println("On initialise votre choix à 0");
        while (nbr != num){
            System.out.println("Vous n'avez pas choisit le bon nombre!");
            if (nbr > num){
                System.out.println("Choisissez un nombre plus petit:");
            }else{
                System.out.println("Choisissez un nombre plus grand:");
            }
            nbr = scan.nextInt();
            tour++;
        }
        scan.close();
        if (tour > 1){        
            System.out.println("Vous avez trouv\u00e9 le bon nombre qui est: "+num+"\nVous avez jou\u00e9 pendant "+tour+" tours");
        }else{
            System.out.println("Vous avez trouv\u00e9 le bon nombre qui est: "+num+"\nVous avez trouv\u00e9 du premier coup. BRAVO ^_^");
        }
    }
    
}
