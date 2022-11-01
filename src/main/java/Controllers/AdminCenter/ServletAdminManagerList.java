package Controllers.AdminCenter;

import Dao.CategorieDao;
import Dao.CenterDao;
import Dao.ManagerDao;
import Models.Centreadmin;
import Models.Manager;
import Utuls.Password;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
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
        request.getRequestDispatcher("./AdminCenter/AdminManagerList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashpassword = Password.hashPassword(password);
        String fullname = request.getParameter("fullName");
        int idcenter = Integer.parseInt(request.getParameter("idcategorie"));
        // add manager
        Manager adminCenter = new Manager();

        managerDao.createRespRayon(adminCenter);
        CategorieDao categorieDao = new CategorieDao();
        List AllManager = managerDao.getAllRespRayons();
        List allcategorie = categorieDao.getAllCategorieDisponible();
        request.setAttribute("AllManager", AllManager);
        request.setAttribute("Allcategorie", allcategorie);
        request.getRequestDispatcher("./AdminCenter/AdminManagerList.jsp").forward(request, response);
    }
}
