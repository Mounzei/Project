public class Achat extends Acheteur{
    private Article[] article;
    private int[] quantity;

    public Achat(Article[] a, int[] q){
        this.article = a;
        this.quantity = q;
    }
    public Achat(Article[] a){
        this.article = a;
        this.quantity = null;
    }

    //setteurs

    public void setQuantity(int[] q){
        quantity = q;
    }
    public void setName(String n){
        name = n;
    }

    //getteurs

    public Article[] getArticle(){
        return article;
    }
    public int[] getQuantity(){
        return quantity;
    }
}
