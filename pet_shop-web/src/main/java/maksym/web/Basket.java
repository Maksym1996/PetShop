package maksym.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maksym.db.DBManager;
import maksym.db.entity.Product;
import maksym.photo.PhotoLinks;

/**
 * Servlet implementation class Basket
 */
@WebServlet("/Basket")
public class Basket extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Basket() {
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
		int id = Integer.parseInt(request.getParameter("id"));

		Product prod = DBManager.getInstance().getProductForId(id);
		StringBuffer result = new StringBuffer();

		result.append(" <HTML>\r\n" + "      <HEAD>\r\n" + "        <TITLE>̳� �����</TITLE>\r\n"
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
		 * + "					����� ��� ����� ������:( \r\n" +
		 * "					<br>\r\n" +
		 * "					�������� �� ����-���� �������� �� ���� �� ������ ������� �����\r\n"
		 * + "				</font>\r\n" + "				<br> <br>\r\n" +
		 * "				<img  src=\"Photo/�������� ���.jpg\" >\r\n" +
		 * "			</p>\r\n" + "			\r\n" + "			\r\n" +
		 * "      </BODY>\r\n" + "    </HTML>");
		 */
		result.append("<br><br><br><br><br><div align=\"left\"><font size+=20 ><b>������� ���� �����:</b></font></div>"
				+ "<table><tr><td>\r\n" + "						 <figure class=\"sign\">" + "<img src="
				+ prod.getPhoto_link() + "height=\"150\"\r\n" + "			width=\"150\"> </figure>\r\n"
				+ "						<br><p> " + prod.getName() + ", " + prod.getWeight() + "��.\r\n"
				+ "						</p>\r\n" + "						<p>	\r\n"
				+ "						<form action=\"/pet_shop-web/Gratitute.html\" > \r\n"
				+ "<font size=+2 color=green>" + prod.getPrice()
				+ " ���</font> <input type=\"submit\" value=\"������\" />   \r\n"
				+ "								</form>  \r\n" + "						</p>\r\n"
				+ "					</td></tr></table>\r\n");
		response.getWriter().append(result.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
