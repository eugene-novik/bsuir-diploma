<%@ page import="org.jazzteam.model.table.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="css/bootstrap-responsive.css" rel="stylesheet">
    <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<%
    User user = new User();
    if (session.getAttribute("user") == null) {
        response.sendRedirect("logIn.jsp");
    } else {
        user = (User) session.getAttribute("user");
    }
%>
<jsp:include page="panel.jsp" flush="true"/>
<%--Settings--%>
<div class="container-fluid" style="margin-top: 5%">
    <div class="span4">
        <div id="error">

        </div>
    </div>
    <div class="span8">
        <form class="form-horizontal" action="Settings" method="post">
            <div class="control-group">
                <label class="control-label" for="status">Статус</label>

                <div class="controls">
                    <select id="status" name="status" class="" required="required">
                        <option>Свободна</option>
                        <option>Занята</option>
                    </select>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="price">Цена</label>

                <div class="controls">
                    <div class="input-prepend">
                        <span class="add-on"><img src="img/dollar.png" style="width: 15px;height: 15px;margin-top: 2px"></span>
                        <input type="text" id="price" name="price" placeholder="Цена" style="height: 30px"
                               class="span2"
                               required="required">
                    </div>
                </div>
            </div>

            <div class="control-group">
                <label class="control-label" for="description">Описание</label>

                <div class="controls">
                    <textarea id="description" name="description" class="" placeholder="Описание"
                              style="resize: none; height: 150px" required="required"></textarea>
                </div>
            </div>


            <div class="control-group">
                <div class="controls">
                    <button type="submit" class="btn btn-success" id="saveSettings">Сохранить</button>
                    <a class="btn btn-danger" href="home.jsp">Вернуться</a>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>