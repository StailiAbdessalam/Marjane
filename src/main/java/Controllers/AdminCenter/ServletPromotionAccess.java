package Controllers.AdminCenter;

import Dao.AdminCenterDao;
import Dao.CategorieDao;
import Models.Categorie;
import Models.Centreadmin;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.time.Instant;
import java.util.List;

@WebServlet(name = "ServletPromotionAccess", value = "/PromotionAccess")
public class ServletPromotionAccess extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CategorieDao categorieDao = new CategorieDao();
        List allcategorie = categorieDao.getAllCategories();
        request.setAttribute("Allcategorie", allcategorie);
        request.getRequestDispatcher("./AdminCenter/Promotion.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idcentrerAdmin = (int) request.getAttribute("idcenter");
        int idCategorie = (int) request.getAttribute("idcateorie");
        int porsantage = (int) request.getAttribute("postantage");
        Instant datestart = (Instant) request.getAttribute("datestart");
        Instant datefinish = (Instant) request.getAttribute("datefinish");
        String description = (String) request.getAttribute("description");

    }
}
