package maksym.web;

import maksym.db.DBManager;
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

@WebServlet("/SuccessBuy")
public class SuccessBuy extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        Order order = new Order();
        User user = (User)session.getAttribute("user");
        order.setUser_id(user.getId());
        Basket basket = (Basket)session.getAttribute("basket");
        DBManager manager = DBManager.getInstance();

        for (Product prod: basket.getProducts()) {
            manager.updateProductAmount(prod, 1);
            order.setProdut_id(prod.getId());
            order.setCount_product(1);
            manager.insertOrder(order);
        }

        response.sendRedirect("Gratitute.html");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}