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
Please, confirm the visit.
</div>

<div>Veterinarian: ${addVisitBean.vet.firstName} ${addVisitBean.vet.lastName}</div>
<div>Owner: ${addVisitBean.owner.firstName} ${addVisitBean.owner.lastName}</div>
<div>Pet: ${addVisitBean.chosenPet.name} </div>
<div>Visit date: ${addVisitBean.visitDate}</div>

                <div>
                    <p>
                        <form:form>
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


