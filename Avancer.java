package control;

import model.Parcours;
import view.Affichage;

public class Avancer implements Runnable{
    Parcours parcours;
    Affichage affichage;

    /**
     * Constructeur
     * @param parcours
     * @param affichage
     */
    public Avancer(Parcours parcours, Affichage affichage){
        this.parcours=parcours;
        this.affichage=affichage;
    }

    /**
     * pour avancer ligne
     */
    public void run(){
        while(true){
            try {
                Thread.sleep(500);
                parcours.setter();
                affichage.revalidate();
                affichage.repaint();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
