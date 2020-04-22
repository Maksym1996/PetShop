package maksym.web;

import maksym.db.DBManager;
import maksym.db.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

import static maksym.db.entity.UserRole.ADMIN;

@WebServlet("/Profile")
public class Profile extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String forwardPage;
        if (session == null || session.getAttribute("user") == null) {
            forwardPage = "Profile.html";
        } else {
            User user = (User)session.getAttribute("user");
            if(user.getRole() == ADMIN){
                forwardPage = "AdminProfile.html";
            }else{
                forwardPage = "UserProfile.html";
            }
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
            response.sendRedirect("Profile");
            return;
        }
        if (!Objects.equals(user.getPass(), pass)) {
            response.sendRedirect("Profile");
            return;
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        RequestDispatcher dispatcher = request.getRequestDispatcher("UserProfile.html");
        dispatcher.forward(request, response);
    }

}