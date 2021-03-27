package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static by.it_academy.jd2.core.constants.Constants.*;


@WebServlet(name = "LoginUserServlet", urlPatterns = "/login")

public class LoginUserServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        List<Client> usersList = (List<Client>) session.getAttribute("users");
        if (getRegisteredUser(usersList, login, password, writer) == null) {
            writer.println("<p><span style='color: red;'>User doesn't exist or Login/Password is incorrect</span></p>"
                    + "\n" + "<p><a href=\"loginPage\">Re-Login</a></p>");
        } else {
            String currentUser = getRegisteredUser(usersList, login, password, writer);
            session.setAttribute("currentUser", currentUser);
            session.setAttribute("login", login);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/homePage.jsp");
        }
    }

    public String getRegisteredUser(List<Client> usersList, String login, String password, PrintWriter writer) {
        if (usersList != null) {
            String user = "";
            for (Client u : usersList) {
                if (u.getLogin().equals(login) && u.getPassword().equals(password)) {
                    user = u.getFirstName() + " " + u.getMiddleName();
                    return user;
                }
            }
        } else {
            writer.println("No Data found, register any user"
                    + "\n" + "<p><a href=\"addUser\">Register</a></p>");
        }
        return null;
    }
}
