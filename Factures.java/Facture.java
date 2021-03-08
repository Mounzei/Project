public class Facture {
    private String[] id;
    private Achat[] produit;

    public Facture(String[] i, Achat[] p){
        this.id = i;
        this.produit = p;
    }
    public Facture(Achat[] p){
        this.id = null;
        this.produit = p;
    }

    //string

    // public String toString(){
    //     return "Voici votre facture n°"+getId();
    // }
    // public void affiche(){
    //     System.out.println(toString());
    // }

    //setteurs

    public void setId(String[] i){
        id = i;
    }

    //getteurs

    public String[] getId(){
        return id;
    }
    public Achat[] getProduit(){
        return produit;
    }

    //op

    public void getfacture(){
        int i = 0;
        while (i < getProduit().length){
            getProduit()[i].setAcheteur();
            float totalHT = 0;
            float totalTTC = 0;
            System.out.println("Voici votre facture n°"+getId()[i]);
            int j = 0;
            while (j < getProduit()[i].getArticle().length){
                System.out.println(getProduit()[i].getArticle()[j].getCode()+" / "+getProduit()[i].getArticle()[j].getPrix()*getProduit()[i].getQuantity()[j]+"€ / "+getProduit()[i].getArticle()[j].getTva()*100+"% / "+getProduit()[i].getArticle()[j].getTtc()*getProduit()[i].getQuantity()[j]+"€ / "+getProduit()[i].getQuantity()[j]);
                totalHT+=getProduit()[i].getArticle()[j].getPrix()*getProduit()[i].getQuantity()[j];
                totalTTC+=getProduit()[i].getArticle()[j].getTtc()*getProduit()[i].getQuantity()[j];
                j++;
            }
            System.out.println("Code produit / prix HT / TVA / prix TTC / quantité");
            System.out.println("Le total HT est de "+totalHT+"€ et le total TTC est de "+totalTTC+"€");
            System.out.println("Merci pour votre achat et à bientôt "+getProduit()[i].getName()+" "+getProduit()[i].getLastName());
            System.out.println("N° Client: "+getProduit()[i].getNum());            
            i++;
        }
        
    }
    public void setTabTtc(){
        int i = 0;
        while (i < getProduit().length){
            int j = 0;
            while (j < getProduit()[i].getArticle().length){
                getProduit()[i].getArticle()[j].setTtc();
                j++;
            }
            i++;
        }
    }
}
