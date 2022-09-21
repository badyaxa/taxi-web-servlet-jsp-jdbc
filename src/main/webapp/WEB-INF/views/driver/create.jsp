<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREATE driver</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>

    <h1>${title}</h1>

    <form method="POST" action="${pageContext.request.contextPath}/drivers/add">
        <label for="name">name: </label>
        <input type="text" name="name" id="name" placeholder="Bohdan" value="${name}" pattern="[a-zA-Z ]{3,}">

        <label for="licenseNumber"> license number: </label>
        <input type="text" name="licenseNumber" id="licenseNumber" placeholder="852753951" value="${licenseNumber}" pattern="[0-9]{9,}">

        <input type="submit" value="CREATE" style="background-color: limegreen">
    </form>

    <jsp:include page="../footer.jsp"/>
</body>
</html>
