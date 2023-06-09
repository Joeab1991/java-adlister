<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="../partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="../partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome <c:out value="${sessionScope.user}"/>!</h1>
        <h2>Viewing your profile.</h2>
        <form action="/logout" method="post">
            <input type="submit" value="Logout" id="logout"/>
        </form>
    </div>

</body>
</html>
