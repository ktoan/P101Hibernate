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
    <title>Add Content</title>
    <jsp:include page="import-style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="height: calc(100vh - 60px)" class="d-flex gap-1">
    <jsp:include page="sidebar.jsp"/>
    <div class="p-3 w-100">
        <h3 class="mb-3">Add content</h3>
        <div class="card">
            <div class="card-header">
                <p class="mb-0">Content form elements</p>
            </div>
            <div class="card-body">
                <form method="post">
                    <div class="mb-3">
                        <label class="fw-bold mb-1">Title</label>
                        <input class="form-control"
                               placeholder="Enter the title" name="title"
                               aria-label="Title"/>
                    </div>
                    <div class="mb-3">
                        <label class="fw-bold mb-1">Brief</label>
                        <textarea class="form-control" name="brief"
                                  aria-label="Brief"></textarea>
                    </div>
                    <div class="mb-3">
                        <label class="fw-bold mb-1">Content</label>
                        <textarea rows="5" class="form-control" name="content"
                                  aria-label="Content"></textarea>
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
