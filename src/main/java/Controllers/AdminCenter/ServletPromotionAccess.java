package Controllers.AdminCenter;

import Dao.AdminCenterDao;
import Dao.CategorieDao;
import Dao.ManagerDao;
import Dao.PromotionDao;
import Models.Categorie;
import Models.Centreadmin;
import Models.Manager;
import Models.Promotion;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.List;

@WebServlet(name = "ServletPromotionAccess", value = "/PromotionAccess")
public class ServletPromotionAccess extends HttpServlet {
    private PromotionDao promotionDao;
    @Override
    public void init() throws ServletException {
        promotionDao   = new PromotionDao();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("idcenteradmin")!=null) {
            CategorieDao categorieDao = new CategorieDao();
            List allcategorie = categorieDao.getAllCategories();
            request.setAttribute("Allcategorie", allcategorie);
            Integer id = (Integer) session.getAttribute("id");
            request.setAttribute("AllPromotion", promotionDao.getAllPromotionByIdAdminCenter(Long.valueOf(id)));
            request.getRequestDispatcher("./AdminCenter/Promotion.jsp").forward(request, response);
        }else {
            response.sendRedirect("login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("idcenteradmin")!=null) {
            Integer idcentrerAdmin = Integer.valueOf(request.getParameter("idcenter"));
            Integer idCategorie = Integer.valueOf(request.getParameter("idcateorie"));
            Integer porsantage = Integer.valueOf(request.getParameter("postantage"));
            String datedebut = request.getParameter("datestart");
            String datefinish = request.getParameter("datefinish");
            String description = request.getParameter("description");
            Centreadmin centerAdmin = new AdminCenterDao().getadmincenterbyid(idcentrerAdmin);
            Categorie categorie = new CategorieDao().getCategoryById(idCategorie);
            promotionDao.createPromotion(new Promotion(Instant.now(), porsantage, "Pending", categorie, centerAdmin, datedebut, description, datefinish));
            response.sendRedirect("/PromotionAccess");
        }else {
            response.sendRedirect("login");
        }
    }



    }
