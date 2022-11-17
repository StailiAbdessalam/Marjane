package Controllers.Manager;

import Dao.ManagerDao;
import Dao.PromotionDao;
import Models.Manager;
import Models.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


import java.io.IOException;

@WebServlet(name = "ServletPromtionList", value = "*.manager")
public class ServletPromtionList extends HttpServlet {
    private PromotionDao promotionDao;
    private ManagerDao managerDao;

    @Override
    public void init() throws ServletException {
        promotionDao = new PromotionDao();
        managerDao = new ManagerDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("manager")!=null) {
            String email = (String) session.getAttribute("manager");
            Manager manager = managerDao.getManagerByemail(email);
            request.setAttribute("profile", manager);
            request.setAttribute("allpromotion", promotionDao.getAllPromotionByIdCategory(Long.valueOf(manager.getMidcategorie().getId())));
            request.getRequestDispatcher("./AdminManager/PromotionList.jsp").forward(request, response);
        }else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("manager")!=(null)) {
            String path = request.getServletPath();
            if (path.equals("/acceptPromotion.manager")) {
                Promotion promotion = promotionDao.findOne(Long.parseLong(request.getParameter("id")));
                promotionDao.updateStatus(promotion, "Accepter");
                response.sendRedirect("PromtionList.manager");
            } else if (path.equals("/rejecterpromotion.manager")) {
                Promotion promotion = promotionDao.findOne(Long.parseLong(request.getParameter("id")));
                promotionDao.updateStatus(promotion, "Refuser");
                response.sendRedirect("PromtionList.manager");
            }
        }else {
            response.sendRedirect("login");
        }


    }
}
