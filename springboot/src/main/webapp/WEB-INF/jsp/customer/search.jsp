<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp"/>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>

<section>
    <div class="container pt-5">
    <h1  class="pb-3">Customer search by name</h1>

        <form method="GET" action="/customer/search">
            <div class="mb-3">
                <label for="search" class="form-label">Search</label>
                <input type="text" class="form-control" id="search"  name="search"  placeholder="Search by name" value="${search}">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>

    <h1 class="mb-3">Customer search by full name</h1>
            <form method="GET" action="/customer/searchbyname">
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

        <c:if test="${not empty customersVar}">
          <h6 class="pt-3">customers found  ${customersVar.size()} </h6>
          <table class='table'>
            <tr>
                <td>First name</td>
                <td>Last name</td>
                <td>Phone</td>
                <td>City</td>
                <td>Image</td>
                <td>Edit</td>
                <td>Detail</td>
                <td>Upload</td>
            </tr>
        <c:forEach items="${customersVar}" var="customer">
            <tr>
                <td>${customer.firstName}</td>
                <td>${customer.lastName}</td>
                <td>${customer.phone}</td>
                <td>${customer.city}</td>
                <td><img src="${customer.imageUrl}" style="max-width: 100px"></td>
                <td><a href="/customer/edit/${customer.id}">Edit</a></td>
                <td><a href="/customer/detail/?customerId=${customer.id}">Detail</a></td>
                <td><a href="/customer/fileupload?id=${customer.id}">Upload</a></td>
            </tr>
        </c:forEach>
          </table>

        </c:if>
    </div>
</section>

<jsp:include page="../include/footer.jsp"/>