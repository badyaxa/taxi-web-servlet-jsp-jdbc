<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${name} (${license_number})</title>
</head>
<body>
    <jsp:include page="../header.jsp"/>
    <h1>${title}</h1>
    <form action="${pageContext.request.contextPath}/drivers/delete/${id}" method="get">
        <input type="text" name="id" readonly value="${id}" style='background:lightgrey' , size="2">
        <input type="submit" value="DELETE" style="background-color: red">
    </form>
    <form action="${pageContext.request.contextPath}/drivers/${id}" method="post">
        <input type="text" name="name" id="name"
               placeholder="Bohdan" value="${name}" pattern="[a-zA-Z ]{3,}">
        <label for="name"> name</label>
        <br>
        <input type="text" name="license_number" id="license_number"  value="${license_number}"
               placeholder="852753951" value="${licenseNumber}" pattern="[0-9]{9,}">
        <label for="license_number"> license number</label>
        <br>
        <input type="text" name="login" id="login" value="${login}"
               placeholder="login" required>
        <label for="login"> login</label>
        <br>
        <input type="password" name="password" id="password"
               placeholder="password" required>
        <label for="password"> password</label>
        <br>
        <input type="password" name="repeat_password" id="repeat_password"
               placeholder="repeat password" required>
        <label for="repeat_password"> repeat password</label>
        <br>
        <input type="submit" value="UPDATE" style="background-color: orange">
    </form>
    <jsp:include page="../footer.jsp"/>
</body>
</html>
