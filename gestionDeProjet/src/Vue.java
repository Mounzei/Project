package gestionDeProjet.src;

public interface Vue {
    /**
     * Méthode permetttant de mettre à jour la vue présent dans une Classe
     * @param c Classe en lien avec la vue
     */
     public void setClasse(Classe c);

     /**
     * Méthode permettant de dire à la vue qu'il y a eu des changeemns dans la classe
     */
    public void notifierChangement();
}
