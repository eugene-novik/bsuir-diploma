<%@ page import="org.jazzteam.model.table.User" %>
<%@ page import="org.jazzteam.servlets.Navigation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<%!
    public String SURNAME = null;
    public String NAME = null;
    public String CONTROL = null;
    public String CITY = null;
%>
<%
    User user = null;
    if (Navigation.objectInSession(session, "user")) {
        user = Navigation.getSessionUser(session,"user");
        SURNAME = user.getSurname();
        NAME = user.getName();
        CONTROL = user.getControl().getType();
        CITY = user.getCity();
    } else {
        Navigation.redirectToIndexPage(response, "logIn.jsp");
    }
%>
<%--menu--%>
<jsp:include page="panel.jsp" flush="true"/>
<%--Lesse--%>
<div class="container-fluid" style="margin-top: 5%">
    <div class="row-fluid">
        <div class="span6 offset3">
            <div class="container-fluid well">
                <%--INFORM--%>
                <div class="span12 ">

                    <div class="">
                        <h3 class="">
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
                                        <p class="">
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
                                        <p class="">
                                            <%=CITY%>
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
                                                <a href="review.jsp" name="user"><i class="icon-comment"></i> Отзывы</a>
                                            </li>
                                            <li>
                                                <a href="#"><i class="icon-th-large"></i> Список предложений</a>
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