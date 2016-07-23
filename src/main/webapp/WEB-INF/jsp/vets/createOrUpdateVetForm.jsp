<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../fragments/htmlHeader.jsp"/>

<body>
<petclinic:bodyHeader menuName="vet"/>
<div class="container-fluid">
    <div class="container xd-container">
        <h2>
            <c:if test="${vet['new']}">New </c:if> Vet
        </h2>
        <form:form modelAttribute="vet" class="form-horizontal" id="add-vet-form">
            <div class="form-group has-feedback">
                <petclinic:inputField label="First Name" name="firstName"/>
                <petclinic:inputField label="Last Name" name="lastName"/>
                <petclinic:selectField name="specialties" label="Specialties " multiSelect="${true}" names="${specialties}" size="5"/>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <c:choose>
                        <c:when test="${vet['new']}">
                            <button class="btn btn-default" type="submit">Add Vet</button>
                        </c:when>
                        <c:otherwise>
                            <button class="btn btn-default" type="submit">Update Vet</button>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </form:form>
        <petclinic:pivotal/>
    </div>
</div>
<jsp:include page="../fragments/footer.jsp"/>
</body>

</html>
