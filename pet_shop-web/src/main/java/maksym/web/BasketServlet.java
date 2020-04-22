package maksym.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import maksym.db.DBManager;
import maksym.db.entity.Basket;
import maksym.db.entity.Product;

/**
 * Servlet implementation class Basket
 */
@WebServlet("/Basket")
public class BasketServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        Product prod = DBManager.getInstance().getProductForId(id);

        HttpSession session = request.getSession(true);
        Basket basket =  (Basket)session.getAttribute("basket");
        if(basket==null){
            basket = new Basket();
            session.setAttribute("basket", basket);
        }
        List<Product> products = basket.getProducts();
        products.add(prod);
        response.sendRedirect("OurProducts?pet="+ prod.getPet_id()) ;
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }

}
