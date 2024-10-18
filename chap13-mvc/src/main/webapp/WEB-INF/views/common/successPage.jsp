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
                case 'insertEmp':successMessage = "신규 직원 등록 성공!" ; break;
                case 'updateEmp':successMessage = "직원 정보 수정 성공"; break;
                case 'delete':successMessage = "직원 정보 삭제 성공"; break;

            }
            alert(successMessage);
            location.href = `${pageContext.servletContext.contextPath}/employee/list`;
        })();
    </script>
</body>
</html>
