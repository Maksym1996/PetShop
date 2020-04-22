package maksym.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maksym.db.DBManager;
import maksym.db.entity.User;
import maksym.db.entity.UserRole;
import maksym.photo.PhotoLinks;

/**
 * Servlet implementation class Gratitude
 */
@WebServlet("/Gratitude")
public class Gratitude extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");


        String name = request.getParameter("name");
        String sur = request.getParameter("surname");
        String phone = request.getParameter("mobile");
        String mail = request.getParameter("email");
        String pass = request.getParameter("Pass");
        DBManager.getInstance().insertUser(User.createUser(name, sur, phone, mail, pass, UserRole.USER));
        System.out.println(name + " " + " " + sur + " " + phone + " " + mail + " " + pass);
        response.getWriter().println("  <HTML>\r\n" + "      <HEAD>\r\n"
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
                + "			<img src=" + PhotoLinks.YELLOWLINE + " height=\"60\"  width=\"100%\">\r\n"
                + "			<h1 align=\"center\">Дякуємо," + name + " " + sur + ", що ви з нами :)</h1>\r\n"
                + "			<div align=\"center\">\r\n"
                + "			<img src=\"https://raw.githubusercontent.com/Maksym1996/Diplom/master/Joy.jpg\" >\r\n"
                + "			</div>\r\n"
                + "			<h1 align=\"center\"><a href=\"/petshop-web/MainPage.html\">Повернутися на головну</a></h1>\r\n"
                + "			 \r\n" + "			\r\n" + "      </BODY>\r\n" + "    </HTML>");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
