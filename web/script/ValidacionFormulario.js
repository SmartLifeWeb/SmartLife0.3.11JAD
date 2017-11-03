//Validar nombre del Usuario
function ValidNombre(e) {
    var keychar = e.keyCode || e.which;

    if ((keychar >= 65 && keychar <= 90) || (keychar >= 97 && keychar <= 122) || (keychar === 8) || (keychar === 32) ||
            (keychar === 130) || (keychar === 181) || (keychar === 239) || (keychar === 144) ||
            (keychar === 214) || (keychar === 224) || (keychar === 233) || (keychar === 239) || (keychar === 160))
    {
        return true;
    } else

    {
        return false;
    }

}
function apellidos(e) {
    var keychar = e.keyCode || e.which;

    if ((keychar >= 65 && keychar <= 90) || (keychar >= 97 && keychar <= 122) || (keychar === 8) ||
            (keychar === 130) || (keychar === 181) || (keychar === 239) || (keychar === 144) ||
            (keychar === 214) || (keychar === 224) || (keychar === 233) || (keychar === 239) || (keychar === 160))
    {
        return true;
    } else

    {
        return false;
    }
}

function ValidUser(e) {
    var keychar = e.keyCode || e.which;
    if ((keychar >= 65 && keychar <= 90) || (keychar >= 97 && keychar <= 122) || (keychar === 8) || (keychar === 32) || (keychar >= 48 && keychar <= 57))
    {
        return true;
    } else {
        return false;
    }
}

function ValidEmail(input) {
    var email = document.getElementById("email").value;
    var requisitos = /\w+@\w+\.+[a-z]/;
    if (email.length > 50) {
        input.setCustomValidity("Correo muy largo");
    } else if (!requisitos.test(email)) {
        input.setCustomValidity("Correo Incorrecto");
    } else {

        input.setCustomValidity('');
    }

}
function Numeros(e) {
    var keychar = e.keyCode || e.which;
    if (keychar >= 48 && keychar <= 57) {
        return true;
    } else {
        return false;
    }
}

function ValidPass(input) {
    var pass1 = document.getElementById("Contra").value;
    var pass2 = document.getElementById("Confirmar").value;

    if (pass2 !== pass1) {
        input.setCustomValidity("Las contraseñas no coinciden");
    } else {
        input.setCustomValidity('');
    }
}
function validLong(input) {
    var pass1 = document.getElementById("Contra").value;
    var nombre = document.getElementById("nombre").value;
    var aPaterno = document.getElementById("apat").value;
    var aMaterno = document.getElementById("amat").value;
    var user = document.getElementById("user").value;
    var tel = document.getElementById("tel").value;

    if (nombre.length > 30) {
        input.setCustomValidity("Nombre demasiado largo");
    } else if (aPaterno.length > 20) {
        input.setCustomValidity("Apellido muy largo");
    } else if (aMaterno.length > 20) {
        input.setCustomValidity("Apellido muy largo");
    } else if (user.length > 20) {
        input.setCustomValidity("Nombre de usuario muy largo");
    } else if (tel.length > 11 && isNaN(tel)) {
        input.setCustomValidity("Teléfono no válido");
    } else if (pass1.length > 20) {
        input.setCustomValidity("La contraseña es muy larga");
    } else {
        input.setCustomValidity('');
    }

}

function validTodo(input) {
    var pass1 = document.getElementById("Contra").value;
    var pass2 = document.getElementById("Confirmar").value;
    var nombre = document.getElementById("nombre").value;
    var aPaterno = document.getElementById("apat").value;
    var aMaterno = document.getElementById("amat").value;
    var user = document.getElementById("user").value;
    var correo = document.getElementById("email").value;
    var tel = document.getElementById("tel").value;
    var requisitos = /\w+@\w+\.+[a-z]/;

    if (nombre === "" || aPaterno === "" || aMaterno === "" || user === "" || correo === "" || tel === "" || pass1 === "" || pass2 === "") {
        input.setCustomValidity("completa todos los campos");
    } else if (nombre.length > 30) {
        input.setCustomValidity("Nombre demasiado largo");
    } else if (aPaterno.length > 20) {
        input.setCustomValidity("Apellido paterno muy largo");
    } else if (aMaterno.length > 20) {
        input.setCustomValidity("Apellido materno muy largo");
    } else if (user.length > 20) {
        input.setCustomValidity("Nombre de usuario muy largo");
    } else if (correo.length > 50) {
        input.setCustomValidity("Correo muy largo");
    } else if (!requisitos.test(correo)) {
        input.setCustomValidity("Correo Incorrecto");
    } else if (tel.length > 11 && isNaN(tel)) {
        input.setCustomValidity("Teléfono no válido");
    } else if (pass1.length > 20) {
        input.setCustomValidity("La contraseña es muy larga");

    } else if (pass2 !== pass1 || pass1 !== pass1) {
        input.setCustomValidity("Las contraseñas no coinciden");
    } else {
        input.setCustomValidity('');
    }
}