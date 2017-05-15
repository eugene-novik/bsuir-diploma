<%@ page import="org.jazzteam.servlets.Navigation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
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
                    <li>
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

<div class="container-fluid" style="margin-top: 5%">
    <div class="row-fluid">
        <div class="span2">

        </div>

        <div class="span8">
            <div>
                <h2 class="text-success">
                    Социальная сеть "Жилье".
                </h2>

                <h3>Вам надоели злые агенты, которые отнимают ваше время и деньги?</h3>

                <h3>Тогда вам сюда!</h3>

                <p class="text-info">
                    На нашем портале вы можете:
                </p>
                <ul>
                    <li>Предоставить свою квартиру для съема</li>
                    <li>Найти подходящую квартиру для жилья</li>
                    <li>Почитать отзывы других пользователь по поводу района, квартиры соседей и т.д.</li>
                    <li>Узнать отзывы о будущем жильце</li>
                    <li>Поиск по городам и другим критериям</li>
                </ul>

                <p>
                    <strong>Арендодатели</strong> регистрируйте свою квартиру загружайте фото, заполняйте описание.
                </p>

                <p>
                    <strong>Арендаторы</strong> оставляй отзывы о районе, квартирах, будьте честны!
                </p>

                <p>
                    Понравилась квартира и захотел ее снять? Поставь лайк под ней, арендодатель увидит при
                    следующем визите на сайт о вас.
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>