package Controllers.Admin;
import Dao.AdminGeneralDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "adminLogin", value = "/adminLogin")
public class ServletadminLogin extends HttpServlet {
    private AdminGeneralDao adminDao;
    @Override
    public void init() throws ServletException {
        adminDao = new AdminGeneralDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            Object check = session.getAttribute("admin");
            if(check != null){
                request.getRequestDispatcher("AdminCenterList").forward(request,response);
                return;
            }
        }
        request.getRequestDispatcher("./AdminGlobal/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        boolean login = adminDao.validateAdminLogin(new String[]{email, password});
        if(login){
            HttpSession session = request.getSession();
        //set email of admin to use in another class
            session.setAttribute("admin", email);
            response.sendRedirect("AdminCenterList");
        }else{
            request.setAttribute("echo","you information is incorrect");
            request.getRequestDispatcher("./AdminGlobaLogin.jsp").forward(request, response);
        }
    }
}
