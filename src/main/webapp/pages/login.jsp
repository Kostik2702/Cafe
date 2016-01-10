<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Авторизация</title>

    <link   href="<c:url value="/pages/css/reset.css"/>" rel="stylesheet">
    <link   href="<c:url value="/pages/css/style.css"/>" rel="stylesheet">
    <link   href="<c:url value="/pages/css/authentication.css"/>" rel="stylesheet">
    <link   href="<c:url value="/pages/css/font-awesome.css"/>" rel="stylesheet">





<script  src="<c:url value="/pages/script/jquery-1.11.3.min.js"/>">

</script>

<script type="text/javascript">
    $(document).ready(function(){
        $(".arrow").click(function(){

            $("#nav-menu").slideToggle("slow");
            $(this).toggleClass("active"); return false;
        });



    }	);
</script>
</head>
<body>



<div class="sizer edge">
    <div class="border-block">

    </div>
    <div class="content-block">
        <div class="header">
            <h1>Палуба</h1>
        </div>

        <div class="login-space">
            <div class="login-border-t">
            </div>
            <div class="login-border-d">
            </div>
            <div class="login-border-l">
            </div>
            <div class="login-border-r">
            </div>

            <h1>Авторизация</h1>
            <c:url value="/login" var="loginUrl" />
            <form id = "login-form" action="${loginUrl}" method="post">
                <input type="text" id = "login" name="ssoId" placeholder="   Login"></br>
                <input type="password" id = "password" name="password" placeholder = "   Password"></br>
                <input type="hidden" name="${_csrf.parameterName}"  value="${_csrf.token}" />
                <div class="login-button-spacer">
                    <button id="login-button" type="submit">Войти</button>
                </div>
                <a href = "<c:url value="/loginpage/register" />">Регистрация</a>
            </form>

        </div>
    </div>

    <div id="sidebar-block">
        <div id="nav-menu">
            <h2>Меню</h2>
            <div class="menu">
                <ul>
                    <li><a href="<c:url value="/" />">На главную</a></li>
                    <li><a href="#">Новости</a></li>
                    <li><a href="#">Галерея</a></li>
                    <li><a href="#">О нас</a></li>
                    <li><a href="#">Наше меню</a></li>
                    <li><a href="#">Резерв столика</a></li>
                    <li><a href="#">Отзывы</a></li>

                </ul>
            </div>
        </div>
        <div class="arrow">

        </div>

    </div>
</div>

<div class="footer">

</div>


</body>
</html>