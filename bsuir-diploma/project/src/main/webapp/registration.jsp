<%@ page import="org.jazzteam.servlets.Navigation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
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
                    <li class="active">
                        <a href="registration.jsp">Регистрация</a>
                    </li>
                    <li class="">
                        <a href="logIn.jsp">Войти</a>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<%--Registration--%>
<div class="container-fluid" style="margin-top: 5%">
    <div class="span4">
        <div id="error">

        </div>
    </div>
    <div class="span8">
        <form class="form-horizontal" action="Registration" method="post">
            <div class="control-group">
                <label class="control-label" for="nickname">Логин</label>

                <div class="controls">
                    <input type="text" id="nickname" name="nickname" placeholder="логин" style="height: 30px" class=""
                           required="required">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="password">Пароль</label>

                <div class="controls">
                    <input type="password" id="password" name="password" placeholder="пароль" style="height: 30px"
                           class=""
                           required="required">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="email">Email</label>

                <div class="controls">
                    <input class="" id="email" name="email" type="text" style="height: 30px" placeholder="email"
                           required="required">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="surname">Фамилия</label>

                <div class="controls">
                    <input class="" id="surname" type="text" name="surname" style="height: 30px" placeholder="Фамилия"
                           required="required">
                </div>
            </div>
            <div class="control-group">
                <label class="control-label" for="name">Имя</label>

                <div class="controls">
                    <input class="" id="name" type="text" name="name" style="height: 30px" placeholder="имя"
                           required="required">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="mobile">Телефон</label>

                <div class="controls">
                    <input class="" id="mobile" name="mobile" type="text" style="height: 30px" placeholder="телефон"
                           required="required">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="city">Город</label>

                <div class="controls">
                    <input class="" id="city" type="text" name="city" style="height: 30px" placeholder="город"
                           required="required">
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="type">Пользователь</label>

                <div class="controls">
                    <select id="type" name="type" class="" required="required">
                        <option>Арендодатель</option>
                        <option>Арендатор</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-success" id="registration">Регистрация</button>
                    <a class="btn btn-danger" href="home.jsp">Вернуться</a>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>