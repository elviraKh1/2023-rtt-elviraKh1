<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

<section>
    <div class="container pt-5">
      <h1 class="mb-3">Employee search by full name</h1>
            <form method="GET" action="/employee/search">
                    <div class="mb-3">
                        <label for="fName" class="form-label">First name</label>
                        <input type="text" class="form-control" id="fName"  name="fName"  placeholder="Search by first name" value="${fName}">
                    </div>
                    <div class="mb-3">
                         <label for="lName" class="form-label">Last name</label>
                         <input type="text" class="form-control" id="lName"  name="lName"  placeholder="Search by last name" value="${lName}">
                     </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>

        <c:if test="${not empty employees}">
          <h6 class="pt-3">employee found  ${employees.size()} </h6>
          <table class='table'>
            <tr>
                <td>First name</td>
                <td>Last name</td>
                <td>Department</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
        <c:forEach items="${employees}" var="employee">
            <tr>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.departmentName}</td>
                <td><a href="/employee/edit/${employee.id}">Edit</a></td>
                <td><a href="/employee/delete/${employee.id}">Delete</a></td>
            </tr>
        </c:forEach>
          </table>

        </c:if>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>