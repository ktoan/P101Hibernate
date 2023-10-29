<%--
  Created by IntelliJ IDEA.
  User: nktoa
  Date: 10/28/2023
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Profile</title>
    <jsp:include page="import-style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="height: calc(100vh - 60px)" class="d-flex gap-1">
    <jsp:include page="sidebar.jsp"/>
    <div class="p-3 w-100">
        <h3 class="mb-3">Edit Profile</h3>
        <div class="card">
            <div class="card-header">
                <p class="mb-0">Profile form elements</p>
            </div>
            <div class="card-body">
                <form method="post">
                    <div class="mb-3">
                        <label class="fw-bold mb-1">First Name</label>
                        <input class="form-control"
                               placeholder="Enter the first name"
                               name="firstName"
                               aria-label="FirstName"
                               value="${requestScope.member.firstName}"/>
                    </div>
                    <div class="mb-3">
                        <label class="fw-bold mb-1">Last Name</label>
                        <input class="form-control"
                               placeholder="Enter the last name" name="lastName"
                               aria-label="LastName"
                               value="${requestScope.member.lastName}" }/>
                    </div>
                    <div class="mb-3">
                        <label class="fw-bold mb-1">Email</label>
                        <input class="form-control"
                               value="${sessionScope.email}"
                               aria-label="Email"
                               disabled/>
                    </div>
                    <div class="mb-3">
                        <label class="fw-bold mb-1">Phone</label>
                        <input class="form-control"
                               placeholder="Enter the phone" name="phone"
                               aria-label="Phone"
                               value="${requestScope.member.phone}"/>
                    </div>
                    <div class="mb-3">
                        <label class="fw-bold mb-1">Description</label>
                        <textarea class="form-control"
                                  name="description"
                                  aria-label="Description">${requestScope.member.description}</textarea>
                    </div>
                    <div class="d-flex gap-1">
                        <button class="btn btn-light" type="submit">
                            Submit Button
                        </button>
                        <button class="btn btn-light" type="reset">
                            Reset Button
                        </button>
                    </div>
                    <p class="text-danger mb-0 w-100 text-center px-2">
                        <%=request.getAttribute("ErrorMessage") == null
                                ? ""
                                : request.getAttribute("ErrorMessage")%>
                    </p>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="import-js.jsp"/>
</body>
</html>
