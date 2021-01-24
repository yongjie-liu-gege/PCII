package model;
import view.Affichage;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Parcours {
    int x=200;
    int y=200;
    public static final int Avancer=5;
    private int positon;
    private ArrayList<Point> points=new ArrayList<>();

    /**
     * Constructeur
     */
    public   Parcours(){
        this.positon=0;
        points.add(new Point(x,y));
        int z=100+points.get(points.size()-1).x;
        int u= new Random().nextInt(Affichage.HAUT-100);
        points.add(new Point(z,u));
    }
    /**
     * getter pour recuperer la position de l'oval
     * @ return
     * @return
     */
    public int  getter(){
        return  this.positon=positon;
    }

    /**
     * setter pour avancer la position de quelques pixels
     */

    public void setter(){
       this.positon+=Avancer;
    }

    /**
     * pour construire les points et retirer les points losque les coordonnes de point est negatif
     * @return
     */
    public ArrayList<Point> getParcours() {
            this.points.forEach(p->p.x-=this.positon);
            if(points.get(points.size()-1).x<Affichage.LARG){
                int x=250 + points.get(points.size() - 1).x;
                int y=new Random().nextInt(400);
                this.points.add(new Point(x,y));
                removeParcours();
            }
            return this.points;
    }

    /**
     * remove les points inutile.
     */
    public void removeParcours(){
        if(points.get(0).x<0) {
            points.remove(0);
        }
    }
}

