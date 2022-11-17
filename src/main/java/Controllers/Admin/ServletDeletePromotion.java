package Controllers.Admin;

import Dao.ManagerDao;
import Dao.PromotionDao;
import Models.Manager;
import Models.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletDeletePromotion", value = "/DeletePromotion")
public class ServletDeletePromotion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long idpromotion = Long.valueOf(request.getParameter("idpromotion"));
        PromotionDao promotionDao = new PromotionDao();
        Promotion promotiondeleted = promotionDao.getpromotionById(idpromotion);
        promotionDao.delete(promotiondeleted);
    }
}
