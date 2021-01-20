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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
<%--    include css file--%>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

</head>
<body>
<h1 class="test">List Customer will be added soon</h1>
<a href="/customer/showForm" class="btn btn-primary m-4" >Add Customer</a>
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
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
