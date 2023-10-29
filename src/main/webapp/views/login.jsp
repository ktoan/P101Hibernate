<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <jsp:include page="import-style.jsp"/>
</head>
<body>
<div>
    <div style="height: 100vh"
         class="w-100 d-flex align-items-center justify-content-center">
        <div class="card" style="width: 400px">
            <div class="card-header">
                <p class="mb-0">Please sign in</p>
            </div>
            <div class="card-body">
                <form name="loginForm" onsubmit="return validateLoginForm()" method="post" class="pb-0 mb-0">
                    <div class="form-group mb-3">
                        <input type="text" class="form-control" name="email"
                               aria-label="Email" placeholder="Email">
                    </div>
                    <div class="form-group mb-3">
                        <input type="password" class="form-control"
                               name="password" aria-label="Password"
                               placeholder="Password">
                    </div>
                    <div class="form-check mb-3">
                        <input type="checkbox" class="form-check-input"
                               id="loginCheck">
                        <label class="form-check-label" for="loginCheck">
                            Check me out
                        </label>
                    </div>
                    <button type="submit" class="w-100 btn btn-success mb-3">
                        Login
                    </button>
                    <p class="text-danger mb-0 w-100 text-center px-2">
                        <%=request.getAttribute("ErrorMessage") == null
                                ? ""
                                : request.getAttribute("ErrorMessage")%>
                    </p>
                </form>
            </div>
            <div class="card-footer">
                <a class="text-primary text-decoration-none"
                   href="${pageContext.request.contextPath}/register">Click here
                    to Register</a>
            </div>
        </div>
    </div>
    <jsp:include page="import-js.jsp"/>
</div>
</body>
</html>