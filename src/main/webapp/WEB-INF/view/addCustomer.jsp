<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%--
  Created by IntelliJ IDEA.
  User: ahmed
  Date: ٢٠‏/١‏/٢٠٢١
  Time: ٤:٢١ م
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%--    include bootstrap 5 css--%>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-grid.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-reboot.css" />" rel="stylesheet">
    <link href="<c:url value="/resources/css/bootstrap-utilities.css" />" rel="stylesheet">
    <%--    include css file--%>
    <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
    <title>Add Customer</title>

</head>
<body>
    <form:form action="add" method="post" modelAttribute="customer">
        <form:hidden path="id"/>
        <table>
            <tbody>
                <tr>
                    <td><label>First Name</label></td>
                    <td><form:input cssClass="form-control" path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last Name</label></td>
                    <td><form:input cssClass="form-control" path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email</label></td>
                    <td><form:input cssClass="form-control" path="email"/></td>
                </tr>
                <tr>
                    <td>
                        <button class="btn btn-dark" type="submit">Submit</button>
                    </td>
                </tr>
            </tbody>
        </table>
    </form:form>
</body>
</html>
