package maksym.web;

import maksym.db.DBManager;
import maksym.db.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Objects;

import static maksym.db.entity.UserRole.ADMIN;

@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String forwardPage;
        String logout = request.getParameter("logout");

        if("logout".equals(logout)) {

           session.invalidate();

            forwardPage = "Profile.html";
        } else if (session == null || session.getAttribute("user") == null) {
               forwardPage = "Profile.html";
        } else {
               User user = (User) session.getAttribute("user");
               session.setAttribute("role", user.getRole());
               forwardPage = "UserProfile.jsp";

           }

        RequestDispatcher dispatcher = request.getRequestDispatcher(forwardPage);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        User user = DBManager.getInstance().getUserForEmail(email);
        if (user == null) {
            response.sendRedirect("Profile.html");
            return;
        }
        if (!Objects.equals(user.getPass(), pass)) {
            response.sendRedirect("Profile.html");
            return;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        response.sendRedirect("UserProfile.jsp");
        
    }

}