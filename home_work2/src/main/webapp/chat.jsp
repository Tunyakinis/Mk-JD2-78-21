<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
</head>
<body>
<form method="POST" name="Send Message" action="send">
    <tr>
        <td>User Name:</td>
        <div></div>
        <td><input type="text" name="userName"></td>
    </tr>
    <div>
        <input type="text" name="message">
    </div>
    <tr>
        <td ALIGN=right<p><input type="submit" value="Send"></td>
    </tr>
    <p><a href="history">Open History</a></p>
    <p><a href="loginPage">Exit</a></p>
</form>
</body>
</html>