<nav class="border navbar navbar-light bg-light px-3" style="height: 60px">
    <span class="navbar-brand mb-0 h1">CMS</span>
    <div class="d-flex gap-1 align-items-center">
        <p class="mb-0">Hello ${sessionScope.email}</p>
        <a href="${pageContext.request.contextPath}/log-out" class="text-decoration-none text-danger mb-0">Log out</a>
    </div>
</nav>