<%--
  Created by IntelliJ IDEA.
  User: LSK
  Date: 13. 8. 22
  Time: 오후 5:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach var="list" items="${list}">
        ${list.email}<br/>
    </c:forEach>
</body>
</html>