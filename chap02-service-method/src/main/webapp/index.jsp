<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1> service()메소드의 역할</h1>
<br/>
<h3>Get방식의 요청</h3>
<a href="request-service">서비스 메소드 요청하기</a>
<form action="request-service" method="get">
<input type="submit" value="Get방식 요청 전송">
</form>

<h3>Post 방식의 요청</h3>
<form action="request-service" method="post">
    <input type="submit" value="Post방식 요청 전송">
</form>

</body>
</html>