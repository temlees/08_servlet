<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<h1>Cookie handling
</h1>
<br/>
<form action="cookie" method="post">
    <table>
    <tr>
        <td>first name :</td>
        <td><input type="text" name="firstName"></td>
    </tr>
        <tr>
            <td>Last name :</td>
            <td><input type="text" name="lastName"></td>
        </tr>
        <tr>
            <td colspan="2">
            <button type="submit">전송</button>
        </tr>
    </table>
</form>
</body>
</html>