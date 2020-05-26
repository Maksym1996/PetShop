package maksym.web;

import maksym.db.ProductDAO;
import maksym.db.entity.Product;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("SearchResult")
public class SearchResultServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String requestString = request.getParameter("search");

        if(StringUtils.isBlank(requestString)){
            response.sendRedirect("ErrorSearchRequest.html");
        }else{
            List<Product> prod = null;
            try {
                prod = ProductDAO.getInstance().getProductsForSearchRequest(requestString);
            } catch (Exception e) {
                response.sendRedirect("SomeWrong.html");
            }
            if(prod == null){
                response.sendRedirect("ErrorSearchRequest.html");
            } else{
                request.setAttribute("products", prod);
                RequestDispatcher dispatcher = request.getRequestDispatcher("Catalog.jsp");
                dispatcher.forward(request, response);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}