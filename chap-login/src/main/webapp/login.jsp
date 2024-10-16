<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>로그인 페이지</title>
</head>
<body>
<h1>로그인 페이지</h1>
<% if (request.getParameter("error") != null) { %>
<p style="color:red;">로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.</p>
<% } %>
<form action="login" method="post">
    <input type="text" placeholder="User ID" name="id" required>
    <input type="password" placeholder="Password" name="password" required>
    <button type="submit">로그인</button>
</form>
<br/>
<a href="register.jsp">회원가입</a>
</body>
</html>