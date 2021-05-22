
/**
 * Chess
 */
public class Chest {

    // public static boolean check(int[][] tab, int val) {
    //     boolean b = false;
    //     int j = 0;   
    //     while (j < 8){
    //         for(int i : tab[j]){
    //             if(i == val){
    //                 b = true;
    //                 break;
    //             }
    //         }
    //         j++;
    //     } 
    //     return b;
    // }

    public static void main(String[] args) {
        MesPieces p1 = new MesPieces("blanc");
        MesPieces p2 = new MesPieces("noir");
        Gameur g1 = new Gameur("Amine",p1);
        Gameur g2 = new Gameur("Mounirou",p2);
        Game parti = new Game(g1, g2);
        // parti.load("sauvegarde partie entre Amine et Mounirou", "donnees partie entre Amine et Mounirou");
        parti.game();
    }
}