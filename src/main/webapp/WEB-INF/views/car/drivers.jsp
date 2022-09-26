<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${manufacturer.name} ${model} drivers</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>
    <h1>${manufacturer.name} ${model} drivers</h1>
    <c:if test="${drivers.size() == 0}">
        <hr>
        <h2>There are no drivers for this car</h2>
    </c:if>
    <c:if test="${drivers.size() != 0}">
        <hr>
        <table>
            <tr>
                <td>
                    ID
                </td><td>|</td><td>
                    NAME
                </td><td>|</td><td>
                    LICENSE NUMBER
                </td><td>|</td><td>|</td><td>
                    OPERATIONS
                </td>
            </tr>
            <c:forEach items="${drivers}" var="driver">
                <tr>
                    <td>
                        ${driver.id}
                    </td><td>|</td><td>
                        ${driver.name}
                    </td><td>|</td><td>
                        ${driver.licenseNumber}
                    </td><td>|</td><td>|</td><td>
                        <a href='/index'>
                            <input type="button" value="REMOVE DRIVER (not work yet)" style="background-color: red"></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${drivers_remained.size() == 0}">
        <hr>
        <h2>The list of drivers is empty.</h2>
        <a href='${pageContext.request.contextPath}/drivers/add'>
            <input type="button" value="CREATE DRIVER" style="background-color: limegreen"></a>
    </c:if>
    <c:if test="${drivers_remained.size() != 0}">
        <hr>
        <form method="POST" action="${pageContext.request.contextPath}/cars/drivers/add">
            <label for="car"> car: </label>
            <input type="text" id="car" name="car_id"value="${id}" readonly style="background-color: lightgrey" size="3">
            <label for="drivers_remained"> driver: </label>
            <select id="drivers_remained" name="driver_id">
                <option>
                <c:forEach items="${drivers_remained}" var="driver">
                    <option value="${driver.id}">${driver.name}</option>
                </c:forEach>
            </select>
            <input type="submit" value="ADD TO ${manufacturer.name} ${model}" style="background-color: yellow">
        </form>
    </c:if>
    <hr>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
