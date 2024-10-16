<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<h1>게시글 작성
</h1>
<br/>
<form action="board" method="post"><br/>
  <label>제목 : <input type="text" name="title" ></label>
    <label>내용 : <input type="text" name="content" ></label>
    <br/>
    <input type="submit" value="작성하기">

</form>
</body>
</html>