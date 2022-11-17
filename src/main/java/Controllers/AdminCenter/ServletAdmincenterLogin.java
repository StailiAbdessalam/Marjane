package Controllers.AdminCenter;

import Dao.AdminCenterDao;
import Dao.AdminGeneralDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletAdmincenterLogin", value = "/admincenterLogin")
public class ServletAdmincenterLogin extends HttpServlet {

    private AdminCenterDao admincenterDao;
    @Override
    public void init() throws ServletException {
        admincenterDao = new AdminCenterDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session != null){
            Object check = session.getAttribute("admincenter");
            if(check != null){
                request.getRequestDispatcher("AdminManagerList").forward(request,response);
                return;
            }
        }
        request.getRequestDispatcher("./AdminCenter/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Integer login = admincenterDao.validateadminGeneralLogin(new String[]{email, password});
        if(login!=null){
            HttpSession session = request.getSession();
            session.setAttribute("admin", email);
            session.setAttribute("id",login);
            session.setAttribute("idcenteradmin",login);
            response.sendRedirect("AdminManagerList");
        }else{
            request.setAttribute("echo","you information is incorrect");
            request.getRequestDispatcher("./AdminGlobaLogin.jsp").forward(request, response);
        }
    }
}
