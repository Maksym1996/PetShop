package maksym.web;

import maksym.db.OrderDAO;
import maksym.db.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/SuccessBuy")
public class SuccessBuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        HttpSession session = request.getSession();
        Order order = new Order();
        User user = (User)session.getAttribute("user");
        order.setUser_id(user.getId());
        Basket basket = (Basket)session.getAttribute("basket");


       /* ListOrders listOrders = (ListOrders) session.getAttribute("order");

        if (listOrders == null) {
            listOrders = new ListOrders();
            session.setAttribute("order", listOrders);
        }

        List<Order> orders = listOrders.getOrders();*/




        for (Product prod: basket.getProducts()) {
            //manager.updateProductAmount(prod, 1);
            order.setProdut_id(prod.getId());
            order.setCount_product(1);
            OrderDAO.getInstance().insertOrder(order);

            // orders.add(order);

        }
        session.removeAttribute("basket");
        response.sendRedirect("Gratitude.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}