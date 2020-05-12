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


/**
 * Servlet implementation class Catalog
 */
@WebServlet("/Catalog")
public class CatalogServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        int pet = Integer.parseInt(request.getParameter("pet"));
        List<Product> prod = new ArrayList<>();

        prod = DBManager.getInstance().getProductsForPetId(pet);
        request.setAttribute("products", prod);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Catalog.jsp");
        dispatcher.forward(request, response);
        
   
        
        
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
