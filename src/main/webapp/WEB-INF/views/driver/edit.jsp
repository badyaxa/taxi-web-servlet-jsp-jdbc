<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name} (${licenseNumber})</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>

    <h1>${title}</h1>

    <form action="${pageContext.request.contextPath}/drivers/delete/${id}" method="get">
        <input type="text" name="id" readonly value="${id}" style='background:lightgrey' , size="2">
        <input type="submit" value="DELETE" style="background-color: red">
    </form>

    <form action="${pageContext.request.contextPath}/drivers/${id}" method="post">
        <label for="driver"> DRIVER: </label>
        <input type="text" id="driver" name="name" value="${name}" placeholder="Bohdan" pattern=".{3,}">

        <input type="text" name="licenseNumber" value="${licenseNumber}" placeholder="852753951" pattern="[0-9]{9,}">

        <input type="submit" value="UPDATE" style="background-color: orange">
    </form>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
