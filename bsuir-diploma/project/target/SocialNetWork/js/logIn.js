$(document).ready(function () {
//авторизация
    $('#logIn').click(function () {
        var nickname = $('#nickname').val();
        var password = $('#password').val();

        $.post("LogIn", {"nickname": nickname, "password": password}, function (data) {
            $("#nickName").val("");
            $("#password").val("");
            if (data == "ERROR") {
                createError("Не верный логин или пароль!");
            }
            if(data=="Landlord"){
                window.location.href = "landlord.jsp";
            }
            if(data=="Lessee"){
                window.location.href = "lessee.jsp";
            }
        });
    });

});
