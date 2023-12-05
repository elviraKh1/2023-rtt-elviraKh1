<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../include/header.jsp"/>

<section>
    <div class="bg-light2 pt-5 pb-5">
        <div class="row">
            <div class="col-12 text-center">
                <h1 class="m-0">Create Customer</h1>
            </div>
        </div>
    </div>
</section>

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

        <form method="GET" action="/customer/createSubmit">
            <input type="hidden" name="id" value="${form.id}">
            <div class="mt-3">
                <label for="firstName" class="form-label">First name</label>
                <input type="text" class="form-control" id="firstName"  name="firstName" aria-describedby="firstNameHelp" value="${form.firstName}">
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
                <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastNameHelp" value="${form.lastName}">
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
                <label for="phone" class="form-label">Phone</label>
                <input type="text" class="form-control" id="phone" name="phone" aria-describedby="phoneHelp" value="${form.phone}">
                <div id="phoneHelp" class="form-text">Please let us  know your phone number.</div>
                <c:if test="${errors.hasFieldErrors('phone')}">
                    <div style="color:red">
                        <c:forEach items="${errors.getFieldErrors('phone')}" var="error">
                            ${error.defaultMessage}<br>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
            <div class="mt-3">
                <label for="city" class="form-label">City</label>
                <input type="text" class="form-control" id="city" name="city" aria-describedby="cityHelp" value="${form.city}">
                <div id="cityHelp" class="form-text">Please let us  know your city name.</div>
                <c:if test="${errors.hasFieldErrors('city')}">
                    <div style="color:red">
                        <c:forEach items="${errors.getFieldErrors('city')}" var="error">
                            ${error.defaultMessage}<br>
                        </c:forEach>
                    </div>
                </c:if>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</section>
<jsp:include page="../include/footer.jsp"/>
