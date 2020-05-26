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

@WebServlet("/EditProduct")
public class EditProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String prodId = request.getParameter("id");
        Product prod = null;
        try {
            prod = ProductDAO.getInstance().getProductForId(Integer.parseInt(prodId));
        } catch (Exception e) {
            response.sendRedirect("SomeWrong.html");
        }
        request.setAttribute("prod", prod);
        RequestDispatcher dispatcher = request.getRequestDispatcher("EditProduct.jsp");
        dispatcher.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
    	int id = Integer.parseInt(request.getParameter("id"));
    	String name = request.getParameter("name1");
        String price = request.getParameter("price");
        String description = request.getParameter("description");

        String amount = request.getParameter("amount");
        String weight = request.getParameter("weight");
        String producer = request.getParameter("producer");
        String type_id = request.getParameter("type_id");
        String age = request.getParameter("age");
        String breed = request.getParameter("breed");
        String pet_id = request.getParameter("pet_id");
        String photo_link = request.getParameter("photo_link");


        try {
            ProductDAO.getInstance().updateProduct(name, price, description, amount, weight, producer,
                    type_id, age, breed, pet_id, photo_link, id);
        } catch (Exception e) {
            response.sendRedirect("SomeWrong.html");
        }
        String direct = "AboutProduct?id="+id;
        response.sendRedirect(direct);

    }

}