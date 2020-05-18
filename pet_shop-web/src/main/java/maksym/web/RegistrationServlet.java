package maksym.web;

import maksym.db.DBManager;
import maksym.db.entity.User;
import maksym.db.entity.UserRole;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.html");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String sur = request.getParameter("surname");
        String phone = request.getParameter("mobile");
        String mail = request.getParameter("email");
        String pass = request.getParameter("pass");
        User user = User.createUser(name, sur, phone, mail, pass, 0);
        DBManager.getInstance().insertUser(user);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        response.sendRedirect("MainPage.jsp");
    }

}