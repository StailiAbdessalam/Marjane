package Affichage;

import Dao.AdminCenterDao;

import Dao.ManagerDao;
import Dao.PromotionDao;
import Models.Manager;
import Models.Promotion;
import helpers.Menus;
import helpers.Sout;

import java.util.List;

public class WorkFlowCenterAdmin {
    public static int FlowAdminCenter() {
        AdminCenterDao adminCenterDao = new AdminCenterDao();
        ManagerDao managerDao= new ManagerDao();
        PromotionDao promotionDao = new PromotionDao();
        Object[] login = (Object[]) Menus.LoginMenu("Admin General");
        Integer valideConnection = adminCenterDao.validateadminGeneralLogin(login);
        if(valideConnection!=null){
            Sout.sout("green","Connection By success");
            while (true) {
                int choixAdmin = Menus.CentralAdminMenu();
                switch (choixAdmin) {
                    case 1:
                        Manager manager = Menus.createManager(valideConnection);





                        managerDao.create(manager);
                        Sout.sout("green", "your admin added by success");
                        continue;
                    case 2:
                        int choixpromotion = Menus.promotionsMenu();
                        switch (choixpromotion){
                            case 1:
                                List allpromotion = promotionDao.getAllPromotion();

                                Menus.afficheallpromo(allpromotion);
                                continue;
                            case 2:
                                Promotion promotion = Menus.createPromotionMenu(valideConnection);
                                promotionDao.createPromotion(promotion);
                                Sout.sout("green", "your admin added by success");
                                continue;
                            case 3:
                                break;
                            case 4:
                                return 0;
                            default:
                                Sout.sout("red","choix invalid");
                        }
                        break;
                    case 3:
                    case 4:
                        return 0;
                    default:
                        Sout.sout("red", "choix invalid");
                }
                break;
            }

        }else {
            Sout.sout("red","Ton information est incorrect");
            return 0;
        }

        return 1;
    }
}
