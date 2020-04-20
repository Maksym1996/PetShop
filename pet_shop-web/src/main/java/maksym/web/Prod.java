package maksym.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maksym.db.DBManager;
import maksym.db.TypeProduct;
import maksym.db.entity.Product;
import maksym.photo.PhotoLinks;

/**
 * Servlet implementation class Prod
 */
@WebServlet("/Prod")
public class Prod extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Prod() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int prodID = Integer.parseInt(request.getParameter("id"));

		Product prod = DBManager.getInstance().getProductForId(prodID);
		StringBuffer result = new StringBuffer();

		result.append("<HTML>\r\n" + "      <HEAD>\r\n" + "        <TITLE >" + prod.getName() + "</TITLE>");
		result.append("<META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=UTF-8\">\r\n"
				+ "		 <META HTTP-EQUIV=\"CONTENT-LANGUAGE\" CONTENT=\"uk-UK\">\r\n"
				+ "		 <META NAME=\"DESCRIPTION\" CONTENT=\"Онлайн-магазин для домашніх тварин\">\r\n"
				+ "		 <META NAME=\"KEYWORDS\" CONTENT=\"Онлайн-магазин, товар, домашние, животные, собака, кот, кошка, рыба, кролик, попугай, хомяк, крыса, шиншила\">\r\n"
				+ "		 <META NAME=\"DOCUMENT-STATE\" CONTENT=\"STATIC\">\r\n"
				+ "		 <META NAME=\"RESOURCE-TYPE\" CONTENT=\"DOCUMENT\">\r\n"
				+ "		 <LINK rel=\"stylesheet\" href=\"MainPageStyle.css\">\r\n"
				+ "        <Style>.sign figcaption {\r\n"
				+ "    		margin: 0 auto 5px; /* Отступы вокруг абзаца */\r\n" + "   			}" + "</Style> "
				+ "      </HEAD>\r\n" + "      <BODY>\r\n" + "			" + "<div class=\"block\">\r\n"
				+ "			<a href=\"/pet_shop-web/MainPage.html\"><img align = \"left\" src="
				+ PhotoLinks.SWEETYPET + " height=\"200\"  width=\"350\"></a>			\r\n" + "			</div >\r\n"
				+ "			\r\n" +

				"			<a href=\"https://www.purina-felix.com.ua/\"><img align =\"right\" src="
				+ PhotoLinks.ADVERTISING + " height=\"250\"  width=\"500\"></a>\r\n" + "			</p>\r\n"
				+ "			<img src=" + PhotoLinks.YELLOWLINE + " height=\"60\"  width=\"100%\">\r\n");

		String breed;
		TypeProduct typeProduct = TypeProduct.fromId(prod.getType_id());
		String type;
		if (typeProduct != null) {
			type = typeProduct.getName();
		} else {
			type = "-";
		}

		if (prod.getBreed() != null) {
			breed = prod.getBreed();
		} else {
			breed = "-";
		}
		result.append("<h1 align=\"center\">" + prod.getName() + "</h1>\r\n" + "			<table border=0><tr>\r\n"
				+ "				<td><figure class=\"sign\">" + "				<img src=" + prod.getPhoto_link()
				+ "				height = \"300\" width =\"200\" >\r\n" + "</figure></td>" + "				\r\n"
				+ "				<td><h3>Характеристики</h3>\r\n" + "	<table border n=4>\r\n"
				+ "				<tr>\r\n" + "					<td>Вага товару</td>\r\n"
				+ "					<td><p align=\"right\">" + prod.getWeight() + "</p></td>\r\n"
				+ "				</tr>\r\n" + "				<tr>\r\n" + "					<td>Вік</td>\r\n"
				+ "					<td><p align=\"right\">" + prod.getAge() + "</p></td>\r\n"
				+ "				</tr>\r\n" + "				<tr>\r\n" + "					<td>Виробник</td>\r\n"
				+ "					<td><p align=\"right\">" + prod.getProducer() + "</p></td>\r\n"
				+ "				</tr>\r\n" + "				<tr>\r\n" + "					<td>Тип корму</td>\r\n"
				+ "					<td><p align=\"right\">" + type + "</p></td>\r\n" + "				</tr>\r\n"
				+ "				<tr>\r\n" + "					<td>Порода</td>\r\n"
				+ "					<td><p align=\"right\">" + breed + "</p></td>\r\n" + "				</tr>\r\n"
				+ "				\r\n" + "			</table>");

		result.append("<br>\r\n" + "<form action=\"Basket\" method = \"GET\" >\r\n"
				+ "<input type = \"hidden\" name = \"id\" value =" + prod.getId() + ">"
				+ "	<button type=\"submit\">Додати до кошика</button></td></tr><table>\r\n"
				+ "			<br><br><br>\r\n" + "			<h3 align=\"left\">Описання товару</h3>\r\n"
				+ "				\r\n" + prod.getDescription() + "				\r\n" + "			\r\n"
				+ "      </BODY>\r\n" + "    </HTML>");
		response.getWriter().append(result.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
