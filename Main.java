import control.Avancer;
import control.Control;
import control.Voler;
import model.Parcours;
import view.Affichage;
import model.Etat;

import javax.swing.JFrame;

public class Main  {
    public static void main(String[] args) {
        Etat etat=new Etat();//creer un objet etat
        Parcours parcours=new Parcours();
        Affichage a=new Affichage(etat,parcours);//creer un objet affichage avec l'etat
        Voler voler=new Voler(etat,a);
        Thread avancer=new Thread(new Avancer(parcours,a));
        Control control=new Control(etat,a);//creer un objet par rapport etat et affichage.
        avancer.start();
        voler.start();
        JFrame test = new JFrame("Test dessin");//renommer le nom de l'ecran
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        test.add(a);//ajouter l'objet dans l'ecran.
        test.pack();
        test.setVisible(true);
        test.addMouseListener(control);

    }
}

