package Controllers.Manager;

import Dao.AdminGeneralDao;
import Dao.ManagerDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletmanagerLogin", value = "/managerLogin")
public class ServletmanagerLogin extends HttpServlet {

    private ManagerDao managerDao;
    @Override
    public void init() throws ServletException {
        managerDao = new ManagerDao();
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
        request.getRequestDispatcher("./AdminManager/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Boolean login = managerDao.validateRespRayonLogin(new String[]{email, password});
        if(login){
            HttpSession session = request.getSession();
            session.setAttribute("manager", email);
            response.sendRedirect("PromtionList.manager");
        }else{
            request.setAttribute("echo","you information is incorrect");
            request.getRequestDispatcher("./Affichage/Login.jsp").forward(request, response);
        }
    }
}
