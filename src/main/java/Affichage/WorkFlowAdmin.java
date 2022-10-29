package Affichage;
import Dao.AdminCenterDao;
import Dao.AdminGeneralDao;
import Models.Centreadmin;
import helpers.Menus;
import helpers.Sout;

public class WorkFlowAdmin {
    public static int FlowAdmin() {
            AdminGeneralDao adminGeneralDao = new AdminGeneralDao();
            AdminCenterDao adminCenterDao = new AdminCenterDao();
            Object[] login = (Object[]) Menus.LoginMenu("Admin General");
            Boolean valideConnection = adminGeneralDao.validateAdminLogin(login);
            if(valideConnection){
                Sout.sout("green","Connection By success");
                while (true) {
                    int choixAdmin = Menus.GeneralAdminMenu();
                    switch (choixAdmin) {
                        case 1:
                            Centreadmin admin = Menus.createAdminCenter();
                              if(admin!=null){
                                  adminCenterDao.addadminCenter(admin);
                                  Sout.sout("green", "your admin added by success");
                              }
                            continue;
                        case 2:
                            String emaildelete = Menus.deleteadmincenter();
                            if (emaildelete != null) {
                                Centreadmin admindelete = adminCenterDao.getadmincenterByEmail(emaildelete);
                                adminCenterDao.deleteadminGeneral(admindelete);
                                Sout.sout("green", "admin center deleted by success");
                            } else {
                                continue;
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
