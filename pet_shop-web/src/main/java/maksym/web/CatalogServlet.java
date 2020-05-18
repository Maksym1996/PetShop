package maksym.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maksym.db.DBManager;
import maksym.db.TypeProduct;
import maksym.db.entity.Product;
import maksym.db.entity.User;
import maksym.photo.PhotoLinks;
import org.apache.commons.lang3.StringUtils;


/**
 * Servlet implementation class Catalog
 */
@WebServlet("/Catalog")
public class CatalogServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String petString = request.getParameter("pet");
        String typeString = request.getParameter("type_product");
        /*if (StringUtils.isBlank(petString)) {
            // TODO: 16.05.2020 redirect to error page
            return;
        }*/

        int pet = Integer.parseInt(petString);
        List<Product> prod;
       if (StringUtils.isNotBlank(typeString)) {
           int type = Integer.parseInt(typeString);
           prod = DBManager.getInstance().getProductsForTypeAndPetId(pet, type);
           request.setAttribute("products", prod);
           RequestDispatcher dispatcher = request.getRequestDispatcher("Catalog.jsp");
           dispatcher.forward(request, response);


        } else {
           prod = DBManager.getInstance().getProductsForPetId(pet);
           request.setAttribute("products", prod);
           RequestDispatcher dispatcher = request.getRequestDispatcher("Catalog.jsp");
           dispatcher.forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
