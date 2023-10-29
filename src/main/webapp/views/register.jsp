<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>
  <jsp:include page="import-style.jsp"/>
</head>
<body>
<div>
  <div style="height: 100vh"
       class="w-100 d-flex align-items-center justify-content-center">
    <div class="card" style="width: 400px">
      <div class="card-header">
        <p class="mb-0">Register</p>
      </div>
      <div class="card-body">
        <form onsubmit="return validateRegisterForm()" method="post"
              name="registerForm" class="p-0 m-0">
          <div class="form-group mb-3">
            <input type="text" class="form-control" name="username"
                   aria-label="Username" placeholder="Username">
          </div>
          <div class="form-group mb-3">
            <input type="email" class="form-control" name="email"
                   aria-label="Email" placeholder="E-mail">
          </div>
          <div class="form-group mb-3">
            <input id="registerPassword" type="password"
                   class="form-control"
                   name="password" aria-label="Password"
                   placeholder="Password">
          </div>
          <div class="form-group mb-3">
            <input id="registerRePassword" type="password"
                   class="form-control"
                   name="rePassword" aria-label="RePassword"
                   placeholder="Re Password">
          </div>
          <button type="submit"
                  class="w-100 btn btn-success mb-3">
            Register
          </button>
          <p class="text-danger mb-0 w-100 text-center px-2">
              <%=request.getAttribute("ErrorMessage") == null
                                ? ""
                                : request.getAttribute("ErrorMessage")%>
        </form>
      </div>
      <div class="card-footer">
        <a class="text-primary text-decoration-none"
           href="${pageContext.request.contextPath}/login">
          Click here to Login
        </a>
      </div>
    </div>
  </div>
  <jsp:include page="import-js.jsp"/>
</div>
</body>
</html>