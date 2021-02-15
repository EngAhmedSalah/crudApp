<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
    <%--    include css file--%>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Title</title>

</head>
<body>
<h1>Welcome Page</h1>
<h1>User: <security:authentication property="principal.username"/></h1>
<h6>with role: <security:authentication property="principal.authorities"/></h6>
<security:authorize access="hasRole('Manager')">
    <a class="m-4 btn btn-primary" href="/customer/list">List Customers</a>
    <a class="m-4 btn btn-secondary" href="/customer/showForm">Add Customers</a>
</security:authorize>
<a class="m-4 btn btn-warning" href="/customer/leader">Show leaders</a>
<a class="m-4 btn btn-dark" href="/customer/system">Show System</a>
<form:form method="post" action="/logout">
    <input class="m-4 btn btn-danger" value="Logout" type="submit"/>
</form:form>
</body>
</html>
