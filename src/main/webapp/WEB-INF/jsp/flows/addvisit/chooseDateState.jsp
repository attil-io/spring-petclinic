<!DOCTYPE html>

<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>


<html lang="en">

<jsp:include page="../../fragments/htmlHeader.jsp"/>
<spring:url value="/vendors/jquery/jquery.min.js" var="jQuery"/>
<spring:url value="/vendors/jquery-ui/ui/minified/jquery.ui.datepicker.min.js" var="jQueryDatePicker"/>
<script src="${jQuery}"></script>
<script src="${jQueryDatePicker}"></script>

<body>
<petclinic:bodyHeader menuName="vets"/>

<div>
Please, choose a date for the visit.
</div>


<script>
$(document).ready(function() {
    $("#datepicker").datepicker({dateFormat:"yy-mm-dd"});
});
</script>

                <div>
                    <p>
                        <form:form>
                            <p>Date: <input type="text" id="datepicker" name="visitDate"></p>
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


