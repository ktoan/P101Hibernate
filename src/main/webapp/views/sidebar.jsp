<div class="h-100 bg-light border border-top-0">
    <div class="input-group p-3 mb-3">
        <input type="text" class="form-control rounded-0"
               placeholder="Search..." aria-label="Search...">
        <div class="input-group-append">
            <button class="btn btn-outline-secondary rounded-0" type="button">
                Search
            </button>
        </div>
    </div>
    <ul class="list-group rounded-0">
        <li class="list-group-item bg-light border-start-0 border-end-0">
            <a href="${pageContext.request.contextPath}/"
               class="text-decoration-none text-primary">View content</a>
        </li>
        <li class="list-group-item bg-light border-start-0 border-end-0">
            <a href="${pageContext.request.contextPath}/add-content"
               class="text-decoration-none text-primary">Form elements</a>
        </li>
        <li class="list-group-item bg-light border-start-0 border-end-0">
            <a href="${pageContext.request.contextPath}/edit-profile"
               class="text-decoration-none text-primary">Edit profile</a>
        </li>
    </ul>
</div>