<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL manufacturers</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>

    <c:if test="${manufacturers.size() == 0}">
        <h1>There is no manufacturer, please create</h1>
        <a href='${pageContext.request.contextPath}/manufacturers/add'>
            <input type="button" value="CREATE" style="background-color: limegreen"></a>
    </c:if>

    <c:if test="${manufacturers.size() != 0}">
        <h1>List manufacturers.</h1>

        <hr>

        <table>
            <tr>
                <td>ID</td>
                <td>|</td>
                <td>NAME</td>
                <td>|</td>
                <td>COUNTRY</td>
                <td>|</td>
                <td>|</td>
                <td>OPERATIONS</td>
            </tr>

            <c:forEach items="${manufacturers}" var="manufacturer">
                <tr>
                    <td> ${manufacturer.id} </td>
                    <td>|</td>
                    <td> ${manufacturer.name} </td>
                    <td>|</td>
                    <td> ${manufacturer.country} </td>
                    <td>|</td>
                    <td>|</td>
                    <td><a href='manufacturers/${manufacturer.id}'>
                        <input type="button" value="EDIT" style="background-color: orange"></a></td>
                    <td><a href='manufacturers/delete/${manufacturer.id}'>
                        <input type="button" value="DELETE" style="background-color: red"></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <hr>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
