<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="regist" method="post">
    <input type="text" placeholder="User ID" name="id">
    <input type="password" placeholder="Password" name="password">
    <input type="text" placeholder="Email" name="email">
    <button type="submit">가입하기</button>
</form>
<br/>
<a href="login.jsp">로그인화면</a>
</body>
</html>