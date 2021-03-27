package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.Client;
import by.it_academy.jd2.database.UsersDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import java.io.IOException;
import java.io.PrintWriter;

import static by.it_academy.jd2.core.constants.Constants.*;

@WebServlet(name = "AddNewUser", urlPatterns = "/signUp")

public class AddNewUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        Client user = new Client("", "", "", "", "", "");
        HttpSession session = request.getSession();
        user.setFirstName(getValueFromSession(request, FIRST_NAME));
        user.setLastName(getValueFromSession(request, LAST_NAME));
        user.setMiddleName(getValueFromSession(request, MIDDLE_NAME));
        user.setDateOfBirth(getValueFromSession(request, DATE_BIRTH));
        if (!request.getParameter(LOGIN).equals(session.getAttribute(LOGIN))) {
            user.setLogin(getValueFromSession(request, LOGIN));
            user.setPassword(getValueFromSession(request, PASSWORD));
        } else {
            throw new IllegalArgumentException("User: " + request.getParameter(LOGIN) + " already exists");
        }
        UsersDatabase.addUser(user);
        session.setAttribute("users", UsersDatabase.getUserList());
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath + "/signIn.jsp");
    }

    public static String getValueFromSession(HttpServletRequest request, String parameter) {
        String value = request.getParameter(parameter);
        HttpSession session = request.getSession();
        if (value.isEmpty()) {
            if (!session.isNew()) {
                value = (String) session.getAttribute(parameter);
            }
        } else {
            session.setAttribute(parameter, value);
        }
        if (value == null) {
            throw new IllegalArgumentException("Fill in parameters");
        }
        return value;
    }
}
