package maksym.web;

import maksym.db.UserDAO;
import maksym.db.entity.User;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

            forwardPage = "Profile.jsp";
        } else if (session == null || session.getAttribute("user") == null) {
               forwardPage = "Profile.jsp";
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
        User user = UserDAO.getInstance().getUserForEmail(email);
        Map<String, String> errors = new HashMap<>();

        if (user == null) {
            errors.put("error", "Entered Login or Password is incorrectly");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");
            request.setAttribute("errors", errors);
            dispatcher.forward(request, response);
            return;
        }
        if (!Objects.equals(user.getPass(), pass)) {
            errors.put("error", "Entered Login or Password is incorrectly");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Profile.jsp");
            request.setAttribute("errors", errors);
            dispatcher.forward(request, response);
            return;
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserProfile.jsp");
        dispatcher.forward(request, response);
        
    }

}