package helpers;

import Dao.AdminCenterDao;
import Dao.CategorieDao;
import Dao.CenterDao;
import Dao.PromotionDao;
import Models.*;
import Utuls.Password;

import java.time.Instant;
import java.util.List;
import java.util.Scanner;

public class Menus {
    // login menu as SuperAdmin or Admin or manager
    public static int MenuGlobal() {
        printScan.println("------------------- Login Menu -------------------");
        printScan.println("1. Login as Admin General");
        printScan.println("2. Login as Admin Center");
        printScan.println("3. Login as Manager");
        printScan.println("4. Exit");
        printScan.println("-------------------------------------------------");
        printScan.print("Enter your choice: ");
        return printScan.scan().nextInt();
    }
    //menu of login
    public static Object LoginMenu(String role) {
        printScan.println("------------------- "+role+" Login Menu -------------------");
        printScan.println("Enter your email: ");
        String email = printScan.scan().nextLine();
        printScan.println("Enter your password: ");
        String password = printScan.scan().nextLine();
        return new Object[]{email, password};
    }
    public static int GeneralAdminMenu() {
        printScan.println("------------------- General Admin Menu -------------------");
        printScan.println("1. Create Admin Center");
        printScan.println("2. Delete Admin centrer");
        printScan.println("3. Statistics");
        printScan.println("4. Exit");
        printScan.println("-------------------------------------------------");
        printScan.print("Enter your choice: ");
        return printScan.scan().nextInt();
    }
    public static int promotionsMenu() {
        printScan.println("------------------- Promotions Menu -------------------");
        printScan.println("1. View Promotion");
        printScan.println("2. Create Promotion");
        printScan.println("4. Delete Promotion");
        printScan.println("5. Exit");
        printScan.println("-------------------------------------------------");
        printScan.print("Enter your choice: ");
        return printScan.scan().nextInt();
    }
    public static int CentralAdminMenu() {
        printScan.println("------------------- Admin Menu -------------------");
        printScan.println("1. Create Manager");
        printScan.println("2. Promotions");
        printScan.println("3. Statistics");
        printScan.println("4. Exit");
        printScan.println("-------------------------------------------------");
        printScan.print("Enter your choice: ");
        return printScan.scan().nextInt();
    }

    public static Centreadmin createAdminCenter() {
        printScan.println("------------------- Create Admin Center -------------------");
        printScan.println("Enter Admin full name: ");
        String fullName = printScan.scan().nextLine();
        printScan.println("Enter Admin email: ");
        String email = printScan.scan().nextLine();

        printScan.println("Enter Admin password: ");
        String password = printScan.scan().nextLine();


        //make a function to send email of admin center


        printScan.println("Enter id center : ");
        int idcenter = printScan.scan().nextInt();

        String hashedPassword = Password.hashPassword(password);
        return new Centreadmin(idcenter,fullName,email,hashedPassword);
    }
    public static String deleteadmincenter(){
       while(true){
           printScan.println("------------------- Create Admin Center -------------------");
           printScan.println("entrer email of admin center to delete");
           String emaildelete = printScan.scan().nextLine();
           printScan.println("are you sure you want delete these adminCenter");
           printScan.println("1. Yes");
           printScan.println("2. No");
           int choix = printScan.scan().nextInt();
           switch (choix){
               case 1:
                   return emaildelete;
               case 2:
                   return null;
               default:
                   Sout.sout("red","choix invalid");
                   continue;
           }
       }
    }

    public static void afficheallpromo(List allpromo){
        allpromo.forEach(promotion -> {
            printScan.println(promotion.toString());
        });
    }
    public static Manager createManager(Integer id) {
        printScan.println("------------------- Create Manager -------------------");
        printScan.println("Enter Manager full name: ");
        String fullName = printScan.scan().nextLine();
        printScan.println("Enter Manager email: ");
        String email = printScan.scan().nextLine();
        printScan.println("Enter Manager password: ");
        String password = printScan.scan().nextLine();
        String hashedPassword =Password.hashPassword(password);
        AdminCenterDao adminCenterDao = new AdminCenterDao();
        Categorie object = Categorie();
        return new Manager(adminCenterDao.findOne(id),fullName,email,password,Instant.now(),object);
    }

    public static Categorie Categorie(){
        printScan.println("choixi le categorie de cette manager");
        CategorieDao categorie = new CategorieDao();
        List allcategorie = categorie.findAll();
        int i=1;
        allcategorie.forEach(catigo->{
            printScan.println("categorie "+i+" :"+catigo.toString());
        });
        int choixcategorie = printScan.scan().nextInt();
        Categorie cati = categorie.findOne(choixcategorie);
        return cati;
    }

    public static Promotion createPromotionMenu(Integer id) {
        printScan.println("------------------- Create Promotion -------------------");
        printScan.println("Enter points of promotion: ");
        int pionts = printScan.scan().nextInt();
        PromotionDao Promotiondao = new PromotionDao();
        AdminCenterDao adminCenterDao = new AdminCenterDao();
        Categorie categorie = Categorie();
        Promotion promotionobject = new Promotion(adminCenterDao.getadminGeneralById(id),categorie,pionts,false,Instant.now());
        return promotionobject;
    }
}
