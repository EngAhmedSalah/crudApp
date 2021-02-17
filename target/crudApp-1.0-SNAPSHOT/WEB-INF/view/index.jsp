<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: ١٧‏/١‏/٢٠٢١
  Time: ٣:٣٩ م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    include bootstrap 5 css--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
    <%--    include css file--%>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Title</title>

</head>
<body>
<h1>Welcome Page</h1>
<a class="m-4 btn btn-primary" href="/customer/list">List Customers</a>
<a class="m-4 btn btn-danger" href="/customer/showForm">Add Customers</a>
</body>
</html>
