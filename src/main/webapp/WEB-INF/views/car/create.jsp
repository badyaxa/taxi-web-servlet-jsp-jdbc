<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATE car</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>
    <h1>${title}</h1>
    <form method="POST" action="${pageContext.request.contextPath}/cars/add">
        <label for="manufacturers"> manufacturer: </label>
        <select id="manufacturers" name="manufacturer_id">
            <option>
            <c:forEach items="${manufacturers}" var="manufacturer">
                <option value="${manufacturer.id}"
                    <c:if test="${manufacturer_id == manufacturer.id}">
                        selected
                    </c:if>
                >${manufacturer.name}</option>
            </c:forEach>
        </select>
        <label for="model">model: </label>
        <input type="text" id="model" name="model" value="${model}" placeholder="Camry" pattern="[a-zA-Z0-9 ]{2,}">
        <input type="submit" value="CREATE" style="background-color: limegreen">
    </form>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
