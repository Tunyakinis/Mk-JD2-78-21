package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.database.HistoryDatabase;
import by.it_academy.jd2.database.UsersDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static by.it_academy.jd2.core.constants.Constants.*;

@WebServlet(name = "SendMessageServlet", urlPatterns = "/send")
public class SendMessageServlet extends HttpServlet {
    private final HistoryDatabase history = new HistoryDatabase();

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        LocalDateTime time = LocalDateTime.now();
        String messageTime = time.format(DateTimeFormatter.ofPattern("dd.MM.yyy HH:mm:ss"));
        String loginName = (String) session.getAttribute("login");
        String usr = request.getParameter(USER_NAME);
        if (UsersDatabase.getUser(usr) != null) {
            String message = request.getParameter(MESSAGE);
            history.addMessage(usr, loginName + " wrote: " + "\n"
                    + message + "   " + " | at time :" + messageTime);
            String contextPath = request.getContextPath();
            response.sendRedirect(contextPath + "/chat");
        } else {
            writer.println("Wrong username" + "\n" + "<p><a href=\"chat\">Return</a></p>");
        }
    }
}