package kcjava;

import java.io.*;
/**
 * classe abstraite permettant la sauvegarde d'une partie pour la reprendre plus tard
 */
public abstract class Sauvegarde {
    
    /**
     * methode statique permettant l'ecriture d'un joueur dans un fichier
     * @param j joueur a sauvegarder
     * @throws ExceptionSauvegarde
     */
    public static void sauvegarder(CheckTime Check) throws ExceptionSauvegarde{
        try {
            ObjectOutputStream dos;
            dos = new ObjectOutputStream(new FileOutputStream("sauvegarde"));
            dos.writeObject(Check);
            dos.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionSauvegarde("Fichier introuvable");
        } catch (NotSerializableException e) {
            throw new ExceptionSauvegarde("Probleme de serialization");
        } catch (IOException e) {
            throw new ExceptionSauvegarde("Probleme d'ecriture du fichier");
        }
    }
    
    /**
     * methode statique permettant de charger un joueur que l'on a precedemment sauvegarde
     * @return joueur charge
     * @throws ExceptionSauvegarde
     */
    public static CheckTime charger() throws ExceptionSauvegarde{
    	CheckTime Check = null;
        try {
            ObjectInputStream dis = new ObjectInputStream(new FileInputStream("sauvegarde"));
            Check = (CheckTime)(dis.readObject());
            dis.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionSauvegarde("Fichier introuvable : vous n'avez aucune sauvegarde");
        } catch (IOException e) {
            throw new ExceptionSauvegarde("Probleme de lecture du fichier");
        } catch (ClassNotFoundException e) {
            throw new ExceptionSauvegarde("Probleme de lecture du fichier : le fichier a ete cree manuelement");
        }
        return Check;
    }
}