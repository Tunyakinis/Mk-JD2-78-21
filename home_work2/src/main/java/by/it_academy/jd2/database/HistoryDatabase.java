package by.it_academy.jd2.database;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HistoryDatabase {
    private static final Map<String, List<String>> history = new HashMap<>();

    public void addMessage(String login, String message) {
        if (history.get(login) == null) {
            List<String> listMessages = new ArrayList<>();
            listMessages.add(message);
            history.put(login, listMessages);
        } else
            history.get(login).add(message);
    }

    public static List<String> getUserHistory(String login) {
        return history.get(login);
    }

    public static void getListOfMessages(List<String> listOfMessages, PrintWriter writer) {
        if (listOfMessages != null) {
            for (String message : listOfMessages) {
                writer.println("\n" + message);
            }
        } else {
            writer.println("No history" + "\n" + "<p><a href=\"chat\">Back to chat</a></p>");
        }
    }
}
