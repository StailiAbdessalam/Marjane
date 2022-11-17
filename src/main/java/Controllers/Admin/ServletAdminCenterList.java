package Controllers.Admin;
import Dao.AdminCenterDao;
import Dao.CenterDao;
import Models.Centreadmin;
import Utuls.Password;
import Utuls.RandomPassword;
import Utuls.SendMail;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminCenterList", value = "/AdminCenterList")
public class ServletAdminCenterList extends HttpServlet {
    private AdminCenterDao adminCenterDao;
    @Override
    public void init() throws ServletException {
        adminCenterDao = new AdminCenterDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("admin")!=null) {
            List allAdminCenter = adminCenterDao.getAlladminCenter();
            CenterDao centerDao = new CenterDao();
            List allcityDisponible = centerDao.getAllCenterDisponible();
            request.setAttribute("Allcenteradmin", allAdminCenter);
            request.setAttribute("Allcity", allcityDisponible);
            request.getRequestDispatcher("./AdminGlobal/AdminCenterList.jsp").forward(request, response);
        }else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("admin")!=null){
        String email = request.getParameter("email");
        String password = RandomPassword.generateCode();
        String hashpassword = Password.hashPassword(password);
        String fullname = request.getParameter("fullName");
        int idcenter = Integer.parseInt(request.getParameter("idcity"));
        // add a admin center
        Centreadmin adminCenter = new Centreadmin(idcenter,fullname,email,hashpassword);
        //send email of admincenter
            try {
                adminCenterDao.addadminCenter(adminCenter);
                SendMail.sendMail(email,"you password is :"+password);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            response.sendRedirect("AdminCenterList");
        }else {
            response.sendRedirect("login");
        }
    }
}