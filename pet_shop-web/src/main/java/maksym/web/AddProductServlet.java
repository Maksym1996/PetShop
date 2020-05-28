package maksym.web;

import maksym.db.ProductDAO;
import maksym.db.UserDAO;
import maksym.db.entity.Product;
import maksym.db.entity.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@WebServlet("/AddProduct")
public class AddProductServlet extends HttpServlet {
    private static final String NUMBER_REG_EXP = "/d[0-9]+";
    private static final String ONE_NUM_REG_EXP = "/d[0-9]";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.jsp");
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
        String type_id = request.getParameter("type_id");
        String age = request.getParameter("age");
        String breed = request.getParameter("breed");
        String pet_id = request.getParameter("pet_id");
        String photo_link = request.getParameter("photo_link");

        Map<String, String> errors = new HashMap<>();
        List<Product> allProd = ProductDAO.getInstance().getAllProducts();
        for (Product p:allProd) {
            if(p.getName().equals(name)&& p.getWeight().equals(weight)) {
                errors.put("prodOrigin","Such a product already exists");
            }

        }

        if(StringUtils.isBlank(name)){
            errors.put("name", "Provide name product");
        }
        if(StringUtils.isBlank(price)){
            errors.put("price", "Provide price product");
        }
        if(StringUtils.isBlank(description)){
            errors.put("description", "Provide description product");
        }
        if(StringUtils.isBlank(amount)){
            errors.put("amount", "Provide amount product");
        }
        if(StringUtils.isBlank(weight)){
            errors.put("weight", "Provide weight product");
        }
        if(StringUtils.isBlank(producer)){
            errors.put("producer", "Provide producer product");
        }
        if(StringUtils.isBlank(type_id)){
            errors.put("type_id", "Provide type product");
        }
        if(StringUtils.isBlank(age)){
            errors.put("age", "Provide age ");
        }
        if(StringUtils.isBlank(breed)){
            errors.put("breed", "Provide breed ");
        }
        if(StringUtils.isBlank(pet_id)){
            errors.put("pet_id", "Provide pet_id product");
        }
        if(StringUtils.isBlank(photo_link)){
            errors.put("photo_link", "Provide photo link product");
        }

        boolean foundPrice = Pattern.matches(NUMBER_REG_EXP, price);
        if(foundPrice){
            errors.put("pricePattern", "The entered price is incorrect");
        }
        boolean foundAmount = Pattern.matches(NUMBER_REG_EXP, amount);
        if(foundAmount){
            errors.put("amountPattern", "The entered amount is incorrect");
        }
        boolean foundWeight = Pattern.matches(NUMBER_REG_EXP, weight);
        if(foundWeight){
            errors.put("weightPattern", "The entered weight is incorrect");
        }
        boolean foundPet_id = Pattern.matches(ONE_NUM_REG_EXP, pet_id);
        if(foundPet_id){
            errors.put("pet_idPattern", "The entered pet_id is incorrect");
        }
        boolean foundType_id = Pattern.matches(ONE_NUM_REG_EXP, type_id);
        if(foundType_id){
            errors.put("type_idPattern", "The entered type_id is incorrect");
        }

        if (!errors.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("AddProduct.jsp");
            request.setAttribute("errors", errors);
            dispatcher.forward(request, response);
            return;
        }




        Product prod = Product.createProduct(name, price, description, amount, weight, producer,
                Integer.parseInt(type_id), age, breed, Integer.parseInt(pet_id), photo_link);

            ProductDAO.getInstance().insertProduct(prod);

        String direct = "Catalog?pet="+ type_id;
        response.sendRedirect(direct);
    }

}