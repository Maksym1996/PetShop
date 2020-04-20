package maksym.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import maksym.db.DBManager;
import maksym.db.TypeProduct;
import maksym.db.entity.Product;
import maksym.db.entity.User;
import maksym.photo.PhotoLinks;


/**
 * Servlet implementation class OurProducts
 */
@WebServlet("/OurProducts")
public class OurProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OurProducts() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		int pet = Integer.parseInt(request.getParameter("pet"));
		List<Product> prod = new ArrayList<>();
		
		prod = DBManager.getInstance().getProductsForPetId(pet);
		
		
		StringBuffer allPart = new StringBuffer();
		allPart.append("<HTML>\r\n" + 
				"      <HEAD>\r\n" + 
				"        <TITLE >Продукти для тварин</TITLE>\r\n" + 
				"         <META HTTP-EQUIV=\"CONTENT-TYPE\" CONTENT=\"text/html; charset=UTF-8\">\r\n" + 
				"		 <META HTTP-EQUIV=\"CONTENT-LANGUAGE\" CONTENT=\"uk-UK\">\r\n" + 
				"		 <META NAME=\"DESCRIPTION\" CONTENT=\"Онлайн-магазин для домашніх тварин\">\r\n" + 
				"		 <META NAME=\"KEYWORDS\" CONTENT=\"Онлайн-магазин, товар, домашние, животные, собака, кот, кошка, рыба, кролик, попугай, хомяк, крыса, шиншила\">\r\n" + 
				"		 <META NAME=\"DOCUMENT-STATE\" CONTENT=\"STATIC\">\r\n" + 
				"		 <META NAME=\"RESOURCE-TYPE\" CONTENT=\"DOCUMENT\">\r\n" + 
				"		 <LINK rel=\"stylesheet\" href=\"MainPageStyle.css\">\r\n" + 
				"<Style>.sign figcaption {\r\n" + 
				"    margin: 0 auto 5px; /* Отступы вокруг абзаца */\r\n" + 
				"   }</Style>" +
				"      </HEAD>\r\n" + 
				"      <BODY>\r\n" + 
				"			<div class=\"block\">\r\n"
				+ "			<a href=\"/pet_shop-web/MainPage.html\"><img align = \"left\" src="
				+ PhotoLinks.SWEETYPET + " height=\"200\"  width=\"350\"></a>			\r\n" + "			</div >\r\n"
				+ "			\r\n" +

				"			<a href=\"https://www.purina-felix.com.ua/\"><img align =\"right\" src="
				+ PhotoLinks.ADVERTISING + " height=\"250\"  width=\"500\"></a>\r\n" + "			</p>\r\n"
				+ "			<img src=" + PhotoLinks.YELLOWLINE + " height=\"60\"  width=\"100%\">\r\n" +
				"<div align = \"center\"><font size+=10><b> Доступний Товар</b></font></div>" +
	 
				"			<table border n=3>\r\n" + 
				"				<tr>\r\n");
		
					for(Product p: prod ) {
										
									
						allPart.append("<td>\r\n" + 
				"						 <figure class=\"sign\">"
				+ "<img src=" + p.getPhoto_link() + "height=\"150\"\r\n" + 
						"			width=\"150\"> </figure>\r\n" + 
				"						<br><p> " + p.getName() +", " + p.getWeight() + "гр.\r\n" + 
				"						</p>\r\n" + 
				"						<p>	\r\n" + 
				"						<form action=\"Prod\" method=\"GET\"> \r\n" +
										     "<input type = \"hidden\" name = \"id\" value =" +p.getId()+ ">" +
				"							\r\n" + 
				"							\r\n" + 
				"							<font size=+2 color=green>" + p.getPrice() + " ГРН</font> <input type=\"submit\" value=\"Переглянути\" />   \r\n" + 
				"								</form>  \r\n" + 
				"						</p>\r\n" + 
				"					</td>\r\n" 
								
									
				);
				}
					allPart.append("				</tr>\r\n" + 
							"			</table>\r\n" + 
							"			\r\n" + 
							"      </BODY>\r\n" + 
							"    </HTML>" );
					
					response.getWriter().println(allPart.toString());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
