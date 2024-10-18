<%--
  Created by IntelliJ IDEA.
  User: 804-15
  Date: 2024-10-18
  Time: 오후 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>게시판</h1>
<br/>
<%--<a href="board/insert">새 게시글 작성</a>--%>
<a href="move">새 게시글 작성</a>
<h1>게시글 목록</h1>

<c:choose>
    <c:when test="${empty requestScope.boardList}">
        <tr>
            <td colspan="3">목록이 없습니다.</td>
        </tr>
    </c:when>
    <c:otherwise>
<tr>
    <th>ID</th>
    <th>제목</th>
    <th>작업</th>
</tr>
        <c:forEach items="${requestScope.boardList}" var="board">

<table>

            <tr>
                <td>${board.id}</td>
             <td> <a href="/board/detail?id=${board.id}">${board.title}</a></td>
                <td><a href="/board/update?id=${board.id}">수정</a></td>
                <td><a href="/board/delete?id=${board.id}">삭제</a></td>
            </tr>
        </c:forEach>
    </c:otherwise>
</c:choose>
</table>
</body>
</html>
