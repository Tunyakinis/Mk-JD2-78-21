<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>
<%!
    String getFormattedDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyy HH:mm:ss");
        return sdf.format(new Date());
    }
%>
<html>
<head>
    <title>Authorization Page</title>
    <meta charset="utf-8">
</head>
<body>
<form method="GET" name="authorization" action="login">
    <table style="with: 50%">
        <p><a href="addUser">Registration</a></p>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login"></td>
        </tr>
        <tr>
            <td> Password:</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
    </table>
</form>
</body>
</html>