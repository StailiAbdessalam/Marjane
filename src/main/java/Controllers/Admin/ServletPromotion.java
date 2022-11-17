package Controllers.Admin;

import Dao.ManagerDao;
import Dao.PromotionDao;
import Models.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ServletPromotion", value = "/Promotion")
public class ServletPromotion extends HttpServlet {
    private PromotionDao promotionDao;
    @Override
    public void init() throws ServletException {
        promotionDao = new PromotionDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("admin")!=null){
        request.setAttribute("allpromotionAccepter",promotionDao.getPromotionByStatus("Accepter"));
        request.setAttribute("allpromotionRefuser",promotionDao.getPromotionByStatus("Refuser"));
        request.setAttribute("allpromotionPending",promotionDao.getPromotionByStatus("Pending"));
        PromotionDao promotionDao  = new PromotionDao();
        request.setAttribute("AllPromotion",promotionDao.getAllPromotion());
        request.getRequestDispatcher("./AdminGlobal/Promotion.jsp").forward(request, response);
        }else {
            response.sendRedirect("login");
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        promotionDao.deletepromo(Long.parseLong(request.getParameter("idpromo")));
        response.sendRedirect("Promotion");
    }
}
