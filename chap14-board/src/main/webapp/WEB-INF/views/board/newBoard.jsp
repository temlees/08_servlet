<%--
  Created by IntelliJ IDEA.
  User: 804-15
  Date: 2024-10-18
  Time: 오후 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>새 게시글 작성</h1>
<form action="insert" method="post">
    <label>제목 : <input name="title"/></label>
    <label>내용 : <input name="content"/></label>
    <button type="submit">작성하기</button>
</form>

</body>
</html>
