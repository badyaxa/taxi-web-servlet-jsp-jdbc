<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <h1>Login Page</h1>
    <h4 style="color: red">${errorMessage}</h4>
    <form method="post" id="login" action="${pageContext.request.contextPath}/login">
        <input type="text" name="login" placeholder="enter login" required>
        <br>
        <input type="password" name="password" placeholder="enter password" required>
        <br>
        <input type="submit" value="LOGIN" style="background-color: limegreen">
        <input type="hidden" name="csrf_token" value="svd6fg4v6g5v36g54c36sdg43c6g4">
    </form>
    <h4><a href="${pageContext.request.contextPath}/register">REGISTER</a></h4>
</body>
</html>
