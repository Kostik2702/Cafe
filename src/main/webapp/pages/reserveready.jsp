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
  <link   href="<c:url value="/pages/css/add-comment.css"/>" rel="stylesheet">
  <link   href="<c:url value="/pages/css/reserve.css"/>" rel="stylesheet">

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

    <div class="comment-space">
      <div class="comment-border-t">
      </div>
      <div class="comment-border-d">
      </div>
      <div class="comment-border-l">
      </div>
      <div class="comment-border-r">
      </div>
      <h1>Дорогой Хоббит!</h1>

      <p>
        Ваша заявка на резерв столика находится в обработке. В ближайшее время с вами свяжется представитель нашего заведения. Спасибо за то, что воспользовались нашей услугой по резерву столика через интернет.
      </p>

        <a href = "<c:url value="/" />">На главную</a>


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
