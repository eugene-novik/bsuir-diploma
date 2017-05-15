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
    <script type="text/javascript" src="js/review.js"></script>
</head>
<body>
<%
    if (Navigation.objectInSession(session, "user")) {

    } else {
        Navigation.redirectToIndexPage(response, "logIn.jsp");
    }
%>
<jsp:include page="panel.jsp" flush="true"/>

<div class="container-fluid" style="margin-top: 5%">
    <div class="row-fluid">
        <div class="span6 offset3" id="review">

        </div>
    </div>
</div>
</body>
</html>