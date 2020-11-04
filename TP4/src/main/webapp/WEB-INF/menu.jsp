<%--
  Created by IntelliJ IDEA.
  User: exbrayat
  Date: 18/09/18
  Time: 17:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Hello ${courant.surnom}</title>

    <script type="application/javascript">
        function participer(ip) {
            // rustique : on soumet un formulaire...
            var form = document.createElement("form");
            form.setAttribute("method", "POST");
            form.setAttribute("action", "http://localhost:8080/correctiontd1_war/");

            var intp = document.createElement("input");
            intp.setAttribute("type", "hidden");
            intp.setAttribute("name", "intituleP");
            intp.setAttribute("value", ip);
            form.appendChild(intp);

            var todo=document.createElement("input");
            todo.setAttribute("type", "hidden");
            todo.setAttribute("name", "TODO");
            todo.setAttribute("value", "participer");
            form.appendChild(todo);

            //Ajout du formulaire à la page et soumission du formulaire
            document.body.appendChild(form);
            form.submit();
        }

    </script>
</head>
<body>

<p>Salut à toi, O ${courant.surnom}.
</p>
<p>
    Ton mot de passe est ${courant.motdepasse}. (comment ça, c'est une info privée?)
</p>

Tes compétences sont :
<ul>
    <c:forEach items="${courant.competences}" var="comp">
        <li> ${comp.key.intituleC} : ( ${comp.value} )</li>
    </c:forEach>
</ul>

Les projets :
<ul>
    <li> dont tu es responsable :
        <c:if test="${empty courant.responsable}">
            <p><i>Liste vide</i></p>
        </c:if>
        <c:if test="${not empty courant.responsable}">
            <ul>
                <c:forEach items="${courant.responsable}" var="projet">
                    <li> ${projet.intitule} : ${projet.description}</li>
                </c:forEach>
            </ul>
            <p/>

        </c:if>
    </li>
    <li> dont tu es simple participant :
        <c:if test="${empty courant.participe}">
            <p><i>Liste vide</i></p>
        </c:if>
        <c:if test="${not empty courant.participe}">
            <ul>
                <c:forEach items="${courant.participe}" var="projet">
                    <li> ${projet.intitule} : ${projet.description}</li>
                </c:forEach>
            </ul>
            <p/>

        </c:if>
    </li>
    <li> pour lesquels tu es compétent :
        <c:if test="${empty competent}">
            <p><i>Tu participes déjà à tous les projets pour lesquels tu es compétent...</i></p>
        </c:if>
        <c:if test="${not empty competent}">
            <ul>
                <c:forEach items="${competent}" var="projet">
                    <li> ${projet.intitule} : ${projet.description}
                        <button type="submit" onclick="participer('${projet.intitule}');">participer</button>
                    </li>
                </c:forEach>
            </ul>
            <p/>
        </c:if>
    </li>

    <li> les autres projets :
        <c:if test="${empty autres}">
            <p><i>Liste vide</i></p>
        </c:if>
        <c:if test="${not empty autres}">
            <ul>
                <c:forEach items="${autres}" var="projet">
                    <li> ${projet.intitule} : ${projet.description}</li>
                </c:forEach>
            </ul>
            <p/>

        </c:if>
    </li>
</ul>
<form method="post">
    nom de la competence : <input type="text" name="nom_comp"><br>
    description de la competence: <input type="text" name="descr_comp"><br>
    <button type="submit" name="TODO" value="add_comp">ajout comp</button>
</form>
</body>
</html>
