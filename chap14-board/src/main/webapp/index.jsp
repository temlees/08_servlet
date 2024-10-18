<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>

<%--<jsp:forward page="WEB-INF/views/main/main.jsp"/>--%>
<a href="${pageContext.request.contextPath}board/main">게시판 보러가기</a>
</body>
</html>