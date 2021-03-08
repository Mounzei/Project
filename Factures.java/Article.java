/**
 * Article
 */

import java.util.Scanner;
public class Article {
    
    private String code,libelle,type;
    private float prix;
    private float tva, ttc;

    public Article(String c,String l,String t,double p){
        this.code = c;
        this.libelle = l;
        this.type = t;
        this.prix = (float) p;
        this.tva = 0;
        this.ttc = 0;
    }
    public Article(){
        this.code = "";
        this.libelle = "";
        this.type = "";
        this.prix = 0;
        this.tva = 0;
        this.ttc = 0;
    }
    public void init(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Le code de l'article: ");
        String c = sc.nextLine();
        System.out.println("Le libéllé de l'article: ");
        String l = sc.nextLine();
        System.out.println("Le type de l'article: ");
        String t = sc.nextLine();
        System.out.println("Le prix de l'article: ");
        float p = sc.nextFloat();
        code = c;
        libelle = l;
        type = t;
        prix = p;
        sc.close();
    }

    //getteurs

    public String getCode(){
        return code;
    }
    public String getLibelle(){
        return libelle;
    }
    public String getType(){
        return type;
    }
    public float getPrix(){
        return prix;
    }
    public float getTtc() {
        return ttc;
    }
    public float getTva() {
        return tva;
    }

    //setteurs

    public void setCode(String c){
        code = c;
    }
    public void setLibelle(String l){
        code = l;
    }
    public void setType(String t){
        code = t;
    }
    public void setPrix(float p){
        prix = p;
    }
    public void setTtc(){
        if (getType() == "A"){
            double x = 0.23;
            this.tva = (float) x;
        }else if (getType() == "B"){
            double x = 0.25;
            this.tva = (float) x;
        }else{
            double x = 0.2;
            this.tva = (float) x;
        }
        this.ttc = getPrix() + getPrix() * tva;
    }

    //affichage 

    public String toString(){
        return "Article=> code: "+code+", libéllé: "+libelle+", prix: "+prix; 
    }
    public void affiche(){
        System.out.println(toString());
    }
}