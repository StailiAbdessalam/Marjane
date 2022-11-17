package Controllers.Admin;

import Dao.ManagerDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.SessionException;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServletManager", value = "/Manager")
public class ServletManager extends HttpServlet {
    private ManagerDao managerDao;
    @Override
    public void init() throws ServletException {
        managerDao = new ManagerDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            if(session.getAttribute("admin")!=null){
                List AllManager = managerDao.getAllRespRayons();
                request.setAttribute("AllManager", AllManager);
                request.getRequestDispatcher("./AdminGlobal/Manager.jsp").forward(request, response);
            }else {
                response.sendRedirect("login");
            }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
