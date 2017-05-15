<%@ page import="org.jazzteam.servlets.Navigation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LogIn</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/recoverPassword.js"></script>
    <script type="text/javascript" src="js/builder.js"></script>
    <script type="text/javascript" src="js/logIn.js"></script>
</head>
<body>
<%--menu--%>
<%
    if (Navigation.objectInSession(session, "user")) {
        if (Navigation.getSessionUser(session,"user").getControl().getType().equals("Арендодатель")) {
            Navigation.redirectToIndexPage(response, "landlord.jsp");
        } else {
            Navigation.redirectToIndexPage(response, "lessee.jsp");
        }
    }
%>
<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container">
            <button type="button" class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="brand" href="home.jsp">Жилье</a>

            <div class="nav-collapse collapse">
                <ul class="nav">
                    <li>
                        <a href="registration.jsp">Регистрация</a>
                    </li>
                    <li class="active">
                        <a href="logIn.jsp">Войти</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%--LogIn--%>
<div class="container-fluid" style="margin-top: 5%">
    <div class="span4">
        <div class="form-horizontal span2" id="error">

        </div>
    </div>
    <div class="span8">
        <div class="form-horizontal">
            <div class="control-group">
                <label class="control-label" for="nickname">Логин</label>

                <div class="controls">
                    <input type="text" id="nickname" placeholder="логин" style="height: 30px"
                           required="required">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="password">Пароль</label>

                <div class="controls">
                    <input type="password" id="password" placeholder="пароль" style="height: 30px"
                           required="required">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-success" id="logIn">Войти</button>
                    <a class="btn btn-info" href="registration.jsp">Регистрация</a>
                </div>
            </div>
        </div>
        <%--recover password--%>
        <div class="form-horizontal">
            <div class="control-group">
                <div class="controls">
                    <h4 class="text-info">Восстановление пароля</h4>
                </div>
            </div>
            <div class="control-group" style="margin-top: -2%">
                <label class="control-label" for="recoverEmail">Email</label>

                <div class="controls">
                    <input type="text" id="recoverEmail" placeholder="email" style="height: 30px">
                </div>
            </div>
            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-warning" id="recoverPassword">Востоновить</button>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>