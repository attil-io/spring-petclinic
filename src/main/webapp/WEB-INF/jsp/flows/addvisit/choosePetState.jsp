<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../../fragments/htmlHeader.jsp"/>

<body>
<petclinic:bodyHeader menuName="vets"/>

<div>
Please, choose the pet of: <b>${addVisitBean.owner.firstName} ${addVisitBean.owner.lastName}</b> to be visited.
</div>

                <div>
                    <p>
                        <form:form modelAttribute="addVisitBean">
                            <form:select path="chosenPet" name="chosenPetId" size="${addVisitBean.pets.size() + 1}">
                               <form:options items="${addVisitBean.pets}" itemLabel="name" itemValue="id" />
                            </form:select>
                            <input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
                            <button type="submit" name="_eventId_continue" >Continue</button>
                            <button type="submit" name="_eventId_cancel" >Cancel</button>
                        </form:form>
                    </p>
                    <petclinic:pivotal/>
                </div>


<jsp:include page="../../fragments/footer.jsp"/>

</body>

</html>


