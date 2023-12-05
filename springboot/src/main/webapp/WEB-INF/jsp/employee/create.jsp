<jsp:include page="../include/header.jsp"/>
<h1>Create employee</h1>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>


<section>
    <div class="container">
        <form method="GET" action="/employee/createSubmit">
          <input type="hidden" name="id" value="${form.id}">
            <div class="mb-3">
                <label for="firstName" class="form-label">First name</label>
                <input type="text" class="form-control" id="firstName"  name="firstName" aria-describedby="firstNameHelp"  value="${form.firstName}">
                <div id="firstNameHelp" class="form-text">Please let us  know your first name.</div>
            </div>
            <div class="mb-3">
                <label for="lastName" class="form-label">Last name</label>
                <input type="text" class="form-control" id="lastName" name="lastName" aria-describedby="lastNameHelp"  value="${form.lastName}">
                <div id="lastNameHelp" class="form-text">Please let us  know your last name.</div>
            </div>
            <div class="mb-3">
                <label for="departmentName" class="form-label">Department name</label>
                <input type="text" class="form-control" id="departmentName" name="departmentName" aria-describedby="departmentNameHelp"  value="${form.departmentName}">
                <div id="departmentNameHelp" class="form-text">Department Name.</div>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>