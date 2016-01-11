<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
  <title>Резерв Столика</title>
  <link   href="<c:url value="/pages/css/reset.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/style.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/authentication.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/reg.css"/>" rel="stylesheet">
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

    <div class="reg-space">
      <div class="reg-border-t">
      </div>
      <div class="reg-border-d">
      </div>
      <div class="reg-border-l">
      </div>
      <div class="reg-border-r">
      </div>

      <h1>Регистрация</h1>
      <form id = "reg-form" action="#" method="GET">
        <input type="text" id = "login" placeholder="   Login"></br>
        <input type="password" id = "password"placeholder = "   Password"></br>
        <input type="password" id = "password-sec" placeholder = "   Password Again"></br>
        <input type="E-mail" id = "email"placeholder = "   E-mail"></br>
        <input type="text" id = "name" placeholder="   Name"></br>
        <input type="text" id = "surname" placeholder="   Surname"></br>

        <div class="reg-button-spacer">
          <button id="reg-button" type="submit">Зарегистрироваться</button>
        </div>
        <a href = "<c:url value="/" />">На главную</a>
      </form>

    </div>
  </div>

  <div id="sidebar-block">
    <div id="nav-menu">
      <h2>Меню</h2>
      <div class="menu">
        <ul>
          <li><a href="<c:url value="/" />">На главную</a></li>
          <li><a href="<c:url value="/news" />">Новости</a></li>
          <li><a href="<c:url value="/gallery" />">Галерея</a></li>
          <li><a href="<c:url value="/aboutUs" />">О нас</a></li>
          <li><a href="<c:url value="/ourmenu" />">Наше меню</a></li>
          <li><a href="<c:url value="/reserve" />">Резерв столика</a></li>
          <li><a href="<c:url value="/comments" />">Отзывы</a></li>
          <sec:authorize access="!isAuthenticated()">
            <li><a href="<c:url value="/loginpage" />">Авторизация</a></li>
          </sec:authorize>
          <sec:authorize access="isAuthenticated()">
            <li><a href="<c:url value="/logout" />">Выход</a></li>
          </sec:authorize>
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
