package kcjava;

/**
 * classe d'exception pour les sauvegardes
 */
public class ExceptionSauvegarde extends Exception{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * constructeur vide
     */
    public ExceptionSauvegarde() {
        System.out.println("Probleme avec la sauvegarde du fichier");
    }
    
    /**
     * @param message message d'erreur que l'on souhaite afficher
     */
    public ExceptionSauvegarde(String message) {
        System.out.println(message);
    }
}
