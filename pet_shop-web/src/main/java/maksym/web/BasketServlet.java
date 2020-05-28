package maksym.web;

import maksym.db.entity.Basket;
import maksym.db.entity.Product;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/basket", name = "BasketServlet")
public class BasketServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");

        if (basket == null ) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("BasketEmpty.jsp");
            dispatcher.forward(request, response);
            return;
        }

        List<Product> products = basket.getProducts();
        String idString = request.getParameter("id");
        if(StringUtils.isNotBlank(idString)){
            int id = Integer.parseInt(idString);
            for(Product p : products) {
               if (p.getId() == id){
                   products.remove(p);
                   break;
               }
           }

        }

        if (basket == null || products.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("BasketEmpty.jsp");
            dispatcher.forward(request, response);
            return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("Basket.jsp");
        dispatcher.forward(request, response);

      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}