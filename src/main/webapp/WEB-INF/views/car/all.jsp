<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ALL cars</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>

    <c:if test="${cars.size() == 0}">
        <h1>There is no car, please create</h1>
        <a href='${pageContext.request.contextPath}/cars/add'>
            <input type="button" value="CREATE" style="background-color: limegreen"></a>
    </c:if>

    <c:if test="${cars.size() != 0}">
        <h1>List cars.</h1>

        <hr>

        <table>
            <tr>
                <td>
                    ID
                </td><td>|</td><td>
                    MANUFACTURER
                </td><td>|</td><td>
                    MODEL
                </td><td>|</td><td>
                    DRIVERS
                </td><td>|</td><td>|</td><td>
                    OPERATIONS
                </td>
            </tr>

            <c:forEach items="${cars}" var="car">
                <tr>
                    <td>
                        ${car.id}
                    </td><td>|</td><td>
                        ${car.manufacturer.name}
                    </td><td>|</td><td>
                        ${car.model}
                    </td><td>|</td><td>
                        <a href='cars/drivers/${car.id}'>
                            <input type="button" value="LIST/ADD/REMOVE" style="background-color: yellow"></a>
                        |
                        <c:forEach items="${car.drivers}" var="driver">
                            ${driver.name},
                        </c:forEach>
                    </td><td>|</td><td>|</td><td>
                        <a href='cars/${car.id}'>
                            <input type="button" value="EDIT" style="background-color: orange"></a>
                    </td><td>
                        <a href='cars/delete/${car.id}'>
                            <input type="button" value="DELETE" style="background-color: red"></a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <hr>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
