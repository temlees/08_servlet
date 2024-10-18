<%--
  Created by IntelliJ IDEA.
  User: 804-15
  Date: 2024-10-18
  Time: 오후 3:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>수정할 게시글 ID: ${id}</p>

<!-- 게시글 수정 폼 -->
<form action="updates" method="post">
    <input type="hidden" name="id" value="${id}" />
    <label>수정 할 제목:   <input type="text" id="title" name="title" /></label>
    <br>
    <label>내용: <input id="content" name="content"></label>
    <br>
    <button type="submit">수정</button>
</form>

</body>
</html>
