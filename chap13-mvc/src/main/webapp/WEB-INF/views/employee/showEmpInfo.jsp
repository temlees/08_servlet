
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="../common/header.jsp"/>
<%--selectEmp : request정보를 담은 객체--%>
    사원 번호 : ${requestScope.selectEmp.empId}<br/>
    사원 이름 : ${requestScope.selectEmp.empName}<br/>
    부서 코드 : ${requestScope.selectEmp.deptCode}<br/>
    직급 코드 : ${requestScope.selectEmp.jobCode}<br/>
    급여 : ${requestScope.selectEmp.salary}<br/>
</body>
</html>
