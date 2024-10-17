
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="../common/header.jsp"/>

    <h3>Employee 테이블에서 EMP_ID를 이용하여 사원 정보 조회해오기</h3>
    <form action="employee/select">
        <label>조회할 사번 :</label>
        <input type="text" name="empId"/>
        <button type="submit">조회하기</button>
    </form>

<h3>Employee 테이블에서 직원 전체 정보조회(퇴사하지않은직원만) : employee/list</h3>
<a href="employee/list">직원정보 전체 조회하기</a>
</body>
</html>
