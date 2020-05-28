package maksym.web;

import maksym.db.UserDAO;
import maksym.db.entity.User;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
    private static final String EMAIL_REG_EXP ="^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    private static final String PHONE_REG_EXP = "\\d[0-9]{10}";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
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

        // TODO: 27.05.2020 add validation
        Map<String, String> errors = new HashMap<>();
        List<User> allUser = UserDAO.getInstance().getAllUsers();
        for (User u: allUser) {
            if(u.getEmail().equals(mail)){
                errors.put("mailOrigin", "An account with such email already exists");
            }
            if(u.getPhone().equals(phone)){
                errors.put("phoneOrigin", "An account with such phone number already exists");
            }
        }
        if(StringUtils.isBlank(name)){
            errors.put("name", "Provide your name");
        }
        if(StringUtils.isBlank(sur)){
            errors.put("sur", "Provide your surname");
        }
        if(StringUtils.isBlank(phone)){
            errors.put("phone", "Provide your phone number");
        }
        if(StringUtils.isBlank(mail)){
            errors.put("mail", "Provide your email");
        }
        if(StringUtils.isBlank(pass)){
            errors.put("pass", "Provide your password");
        }

        // TODO: 28.05.2020 find good email pattern
      /*  boolean foundEmail = Pattern.matches(EMAIL_REG_EXP, mail);
        if(foundEmail){
            errors.put("mailPattern", "The entered email is incorrect");
        }*/
        boolean foundPhone = Pattern.matches(PHONE_REG_EXP, phone);
        if(foundPhone){
            errors.put("phonePattern", "The entered phone number is incorrect");
        }

        if (!errors.isEmpty()) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("Registration.jsp");
            request.setAttribute("errors", errors);
            dispatcher.forward(request, response);
            return;
        }

        User user = User.createUser(name, sur, phone, mail, pass, 0);
        try {
            UserDAO.getInstance().insertUser(user);
        } catch (Exception e) {
            response.sendRedirect("SomeWrong.html");
        }
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        response.sendRedirect("MainPage.jsp");
    }

}