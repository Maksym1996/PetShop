package maksym.web;

import maksym.db.DBManager;
import maksym.db.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String prodId = request.getParameter("id");
        Product prod = DBManager.getInstance().getProductForId((Integer.parseInt(prodId)));
        request.setAttribute("prod", prod);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditProduct.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    }

}