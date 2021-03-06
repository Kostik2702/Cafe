<%--suppress ALL --%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
  <title>Регистрация</title>
  <link   href="<c:url value="/pages/css/reset.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/style.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/authentication.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/reg.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/font-awesome.css"/>" rel="stylesheet">

  <script  src="<c:url value="/pages/script/jquery-1.11.3.min.js"/>">

  </script>

  <script type="text/javascript">
    $(document).ready(function(){




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
      <c:url value="/register?${_csrf.parameterName}=${_csrf.token}" var="reg" />
      <form:form action="${reg}" id = "reg-form"  method="POST"  modelAttribute="userForm" enctype="multipart/form-data">
        <form:input path="login"  id = "login" placeholder="   Login"/></br>
        <form:password path="password"  id = "password" placeholder = "   Password"/></br>

        <form:input path="email" id = "email" placeholder = "   E-mail"/></br>
        <form:input path="name"  id = "name" placeholder="   Name"/></br>
        <form:input path="surname"  id = "surname" placeholder="   Surname"/></br>

        <div class="reg-button-spacer">
          <button id="reg-button" type="submit">Зарегистрироваться</button>
        </div>
        <a href = "<c:url value="/" />">На главную</a>
      </form:form>

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


  </div>
</div>

<div class="footer">

</div>

<script type="text/javascript">

</script>
</body>
</html>
