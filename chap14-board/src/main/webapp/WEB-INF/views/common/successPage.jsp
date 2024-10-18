<%--
  Created by IntelliJ IDEA.
  User: 804-15
  Date: 2024-10-18
  Time: 오후 2:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    <%--즉시 실행 함수--%>
    (function (){
        const successCode = `${requestScope.successCode}`
        let successMessage = "";

        switch (successCode){
            case 'insert':successMessage = "신규 등록 성공!" ; break;
            case 'update':successMessage = " 수정 성공"; break;
            case 'delete':successMessage = "삭제 성공"; break;

        }
        alert(successMessage);
        location.href = `${pageContext.servletContext.contextPath}/board/main`;
    })();
</script>
</body>
</html>
