package maksym.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maksym.db.ProductDAO;
import maksym.db.entity.Product;

/**
 * Servlet implementation class AboutProduct
 */
@WebServlet("/AboutProduct")
public class AboutProductServlet extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int prodID = Integer.parseInt(request.getParameter("id"));

        Product prod = null;

            prod = ProductDAO.getInstance().getProductForId(prodID);

        String breed;
        if (prod.getBreed() != null) {
            breed = prod.getBreed();
        } else {
            breed = "None";
        }

        request.setAttribute("prod", prod);
         request.setAttribute("breed", breed);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("AboutProduct.jsp");
        dispatcher.forward(request, response);
     
        
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
