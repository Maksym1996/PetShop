package maksym.web;

import maksym.db.OrderDAO;
import maksym.db.entity.Basket;
import maksym.db.entity.Order;
import maksym.db.entity.Product;
import maksym.db.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/BuyOneProduct")
public class BuyOneProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int  count = Integer.parseInt(request.getParameter("quantity"));
        HttpSession session = request.getSession();
        Order order = new Order();
        User user = (User)session.getAttribute("user");

        int prodID = Integer.parseInt(request.getParameter("id"));

        order.setUser_id(user.getId());
        order.setProdut_id(prodID);
        order.setCount_product(count);
        try {
            OrderDAO.getInstance().insertOrder(order);
        } catch (Exception e) {
            response.sendRedirect("SomeWrong.html");
        }
        Basket   basket = (Basket)session.getAttribute("basket");
        List<Product> products = basket.getProducts();
        for(Product p : products) {
            if (p.getId() == prodID){
                products.remove(p);
                break;
            }
        }

        if (basket == null || products.isEmpty()) {
                      response.sendRedirect("Gratitude.html");
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