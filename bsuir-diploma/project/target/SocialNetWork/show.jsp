<%@ page import="org.jazzteam.model.table.User" %>
<%@ page import="org.jazzteam.servlets.Navigation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/builder.js"></script>
</head>
<body>
<%!
    public String SURNAME = null;
    public String NAME = null;
    public String CONTROL = null;
    public String CITY = null;
    public String STATUS = null;
    public String PRICE = null;
    public String RATING = null;
    public String DESCRIPTION = null;
%>
<%
    User user = null;
    if (Navigation.objectInSession(session, "user")) {
        if (Navigation.objectInSession(session, "show")) {
            user = (User) session.getAttribute("show");
            SURNAME = user.getSurname();
            NAME = user.getName();
            CONTROL = user.getControl().getType();
            CITY = user.getCity();
            if (user.getApartment() != null) {
                STATUS = user.getApartment().getStatus();
                PRICE = String.valueOf(user.getApartment().getPrice());
                RATING = String.valueOf(user.getApartment().getRating());
                DESCRIPTION = user.getApartment().getDescription();
            } else {
                STATUS = "-";
                PRICE = "-";
                RATING = "-";
                DESCRIPTION = "-";
            }
        } else {
            Navigation.redirectToIndexPage(response, "home.jsp");
        }
    } else {
        Navigation.redirectToIndexPage(response, "logIn.jsp");
    }
%>
<jsp:include page="panel.jsp" flush="true"/>
<div class="container-fluid" style="margin-top: 5%">
    <div class="row-fluid">
        <div class="span6 offset3">
            <div class="container-fluid well">
                <%--INFORM--%>
                <div class="span12 ">

                    <div class="">
                        <h3 class="" id="name">
                            <%=SURNAME + " " + NAME%>
                        </h3>
                    </div>

                    <div>
                        <div class="row-fluid">
                            <div class="">
                                <div class="row-fluid">
                                    <div class="span5">
                                        <p class="">
                                            <strong>
                                                Пользователь:
                                            </strong>
                                        </p>
                                    </div>
                                    <div class="span6 ">
                                        <p class="" id="control">
                                            <%=CONTROL%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div class="row-fluid">
                            <div class="">
                                <div class="row-fluid">
                                    <div class="span5">
                                        <p class="">
                                            <strong>
                                                Город:
                                            </strong>
                                        </p>
                                    </div>
                                    <div class="span6">
                                        <p class="" id="city">
                                            <%=CITY%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div class="row-fluid">
                            <div class="">
                                <div class="row-fluid">
                                    <div class="span5">
                                        <p class="">
                                            <strong>
                                                Статус:
                                            </strong>
                                        </p>
                                    </div>
                                    <div class="span6">
                                        <p class="">
                                            <%=STATUS%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div class="row-fluid">
                            <div class="">
                                <div class="row-fluid">
                                    <div class="span5">
                                        <p class="">
                                            <strong>
                                                Цена:
                                            </strong>
                                        </p>
                                    </div>
                                    <div class="span6">
                                        <p class="">
                                            <%=PRICE%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div class="row-fluid">
                            <div class="">
                                <div class="row-fluid">
                                    <div class="span5">
                                        <p class="">
                                            <strong>
                                                Рейтинг:
                                            </strong>
                                        </p>
                                    </div>
                                    <div class="span6">
                                        <p class="">
                                            <%=RATING%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div>
                        <div class="row-fluid">
                            <div class="">
                                <div class="row-fluid">
                                    <div class="span5">
                                        <p class="">
                                            <strong>
                                                Описание:
                                            </strong>
                                        </p>
                                    </div>
                                    <div class="span6">
                                        <p class="">
                                            <%=DESCRIPTION%>
                                        </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <%--Activity--%>
                    <div>
                        <div class="row-fluid">
                            <div class="">
                                <div class="row-fluid">
                                    <div class="span5">
                                        <ul class="nav nav-list" style="margin-left:-20px">
                                            <li>
                                                <a href="reviewShow.jsp"><i class="icon-comment"></i> Отзывы</a>
                                            </li>
                                            <li>

                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
    </div>

</div>

</body>
</html>