<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name} (${license_number}) cars</title>
</head>
<body>
    <jsp:include page="../../header.jsp"/>
    <h1>${name} (${license_number}) cars</h1>
    <c:if test="${my_cars.size() == 0}">
        <hr>
        <h2>There are no cars for this driver</h2>
    </c:if>
    <c:if test="${my_cars.size() != 0}">
        <hr>
        <table>
            <tr>
                <td>
                    ID
                </td><td>|</td><td>
                    CAR
                </td><td>|</td><td>|</td><td>
                    OPERATIONS
                </td>
            </tr>
            <c:forEach items="${my_cars}" var="car">
                <tr>
                    <td>
                        ${car.id}
                    </td><td>|</td><td>
                        ${car.manufacturer.name} ${car.model}
                    </td><td>|</td><td>|</td><td>
                        <a href='/index'>
                            <input type="button" value="REMOVE CAR (not work yet)" style="background-color: red"></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <c:if test="${cars_remained.size() == 0}">
        <hr>
        <h2>The list of cars is empty.</h2>
        <a href='${pageContext.request.contextPath}/car/add'>
            <input type="button" value="CREATE CAR" style="background-color: limegreen"></a>
    </c:if>
    <c:if test="${cars_remained.size() != 0}">
        <hr>
            <form method="POST" action="${pageContext.request.contextPath}/cars/drivers/add">
                <label for="name"> name: </label>
                <input type="text" id="name" name="name" value="${name}" readonly style="background-color: lightgrey" size="3">
                <label for="cars_remained"> car: </label>
                <select id="cars_remained" name="car_id">
                    <option>
                    <c:forEach items="${cars_remained}" var="car">
                        <option value="${car.id}">${car.manufacturer} ${car.model}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="ADD TO (not work yet)${manufacturer.name} ${model}" style="background-color: yellow">
            </form>
    </c:if>
    <hr>
    <jsp:include page="../../footer.jsp"/>
</body>
</html>
