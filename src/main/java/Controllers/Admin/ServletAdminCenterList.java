package Controllers.Admin;

import Dao.AdminCenterDao;
import Dao.AdminGeneralDao;
import Dao.CenterDao;
import Models.Centreadmin;
import Utuls.Password;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCenterList", value = "/AdminCenterList")
public class ServletAdminCenterList extends HttpServlet {
    private AdminCenterDao adminCenterDao;
    private Centreadmin adminCenter;
    @Override
    public void init() throws ServletException {
        adminCenterDao = new AdminCenterDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List allAdminCenter = adminCenterDao.getAlladminCenter();
        CenterDao centerDao = new CenterDao();
        List allcityDisponible = centerDao.getAllCenterDisponible();
        request.setAttribute("Allcenteradmin", allAdminCenter);
        request.setAttribute("Allcity",allcityDisponible);
        request.getRequestDispatcher("./AdminGlobal/AdminCenterList.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String hashpassword = Password.hashPassword(password);
        String fullname = request.getParameter("fullName");
        int idcenter = Integer.parseInt(request.getParameter("idcity"));
        Centreadmin adminCenter = new Centreadmin(idcenter,fullname,email,hashpassword);
        adminCenterDao.addadminCenter(adminCenter);

        List allAdminCenter = adminCenterDao.getAlladminCenter();
        request.setAttribute("Allcenteradmin", allAdminCenter);

        request.getRequestDispatcher("./AdminGlobal/AdminCenterList.jsp").forward(request, response);
        CenterDao centerDao = new CenterDao();
        List allcityDisponible = centerDao.getAllCenterDisponible();
        request.setAttribute("Allcity",allcityDisponible);
    }
}
