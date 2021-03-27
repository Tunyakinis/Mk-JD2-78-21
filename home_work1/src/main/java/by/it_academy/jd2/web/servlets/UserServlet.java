package by.it_academy.jd2.web.servlets;

import by.it_academy.jd2.core.dto.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import static by.it_academy.jd2.core.constants.Constants.*;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String header = request.getHeader(DATA_TYPE);
        User user = new User("", "", "");
        String[] headerValues = request.getParameterMap().get(header);
        if (headerValues != null) {
            for (String value : headerValues) {
                if (value.equals(COOKIE)) {
                    String firstNameValue = getCookiesValue(request, FIRST_NAME);
                    saveCookie(response, FIRST_NAME, firstNameValue);
                    String lastNameValue = getCookiesValue(request, LAST_NAME);
                    saveCookie(response, LAST_NAME, lastNameValue);
                    String ageValue = getCookiesValue(request, AGE);
                    saveCookie(response, AGE, ageValue);
                    writer.println("Take from Cookies" + "</br>" + user);
                } else if (value.equals(SESSION)) {
                    String firstNameValue = getSessionsValue(request, FIRST_NAME);
                    saveSession(request, FIRST_NAME, firstNameValue);
                    String lastNameValue = getSessionsValue(request, LAST_NAME);
                    saveSession(request, LAST_NAME, lastNameValue);
                    String ageValue = getSessionsValue(request, AGE);
                    saveSession(request, AGE, ageValue);
                    writer.println("Take from Session" + "</br>" + user);
                }
            }
        } else {
            throw new IllegalArgumentException("Error, please set type: cookie or session");
        }
    }

    public static String getCookiesValue(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (value == null) {
            Cookie[] cookie = request.getCookies();
            if (cookie != null) {
                value = Arrays.stream(cookie)
                        .filter(c -> key.equalsIgnoreCase(c.getName()))
                        .map(Cookie::getValue)
                        .findFirst()
                        .orElse(null);
            }
        }
        if (value == null) {
            throw new IllegalArgumentException("No Data found in cookies");
        }
        return value;
    }

    public static void saveCookie(HttpServletResponse response, String key, String value){
        Cookie cookie = new Cookie(key, URLEncoder.encode(value, StandardCharsets.UTF_8));
        cookie.setMaxAge(Math.toIntExact(TimeUnit.DAYS.toSeconds(3)));
        response.addCookie(cookie);
    }

    public static String getSessionsValue(HttpServletRequest request, String key) {
        String value = request.getParameter(key);
        if (value == null) {
            HttpSession session = request.getSession();
            if (!session.isNew()) {
                value = (String) session.getAttribute(key);
            }
        }
        if (value == null) {
            throw new IllegalArgumentException("No Data found in session");
        }
        return value;
    }

    public static void saveSession(HttpServletRequest request, String key, String value){
     HttpSession session = request.getSession();
     session.setAttribute(key, value);
    }
}
