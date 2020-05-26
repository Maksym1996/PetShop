package maksym.web;

import maksym.db.ProductDAO;
import maksym.db.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.html");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String description = request.getParameter("description");
        String amount = request.getParameter("amount");
        String weight = request.getParameter("weight");
        String producer = request.getParameter("producer");
        int type_id = Integer.parseInt(request.getParameter("type_id"));
        String age = request.getParameter("age");
        String breed = request.getParameter("breed");
        int pet_id = Integer.parseInt(request.getParameter("pet_id"));
        String photo_link = request.getParameter("photo_link");

        Product prod = Product.createProduct(name, price, description, amount, weight, producer,
                type_id, age, breed, pet_id, photo_link);
        try {
            ProductDAO.getInstance().insertProduct(prod);
        } catch (Exception e) {
            response.sendRedirect("SomeWrong.html");
        }
        String direct = "Catalog?pet="+ type_id;
        response.sendRedirect(direct);
    }

}