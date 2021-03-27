<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.*, java.text.*" %>

<html>
<head>
    <title>!DOCTYPE</title>
    <meta charset="utf-8">
</head>
<body>
<form action="signUp" method="GET">
    <table style="with: 50%">
        <tr>
            <td>First Name:</td>
            <td><input type="text" name="firstName"/></td>
        </tr>
        <tr>
            <td>Last Name:</td>
            <td><input type="text" name="lastName"/></td>
        </tr>
        <tr>
            <td>Middle Name:</td>
            <td><input type="text" name="middleName"/></td>
        </tr>
        <tr>
            <td>Date of Birth:</td>
            <td><input type="date" name="date"/></td>
        </tr>
        <tr>
            <td>login:</td>
            <td><input type="text" name="login"/></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"></td>
        </tr>
        <p><a href="loginPage">Login</a></p>
    </table>
</form>
</body>
</html>