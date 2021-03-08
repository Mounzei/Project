public class Affiche {
    public static void main(String[] args) {
        Article a = new Article("12345678", "Fance", "", 12);
        Article b = new Article("12345677", "Belgique", "B", 4);
        Article c = new Article("12345676", "Italie", "B", 8);
        Article d = new Article("12345675", "Pologne", "A", 6);
        Article e = new Article("123Rg567", "Sénégal", "A", 100);

        Article[] yes = {a,b,c,d,e};
        int[] quantite = {2,7,3,5,3};
        int[] quantit = {2,7,3,5,4};
        
        Achat kile = new Achat(yes,quantite);
        Achat kil = new Achat(yes,quantit);

        Achat[] tab = {kile,kil};
        String [] num = {"14567893","122FG556"};

        Facture facture = new Facture(num, tab);
        facture.setTabTtc();
        facture.getfacture();
    }
}
