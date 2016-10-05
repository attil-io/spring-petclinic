<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<html lang="en">
<jsp:include page="fragments/htmlHeader.jsp"/>

<body>
<petclinic:bodyHeader menuName="error"/>
<div class="container-fluid">
    <div class="container xd-container">

        <spring:url value="/resources/images/pets.png" var="petsImage"/>
        <img src="${petsImage}"/>

        <h2>Something happened...</h2>

        Message:
        <p>${exception.message}</p>

<br /><br /><br />
        Exception type: ${exception.getClass().getName()} <br />
        Exception cause: ${exception.getCause().getClass().getName()}
        Exception cause: ${exception.getCause().getMessage()}
<br /><br /><br />

        Stack trace:
	  	<c:forEach items="${exception.stackTrace}" var="stackTrace"> 
			${stackTrace} 
		</c:forEach>

        <petclinic:pivotal/>
    </div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>

</html>
