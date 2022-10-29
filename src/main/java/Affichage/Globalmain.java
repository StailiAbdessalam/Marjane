package Affichage;
import helpers.Menus;
import helpers.Sout;
public class Globalmain {
    public static void main(String[] args) {
        while (true){
            int choix = Menus.MenuGlobal();
            switch (choix){
                case 1:
                     int returnAdmin = WorkFlowAdmin.FlowAdmin();
                     if(returnAdmin==0){
                         continue;
                     }else {
                         break;
                     }
                case 2:
                    int returneCenterAdmin = WorkFlowCenterAdmin.FlowAdminCenter();
                    if(returneCenterAdmin==0){
                        continue;
                    }else {
                        break;
                    }
                case 3:
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    Sout.sout("red","Choix Invalid :");
                    continue;
            }
            break;
        }
    }
}
