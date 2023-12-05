<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<h1>Create employee</h1>

<section class="pt-5 pb-5">
    <div class="container">

        <c:if test="${not empty success}">
            <div class="row justify-content-center">
                <div class="col-6 text-center">
                    <div class="alert alert-success" role="alert">
                            ${success}
                    </div>
                </div>
            </div>
        </c:if>

        <form method="GET" action="/employee/createSubmit">
          <input type="hidden" name="id" value="${form.id}">
            <div class="mt-3">
                <label for="firstName" class="form-label">First name</label>
                <input type="text" class="form-control" id="firstName"  name="firstName" aria-describedby="firstNameHelp"  value="${form.firstName}">
                <div id="firstNameHelp" class="form-text">Please let us  know your first name.</div>

                <c:if test="${errors.hasFieldErrors('firstName')}">
                    <div style="color:red">
                        <c:forEach items="${errors.getFieldErrors('firstName')}" var="error">
                            ${error.defaultMessage}<br>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
            <div class="mt-3">
                <label for="lastName" class="form-label">Last name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastNameHelp"  value="${form.lastName}">
                <div id="lastNameHelp" class="form-text">Please let us  know your last name.</div>
                <c:if test="${errors.hasFieldErrors('lastName')}">
                    <div style="color:red">
                        <c:forEach items="${errors.getFieldErrors('lastName')}" var="error">
                            ${error.defaultMessage}<br>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
            <div class="mt-3">
                <label for="departmentName" class="form-label">Department name</label>
                <input type="text" class="form-control" id="departmentName" name="departmentName" aria-describedby="departmentNameHelp"  value="${form.departmentName}">
                <div id="departmentNameHelp" class="form-text">Department Name.</div
                <c:if test="${errors.hasFieldErrors('departmentName')}">
                    <div style="color:red">
                        <c:forEach items="${errors.getFieldErrors('departmentName')}" var="error">
                            ${error.defaultMessage}<br>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
            <div class="mt-3">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>