package maksym.web;

import maksym.db.entity.User;
import maksym.photo.PhotoLinks;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        StringBuffer result = new StringBuffer();
        result.append("  <HTML>\r\n" + "      <HEAD>\r\n"
                + "        <TITLE >Дякуємо за реєстрацію</TITLE>\r\n"
                + "         <META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=UTF-8\">\r\n"
                + "		 <META HTTP-EQUIV=\"CONTENT-LANGUAGE\" CONTENT=\"uk-UK\">\r\n"
                + "		 <META NAME=\"DESCRIPTION\" CONTENT=\"Онлайн-магазин для домашніх тварин\">\r\n"
                + "		 <META NAME=\"KEYWORDS\" CONTENT=\"Онлайн-магазин, товар, домашние, животные, собака, кот, кошка, рыба, кролик, попугай, хомяк, крыса, шиншила\">\r\n"
                + "		 <META NAME=\"DOCUMENT-STATE\" CONTENT=\"STATIC\">\r\n"
                + "		 <META NAME=\"RESOURCE-TYPE\" CONTENT=\"DOCUMENT\">\r\n"
                + "		 <LINK rel=\"stylesheet\" href=\"MainPageStyle.css\">\r\n" + "      </HEAD>\r\n"
                + "      <BODY >\r\n" + "<div class=\"block\">\r\n"
                + "			<a href=\"/pet_shop-web/MainPage.html\"><img align = \"left\" src="
                + PhotoLinks.SWEETYPET + " height=\"200\"  width=\"350\"></a>			\r\n" + "			</div >\r\n"
                + "			\r\n" +

                "			<a href=\"https://www.purina-felix.com.ua/\"><img align =\"right\" src="
                + PhotoLinks.ADVERTISING + " height=\"250\"  width=\"500\"></a>\r\n" + "			</p>\r\n"
                + "			<img src=" + PhotoLinks.YELLOWLINE + " height=\"60\"  width=\"100%\">\r\n");
        result.append("<h1>Ваш Профіль</h1> " +
                "<div aling = \"center\">" +
                "<p>Ім'я</p><p>"+ user.getName() + "</p>" +
                "<p>Фамілія</p><p>" + user.getSurname() + "</p>" +
                "<p>Телефон</p><p>" + user.getPhone() + "</p>" +
                "<p>Електронна пошта</p><p>" + user.getEmail() + "</p>" +
                "<p> <form  action=\"MainPage.html\">\n" +
                "<button type=\"submit\">Повернутися на головну</button></p>"+
                "</div>");
        result.append("		 \r\n" + "			\r\n" + "      </BODY>\r\n" + "    </HTML>");
        response.getWriter().append(result.toString());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}