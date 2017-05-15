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
                    Программное средство "Аренда и продажа квартир".
                </h2>

                <p class="text-info">
                    На данном портале вы можете:
                </p>
                <ul>
                    <li>Предоставить свою квартиру для съема или продажи</li>
                    <li>Найти подходящую квартиру для жилья</li>
                    <li>Почитать отзывы других пользователь по поводу района, квартиры соседей, аренды или продажи квартиры</li>
                    <li>Узнать отзывы о будущем жильце</li>
                    <li>Поиск хороших предложений по множеству критериев</li>
                </ul>

                <p>
                    <strong>Риэлторы</strong> регистрируйте свою недвиживость, загружайте фото, заполняйте описание.
                </p>

                <p>
                    <strong>Клиенты</strong> оставляй отзывы о районе, квартирах, других пользователях!
                </p>

                <p>
                    Понравилась квартира и захотел ее купить/снять? Поставь лайк под ней, другой пользователь увидит при
                    следующем визите на сайт о вашей активности.
                </p>
            </div>
        </div>
    </div>
</div>

</body>
</html>