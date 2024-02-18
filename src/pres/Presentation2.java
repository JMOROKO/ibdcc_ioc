package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Presentation2 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("config.txt"));
            //lecture de la première ligne du fichier
            String daoClassName = sc.nextLine();
            //vérifie si la class existe afin de la charger en mémoire
            Class cDao = Class.forName(daoClassName);
            IDao dao = (IDao) cDao.newInstance();
            System.out.println(dao.getData());

            String metierClassName = sc.nextLine();
            //vérifie si la class existe afin de la charger en mémoire
            Class cMetier = Class.forName(metierClassName);
            IMetier metier = (IMetier) cMetier.newInstance();
            Method method = cMetier.getMethod("setDao", IDao.class);
            method.invoke(metier, dao);
            System.out.println("Resultat = "+metier.calcule());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
