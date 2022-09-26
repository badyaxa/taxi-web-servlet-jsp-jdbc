<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${manufacturer.name} ${model}</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>

    <h1>${title}</h1>

    <form action="${pageContext.request.contextPath}/cars/delete/${id}" method="get">
        <input type="text" name="id" readonly value="${id}" style='background:lightgrey' , size="2">
        <input type="submit" value="DELETE" style="background-color: red">
    </form>

    <form action="${pageContext.request.contextPath}/cars/${id}" method="post">
        <label for="car"> CAR: </label>
        <select id="car" name="manufacturer" value="${manufacturer.name}">
            <c:forEach items="${manufacturers}" var="manufacturer">
                <option value="${manufacturer.id}"
                    <c:if test="${manufacturerId == manufacturer.id}">
                        selected
                    </c:if>
                >${manufacturer.name}</option>
            </c:forEach>
        </select>

        <input type="text" name="model" value="${model}" placeholder="Camry" pattern=".{2,}">

        <input type="submit" value="UPDATE" style="background-color: orange">
    </form>

    <a href='drivers/${id}'>
        <input type="button" value="(drivers) LIST/ADD/REMOVE" style="background-color: yellow"></a>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
