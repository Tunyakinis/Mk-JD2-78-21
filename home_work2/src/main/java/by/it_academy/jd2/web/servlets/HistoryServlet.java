package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.database.HistoryDatabase;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet(name = "HistoryServlet", urlPatterns = "/history")
public class HistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        LocalDateTime time = LocalDateTime.now();
        List<String> checkHistory = HistoryDatabase.getUserHistory((String) session.getAttribute("login"));
        HistoryDatabase.getListOfMessages(checkHistory, writer);
    }
}
