package presentation;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Method;
import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        try {
            Scanner scanner= new Scanner( new File("config.txt"));

            String daoClassname = scanner.nextLine();
            Class cdao = Class.forName(daoClassname);
            IDao dao = (IDao) cdao.newInstance();

            String metierClassname = scanner.nextLine();
            Class cmetier = Class.forName(metierClassname);
            IMetier metier = (IMetier) cmetier.newInstance();

            Method meth = cmetier.getMethod("setDao",IDao.class);
            meth.invoke(metier,dao);
            System.out.println(metier.calcul());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
