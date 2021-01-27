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
    <title>Title</title>
    <%--    include bootstrap 5 css--%>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-grid.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-reboot.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-utilities.css" />" rel="stylesheet">
    <%--    include css file--%>
    <style><%@include file="../../resources/css/style.css"%></style>
</head>
<body>
<h1 class="test">List of Customer of Our Company</h1>
<a href="${pageContext.request.contextPath}/customer/showForm" class="btn btn-primary m-4" >Add Customer</a>
<div class="wrapper">
    <div class="header">
        <h1>CRM Table</h1>
    </div>
</div>
<div id="container">
    <div class="content">
        <!-- table here -->
        <table class="table table-striped">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>
            <!-- loop in the list -->
            <c:forEach var="tempCustomer" items="${customers}">
                <tr>
                    <td>${tempCustomer.firstName}</td>
                    <td>${tempCustomer.lastName}</td>
                    <td>${tempCustomer.email}</td>
                    <td><a href="" class="btn btn-warning">Update</a></td>
                    <td><a href="/customer/delete" class="btn btn-danger" >Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
