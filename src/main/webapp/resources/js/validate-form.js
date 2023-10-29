function validateLoginForm() {
    const data = $("form[name='loginForm']").serializeArray();
    for (let i = 0; i < data.length; i++) {
        if (data[i].value === "") {
            return false;
        }
    }
    return true;
}

function validateRegisterForm() {
    const data = $("form[name='registerForm']").serializeArray();
    for (let i = 0; i < data.length; i++) {
        if (data[i].value === "") {
            return false;
        }
    }
    return true;
}