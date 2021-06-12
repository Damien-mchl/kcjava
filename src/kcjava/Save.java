package kcjava;

import java.io.*;
import java.util.ArrayList;
/**
 * classe abstraite permettant la sauvegarde
 */
public abstract class Save {
    
    /**
     * methode statique permettant l'ecriture d'une liste de pointages dans un fichier
     * @param Checks pointages a sauvegarder
     * @param path chemin du fichier de sauvegarde
     * @throws ExceptionSave exception de sauvegarde
     */
    public static void save(ArrayList<CheckTime> Checks, String path) throws ExceptionSave{
        try {
            ObjectOutputStream dos;
            dos = new ObjectOutputStream(new FileOutputStream(path));
            dos.writeObject(Checks);
            dos.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionSave("Fichier introuvable");
        } catch (NotSerializableException e) {
            throw new ExceptionSave("Probleme de serialization");
        } catch (IOException e) {
            throw new ExceptionSave("Probleme d'ecriture du fichier");
        }
    }
    
    
    /**
     * methode permettant la sauvegarde d'une entreprise
     * @param comp entreprise a sauvegarder
     * @param path chemin du fichier de sauvegarde
     * @throws ExceptionSave exception de sauvegarde
     */
    public static void saveCompany(Company comp, String path) throws ExceptionSave{
    	try {
            ObjectOutputStream dos;
            dos = new ObjectOutputStream(new FileOutputStream(path));
            dos.writeObject(comp);
            dos.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionSave("Fichier introuvable");
        } catch (NotSerializableException e) {
            throw new ExceptionSave("Probleme de serialization");
        } catch (IOException e) {
            throw new ExceptionSave("Probleme d'ecriture du fichier");
        }
    }
    
    
	/**
	 * methode permettant de charger les pointages
	 * @param path chemin du fichier de sauvegarde
	 * @return liste des pointages
	 * @throws ExceptionSave exception de sauvegarde
	 */
	public static ArrayList<CheckTime> load(String path) throws ExceptionSave{
    	ArrayList<CheckTime> Check = null;
        try {
            ObjectInputStream dis = new ObjectInputStream(new FileInputStream(path));
            Check = (ArrayList<CheckTime>)(dis.readObject());
            dis.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionSave("Fichier introuvable : vous n'avez aucune sauvegarde");
        } catch (IOException e) {
            throw new ExceptionSave("Probleme de lecture du fichier");
        } catch (ClassNotFoundException e) {
            throw new ExceptionSave("Probleme de lecture du fichier : le fichier a ete cree manuelement");
        }
        return Check;
    }
	
    /**
     * methode permettant de charger une entreprise
     * @param path chemin du fichier de sauvegarde
     * @return entreprise
     * @throws ExceptionSave exception de sauvegarde
     */
    public static Company loadCompany(String path) throws ExceptionSave{
    	Company comp;
        try {
            ObjectInputStream dis = new ObjectInputStream(new FileInputStream(path));
            comp = (Company)(dis.readObject());
            dis.close();
        } catch (FileNotFoundException e) {
            throw new ExceptionSave("Fichier introuvable : vous n'avez aucune sauvegarde");
        } catch (IOException e) {
            throw new ExceptionSave("Probleme de lecture du fichier");
        } catch (ClassNotFoundException e) {
            throw new ExceptionSave("Probleme de lecture du fichier : le fichier a ete cree manuelement");
        }
        return comp;
    }
}