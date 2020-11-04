<%--
  Created by IntelliJ IDEA.
  User: exbrayat
  Date: 27/08/18
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Bienvenue !</title>
</head>
<body>
<p><c:out value="${message1}"/></p>
<p><c:out value="${message1bis}"/></p>
<p><c:out value="${message2}"/></p>
<p><c:out value="${message3}"/></p>
<p><c:out value="${message5}"/></p>
<p><c:out value="${message6}"/></p>


<p>l'objet service 2 a pour id:<c:out value="${serviceId}"/></p>


<form method="get" action="autre">
    <button type="submit">Une autre servlet...</button>
</form>
</body>
</html>
