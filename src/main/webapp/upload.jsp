<%--
  Created by IntelliJ IDEA.
  User: FQT_CJ
  Date: 2019/5/31
  Time: 23:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>fileUpload</title>
</head>
<body>
<form action="http://localhost:8080/SSH/upload/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file1">
    <input type="submit">
</form>
</body>
</html>
