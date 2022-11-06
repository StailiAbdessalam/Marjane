package Controllers.AdminCenter;

import Dao.AdminCenterDao;
import Dao.CategorieDao;
import Dao.ManagerDao;
import Models.Categorie;
import Models.Centreadmin;
import Models.Manager;
import Utuls.Password;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@WebServlet(name = "ServletAdminManagerList", value = "/AdminManagerList")
public class ServletAdminManagerList extends HttpServlet {

    private ManagerDao managerDao;
    private Centreadmin adminCenter;
    @Override
    public void init() throws ServletException {
        managerDao = new ManagerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List AllManager = managerDao.getAllRespRayons();
        CategorieDao categorieDao = new CategorieDao();
        List allcategorie = categorieDao.getAllCategorieDisponible();
        request.setAttribute("AllManager", AllManager);
        request.setAttribute("Allcategorie", allcategorie);
        request.setAttribute("idcenteradmin",request.getAttribute("idcenteradmin"));
        request.getRequestDispatcher("./AdminCenter/AdminManagerList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashpassword = Password.hashPassword(password);
        String fullname = request.getParameter("fullName");
        int idcategorie = Integer.parseInt(request.getParameter("idcategorie"));
        int idcenterAdmin = Integer.parseInt(request.getParameter("idcenter"));
        AdminCenterDao adminCenterDao = new AdminCenterDao();
        Centreadmin centreadmin = adminCenterDao.getadmincenterbyid(idcenterAdmin);
        Categorie categorie = new CategorieDao().getCategoryById(idcategorie);
        Manager adminCenter = new Manager(centreadmin,fullname,email,hashpassword, Instant.now(),categorie);

        managerDao.createRespRayon(adminCenter);
        CategorieDao categorieDao = new CategorieDao();
        List AllManager = managerDao.getAllRespRayons();
        List allcategorie = categorieDao.getAllCategorieDisponible();
        request.setAttribute("AllManager", AllManager);
        request.setAttribute("Allcategorie", allcategorie);
        request.getRequestDispatcher("./AdminCenter/AdminManagerList.jsp").forward(request, response);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("rest", request.getAttribute("idmanager"));
        request.getRequestDispatcher("./AdminCenter/AdminManagerList.jsp").forward(request, response);
    }



    }
