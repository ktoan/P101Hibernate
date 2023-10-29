<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Content</title>
    <jsp:include page="import-style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div style="height: calc(100vh - 60px)" class="d-flex gap-1">
    <jsp:include page="sidebar.jsp"/>
    <div class="p-3 w-100">
        <h3 class="mb-3">View content</h3>
        <div class="card">
            <div class="card-header">
                <p class="mb-0">View content list</p>
            </div>
            <div class="card-body">
                <table class="table mb-0 w-100 table-bordered">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Brief</th>
                        <th>CreatedDate</th>
                    </tr>
                    </thead>
                    <tbody>

                    <c:forEach items="${requestScope.contents}" var="item">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.title}</td>
                            <td>${item.brief}</td>
                            <td>${item.createdAt}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="import-js.jsp"/>
</body>
</html>
