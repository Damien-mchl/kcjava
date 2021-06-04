package kcjava;

import java.io.*;
import java.util.ArrayList;
/**
 * classe abstraite permettant la sauvegarde d'une partie pour la reprendre plus tard
 */
public abstract class Sauvegarde {
    
    /**
     * methode statique permettant l'ecriture d'un joueur dans un fichier
     * @param j joueur a sauvegarder
     * @throws ExceptionSauvegarde
     */
    public static void sauvegarder(ArrayList<CheckTime> Check, String path) throws ExceptionSauvegarde{
        try {
            ObjectOutputStream dos;
            dos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            dos.writeObject(Check);
            dos.close();
        } catch (NotSerializableException e) {
            throw new ExceptionSauvegarde("Probleme de serialization");
        } catch (IOException e) {
            throw new ExceptionSauvegarde("Probleme d'ecriture du fichier");
        }
    }
    public static void sauvegarderCompany(Company comp, String path) throws ExceptionSauvegarde{
        try {
            ObjectOutputStream dos;
            dos = new ObjectOutputStream(new FileOutputStream(new File(path)));
            dos.writeObject(comp);
            dos.close();
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
    @SuppressWarnings("unchecked")
	public static ArrayList<CheckTime> charger(String path) throws ExceptionSauvegarde{
    	ArrayList<CheckTime> Check = null;
        try {
            ObjectInputStream dis = new ObjectInputStream(new FileInputStream(path));
            Check = (ArrayList<CheckTime>)(dis.readObject());
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
    public static Company chargerCompany(String path) throws ExceptionSauvegarde{
    	Company comp = null;
        try {
            ObjectInputStream dis = new ObjectInputStream(new FileInputStream(path));
            comp = (Company)(dis.readObject());
            dis.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionSauvegarde("Fichier introuvable : vous n'avez aucune sauvegarde");
        } catch (IOException e) {
            throw new ExceptionSauvegarde("Probleme de lecture du fichier");
        } catch (ClassNotFoundException e) {
            throw new ExceptionSauvegarde("Probleme de lecture du fichier : le fichier a ete cree manuelement");
        }
        return comp;
    }
}