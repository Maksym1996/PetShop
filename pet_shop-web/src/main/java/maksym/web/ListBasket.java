package maksym.web;

import maksym.db.entity.Basket;
import maksym.db.entity.Product;
import maksym.photo.PhotoLinks;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/ListBasket", name = "ListBasket")
public class ListBasket extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        Basket basket = (Basket) session.getAttribute("basket");
        StringBuffer result = new StringBuffer();
        if (basket == null) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Basket.html");
            dispatcher.forward(request, response);
            return;
        }

        result.append(" <HTML>\r\n" + "      <HEAD>\r\n" + "        <TITLE>Мій кошик</TITLE>\r\n"
                + "        <META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=UTF-8\">\r\n"
                + "		<META HTTP-EQUIV=\"CONTENT-LANGUAGE\" CONTENT=\"uk-UK\">\r\n"
                + "		<LINK rel=\"stylesheet\" href=\"MainPageStyle.css\">\r\n" + "      </HEAD>\r\n"
                + "      <BODY>\r\n" + "<div class=\"block\">\r\n"
                + "			<a href=\"/pet_shop-web/MainPage.html\"><img align = \"left\" src="
                + PhotoLinks.SWEETYPET + " height=\"200\"  width=\"350\"></a>			\r\n" + "			</div >\r\n"
                + "			\r\n" +

                "			<a href=\"https://www.purina-felix.com.ua/\"><img align =\"right\" src="
                + PhotoLinks.ADVERTISING + " height=\"250\"  width=\"500\"></a>\r\n" + "			</p>\r\n"
                + "			<img src=" + PhotoLinks.YELLOWLINE + " height=\"60\"  width=\"100%\">\r\n");

        /*
         * result.append("<p align=\"center\">\r\n" + "				<font size=+2>\r\n"
         * + "					Зараз ваш кошик пустий:( \r\n" +
         * "					<br>\r\n" +
         * "					Перейдіть за будь-якою категорією на вибір та оберіть бажаний товар\r\n"
         * + "				</font>\r\n" + "				<br> <br>\r\n" +
         * "				<img  src=\"Photo/Грустный кот.jpg\" >\r\n" +
         * "			</p>\r\n" + "			\r\n" + "			\r\n" +
         * "      </BODY>\r\n" + "    </HTML>");
         */
        result.append("<br><br><br><br><br><div align=\"left\"><font size+=20 ><b>Обраний вами товар:</b></font></div>"
                + "<table><tr>\r\n");
        for (Product prod : basket.getProducts()) {
            result.append(" <td><figure class=\"sign\">" + "<img src="
                    + prod.getPhoto_link() + "height=\"150\"\r\n" + "			width=\"150\"> </figure>\r\n"
                    + "						<br><p> " + prod.getName() + ", " + prod.getWeight() + "гр.\r\n"
                    + "						</p>\r\n" + "						<p>	\r\n"
                    + "						 \r\n"
                    + "<font size=+2 color=green>" + prod.getPrice()
                    + " ГРН</font>   \r\n"
                    + "	</p>\r\n"
                    + "					</td>");
        }

        result.append("</tr></table>\r\n" +
                "<form action=\"OurProducts\">\n" +
                "        <button type=\"submit\">Показати товар</button> </BODY> </HTML>");
        response.getWriter().append(result.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}